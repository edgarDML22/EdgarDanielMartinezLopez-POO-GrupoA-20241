import java.util.*;

public class User {
    Random ran = new Random();
    private String name;
    private int age;
    private ArrayList<Book> bookList = new ArrayList<>();
    private String ID;
    private int rentCounter;    


    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.ID = generateID();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String getID() {
        return ID;
    }

    public int getRentCounter() {
        return rentCounter;
    }

    public void increaseCounter(){
        rentCounter ++;
    }

    public void rentBook(Book book){
        bookList.add(book);
        rentCounter++;
    }

    public void returnBook(Book book){
        bookList.remove(book);
    }

    public void showUserBooks(){//QUITAR
        System.out.printf("These are the books rented by: %s", getName());
        for (Book book : bookList) {
            System.out.printf("\n | TITLE: %s| AUTHOR: %s |", book.getTitle(), book.getAuthor());
        }
    }



    //MÉTODOS AUXILIARES
    private String generateID(){
        String bank = "abcdefghijklmnopqrstuvwxyz0123456789";
        String cad = "";
        for (int i = 0; i < 6; i++) {
            cad += bank.charAt(ran.nextInt(bank.length()));        
        }
        return cad;
    }
    
}
