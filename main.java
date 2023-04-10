

class main{
    public static void main(String[] args){
        //test book to test code
        Books bookname = new Books("456456", "series 1", "book", "harry potter", "penguin", 1997, "fiction", "456456", "JK rowling", 100);
        System.out.println(bookname.getISBN());
        System.out.println(bookname.getTitle());
        

    }
}