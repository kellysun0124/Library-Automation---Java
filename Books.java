import java.util.*;

public class Books extends Collections {
    protected String ISBN;
    protected String author;
    protected int amountOfPages;

    public Books() {
        super();
        this.type = "Book";
        this.ISBN = "000000";
        this.author = "Unknown Author";
        this.amountOfPages = 0;
    }

    public Books(String collectionID, String title, String ISBN) {
        this();
        this.collectionID = collectionID;
        this.title = title;
        this.ISBN = ISBN;
    }

    public Books(String collectionID, String section, String title, String publisher, String genre, String ISBN,
            String author, String type, int amountOfPages) {
        super(collectionID, section, title, publisher, genre, type);
        this.type = "Book";
        this.ISBN = ISBN;
        this.author = author;
        this.amountOfPages = amountOfPages;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getAmountOfPages() {
        return this.amountOfPages;
    }
}