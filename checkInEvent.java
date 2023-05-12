import java.io.*;
import java.util.Scanner;
import java.util.*;

public class checkInEvent {

    public static void checkInEvent(ArrayList<Member> memberList) {
        Scanner scanner = new Scanner(System.in);

        Member member = null;

        System.out.print("Enter the ID of the member to check in for: ");
        String inputId = scanner.nextLine().strip();

        for(Member mem : memberList) {
            if(inputId.equals(mem.getMemberID())) {
                member = mem;
            }
        }

        if(member == null) {
            System.out.println("There was no member found with member ID " + inputId);
        } else {

            System.out.print("Please enter the ID of the collection to be checked in: ");
            String collectionId = scanner.nextLine();

            File myFile = new File("CheckedOutItems.txt");
            File tempFile = new File("tempCheckedIn.txt");

            try {
                BufferedReader reader = new BufferedReader(new FileReader(myFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                
                String lineToRemove = collectionId;
                String currentLine;
                boolean found = false;

                while ((currentLine = reader.readLine()) != null) {
                    String[] currline = currentLine.split("\t");
                    String memID = currline[0];
                    String col1 = currline[1];
                    String col2 = currline[2];
                    String col3 = currline[3];
                    String col4 = currline[4];
                    String col5 = currline[5];
                    int i = 0;

                    for(String col : currline) {
                        if(col.equals(collectionId)) {
                            member.setCheckedOut(i, "0");
                            writer.write("0\t");
                            found = true;
                        } else {
                            writer.write(col + "\t");
                        }
                        i++;
                    }

                    writer.newLine();
                }

                if (!found) {
                    System.out.println("Book not found.");
                } else {
                    System.out.println("Book returned successfully.");
                }

                reader.close();
                writer.close();

                scanner.close();
                myFile.delete();
                tempFile.renameTo(myFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
