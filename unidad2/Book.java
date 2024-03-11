import java.util.Random;

public class Book {
    Random ran = new Random();
    private String title, author, ID;
    private boolean isRented;
    

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

    private String generateID(){
        String bank = "abcdefghijklmnopqrstuvwxyz0123456789";
        String cad = "";
        for (int i = 0; i < 6; i++) {
            cad += bank.charAt(ran.nextInt(bank.length()));        
        }
        System.out.println("cad: " + cad);
        return cad;
    }
    
}
