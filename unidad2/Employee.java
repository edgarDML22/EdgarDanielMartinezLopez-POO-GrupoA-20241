public class Employee {
    private String name;
    private String lastName;
    private BankAccount account;

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Employee(String name, String lastName, long accountNumber, String type) {
        this.name = name;
        this.lastName = lastName;
        this.account = new BankAccount(accountNumber, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void printAccount(){
        if(account.getType().equals("")){
            System.out.println("\nEste empleado no tiene una cuenta bancaria");
        }

        else{
            System.out.printf("El número de cuenta del emepleado %s %s es %d, su saldo es % .2f y la cuenta es de tipo %s", getName(), 
            getLastName(), account.getAccountNumber(), account.getAmount(), account.getType());
        }

    }

    
}



