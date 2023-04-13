import java.util.*;

class MainClass{
    public static void main(String[] args){
        Books book1 = new Books();
        System.out.println(book1.getISBN());
        System.out.println(book1.getTitle());

        System.out.println();

        Books book2 = new Books("1", "Percy Jackson", "ABC123");
        System.out.println(book2.getISBN());
        System.out.println(book2.getTitle());
        System.out.println(book2.getCollectionID());
        

    /* 
        protected String ISBN;
        protected String author;
        protected int amountOfPages;


        ---
        protected String section;
        protected String collectionID;
        protected String type;
        protected String publisher;
        protected String title;
        protected int year;
        protected String genre;
        */
    }
}