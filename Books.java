public class Books extends Collections {
    protected String ISBN;
    protected String author;
    protected int amountOfPages;

    public Books(String collectionID, String section, String type, String title, String publisher, int year, String genre, String ISBN, String author, int amountOfPages) {
        super(collectionID, section, type, title, publisher, year, genre);
        this.ISBN = ISBN;
        this.author = author;
        this.amountOfPages = amountOfPages;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getAmountOfPages() {
        return this.amountOfPages;
    }
}
