import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class newEmployee {
    //NOTE: why pass int empnum??? if the employee haven't been created how would there be an employee number
    //newemployee.newEmployeeEvent(employeenumber)
    public static void newEmployeeEvent() {
        //get user input

        Scanner scn = new Scanner(System.in);


        System.out.println("Enter New Employee info: ");

        System.out.println("Enter Member ID: ");
        int empNum = scn.nextInt();

        Scanner scn1 = new Scanner(System.in);
        System.out.println("Enter Employee Full Name: ");
        String name = scn1.nextLine();

        Scanner scn2 = new Scanner(System.in);
        System.out.println("Enter Address: ");
        String address = scn2.nextLine();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);

        Date dob = new Date(0);
        boolean valid = false;

        Scanner scn3 = new Scanner(System.in);
        while(valid != true) {
            try {
                System.out.print("Enter Member Date of Birth(mm/dd/yyyy): ");
                String input = scn3.nextLine();

                dob = dateFormat.parse(input);
                valid = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date of birth in mm/dd/yyyy format.");
                continue;
            }
        }
        



        System.out.print("Enter Email: ");
        String email = scn.nextLine().toLowerCase();
        System.out.print("Enter Member SSN: ");
        String socialsecuritynumber = scn.nextLine();
        System.out.print("Enter Employee type (Librarian/Technician)");
        String emptype = scn.nextLine().toLowerCase();
        System.out.print("Creating a new employee.....");

        //make new employee, make and get new employee id
        Employee mem = new Employee(empNum, name, address, dob, email, socialsecuritynumber, emptype);
        String stringMem = mem.toString();
        //use savetofile to save to txt
        SaveToFile.save(stringMem, "employees.txt");
        System.out.println("New Employee Successfully Saved to file.");

    }
}
