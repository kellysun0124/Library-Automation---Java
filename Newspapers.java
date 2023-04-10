import java.util.Date;

public class Newspapers extends Collections {
    protected String ISSN;
    protected Date date;
    protected int amountOfPages;

    public Newspapers(String collectionID, String section, String type, String title, String publisher, int year, String genre, String ISSN, Date date, int amountOfPages) {
        super(collectionID, section, type, title, publisher, year, genre);
        this.ISSN = ISSN;
        this.date = date;
        this.amountOfPages = amountOfPages;
    }

    public String getISSN() {
        return this.ISSN;
    }

    public Date getDate() {
        return this.date;
    }

    public int getAmountOfPages() {
        return this.amountOfPages;
    }
}
