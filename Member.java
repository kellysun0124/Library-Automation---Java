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
    
    private Collections[] collectionsArray = new Collections[5];
    private int collectionCount = 0;
    
    public void addCollection(Collections collection) {
        if (collectionCount < 5) {
            collectionsArray[collectionCount] = collection;
            collectionCount++;
        } else {
            System.out.println("Error: Maxium collections reached.");
        }
    }
}
