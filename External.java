import java.util.*;

public class External extends Member {

    public External(String name, String address, Date dateOfBirth, String email, String socialSecurityNumber, String memberID, int professorID, String memberType) {
        super(name, address, dateOfBirth, email, socialSecurityNumber, memberID, memberType);
        
    }
    private Collections[] collectionsArray = new Collections[5];
    private int collectionCount = 0;
   
}
