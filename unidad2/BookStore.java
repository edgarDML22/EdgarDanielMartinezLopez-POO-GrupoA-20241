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
        System.out.print("Insert the age: ");
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
        System.out.println("Insert the title: ");
        String title = sc.nextLine();
        System.out.println("Insert the author: ");
        String author = sc.nextLine();
            bookList.add(new Book(title, author));
            System.out.println("The book was added successfully");
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
            System.out.println("There are not users or books to make a rent");
        }
        else{
            int i = getBookIndex();
            if(validBookIndex(i)){
                if(!bookList.get(i).isRented()){
                    int n = getUserIndex();
                    if(validUserIndex(n)){
                        bookList.get(i).rentBook(userList.get(n));
                        userList.get(n).rentBook(bookList.get(i));
                    }
                    else{
                        System.out.println("The user wasn't found");
                    }
                }
                else{
                    System.out.println("This book is actually rented by: " + bookList.get(i).getOwner().getName());
                }        
            }
            else{
                System.out.println("The book wasn't found");
            }
        }
    }

    public void returnBook(){
        if(bookList.isEmpty()){
            System.out.println("There are not books registered");
        }
        else{
            int i = getUserIndex();
            if(validUserIndex(i)){
                if(!userList.get(i).getBookList().isEmpty()){
                    int n = getBookIndex(i);
                    if(validBookIndex(n)){
                        userList.get(i).returnBook(bookList.get(n));
                        bookList.get(n).returnBook();
                        System.out.println("The book has been returned to the book store");
                    }
                    else{
                        System.out.println("The book wasn't found");
                    }
                }
                else{
                    System.out.println("This user hasn't rented any books yet");
                }
            }
            else{
                System.out.println("The user wasn't found");
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
                System.out.printf("\n | NAME: %s | AGE: %s | ID: %s |",user.getName(), user.getAge(), user.getID());   
                if(user.getBookList().isEmpty()){
                    System.out.println("\n---------This user hasn't rented any books---------");
                }
                else{
                    System.out.println(" \n_____________BOOKS RENTED_____________ ");
                    for (Book book : user.getBookList()) {
                        System.out.printf("\n | TITLE: %s| AUTHOR: %s |", book.getTitle(), book.getAuthor());                   
                    }
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
                    if(userList.get(i).getBookList().isEmpty()){
                        System.out.println("\n---------This user hasn't rented any books---------");
                    }
                    else{
                        System.out.println(" \n_____________BOOKS RENTED_____________ ");
                            for (Book book : userList.get(i).getBookList()) {
                                System.out.printf(" | TITLE: %s| AUTHOR: %s |", book.getTitle(), book.getAuthor());
                                System.out.println();
                            }                            
                    }
                    System.out.println();
            }
            else{
                System.out.println("The user wasn't found");
            }
            
        }
    }

    //EHCALO PARA EL FINAL
    

    public void showBookList(){
        if(bookList.isEmpty()){
            System.out.println("There are not books registered");
        }
        else{
            System.out.println(" ------------BOOK LIST------------");
            for (Book book : bookList) {
                System.out.printf("\n | TITLE: %s| AUTHOR: %s | NUMBER OF RENTS: %d | ", book.getTitle(), book.getAuthor(), book.getRentCounter());
                    if(!book.isRented()){
                        System.out.print(" | NO ACTUAL OWNER | ");
                    }
                    else{
                        System.out.printf(" | ACTUAL OWNER: %s | ", book.getOwner().getName());
                    }
                System.out.println();      
            }
        }
    }

    public void showActiveUsers(){
        if(userList.isEmpty()){
            System.out.println("There are not users registered");
        }
        else{
            System.out.println("These users have at least one rent on the register");
            for (User user : userList) {
                if(user.getRentCounter() > 0){
                    System.out.printf("\n | NAME: %s | AGE: %s | ID: %s |",user.getName(), user.getAge(), user.getID());
                    System.out.println();
                }       
            }
        }
    }

    public void showActiveBooks(){
        if(bookList.isEmpty()){
            System.out.println("There are not books registered");
        }
        else{
            for (Book book : bookList) {
                if(book.getRentCounter() > 0){
                    System.out.printf("\n | TITLE: %s| AUTHOR: %s | NUMBER OF RENTS: %d | ", book.getTitle(), book.getAuthor(), book.getRentCounter());
                    if(!book.isRented()){
                        System.out.print(" | NO ACTUAL OWNER | ");
                    }
                    else{
                        System.out.printf(" | ACTUAL OWNER: %s| ", book.getOwner().getName());
                    }
                System.out.println();
                }       
            }
        }
    }

    public void showInactiveBooks(){
        if(bookList.isEmpty()){
            System.out.println("There are not books registered");
        }
        else{
            System.out.println("These books have never been rented");
            for (Book book : bookList) {
                if(book.getRentCounter() == 0){
                    System.out.printf("\n | TITLE: %s| AUTHOR: %s | NUMBER OF RENTS: %d | ", book.getTitle(), book.getAuthor(), book.getRentCounter());
                    System.out.println();
                }       
            }
        }
    }



    




    private void showUserNames(){
        System.out.println("These are the ID avaliable");
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

    private void showBookTitles(int i){//i ES PARA EL USUARIO
        System.out.printf("These are the ID avaliable for the user: %s", userList.get(i).getName());
        System.out.println("----------------------------------");
        for (Book book : userList.get(i).getBookList()) {
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

    private int getBookIndex(int i){//
        int x = -1;
        showBookTitles(i);
            System.out.println("Insert the ID of the book");
            String ID = sc.next();

            for (int j = 0; j < bookList.size(); j++) {
                if(ID.equals(userList.get(i).getBookList().get(j).getID())){
                    x = j;
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
