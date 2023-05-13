public class uinewcollection {
    String currCollection = null;
    List<Collections> collectionsList = new ArrayList<>();

    public void saveButtonClicked() {
        if(currCollection != null) {
            String ID = GetIDs.returnID("Collectiondatabase.txt");
            String title = titleField.getText();
            String publisher = publisherField.getText();
            String genre = genreField.getText();
            String type = currCollection;
            String itemInfo = title + "\t" + publisher + "\t" + genre + "\t" + type + "\t";

            switch (currCollection) {
                case "DVDs":
                    String isbn = isbnField.getText();
                    itemInfo = ID + "\t" + isbn + "\t" + itemInfo + "\n";

                    DVDs dvd = new DVDs(ID, title, publisher, genre, isbn, type);
                    collectionsList.add(dvd);
                case "Books":
                    String isbn = isbnField.getText();
                    String author = authorField.getText();
                    itemInfo = ID + "\t" + isbn + "\t" + author + "\t" + itemInfo + "\n";

                    Books book = new Books(ID, title, publisher, genre, isbn, author, type);
                    collectionsList.add(book);
                case "Journals":
                    String issn = issnField.getText();
                    String author = authorField.getText();
                    itemInfo = ID + "\t" + issn + "\t" + author + "\t" + itemInfo + "\n";

                    Journals journal = new Journals(ID, title, publisher, genre, type, issn, author);
                    collectionsList.add(journal);
                case "Newspapers":
                    String issn = issnField.getText();
                    itemInfo = ID + "\t" + issn + "\t" + itemInfo + "\n";

                    Newspapers newspaper = new Newspapers(ID, title, publisher, genre, type, issn);
                    collectionsList.add(newspaper);
            }

            SaveToFile.save(employeeInfo, "Collectiondatabase.txt");
        } else {
            System.out.println("The collection type doesn't exist.");
        }
    }
}
