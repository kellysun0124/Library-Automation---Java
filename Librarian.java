public class Librarian extends Employee {
    public Librarian (String name, String address, String dateOfBirth, String email, String socialSecurityNumber, String empType, int employeeNumber){
        super(name, address, dateOfBirth, email, socialSecurityNumber, empType, employeeNumber);
        
    }
    public String getMemberID(Member member){
        return member.getMemberID();
    }
    public void setMemberID(Member member){
        setMemberID(member);
    }
    public String getCollectionID(Collections collection){
        return collection.getCollectionID();
    }

    public String getBookISBN(Books book){
        return book.getISBN();
    }
    //maybe need to get author? type? 
    //managing the collections
    //helping customer with resources
    
}


