import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    Scanner sc = new Scanner(System.in);
    ArrayList<BankAccount> BankAccountList = new ArrayList<>();
    ArrayList<Employee>EmployeeList = new ArrayList<>();

    public Bank(){
    }

    public void addEmployee(){//VERSIÓN FINAL
        System.out.print("Insert the employee name: ");
        String name = sc.next();
        System.out.print("Insert the employee last name: ");
        String lastName = sc.next();
        System.out.print("Insert the account number: ");
        long accountNumber = sc.nextLong();
        System.out.print("Insert the account type: ");
        String type = sc.next();

        Employee employee = new Employee(name, lastName, accountNumber, type);
            if(employee.isStatus()){
                EmployeeList.add(employee);
                BankAccountList.add(employee.getAccount());
                System.out.println("The employee was added succesfully");
            }
            else{
                System.out.println("The employee wasn't added");
            }
    }

    public void addAccount(){//VERSIÓN FINAL
        if(EmployeeList.isEmpty()){
            System.out.println("There are no employees registered");
        }
        else{
            int i = getEmployeeIndex(askName());
                if(validEmployeeIndex(i)){
                    System.out.print("Insert the account number: ");
                    long accountNumber = sc.nextLong();
                    System.out.print("Insert the account type: ");
                    String type = sc.next();

                    BankAccount newAccount = EmployeeList.get(i).addAccount(accountNumber, type);
                        if(newAccount != null){
                            BankAccountList.add(newAccount);
                            System.out.println("The account was added succesfully");
                        }
                        else{
                            System.out.println("The account wasn't added");
                        }
                }
                else{
                    System.out.println("The name wasn't found");
                } 
        }
    }

    public void addMoneyAccount(){ //VERSIÓN FINAL
        int i = getEmployeeIndex(askName());
            if(validEmployeeIndex(i)){
                if(EmployeeList.get(i).getAccountList().isEmpty()){
                    System.out.println("This user has no accounts registered");
                }
                else{
                    showBankAccounts(i);
                        int n = getBankAccountNumberIndex(askAccountNumber(), i);
                        if(validAccountNumber(n)){
                            BankAccount bankAccount = EmployeeList.get(i).getAccountList().get(n);
                            System.out.print("\nIngrese el monto a depositar: ");
                            double monto = sc.nextDouble();
                            bankAccount.agregarDinero(monto);
                        }
                        else{
                            System.out.println("The account wasn't found");
                        }
                }  
            }
            else{
                System.out.println("The name wasn't found");

            } 
    }

    public void getMoneyAccount(){ //VERSIÓN FINAL
        int i = getEmployeeIndex(askName());
            if(validEmployeeIndex(i)){
                if(EmployeeList.get(i).getAccountList().isEmpty()){
                    System.out.println("This user has no accounts registered");
                }
                else{
                    showBankAccounts(i);
                        int n = getBankAccountNumberIndex(askAccountNumber(), i);
                            if(validAccountNumber(n)){
                                BankAccount bankAccount = EmployeeList.get(i).getAccountList().get(n);
                                System.out.println("Ingrese el monto a retirar");
                                double monto = sc.nextDouble();
                                bankAccount.retirarDinero(monto);
                            }
                            else{
                                System.out.println("The account wasn't found");
                            }
                }
            }
            else{
                System.out.println("The name wasn't found");
            }
    }

    public void deleteEmployee(){
        if(EmployeeList.isEmpty()){
            System.out.println("There are no employees registered");
        }
        else{
            int i = getEmployeeIndex(askName());
                if(validEmployeeIndex(i)){ 

                    EmployeeList.remove(i);
                    System.out.println("The employee was removed succesfully");
                }
                else{
                    System.out.println("The emplyee wasn't found");
                }
        }   
    }

    public void deleteAccount(){
        int i = getEmployeeIndex(askName());
            if(validEmployeeIndex(i)){
                if(BankAccountList.isEmpty()){
                    System.out.println("There are no bank accounts registered");
                }
                else{
                    showBankAccounts(i); 
                        int n = getBankAccountNumberIndex(askAccountNumber(), i);
                            if(validAccountNumber(n)){
                                Employee employee = EmployeeList.get(i);
                                BankAccountList.remove(employee.getAccountList().get(n));
                                employee.getAccountList().remove(n);
                                System.out.println("The account was removed succesfully");
                            }
                            else{
                                System.out.println("The account wasn't found");
                            }

                }
            }
            else{
                System.out.println("The name wasn't found");
            }
    }  
    

    public void showBankAccountList(){//TERMINADO NO TOCAR
        if(BankAccountList.isEmpty()){
            System.out.println("There are no bank acounts registered");
        }
        else{
            System.out.println(" --------------------------BANK ACCOUNTS INFORMATION--------------------------");
                for (Employee employee : EmployeeList) {
                    for (BankAccount bankAccount : employee.getAccountList()) {//NOMBRE, NÚMERO DE CUENTA, TIPO DE CUENTA Y AMOUNT
                        System.out.printf(" | EMPLOYEE: %s | ACCOUNT NUMBER: %d | ACCOUNT TYPE: %s | AMOUNT: % .2f |", employee.getFullName(), bankAccount.getAccountNumber(), bankAccount.getType(), bankAccount.getAmount());
                        System.out.println();
                    } 
                } 
        }
    }

    public void showBankAccountData(){//VERSIÓN FINAL --TERMINADO-- PIDIENDO EL NOMBRE Y EL NÚERO DE CUENTA
        int i = getEmployeeIndex(askName());
            if(validEmployeeIndex(i)){ 
                showBankAccounts(i); //CUENTAS DEL EMPLEADO EMPLOYEELIST.GET(i)
                int n = getBankAccountNumberIndex(askAccountNumber(), i);//MÉTODO PARA OBTENER EL INDICE DEL NUMERO DE CUENTA INGRESADO EN CONSOLA
                if(validAccountNumber(n)){
                    BankAccount bankAccount = EmployeeList.get(i).getAccountList().get(n);
                    System.out.printf("| ACCOUNT NUMBER: %d | ACCOUNT TYPE: %s | AMOUNT: % .2f |", bankAccount.getAccountNumber(), bankAccount.getType(), bankAccount.getAmount());
                    System.out.println();
                }
                else{
                    System.out.println("The account wasn't found");
                }
            }
            else{
                System.out.println("The name wasn't found");
            }   
    }



    public void showEmployeeList(){//EJEMPLO PARA LOS DEMÁS SHOW -- VERSIÓN FINAL
        if(EmployeeList.isEmpty()){
            System.out.println("There are no employees registered");
        }
        else{
            System.out.println(" --------------------------EMPLOYEES INFORMATION-------------------------- ");
                for (Employee employee : EmployeeList) {
                    System.out.printf("| NAME: %s | LASTNAME: %s |" , employee.getName(), employee.getLastName());
                    System.out.println(" \n------------------------------EMPLOYEE ACCOUNTS------------------------------ ");
                        for (BankAccount bankAccount : employee.getAccountList()) {
                                System.out.printf("| ACCOUNT NUMBER: %d | ACCOUNT TYPE: %s | ACCOUNT AMOUNT: % .2f |",bankAccount.getAccountNumber(), bankAccount.getType(), bankAccount.getAmount());
                                System.out.println();
                        }
                System.out.println("******************************************************************************");
                }  
        }    
    }


    public void showEmployeeData(){//--------EJEMPLO DE COMO HACERLO PIDIENDO EL NOMBRE EN CONSOLA------------
        if(EmployeeList.isEmpty()){
            System.out.println("There are no employees registered");
        }
        else{
            int i = getEmployeeIndex(askName());
            if(validEmployeeIndex(i)){
                System.out.printf("| NAME: %s | LASTNAME: %s |" , EmployeeList.get(i).getName(), EmployeeList.get(i).getLastName());
                System.out.println(" \n------------------------------EMPLOYEE ACCOUNTS------------------------------ ");
                    for (BankAccount bankAccount : EmployeeList.get(i).getAccountList()) {
                        System.out.printf("| ACCOUNT NUMBER: %d | ACCOUNT TYPE: %s | ACCOUNT AMOUNT: % .2f |", bankAccount.getAccountNumber(), bankAccount.getType(), bankAccount.getAmount());
                        System.out.println();
                    }             
            }
            else{
                System.out.println("The name wasn't found");    
            }
        }  
    }

    //MÉTODOS AUXILIARES

    private boolean showUserNames(){//MÉTODO PARA MOSTRAR LOS NOMBRES DISPONIBLES
        if(EmployeeList.isEmpty()){
            System.out.println("There are no employees registered");
            System.out.println("AQUÍ MERO ENTRA");
            return false;
        }
        else{
            System.out.println("These are the employees registered in the bank");
            System.out.println("--------------------------------------------------");
                for (Employee employee : EmployeeList) {
                    System.out.printf(" | %s | " , employee.getName());       
                }
            return true;
        }
    }

    private String askName(){//MÉTODO PARA PEDIR EL NOMBRE EN CONSOLA
        boolean flag = showUserNames();
            if(flag){
                System.out.print("\nInsert the employee name: ");
                String name = sc.next();
                    return name;
            }
            else{
                return "noUser";
            }
        
    }

    private int getEmployeeIndex(String name){//MÉTODO PARA OBTENER EL ÍNDICE CUANDO SE INGRESA EL NOMBRE EN LA CONSOLA
        int x = -1;
            for (int i = 0; i < EmployeeList.size(); i++) {
                if(EmployeeList.get(i).getName().equalsIgnoreCase(name)){
                    x = i;
                    break;
                }
            }
            return x;
    }

    private boolean validEmployeeIndex(int i){//MÉTODO PARA VALIDAR EL ÍNDICE RECIBIDO DEL MÉTODO getEmployeeIndex
        if(i == -1){
            return false;
        }
        else{
            return true;
        }
    }

    private void showBankAccounts(int i){
        if(EmployeeList.get(i).getAccountList().isEmpty()){
            System.out.println("This user has no account numbers");
        }
        else{
            System.out.printf("These are the account numbers of the employee %s", EmployeeList.get(i).getName());
            System.out.println("\n--------------------------------------------------");
                for (BankAccount bankAccount : EmployeeList.get(i).getAccountList()) {
                    System.out.printf(" | %d | " , bankAccount.getAccountNumber());       
                }
        }
    }

    private long askAccountNumber(){
        System.out.print("\nInsert the account number: ");
        long accountNumber = sc.nextLong();
        return accountNumber;
    }

    private int getBankAccountNumberIndex(long accountNumber, int index){//MÉTODO PARA DEVOLVER EL ÍNDICE DE LA CUENTA CON ACCOUNT NUMBER RECIBIDO
        int x = -1;
            for (int i = 0; i < EmployeeList.get(index).getAccountList().size(); i++) {
                if(accountNumber == EmployeeList.get(index).getAccountList().get(i).getAccountNumber()){
                    x = i;
                    break;
                }
            }
            return x;
    }

    private boolean validAccountNumber(int i){//MÉTODO PARA VALIDAR EL ÍNDICE RECIBIDO DEL MÉTODO getAccountNumberIndex
        if(i == -1){
            return false;
        }
        else{
            return true;
        }
    }
}