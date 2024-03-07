import java.util.ArrayList;

public class Bank {
    ArrayList<BankAccount> BankAccountList = new ArrayList<>();

    public Bank(){
    }

    public void agregarCuentaBanco(BankAccount account){
        BankAccountList.add(account);
    }

    public void showBankAccountData(int n){
        BankAccount bankAccount = BankAccountList.get(n);

        System.out.printf("| Número de cuenta: %d | Tipo de cuenta: %s | Saldo de la cuenta: % .2f |",bankAccount.getAccountNumber(), bankAccount.getType(), bankAccount.getAmount());
            System.out.println("\n______________________________________________________________________");

    }

    public void showBankAccountList(){
        for (BankAccount bankAccount : BankAccountList) {
            System.out.printf("| Número de cuenta: %d | Tipo de cuenta: %s | Saldo de la cuenta: % .2f |",bankAccount.getAccountNumber(), bankAccount.getType(), bankAccount.getAmount());
            System.out.println("\n______________________________________________________________________");
            
        }

    }
    
}
