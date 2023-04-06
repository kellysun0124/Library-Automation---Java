public class Librarian extends Employee {
    public Librarian (String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int employeeNumber){
        super(name, address, dateOfBirth, email, socialSecurityNumber, employeeNumber);
    }
    public void getMemberID(Member member){
        member.getMemberID();
    }
    public void setMemberID(Member member){
        member.setMemberID();
    }
}



