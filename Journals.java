public class Journals extends Collections {
    protected String ISSN;
    protected String author;
    protected int amountOfPages;

    public Journals(String collectionID, String section, String type, String title, String publisher, int year, String genre, String ISSN, String author, int amountOfPages) {
        super(collectionID, section, type, title, publisher, year, genre);
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
