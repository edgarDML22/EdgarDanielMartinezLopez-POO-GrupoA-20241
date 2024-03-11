import java.util.*;

public class BookStore {

    Scanner sc = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();

    public BookStore(){

    }

    public void addUser(){
        System.out.print("Insert the name: ");
        String name = sc.next();
        System.out.print("\nInsert the age: ");
        int age = sc.nextInt();
            userList.add(new User(name, age));
            System.out.println("The user was added succesfully");
    }

    public void deleteUser(){
        if(userList.isEmpty()){
            System.out.println("There are not users registered");
        }
        else{
            int i = getUserIndex();
            if(validUserIndex(i)){
                userList.remove(i);
                System.out.println("The user was removed succesfully");
            }
            else{
                System.out.println("The user wasn't found");
                /* 
                System.out.println("Do you want to try again? Y/N"); //FASE DE PRUEBA
                String answer = sc.next();
                    if(answer.equals("Y")){
                        deleteUser();
                    }
                */
            }
        } 
    }

    public void addBook(){
        System.out.print("Insert the title: ");
        String title = sc.next();
        System.out.print("\nInsert the author: ");
        String author = sc.next();
            bookList.add(new Book(title, author));
            System.out.println("The book was added succesfully");
    }

    public void deleteBook(){
        if(bookList.isEmpty()){
            System.out.println("There are not books registered");
        }
        else{
            int i = getBookIndex();
            if(validBookIndex(i)){
                bookList.remove(i);
                System.out.println("The book was removed succesfully");
            }
            else{

                System.out.println("The book wasn't found");
                /* 
                System.out.println("Do you want to try again? Y/N"); //FASE DE PRUEBA
                String answer = sc.next();
                    if(answer.equals("Y")){
                        deleteUser();
                    }
                */
            }

        }   
    }

    public void rentBook(){
        if(userList.isEmpty() || bookList.isEmpty()){
            System.out.println("There are no users or books to make a rent");
        }
        else{
            int i = getBookIndex();
            if(validBookIndex(i)){
                int n = getUserIndex();
                if(validUserIndex(n)){
                    bookList.get(i).setRented(true);
                    userList.get(n).getBookList().add(bookList.get(i));
                }
                else{
                    System.out.println("The user wasn't found");
                }
            }
            else{
                System.out.println("The book wasn't found");
            }
        }
    }

    public void showUserList(){
        if(userList.isEmpty()){
            System.out.println("There are not users registered");
        }
        else{
            System.out.println(" -------------USERS INFORMATION------------- ");
            for (User user : userList) {
                System.out.printf(" | NAME: %s | AGE: %s | ID: %s |",user.getName(), user.getAge(), user.getID());
                System.out.println(" \n_____________BOOKS RENTED_____________ ");
                for (Book book : user.getBookList()) {
                    System.out.printf(" | TITLE: %s| AUTHOR: %s |", book.getTitle(), book.getAuthor());                   
                }
                System.out.println();
            }
        }
    }

    public void showUserData(){
        if(userList.isEmpty()){
            System.out.println("There are not users registered");
        }
        else{
            int i = getUserIndex();
            if(validUserIndex(i)){
                System.out.println(" INFORMATION FROM THE USER: " + userList.get(i).getName());
                    System.out.printf(" | NAME: %s | AGE: %s | ID: %s |", userList.get(i).getName(), userList.get(i).getAge(), userList.get(i).getID());
                    System.out.println(" \n_____________BOOKS RENTED_____________ ");
                    for (Book book : userList.get(i).getBookList()) {
                        System.out.printf(" | TITLE: %s| AUTHOR: %s |", book.getTitle(), book.getAuthor());                   
                    }
                    System.out.println();
            }
            else{
                System.out.println("The user wasn't found");
            }
            
        }
    }




    private void showUserNames(){
        System.out.println("These are the ID avaliable to make a register");
        System.out.println("----------------------------------");
        for (User user : userList) {
            System.out.printf(" | NAME: %s | ID: %s | ", user.getName(), user.getID());
            System.out.println();
            
        }
    }

    private int getUserIndex(){//PROBAR QUE SE INGRESEN 2 CON EL MISMO NOMBRE Y SER CAPAZ DE DISTINGUIRLOS POR ID
        int x = -1;
        showUserNames();
            System.out.println("Insert the ID of the user");
            String ID = sc.next();

            for (int i = 0; i < userList.size(); i++) {
                if(ID.equals(userList.get(i).getID())){
                    x = i;
                    break;
                }
            }
        return x;
    }

    private boolean validUserIndex(int i){
        if(i == -1){
            return false;
        }
        else{
            return true;
        }
    }


    private void showBookTitles(){
        System.out.println("These are the ID avaliable");
        System.out.println("----------------------------------");
        for (Book book : bookList) {
            System.out.printf(" | TITLE: %s | ID: %s | ", book.getTitle(), book.getID());
            System.out.println();
            
        }
    }

    private int getBookIndex(){//PROBAR QUE SE INGRESEN 2 CON EL MISMO NOMBRE Y SER CAPAZ DE DISTINGUIRLOS POR ID
        int x = -1;
        showBookTitles();
            System.out.println("Insert the ID of the book");
            String ID = sc.next();

            for (int i = 0; i < bookList.size(); i++) {
                if(ID.equals(bookList.get(i).getID())){
                    x = i;
                    break;
                }
            }
        return x;
    }

    private boolean validBookIndex(int i){
        if(i == -1){
            return false;
        }
        else{
            return true;
        }
    }

    
}
