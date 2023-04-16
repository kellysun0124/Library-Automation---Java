import java.util.Scanner;
import java.io.*;

public class newMemberEvent {
    
    public static void newMemberEvent(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Membership info: ");

        System.out.print("Enter Member Name: ");
        String name = scn.nextLine();

        System.out.print("Enter Member Address: ");
        String address = scn.nextLine();

        System.out.print("Enter Member Date of Birth: ");
        String dob = scn.nextLine();

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


        mem.saveTo("membershipdatabasefile.txt");
        System.out.println("New Member Successfully Saved to file."); 
    }
}
