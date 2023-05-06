import java.util.*;

public class External extends Member {

    public External(String name, String address, Date dateOfBirth, String email, String socialSecurityNumber, String memberID, int professorID, String memberType) {
        super(name, address, dateOfBirth, email, socialSecurityNumber, memberID, memberType);
        
    }
    //I think the professor account is different from their member account?
    private Collections[] collectionsArray = new Collections[5];
    private int collectionCount = 0;
    //can only check out 5 collections
    public void addCollection(Collections collection) {
        if (collectionCount < 5) {
            collectionsArray[collectionCount] = collection;
            collectionCount++;
        } else {
            System.out.println("Error: Maxium collections reached.");
        }
    }
}
