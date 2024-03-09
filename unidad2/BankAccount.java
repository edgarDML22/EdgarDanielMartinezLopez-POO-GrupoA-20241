public class BankAccount {
    private long accountNumber;
    private double amount;
    private String type;
    private boolean status = true;

    public BankAccount(long accountNumber, String type) {
        if(validType(type)){
            this.accountNumber = accountNumber;
            this.type = type;
        }
        else{
            this.status = false;
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

    public boolean isStatus() {
        return status;
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

    public void agregarDinero(double cargo){
        switch(type){
            case "A":
                agregarDineroA(cargo);
                System.out.println("Money added succesfully");
            break;

            case "B":
                agregarDineroB(cargo);
                System.out.println("Money added succesfully");
            break;

            case "C":
                agregarDineroC(cargo);
                System.out.println("Money added succesfully");
            break;   
        }
    }

    public void retirarDinero(double retiro){
        switch(type){
            case "A":
                retirarDineroA(retiro);
                System.out.println("Money taken succesfully");
            break;

            case "B":
                retirarDineroB(retiro);
                System.out.println("Money taken succesfully");
            break;

            case "C":
                retirarDineroC(retiro);
                System.out.println("Money taken succesfully");
            break; 
        }
    }



    private void agregarDineroA(double cargo){
        if(amount + cargo >= 50000){
            System.out.println("\nHa excedido la cantidad máxima de este tipo de cuenta");
        }
        else if(cargo < 0){
            System.out.println("\nNo puede realizar un cargo negativo");
        }
        else{
            amount += cargo;
        }
    }


    private void agregarDineroB(double cargo){
        if(amount + cargo >= 100000){
            System.out.println("\nHa excedido la cantidad máxima de este tipo de cuenta");
        }
        else if(cargo < 0){
            System.out.println("\nNo puede realizar un cargo negativo");
        }
        else{
            amount += cargo;
        }
    }


    private void agregarDineroC(double cargo){
        if(cargo < 0){
            System.out.println("\nNo puede realizar un cargo negativo");
        }
        else{
            amount += cargo;
        }
    }

    private void retirarDineroA(double retiro){
        if(amount < 1000){
            System.out.println("\nSaldo insuficiente para retirar");
        }
        else if(amount < retiro){
            System.out.println("\nEl dinero a retirar es mayor al saldo disponible");
        }
        else{
            amount -= retiro;
        }               
    }

    private void retirarDineroB(double retiro){
        if(amount < 5000){
            System.out.println("\nSaldo insuficiente para retirar");
        }
        else if(amount < retiro){
            System.out.println("\nEl dinero a retirar es mayor al saldo disponible");
        }
        else{
            amount -= retiro;
        } 
    }

    private void retirarDineroC(double retiro){
        if(amount < 10000){
            System.out.println("\nSaldo insuficiente para retirar");
        }
        else if(amount < retiro){
            System.out.println("\nEl dinero a retirar es mayor al saldo disponible");
        }
        else{
            amount -= retiro;
        }
    }



    
}