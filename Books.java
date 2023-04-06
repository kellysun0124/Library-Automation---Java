public class Books extends Collections {
    protected String ISBN;
    protected String author;

    public Books(String collectionID, String section, String type, String title, String publisher, int year, String genre, String ISBN, String author) {
        super(collectionID, section, type, title, publisher, year, genre);
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getAuthor() {
        return this.author;
    }
}
