import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args){
        Books book1 = new Books();
        System.out.println(book1.getISBN());
        System.out.println(book1.getTitle());

        System.out.println();

        Books book2 = new Books("1", "Percy Jackson", "ABC123");
        System.out.println(book2.getISBN());
        System.out.println(book2.getTitle());
        System.out.println(book2.getCollectionID());

        //newMemberEvent.newMemberEvent();
        
        //newCollectionEvent.newCollectionEvent();
        //RemoveCollectionEvent.removeCollection();

        //Call this method with the member object to be updated
        //UpdateMember.update(<member>);
    }
}
