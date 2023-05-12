import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.*;

public class Checkout {
    static Scanner scn = new Scanner(System.in);

    public static void checkouts(ArrayList<Member> memberList) {
        Member member = null;
        System.out.print("Enter the ID of the member to checkout for: ");
        String inputId = scn.nextLine().strip();

        for(Member mem : memberList) {
            if(inputId.equals(mem.getMemberID())) {
                member = mem;
            }
        }

        if(member == null) {
            System.out.println("There was no member found with member ID " + inputId);
        } else {
            int id = Integer.parseInt(member.getMemberID());
            boolean valid = false;

            int[] total = {0};
            boolean idExists = readCheckedOutItems(0, "-1", id, member, total);

            if (idExists == true) {
                System.out.println("The member's currently checked out items are: ");
                for (int i = 0; i < 5; i++) {
                    String item = member.getCheckedOut(i);
                    if(!item.equals("0")) {
                        System.out.println(" *" + member.getCheckedOut(i));
                    } else {
                        System.out.println(" *Empty");
                    }
                }
                
                ArrayList<String> itemList = new ArrayList<>();
                
                readCheckedOutItems(1, "-1", id, member, total);

                if (total[0] < 5) {
                    int more = 5 - total[0];
                    System.out.printf("You can checkout %d more items.\n", more);
                    System.out.print("Would you like to checkout another item?(y/n) ");
                    
                    String answer = scn.nextLine();
                    boolean validInput = false;

                    if (answer.toLowerCase().equals("y")) {
                        String newItemID = checkoutNewItem(scn);
                        readCheckedOutItems(1, newItemID, id, member, total);
                    } else {
                        File temp = new File("tempCheckedOut.txt");
                        temp.delete();
                    }
                } else {
                    System.out.println("You already have the max amount of checked out items.");
                }
            } else {
                System.out.println("The given member ID was not found: " + id);
            }
        }
    }

    private static String checkoutNewItem(Scanner scn) {
        System.out.print("Enter the ISBN/ISSN of the item you want to checkout: ");
        String itemID = scn.nextLine();

        boolean valid = false;

        File collections = new File("Collectiondatabase.txt");
        String collectionID = "0";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(collections));

            String curr;
            boolean found = false;

            while ((curr = reader.readLine()) != null) {
                String[] collectionInfo = curr.split(",");

                if(collectionInfo.length < 1) {
                    continue;
                }

                collectionID = collectionInfo[0];
                
                String isbn_sn = collectionInfo[1];

                if (itemID.strip().equals(isbn_sn)) {
                    found = true;
                    break;
                }
            }

            reader.close();
            return collectionID;
        } catch (IOException e) {
            System.out.println("There was an error reading the checked out items.");
            e.printStackTrace();
        }

        return collectionID;
    }

    private static boolean readCheckedOutItems(int toDo, String collectionID, int memberID, Member member, int[] total) {
        total[0] = 0;

        String curr;

        int id = Integer.parseInt(member.getMemberID());
        
        File temp = null;
        File checkedOutItems = null;
        boolean updated = false;
        boolean returnValue = false;

        try {
            temp = new File("tempCheckedOut.txt");
            checkedOutItems = new File("CheckedOutItems.txt");

            BufferedReader reader = new BufferedReader(new FileReader(checkedOutItems));
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));

            while ((curr = reader.readLine()) != null) {
                String[] currInfo = curr.split("\t");
                int memID = Integer.parseInt(currInfo[0]);

                if (toDo == 0 && id == memID) {
                    returnValue = true;
                }

                if (toDo == 1 && id == memID) {
                    for (int i = 1; i < 6; i++) {
                        if (!currInfo[i].equals("0")) {
                            total[0]++;
                        }
                    }
                }

                if (collectionID != "-1") {

                    if (memID == id) {
                        String content;

                        for (int i = 1; i < 6; i++) {
                            if (currInfo[i].equals("0")) {
                                currInfo[i] = collectionID;

                                member.setCheckedOut(i, collectionID);
                                
                                for(String value : currInfo) {
                                    writer.write(value + "\t");
                                }
                                updated = true;
                                writer.newLine();
                                break;
                            }
                        }
                    } else {
                        writer.write(curr);
                        writer.newLine();
                    }
                }
            }

            reader.close();
            writer.close();
            performFileOperations(temp, checkedOutItems, updated);
        } catch (IOException e) {
            System.out.println("There was an error trying to update checked out items for member " + id + "\n");
            e.printStackTrace();
        }

        return returnValue;
    }

    private static void performFileOperations(File temp, File checkedOutItems, boolean updated) {
        if(updated == true) {
            if (!checkedOutItems.delete()) {
                System.out.println("Could not delete file: " + checkedOutItems.getName());
            }
        
            if (!temp.renameTo(checkedOutItems)) {
                System.out.println("Could not rename file: " + temp.getName());
            }
        }
    }

    public static void closeScanner() {
        scn.close();
    }
}
