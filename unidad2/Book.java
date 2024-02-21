public class Book {
    public String title = "El principito", author = "Antoine";
    public int year = 1943;


    String getBookInfo(){
        return String.format("Title: %s, Age: %d, Author: %s", title, year, author);
    }

    public void print(){
        System.out.println(getBookInfo());
    }
    
}
