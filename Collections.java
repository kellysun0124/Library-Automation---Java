public abstract class Collections {
    protected String collectionID;
    protected String type;
    protected String publisher;
    protected String title;
    protected String genre;

    //set defaults
    public Collections() {
        this.collectionID = "Unknown CollectionID";
        this.type = "Unknown Type";
        this.title = "Unknown Title";
        this.publisher = "Unknown Publisher";
        this.genre = "Unknown Genre";
    }

    //constructors
    public Collections(String collectionID, String title, String publisher, String genre, String type) {
        this.collectionID = collectionID;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
    }


    public String getCollectionID() {
        return this.collectionID;
    }

    public String getType() {
        return this.type;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getTitle() {
        return this.title;
    }
}
