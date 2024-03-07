public class BankAccount {
    private long accountNumber;
    private double amount;
    private String type;

    public BankAccount(long accountNumber, String type) {
            this.accountNumber = accountNumber;
            this.type = type;
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

 

    public void agregarDinero(double cargo){
        switch(type){
            case "A":
            agregarDineroA(cargo);
            break;

            case "B":
            agregarDineroB(cargo);
            break;

            case "C":
            agregarDineroC(cargo);
            break;

            default:
            System.out.println("No hay una cuenta bancaria existente");
        
        }
    }

    public void retirarDinero(double retiro){
        switch(type){
            case "A":
            retirarDineroA(retiro);
            break;

            case "B":
            retirarDineroB(retiro);
            break;

            case "C":
            retirarDineroC(retiro);
            break;

            default:
            System.out.println("No hay una cuenta bancaria existente");
        
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