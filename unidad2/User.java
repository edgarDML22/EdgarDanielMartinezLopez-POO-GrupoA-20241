import java.util.*;

public class User {
    Random ran = new Random();
    private String name;
    private int age;
    private ArrayList<Book> bookList;
    private String ID;

    


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


    //MÉTODOS AUXILIARES
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
