public class Professor extends Member{
    private int professorID;

    public Professor(String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int memberID, int professorID) {
        super(name, address, dateOfBirth, email, socialSecurityNumber, memberID);
        this.professorID = professorID;
    }

    public int getProfessorID() {
        return professorID;
    }
    public void setProfessorID(int strudentID) {
        this.professorID = professorID;
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
