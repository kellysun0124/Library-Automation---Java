import java.util.*;

public abstract class Collections {
    protected String section;
    protected String collectionID;
    protected String type;
    protected String author;
    protected String publisher;
    protected String title;
    protected int year;
    
    public Collections(String collectionID, String author, String section, String type, String title, String publisher, int year) {
        this.collectionID = collectionID;
        this.author = author;
        this.section = section;
        this.type = type;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }
}