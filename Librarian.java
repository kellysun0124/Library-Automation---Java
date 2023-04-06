public class Librarian extends Employee {
    public Librarian (String name, String address, String dateOfBirth, String email, String socialSecurityNumber, int employeeNumber){
        super(name, address, dateOfBirth, email, socialSecurityNumber, employeeNumber);
    }
    public int getMemberID(Member member){
        return member.getMemberID();
    }
    public void setMemberID(Member member){
        setMemberID(member);
    }
    public String getCollectionID(Collections collection){
        return collection.getCollectionID();
    }
    //maybe need to get author? type? 
    //managing the collections
    //helping customer with resources
    
}


