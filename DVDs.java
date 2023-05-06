import java.util.*;

public class DVDs extends Collections {
    protected String ISBN;
    protected int runtime;

    //default & set type to dvd
    public DVDs() {
        super();
        this.type = "DVD";
        this.ISBN = "000000";
        this.runtime = 0;
    }

    public DVDs(String collectionID, String title, String ISBN) {
        this();
        this.collectionID = collectionID;
        this.title = title;
        this.ISBN = ISBN;
    }

    public DVDs(String collectionID, String section, String title, String publisher, String genre, String ISBN,
            String type, int runtime) {
        super(collectionID, section, title, publisher, genre, type);
        this.type = "DVD";
        this.ISBN = ISBN;
        this.runtime = runtime;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public int getRuntime() {
        return this.runtime;
    }

    //make into string to be used with SaveToFile.java
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", this.getCollectionID(), this.getSection(), this.getType(), this.getTitle(), this.getPublisher(), this.getGenre(), this.getISBN(), this.getRuntime());
    }
}
