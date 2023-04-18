public abstract class Collections {
    protected String section;
    protected String collectionID;
    protected String type;
    protected String publisher;
    protected String title;
    protected String genre;

    public Collections() {
        this.collectionID = "Unknown CollectionID";
        this.section = "Unknown Section";
        this.type = "Unknown Type";
        this.title = "Unknown Title";
        this.publisher = "Unknown Publisher";
        this.genre = "Unknown Genre";
    }

    public Collections(String collectionID, String section, String title, String publisher, String genre, String type) {
        this.collectionID = collectionID;
        this.section = section;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
    }

    public String getCollectionID() {
        return this.collectionID;
    }

    public String getSection() {
        return this.section;
    }

    public String getType() {
        return this.type;
    }

    public String getGenre() {
        return this.type;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getTitle() {
        return this.title;
    }
}