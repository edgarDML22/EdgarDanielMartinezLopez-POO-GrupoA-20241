import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while(flag){
            showOptions();
            int x = sc.nextInt();

            switch (x) {
                case 1:
                    bookStore.addUser();
                break;

                case 2:
                    bookStore.deleteUser();
                break;

                case 3:
                    bookStore.addBook();     
                break;

                case 4:
                    bookStore.deleteBook();       
                break;

                case 5:
                    bookStore.rentBook();
                    
                break;

                case 6:
                    bookStore.returnBook();
                break;

                case 7:
                    bookStore.showUserData();
                    
                break;

                case 8:
                    bookStore.showUserList();
                break;

                case 9:
                    bookStore.showBookList();
                break;

                case 10:
                    bookStore.showActiveUsers();
                break;

                case 11:
                    bookStore.showActiveBooks();
                break;

                case 12:
                    bookStore.showInactiveBooks();
                break;
            
                default:
                    flag = false;
                break;
            }

        }

        
    }

    public static void showOptions(){
        System.out.println("********WELCOME TO THE BOOK STORE********");
        System.out.println("1. Register an user");
        System.out.println("2. Remove an user");
        System.out.println("3. Register a book");
        System.out.println("4. Remove a book");
        System.out.println("5. Rent a book");
        System.out.println("6. Return book");
        System.out.println("7. Show the information of a specific user");
        System.out.println("8. Show all the users registered");
        System.out.println("9. Show all the books registered");
        System.out.println("10. Show all the users registered with at least one book rented");
        System.out.println("11. Show all the books that have been rented");
        System.out.println("12. Show all the books that haven't been rented");
        System.out.println("13. Get out of the book store");
        System.out.println("*********************************************************");
    }
    
}
