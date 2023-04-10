

class main{
    public static void main(String[] args){
        Books bookname = new Books("456456", "series 1", "book", "harry potter", "penguin", 1997, "fiction", "456456", "JK rowling", 100);
        System.out.println(bookname.getISBN());
        System.out.println(bookname.getTitle());
        

    /* 
        protected String ISBN;
        protected String author;
        protected int amountOfPages;


        ---
        protected String section;
        protected String collectionID;
        protected String type;
        protected String publisher;
        protected String title;
        protected int year;
        protected String genre;
        */
    }
}