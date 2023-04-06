public class Person {
    private String name;
    private String address;
    private String dateOfBirth;
    private String email;
    private String socialSecurityNumber;

    // Constructor
    public Person(String name, String address, String dateOfBirth, String email, String socialSecurityNumber) {
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
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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