import java.util.Date;
import java.text.SimpleDateFormat;

public class Person {
    protected String name;
    protected String address;
    protected Date dateOfBirth;
    protected String email;
    protected String socialSecurityNumber;

    // Constructor
    public Person(String name, String address, Date dateOfBirth, String email, String socialSecurityNumber) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(dateOfBirth);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}