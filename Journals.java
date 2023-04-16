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

    public Journals(String collectionID, String section, String title, String publisher, String genre, Calendar datePublished, String ISSN, String author, int amountOfPages) {
        super(collectionID, section, title, publisher, genre, datePublished);
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
}
