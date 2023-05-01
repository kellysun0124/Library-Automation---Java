import java.io.*;

public class BorrowEvent {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Collection ID: ");
        String collectionID = scn.nextLine();

        // Read from the Collectiondatabase.txt file
        String collectionData = readFile("Collectiondatabase.txt", collectionID);

        if (collectionData.isEmpty()) {
            System.out.println("Collection ID not found.");
            return;
        }

        CollectionItem collection = createCollectionItem(collectionData);

        System.out.print("Enter Member ID: ");
        String memberID = scn.nextLine();

        // Read from the Members.txt file
        String memberData = readFile("Members.txt", memberID);

        if (memberData.isEmpty()) {
            System.out.println("Member ID not found.");
            return;
        }

        Member member = createMember(memberData);

        // Perform the borrowing action
        if (member.borrowItem(collection)) {
            System.out.println("Borrow successful.");
        } else {
            System.out.println("Borrow unsuccessful.");
        }
    }

    private static String readFile(String filename, String id) {
        String data = "";
        try {
            File file = new File(filename);
            Scanner fileScn = new Scanner(file);
            while (fileScn.hasNextLine()) {
                String line = fileScn.nextLine();
                if (line.contains(id)) {
                    data = line;
                    break;
                }
            }
            fileScn.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return data;
    }

    private static CollectionItem createCollectionItem(String data) {
        String[] collectionInfo = data.split(",");
        String collectionID = collectionInfo[0];
        String type = collectionInfo[1];
        String section = collectionInfo[2];
        String title = collectionInfo[3];
        String publisher = collectionInfo[4];
        String genre = collectionInfo[5];

        if (type.equals("Books")) {
            String ISBN = collectionInfo[6];
            String author = collectionInfo[7];
            int amountOfPages = Integer.parseInt(collectionInfo[9]);
            return new Books(collectionID, section, title, publisher, genre, ISBN, author, type, amountOfPages);
        } else if (type.equals("DVDS")) {
            String ISBN = collectionInfo[6];
            int runtime = Integer.parseInt(collectionInfo[8]);
            return new DVDs(collectionID, section, title, publisher, genre, ISBN, type, runtime);
        } else if (type.equals("Journals")) {
            String ISSN = collectionInfo[7];
            String author = collectionInfo[8];
            int amountOfPages = Integer.parseInt(collectionInfo[9]);
            return new Journals(collectionID, section, title, publisher, genre, type, ISSN, author, amountOfPages);
        } else if (type.equals("Newspapers")) {
            String ISSN = collectionInfo[7];
            int amountOfPages = Integer.parseInt(collectionInfo[9]);
            return new Newspapers(collectionID, section, title, publisher, genre, type, ISSN, amountOfPages);
        } else {
            System.out.println("Invalid collection type.");
            return null;
        }
    }

    private static Member createMember(String data) {
        String[] memberInfo = data.split(",");
        String memberID = memberInfo[0];
        String memberType = memberInfo[1];
        String name = memberInfo[2];
        int age = Integer.parseInt(memberInfo[3]);

        if (memberType.equals("Student")) {
            String studentID = memberInfo[4];
            String department = memberInfo[5];
            return new Student(memberID, name, age, studentID, department);
        } else if (memberType.equals("Faculty")) {
            String facultyID = memberInfo[4];
            String department = memberInfo[5];
            return new Faculty(memberID, name, age, facultyID, department);
        } else if (memberType.equals("Staff")) {
            String staffID = memberInfo[4];
            return new Staff(memberID, name, age, staffID);
        } else {
            return null;
        }
    }

    // Borrow an item from the library
    private static void borrowItem() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Collection ID: ");
        String collectionID = scn.nextLine();

        // Read from the Collectiondatabase.txt file
        File collectionFile = new File("Collectiondatabase.txt");
        try (Scanner fileScn = new Scanner(collectionFile)) {
            String collectionData = "";
            while (fileScn.hasNextLine()) {
                String line = fileScn.nextLine();
                if (line.contains(collectionID)) {
                    collectionData = line;
                    break;
                }
            }

            if (collectionData.isEmpty()) {
                System.out.println("Collection ID not found.");
                return;
            }

            Collections collection = createCollection(collectionData);

            if (collection == null) {
                System.out.println("Invalid collection type.");
                return;
            }

            System.out.print("Enter Member ID: ");
            String memberID = scn.nextLine();

            // Read from the Members.txt file
            File membersFile = new File("Members.txt");
            try (Scanner membersScn = new Scanner(membersFile)) {
                String memberData = "";
                while (membersScn.hasNextLine()) {
                    String line = membersScn.nextLine();
                    if (line.contains(memberID)) {
                        memberData = line;
                        break;
                    }
                }

                if (memberData.isEmpty()) {
                    System.out.println("Member ID not found.");
                    return;
                }

                Member member = createMember(memberData);

                if (member == null) {
                    System.out.println("Invalid member type.");
                    return;
                }

                // Borrow the item
                if (member.borrowItem(collection)) {
                    System.out.println("Borrow successful.");
                } else {
                    System.out.println("Borrow unsuccessful. Item already borrowed.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Members.txt not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Collectiondatabase.txt not found.");
        }
    }
}