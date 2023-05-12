import java.util.Date;

public class Student extends Member{
    private int studentID;
    private Professor advisor;
    //constructor
    public Student(String name, String address, Date dateOfBirth, String email, String socialSecurityNumber, String memberID, int studentID, Professor advisor, String memberType) {
        super(name, address, dateOfBirth, email, socialSecurityNumber, memberID, memberType);
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    
    public void accessProfessor(Professor advisor) {
        this.advisor = advisor;
    }

}
