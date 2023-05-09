import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class newMemberEvent {
    
    public static void newMemberEvent(Member newMem){
        Scanner scn = new Scanner(System.in);
        try{
            System.out.println("Enter Membership info: ");

            System.out.print("Enter Member Name: ");
            String name = scn.nextLine();

            System.out.print("Enter Member Address: ");
            String address = scn.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            dateFormat.setLenient(false);

            Date dob = new Date(0);
            boolean valid = false;

            while(valid != true) {
                try {
                    System.out.print("Enter Member Date of Birth(mm/dd/yyyy): ");
                    String input = scn.nextLine();

                    dob = dateFormat.parse(input);
                    valid = true;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter date of birth in mm/dd/yyyy format.");
                    continue;
                }
            }

            System.out.print("Enter Member email: ");
            String email = scn.nextLine();

            System.out.print("Enter Member SSN: ");
            String ssn = scn.nextLine();       
            
            String membertype = "Student";

            Boolean validInput = false;

            while (validInput == false) {
                System.out.print("Enter Membership type (Student/Professor/External): ");
                membertype = scn.nextLine().toLowerCase();

                switch(membertype) {
                    case "student":
                    case "professor":
                    case "external":
                        validInput = true;
                        break;
                    default:
                        System.out.println("Please enter a valid member type.");
                }
            }

            System.out.print("Creating a new member...\n");
            
            String memberID = GetIDs.returnID("members.txt");
            Member mem = new Member(name,address,dob,email,ssn,memberID,membertype);
            
            SaveToFile.save(mem.toString(), "members.txt");
            newMem = mem;

        } catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            scn.close();
        }
    }
}