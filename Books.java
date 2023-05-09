import java.util.*;

public class Books extends Collections {
    protected String ISBN;
    protected String author;
    protected int amountOfPages;

    //set defaults and set type to book
    public Books() {
        super();
        this.type = "Book";
        this.ISBN = "0000000000000";
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
    //make into string to be used with SaveToFile.java
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%2d\n", this.getCollectionID(), this.getISBN(), this.getSection(), this.getType(), this.getTitle(), this.getPublisher(), this.getGenre(), this.getAuthor(), this.getAmountOfPages());
    }
}
