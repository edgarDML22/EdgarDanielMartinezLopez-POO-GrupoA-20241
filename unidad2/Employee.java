import java.util.ArrayList;

public class Employee {
    private String name;
    private String lastName;
    private BankAccount account;
    private boolean status = true;
    private ArrayList <BankAccount> AccountList = new ArrayList<>();

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Employee(String name, String lastName, long accountNumber, String type) {
        if(validType(type)){
            this.name = name;
            this.lastName = lastName;
            this.account = new BankAccount(accountNumber, type);
            AccountList.add(account);
        }
        else{
            this.status = false;
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

    public boolean isStatus() {
        return status;
    }

    public ArrayList <BankAccount> getAccountList(){//CREO QUE NO LO OCUPAS    
        return AccountList;
    }

    public BankAccount addAccount(long accountNumber, String type){
        BankAccount newAccount = null;
        if(validType(type)){
            newAccount = new BankAccount(accountNumber, type);
            AccountList.add(newAccount);
        }
        return newAccount;
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

    public String getFullName(){
        return name + " " + lastName;
    }

    /*private String generarID(){
        String bank = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890";
        String cad = "";
        for (int i = 0; i < 5; i++) {
            cad += bank.charAt(ran.nextInt(bank.length()));
        }
        return cad;
    }
    */
}