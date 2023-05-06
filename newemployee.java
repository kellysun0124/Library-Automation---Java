import java.util.Scanner;

public class newemployee {

    public static void newEmployeeEvent(int empNum) {
        //get user input
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter New Employee info: ");
        System.out.print("Enter Employee Full Name: ");
        String name = scn.nextLine();
        System.out.print("Enter Address: ");
        String address = scn.nextLine();
        System.out.print("Enter Employee Date of Birth: ");
        String dateOfBirth = scn.nextLine();
        System.out.print("Enter Email: ");
        String email = scn.nextLine();
        System.out.print("Enter Member SSN: ");
        String socialsecuritynumber = scn.nextLine();
        System.out.print("Enter Employee type (Librarian/Technician)");
        String emptype = scn.nextLine();
        System.out.print("Creating a new employee.....");

        //make new employee, make and get new employee id
        //note empnum is the last one but should it be the first one????
        Employee mem = new Employee(name, address, dateOfBirth, email, socialsecuritynumber, emptype, empNum);
        System.out.print("The Employee ID is: " + mem.getEmployeeNumber());
        String stringMem = mem.toString();
        //use savetofile to save to txt
        SaveToFile.save(stringMem, "employees.txt");
        System.out.println("New Employee Successfully Saved to file.");
    }
}
