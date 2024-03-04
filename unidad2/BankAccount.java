public class BankAccount {
    private long accountNumber;
    private double amount;
    private String type;

    public BankAccount(long accountNumber, String type) {
        switch (type) {
            case "A":
            case "B":
            case "C":
                this.accountNumber = accountNumber;
                this.type = type;
                System.out.println("Cuenta creada exitosamente");
            break;    

            default:
                System.out.println("No fue posible crear la cuenta");
                this.type = "";
                break;
        }
        
    }


    public long getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void cargarCuenta(double cargo){
        switch (type) {
            case "A":
            if(amount + cargo >= 50000){
                System.out.println("\nHa excedido la cantidad máxima de este tipo de cuenta");
            }
            else if(cargo < 0){
                System.out.println("\nNo puede realizar un cargo negativo");
            }
            else{
                amount += cargo;
            }               
            break;

            case "B":
            if(amount + cargo >= 100000){
                System.out.println("\nHa excedido la cantidad máxima de este tipo de cuenta");
            }
            else if(cargo < 0){
                System.out.println("\nNo puede realizar un cargo negativo");
            }
            else{
                amount += cargo;
            }               
            break;
        
            case "C":
            if(cargo < 0){
                System.out.println("\nNo puede realizar un cargo negativo");
            }
            else{
                amount += cargo;
            }               
            break;

            default:
            System.out.println("No hay una cuenta bancaria a la cual hacer el cargo");
            break;
        }


    }

    public void retirarCuenta(double retiro){
        switch (type) {
            case "A":
            if(amount < 1000){
                System.out.println("\nSaldo insuficiente para retirar");
            }
            else if(amount < retiro){
                System.out.println("\nEl dinero a retirar es mayor al saldo disponible");
            }
            else{
                amount -= retiro;
            }               
            break;

            
            case "B":
            if(amount < 5000){
                System.out.println("\nSaldo insuficiente para retirar");
            }
            else if(amount < retiro){
                System.out.println("\nEl dinero a retirar es mayor al saldo disponible");
            }
            else{
                amount -= retiro;
            }               
            break;

            case "C":
            if(amount < 10000){
                System.out.println("\nSaldo insuficiente para retirar");
            }
            else if(amount < retiro){
                System.out.println("\nEl dinero a retirar es mayor al saldo disponible");
            }
            else{
                amount -= retiro;
            }               
            break;

            default:
            System.out.println("No hay una cuenta bancaria para realizar el retiro");
            break;
        }


    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 17cf335a909e934d787bac37ce5b9ecc45ee109f
