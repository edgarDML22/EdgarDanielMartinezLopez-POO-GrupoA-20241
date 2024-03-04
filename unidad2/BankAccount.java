public class BankAccount {
    double monto;
    long numeroCuenta;
    String type;


    public BankAccount(double monto, long numeroCuenta, String type) {
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
        this.type = type;
    }


    public double getMonto() {
        return monto;
    }


    public void setMonto(double monto) {
        this.monto = monto;
    }


    public long getNumeroCuenta() {
        return numeroCuenta;
    }


    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
    

    
    
}
