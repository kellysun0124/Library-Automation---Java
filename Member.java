public class Member extends Person {
    private int memberID;
    private String memberType;

    // Constructor
    public Member(String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int memberID, String memberType) {
        super(name, address, dateOfBirth, email, socialSecurityNumber);
        this.memberID = memberID;
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    // Getter and Setter for memberID
    public int getMemberID() {
        return memberID;
    }
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
    
}
