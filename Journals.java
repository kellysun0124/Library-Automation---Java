import java.util.*;

public class Journals extends Collections {
    protected String ISSN;
    protected String author;

    //set defaults and set type to journal
    public Journals() {
        super();
        this.type = "Journal";
        this.ISSN = "0000000";
        this.author = "Unknown Author";
    }

    public Journals(String collectionID, String title, String ISSN) {
        this();
        this.collectionID = collectionID;
        this.title = title;
        this.ISSN = ISSN;
    }

    public Journals(String collectionID, String title, String publisher, String genre, String type,
            String ISSN, String author) {
        super(collectionID, title, publisher, genre, type);
        this.type = "Journal";
        this.ISSN = ISSN;
        this.author = author;
    }

    public String getISSN() {
        return this.ISSN;
    }

    public String getAuthor() {
        return this.author;
    }

  
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s\n", this.getCollectionID(), this.getISSN(), this.getTitle(), this.getPublisher(), this.getGenre(), this.getType(), this.getAuthor());
    }
}
   
