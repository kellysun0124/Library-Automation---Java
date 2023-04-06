import java.util.*;

public abstract class Collections {
    protected String section;
    protected String collectionID;
    protected String type;
    protected String author;
    protected String publisher;
    protected String title;
    protected int year;
    protected String genre;

    public Collections(String collectionID, String author, String section, String type, String title, String publisher, int year, String genre) {
        this.collectionID = collectionID;
        this.author = author;
        this.section = section;
        this.type = type;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.genre = genre;
    }

    public String getCollectionID() {
        return this.collectionID;
    }

    public String getSection() {
        return this.section;
    }

    public String getType() {
        return this.type;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }
}