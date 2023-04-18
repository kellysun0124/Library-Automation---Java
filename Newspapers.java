import java.util.Calendar;

public class Newspapers extends Collections {
    protected String ISSN;
    protected int amountOfPages;

    public Newspapers() {
        super();
        this.type = "Newspaper";
        this.ISSN = "000000";
        this.amountOfPages = 0;
    }

    public Newspapers(String collectionID, String title, String ISSN) {
        this();
        this.collectionID = collectionID;
        this.title = title;
        this.ISSN = ISSN;
    }

    public Newspapers(String collectionID, String section, String title, String publisher, String genre, String type,
            String ISSN, int amountOfPages) {
        super(collectionID, section, title, publisher, genre, type);
        this.type = "Newspaper";
        this.ISSN = ISSN;
        this.amountOfPages = amountOfPages;
    }

    public String getISSN() {
        return this.ISSN;
    }

    public int getAmountOfPages() {
        return this.amountOfPages;
    }
}
