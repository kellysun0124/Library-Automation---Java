public class External extends Member {

    public External(String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int memberID, int professorID) {
        super(name, address, dateOfBirth, email, socialSecurityNumber, memberID);
        
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
