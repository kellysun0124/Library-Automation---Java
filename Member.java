import java.util.*;

public class Member extends Person {
    private String memberID;
    private String memberType;
    protected String[] checkedOut;

    // Default Constructor
    public Member() {
        super();
        this.memberID = "0";
        this.memberType = "student";
        this.checkedOut = new String[4];
        Arrays.fill(checkedOut, "0");
    }

    // Overloaded constructor
    public Member(String name, String address, Date dateOfBirth, String email, String socialSecurityNumber, String memberID, String memberType) {
        super(name, address, dateOfBirth, email, socialSecurityNumber);
        this.memberID = memberID;
        this.memberType = memberType;
        this.checkedOut = new String[4];
        Arrays.fill(checkedOut, "0");
    }

    public String[] getCheckedOut() {
        return this.checkedOut;
    }
    
    public String getCheckedOut(int index) {
        return this.checkedOut[index];
    }

    public void setCheckedOut(String[] collectionList) {
        this.checkedOut = collectionList;
    }

    public void setCheckedOut(int index, String collectionID) {
        this.checkedOut[index] = collectionID;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    // Getter and Setter for memberID
    public String getMemberID() {
        
        return memberID;
    }
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }



    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", this.getMemberID(), this.getAddress(), this.getDateOfBirth(), this.getEmail(), this.getSocialSecurityNumber(), this.getName(), this.getMemberType());
    }
}



