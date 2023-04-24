import java.util.Scanner;
import java.io.*;

public class newCollectionEvent {

    public static void newCollectionEvent() {
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter Collection Information: ");

            System.out.print("Enter Collection ID: ");
            String collectionID = scn.nextLine();

            System.out.print("Enter Section: ");
            String section = scn.nextLine();

            String type = "";
            while (true) {
                System.out.print("Enter Type: DVDS, Books, Journals, Newspaper: ");
                type = scn.nextLine().toLowerCase();
                if (type.equals("dvds") || type.equals("books") || type.equals("journals")
                        || type.equals("newspapers")) {
                    break;
                } else {
                    System.out.println("Invalid collection type. Please enter DVDS, Books, Journals, or Newspaper.");
                }
            }

            System.out.print("Enter Title: ");
            String title = scn.nextLine();

            System.out.print("Enter Publisher: ");
            String publisher = scn.nextLine();

            System.out.print("Enter Genre: ");
            String genre = scn.nextLine();

            System.out.print("Creating a new member...");
            Collections mem;
            switch (type) {
                case "dvds":
                    String ISBN = "";
                    int runtime = 0;
                    while (true) {
                        System.out.print("Enter ISBN: ");
                        ISBN = scn.nextLine();

                        try {
                            System.out.print("Enter RunTime: ");
                            runtime = Integer.parseInt(scn.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    mem = new DVDs(collectionID, section, title, publisher, genre, ISBN, type, runtime);
                    break;

                case "books":
                    ISBN = "";
                    String author = "";
                    int amountOfPages = 0;
                    while (true) {
                        //add if to check if > 6 characters
                        System.out.print("Enter ISBN: ");
                        ISBN = scn.nextLine();

                        System.out.print("Enter Author: ");
                        author = scn.nextLine();

                        try {
                            System.out.print("Enter Amount of Pages: ");
                            amountOfPages = Integer.parseInt(scn.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    mem = new Books(collectionID, section, title, publisher, genre, ISBN, author, type, amountOfPages);
                    break;

                case "journals":
                    String ISSN = "";
                    author = "";
                    amountOfPages = 0;
                    while (true) {
                        //check for > 6, different while loop
                        System.out.print("Enter ISSN: ");
                        ISSN = scn.nextLine();

                        System.out.print("Enter Author: ");
                        author = scn.nextLine();

                        try {
                            System.out.print("Enter Amount of Pages: ");
                            amountOfPages = Integer.parseInt(scn.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    mem = new Journals(collectionID, section, title, publisher, genre, type, ISSN, author,
                            amountOfPages);
                    break;

                case "newspapers":
                    ISSN = "";
                    author = "";
                    amountOfPages = 0;
                    while (true) {
                        System.out.print("Enter ISSN: ");
                        ISSN = scn.nextLine();

                        System.out.print("Enter Author: ");
                        author = scn.nextLine();

                        try {
                            System.out.print("Enter Amount of Pages: ");
                            amountOfPages = Integer.parseInt(scn.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    mem = new Newspapers(collectionID, section, title, publisher, genre, type, ISSN, amountOfPages);
                    break;

                default:
                    System.out.println("Invalid collection type. Please enter DVDS, Books, Journals, or Newspaper.");
                    return;
            }

            SaveToFile.save(mem.toString(), "Collectiondatabase.txt");

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
