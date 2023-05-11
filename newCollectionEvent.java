import java.util.Scanner;

import javax.sound.sampled.BooleanControl.Type;

import java.io.*;
import java.util.*;

public class newCollectionEvent {

    public static void newCollectionEvent() {

        try {
            //get input from user
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter Collection Information: ");

            System.out.println("Enter Collection ID: ");
            String collectionID = scn.nextLine();


            System.out.println("Enter Title: ");
            String title = scn.nextLine();

            System.out.println("Enter Publisher: ");
            String publisher = scn.nextLine();

            System.out.println("Enter Genre: ");
            String genre = scn.nextLine();

    

            //type
            String type = "";
            while (true) {
                System.out.println("Enter Type: DVDS, Books, Journals, Newspapers: ");
                type = scn.nextLine().toLowerCase();
                if (type.equals("dvds") || type.equals("books") || type.equals("journals")
                        || type.equals("newspapers")) {
                    break;
                } else {
                    System.out.println("Invalid collection type. Please enter DVDS, Books, Journals, or Newspaper.");
                }
            }

            
            //switch based on type of collection and make new collection based on switch case
            switch (type) {
                case "dvds":
             
                    System.out.print("Enter ISBN: ");
                        String ISBN = scn.nextLine();

                    DVDs mem = new DVDs(collectionID, title, publisher, genre, ISBN, type);
                    
                 

                    System.out.print("Creating a new member...");
                    SaveToFile.save(mem.toString(), "Collectiondatabase.txt");

                    break;
                

                case "books":
                   
                    System.out.print("Enter ISBN: ");
                    ISBN = scn.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scn.nextLine();

                

                    Books mem1 = new Books(collectionID, title, publisher, genre, ISBN, author, type);
                    System.out.print("Creating a new member...");
                    SaveToFile.save(mem1.toString(), "Collectiondatabase.txt");
                    //System.out.print(mem1.toString());
                    
                    break;
                    

                case "journals":

                    System.out.print("Enter ISSN: ");
                    String ISSN = scn.nextLine();

                    System.out.print("Enter Author: ");
                    author = scn.nextLine();

                    Journals mem2 = new Journals(collectionID, title, publisher, genre, type, ISSN, author);
                    System.out.print("Creating a new member...");
                    SaveToFile.save(mem2.toString(), "Collectiondatabase.txt");
                    

                    break;
                    

                case "newspapers":
                
                    System.out.print("Enter ISSN: ");
                    ISSN = scn.nextLine();

                
                    Newspapers mem3 = new Newspapers(collectionID, title, publisher, genre, type, ISSN);
                    System.out.print("Creating a new member...");
                    SaveToFile.save(mem3.toString(), "Collectiondatabase.txt");
                    
                    break;

                    
                default:
                    System.out.println("Invalid collection type. Please enter DVDS, Books, Journals, or Newspaper.");
                    return;
                }

        

            //catch error and output
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }
}

