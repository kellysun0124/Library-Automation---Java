import java.util.Calendar;

public class Newspapers extends Collections {
    protected String ISSN;

    //set default and set type to newspaper
    public Newspapers() {
        super();
        this.type = "Newspaper";
        this.ISSN = "0000000";
    }

    public Newspapers(String collectionID, String title, String ISSN) {
        this();
        this.collectionID = collectionID;
        this.title = title;
        this.ISSN = ISSN;
    }

    public Newspapers(String collectionID, String title, String publisher, String genre, String type,
            String ISSN) {
        super(collectionID, title, publisher, genre, type);
        this.type = "Newspaper";
        this.ISSN = ISSN;
    }

    public String getISSN() {
        return this.ISSN;
    }



    //make into string to be used with SaveToFile.java
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s\n", this.getCollectionID(), this.getISSN(), this.getTitle(), this.getPublisher(), this.getGenre(), this.getType());
    }
}
