public class Books extends Collections {
    protected String ISBN;

    public Books(String collectionID, String author, String section, String type, String title, String publisher, int year, String genre, String ISBN) {
        super(collectionID, author, section, type, title, publisher, year, genre);
    }

    public String getISBN() {
        return this.ISBN;
    }
}
