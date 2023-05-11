import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args){
        /*Books book1 = new Books();
        /*
        Books book1 = new Books();
        System.out.println(book1.getISBN());
        System.out.println(book1.getTitle());
        */


        /*
        Books book2 = new Books("1", "Percy Jackson", "ABC123");
        System.out.println(book2.getISBN());
        System.out.println(book2.getTitle());
        System.out.println(book2.getCollectionID());
        System.out.println(book2.getCollectionID());
        */

        Date dob = new Date(0);
        Member member1 = new Member();
        
        UpdateMember.update(member1);
        //UpdateMember.update(member1);

        //newCollectionEvent.newCollectionEvent();
        //RemoveCollectionEvent.removeCollection();

        newCollectionEvent.newCollectionEvent();
        Checkout.checkouts(member1);
        //Checkout.checkouts(member1);
        //Call this method with the member object to be updated
        //UpdateMember.update(<member>);

        //should make some data for each (books, dvd, journals, newpapers, professor, student, external, technicians)
        //check all is working (newEmployee, newCOllectionEvent, newMemberEvent, removeCollectionEvent, removeEmployeeEvent, updateMember, CheckInEvent, checkoutEvent)
    }
}
