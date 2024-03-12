import java.util.Random;

public class Book {
    Random ran = new Random();
    private String title, author, ID;
    private boolean isRented;
    private int rentCounter;
    private User owner;
    

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        ID = generateID();
        this.isRented = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getID() {
        return ID;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean isRented) {
        this.isRented = isRented;
    }

    public int getRentCounter() {
        return rentCounter;
    }

    public void increaseCounter(){
        rentCounter ++;
    }

    public void setOwner(User owner){
        this.owner = owner;
    }

    public User getOwner(){
        return this.owner;
    }

    public void rentBook(User owner){
        setOwner(owner);
        setRented(true);
        rentCounter++;
        System.out.println("The book was rented succesfully");
    }

    public void returnBook(){
        setRented(false);
        setOwner(null);
    }

    private String generateID(){
        String bank = "abcdefghijklmnopqrstuvwxyz0123456789";
        String cad = "";
        for (int i = 0; i < 6; i++) {
            cad += bank.charAt(ran.nextInt(bank.length()));        
        }
        return cad;
    }   
}
