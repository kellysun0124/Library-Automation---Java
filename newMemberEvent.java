public class newMemberEvent {
    
    public static void newMemberEvent(){
        System.out.println("Enter Membership info: ");
        Scanner scn = new Scanner(System.in);

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

        System.out.print("Enter Membership type (Student/Professor/External): ");
        String memtype = scn.nextLine();

        System.out.print("Creating a new member...");
        Member mem = new Member(name,address,dob,email,ssn,memtype);

        //String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int memberID, String memberType) {
        super(name, address, dateOfBirth, email, socialSecurityNumber);

        System.out.print("The membership ID is: "+mem.getID());

        mem.saveTo("membershipdatabasefile.txt");
        System.out.println("New Member Successfully Saved to file."); 
    }
}
