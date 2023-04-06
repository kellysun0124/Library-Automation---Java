public class DVDs extends Collections {
    protected String ISBN;
    protected int runTime;

    public DVDs(String collectionID, String section, String type, String title, String publisher, int year, String genre, String ISBN, int runTime) {
        super(collectionID, section, type, title, publisher, year, genre);
        //check what to do with author for dvds bruh
    }

    public String getISBN() {
        return this.ISBN;
    }

    public int getRunTime() {
        return this.runTime;
    }
}
