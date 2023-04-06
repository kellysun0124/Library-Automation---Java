public class Student extends Member{
    private int studentID;

    public Student(String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int memberID, int studentID) {
        super(name, address, dateOfBirth, email, socialSecurityNumber, memberID);
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int strudentID) {
        this.studentID = studentID;
    }
}
