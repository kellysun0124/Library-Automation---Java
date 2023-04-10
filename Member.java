public class Member extends Person {
    private int memberID;

    // Constructor
    public Member(String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int memberID) {
        super(name, address, dateOfBirth, email, socialSecurityNumber);
        this.memberID = memberID;
    }

    // Getter and Setter for memberID
    public int getMemberID() {
        return memberID;
    }
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
    
}
