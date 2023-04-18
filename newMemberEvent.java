import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class newMemberEvent {
    
    public static void newMemberEvent(){
        Scanner scn = new Scanner(System.in);
        try{
            System.out.println("Enter Membership info: ");

            System.out.print("Enter Member Name: ");
            String name = scn.nextLine();

            System.out.print("Enter Member Address: ");
            String address = scn.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            dateFormat.setLenient(false);

            System.out.print("Enter Member Date of Birth(mm/dd/yyyy): ");
            String input = scn.nextLine();
            
            Date dob = Date.from(null);
            boolean valid = false;

            while(!valid) {
                try {
                    dob = dateFormat.parse(input);
                    valid = true;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter date of birth in mm/dd/yyyy format.");
                }
            }

            System.out.print("Enter Member email: ");
            String email = scn.nextLine();

            System.out.print("Enter Member SSN: ");
            String ssn = scn.nextLine();

            System.out.print("Enter Member ID: ");
            String memberID = scn.nextLine();        

            System.out.print("Enter Membership type (Student/Professor/External): ");
            String membertype = scn.nextLine();

            System.out.print("Creating a new member...");
            Member mem = new Member(name,address,dob,email,ssn,memberID,membertype);

            //public Member(String name, String address, String dateOfBirth, String email, String socialSecurityNumber, String memberID, String memberType) {

            
            FileWriter myWriter = new FileWriter("membershipdatabasefile.txt");
        
            myWriter.write(mem.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            scn.close();
        }
    }
}