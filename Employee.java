public class Employee extends Person {
    private int employeeNumber;

    // Constructor
    public Employee(String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int employeeNumber) {
        super(name, address, dateOfBirth, email, socialSecurityNumber);
        this.employeeNumber = employeeNumber;
    }

    // Getter and Setter for employeeNumber
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}