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
    
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%2d\n", this.getName(), this.getAddress(), this.getDateOfBirth(), this.getEmail(), this.getSocialSecurityNumber(), this.getMemberID());
    }
}
