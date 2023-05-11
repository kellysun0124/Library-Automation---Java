import java.util.Date;

public class Employee extends Person {
    private int employeeNumber;
    protected String empType;

    // Constructor
    public Employee(int employeeNumber, String name, String address, Date dateOfBirth, String email, String socialSecurityNumber,
            String empType) {
        super(name, address, dateOfBirth, email, socialSecurityNumber);
        this.employeeNumber = employeeNumber;
        this.empType = empType;
    }

    // Getter and Setter for employeeNumber
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) { 
        this.employeeNumber = employeeNumber;
    }

    public String getEmpType() {
        return this.empType;
    }

    //make into string to be used with SaveToFile.java
    public String toString() {
        return String.format("%2d\t%s\t%s\t%s\t%s\t%s\t%s\t\n", this.getEmployeeNumber(), this.getName(), this.getAddress(), this.getDateOfBirth(), this.getEmail(), this.getSocialSecurityNumber(), this.getEmpType());
    }

}