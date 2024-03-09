import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        boolean flag = true;
        while (flag) {
            showOptions();
            int x = sc.nextInt();
            switch (x) {
                case 1://VERSIÓN FINAL :))
                    bank.addEmployee();
                break;  

                case 2://VERSIÓN FINAL :))
                    bank.addAccount();         
                break;

                case 3: //VERSIÓN FINAL :))
                    bank.addMoneyAccount();
                break;

                case 4: //VERSIÓN FINAL :))
                    bank.getMoneyAccount();
                break;

                case 5:
                    bank.deleteEmployee();
                break;
                    
                case 6:
                    bank.deleteAccount();
                break;

                case 7://VERSIÓN FINAL :))
                    bank.showEmployeeList();                     
                break;

                case 8://VERSIÓN FINAL :))
                    bank.showEmployeeData();
                break;

                case 9://VERSIÓN FINAL
                    bank.showBankAccountList();
                break;

                case 10://VERSIÓN FINAL PIDIENDO NOMBRE Y ACCOUNTNUMBER :))
                    bank.showBankAccountData();
                break;
                    
                default: 
                    flag = false;
                break;        
            }//SWITCH
        }//WHILE   
    }//MAIN


        public static void showOptions(){
            System.out.println(" \n*******************BIENVENIDO AL BANCO******************* ");
            System.out.println("Choose an option");
            System.out.println("1. Add employee");
            System.out.println("2. Add account to a specific employee");
            System.out.println("3. Make a deposit to a specific account");
            System.out.println("4. Get money from a specific account");
            System.out.println("5. Delete an employee");
            System.out.println("6. Delete a bank account from an employee");
            System.out.println("7. Show the information of all registered employees");
            System.out.println("8. Show the information of an specific employee");
            System.out.println("9. Show all the bank accounts registered");
            System.out.println("10. Show the information of a specific bank account");
            System.out.println("11. Get out of the menu");
        }


}