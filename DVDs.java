import java.util.*;

public class DVDs extends Collections {
    protected String ISBN;
    protected int runtime;

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

    public DVDs(String collectionID, String section, String title, String publisher, String genre, Calendar datePublished, String ISBN, int runtime) {
        super(collectionID, section, title, publisher, genre, datePublished);
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
}