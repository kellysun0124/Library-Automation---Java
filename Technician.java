public class Technician extends Employee{
    public Technician (String name, String address, String dateOfBirth, String email, String socialSecurityNumber, String empType, int employeeNumber){
        super(name, address, dateOfBirth, email, socialSecurityNumber, empType, employeeNumber);
    }
    //access collection to re-shelve things
    public String getCollectionID(Collections collection){
        return collection.getCollectionID();
    }
}

