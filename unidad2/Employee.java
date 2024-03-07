import java.util.ArrayList;

public class Employee {
    private String name;
    private String lastName;
    private BankAccount account;
    ArrayList <BankAccount>AccountList = new ArrayList<>();

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Employee(String name, String lastName, long accountNumber, String type) {
        if(validType(type)){
            this.name = name;
            this.lastName = lastName;
            account = new BankAccount(accountNumber, type);
            AccountList.add(account);
        }
        else{
            this.name = null;
            System.out.println("No fue posible crear el empleado");
        } 
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void agregarCuenta(long accountNumber, String type){
        if(validType(type)){
            AccountList.add(new BankAccount(accountNumber, type));
        }
        else{
            System.out.println("No fue posible agregar la cuenta");
        }
    }

    private boolean validType(String type){
        switch(type){
            case "A":
            case "B":
            case "C":
                return true;

            default:
                return false;
        }
    }

    public void showData(){
        System.out.printf("| Nombre del empleado: %s |",nombreCompleto());
        System.out.println("\n______________________________________________________________________");
    }

    public void showAccountList(){
        for (BankAccount bankAccount : AccountList) {
            System.out.printf("| Número de cuenta: %d | Tipo de cuenta: %s | Saldo de la cuenta: % .2f |",bankAccount.getAccountNumber(), bankAccount.getType(), bankAccount.getAmount());
            System.out.println("\n______________________________________________________________________");
        }
    }

    public void getAccountList(){
        
    }

    public String nombreCompleto(){
        return name + " " + lastName;
    }

  
}