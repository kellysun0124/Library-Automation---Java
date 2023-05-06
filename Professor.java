import java.util.Date;

public class Professor extends Member{
    private int professorID;
    //constructor
    public Professor(String name, String address, Date dateOfBirth, String email, String socialSecurityNumber, String memberID, int professorID, String memberType) {
        super(name, address, dateOfBirth, email, socialSecurityNumber, memberID, memberType);
        this.professorID = professorID;
    }

    public int getProfessorID() {
        return professorID;
    }
    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }
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
