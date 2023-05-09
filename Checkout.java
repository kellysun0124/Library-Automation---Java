import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Checkout {
    public static void checkouts(Member member) {
        Scanner scn = new Scanner(System.in);

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
            
            readCheckedOutItems(1, "0", id, member, total);

            if (total[0] < 5) {
                int more = 5 - total[0];
                System.out.printf("You can checkout %d more items.\n", more);
                System.out.print("Would you like to checkout another item?(y/n) ");
                
                String answer = "";

                if(scn.hasNextLine()) {
                    answer = scn.nextLine();
                } else {
                    System.out.println("NO INPUT");
                }
                

                if (answer.toLowerCase().equals("y")) {
                    String newItemID = checkoutNewItem(scn);
                    readCheckedOutItems(1, newItemID, id, member, total);

                } else {
                    System.out.println("Goodbye!");
                }
            } else {
                System.out.println("You already have the max amount of checked out items.");
            }
        } else {
            System.out.println("The given member ID was not found: " + id);
        }
    }

    private static String checkoutNewItem(Scanner scn) {
        String itemID = scn.nextLine();

        boolean valid = false;

        File collections = new File("Collectiondatabase.txt");
        String collectionID = "0";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(collections));

            String curr;
            boolean found = false;

            while ((curr = reader.readLine()) != null) {
                String[] collectionInfo = curr.split("\t");
                collectionID = collectionInfo[0];
                String isbn = collectionInfo[1];

                if (itemID == isbn) {
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

        try {
            File temp = new File("tempCheckedOut.txt");
            File checkedOutItems = new File("CheckedOutItems.txt");

            BufferedReader reader = new BufferedReader(new FileReader(checkedOutItems));

            while ((curr = reader.readLine()) != null) {
                String[] currInfo = curr.split("\t");
                int memID = Integer.parseInt(currInfo[0]);

                if (toDo == 0 && id == memID) {
                    return true;
                }

                if (toDo == 1 && id == memID) {
                    for (int i = 1; i < 6; i++) {
                        if (!currInfo[i].equals("0")) {
                            System.out.println("Not equal");
                            total[0]++;
                        }
                    }
                }

                if (collectionID != "-1") {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(temp));

                    if (memID == id) {
                        String content;

                        for (int i = 0; i < 6; i++) {
                            if (currInfo[i] == "0") {
                                currInfo[i] = collectionID;
                                member.setCheckedOut(i, collectionID);
                                break;
                            }
                        }

                        writer.write(Arrays.toString(currInfo));
                    } else {
                        writer.write(curr);
                        writer.newLine();
                    }
                    writer.close();
                }
            }

            reader.close();
            temp.delete();
            checkedOutItems.delete();
            temp.renameTo(checkedOutItems);
        } catch (IOException e) {
            System.out.println("There was an error trying to update checked out items for member " + id + "\n");
            e.printStackTrace();
        }

        return false;
    }
}
