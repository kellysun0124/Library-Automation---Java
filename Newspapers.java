public class Newspapers extends Collections {
    protected String ISSN;
    protected String author;

    public Newspapers(String collectionID, String section, String type, String title, String publisher, int year, String genre, String ISBN, String author) {
        super(collectionID, section, type, title, publisher, year, genre);
    }

    public String getISSN() {
        return this.ISSN;
    }

    public String getAuthor() {
        return this.author;
    }
}
