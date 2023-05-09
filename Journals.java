import java.util.*;

public class Journals extends Collections {
    protected String ISSN;
    protected String author;
    protected int amountOfPages;

    public Journals() {
        super();
        this.type = "Journal";
        this.ISSN = "000000";
        this.author = "Unknown Author";
        this.amountOfPages = 0;
    }

    public Journals(String collectionID, String title, String ISSN) {
        this();
        this.collectionID = collectionID;
        this.title = title;
        this.ISSN = ISSN;
    }

    public Journals(String collectionID, String section, String title, String publisher, String genre, String type,
            String ISSN, String author, int amountOfPages) {
        super(collectionID, section, title, publisher, genre, type);
        this.type = "Journal";
        this.ISSN = ISSN;
        this.author = author;
        this.amountOfPages = amountOfPages;
    }

    public String getISSN() {
        return this.ISSN;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getAmountOfPages() {
        return this.amountOfPages;
    }

    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%2d\n", this.getCollectionID(), this.getISSN(), this.getSection(), this.getType(), this.getTitle(), this.getPublisher(), this.getGenre(), this.getAuthor(), this.getAmountOfPages());
    }
}
