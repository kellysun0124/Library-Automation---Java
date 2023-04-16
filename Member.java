public class Member extends Person {
    private String memberID;
    private String memberType;

    // Constructor
    public Member(String name, String address, String dateOfBirth, String email, String socialSecurityNumber, String memberID, String memberType) {
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
    public String getID() {
        
        return memberID;
    }
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
    public void saveTo(String string) {
    }    
}

