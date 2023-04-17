public class Employee extends Person {
    private int employeeNumber;
    protected String empType;

    // Constructor
    public Employee(String name, String address, String dateOfBirth, String email, String socialSecurityNumber,
            String empType, int employeeNumber) {
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

    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%2d\n", this.getName(), this.getAddress(), this.getDateOfBirth(), this.getEmail(), this.getSocialSecurityNumber(), this.getEmpType(), this.getEmployeeNumber());
    }

}