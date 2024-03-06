public class Tarjeta {
    String entidadFinanciera, entidadBancariaString;
    long numeroTarjeta;
    double saldo;
    Titular titular;

    public Tarjeta(String entidadFinanciera, String entidadBancariaString, long numeroTarjeta, double saldo, String dNI, String nombre, String apellido, String email, String telefono) {
        this.entidadFinanciera = entidadFinanciera;
        this.entidadBancariaString = entidadBancariaString;
        this.numeroTarjeta = numeroTarjeta;
        this.saldo = saldo;
        titular = new Titular(dNI, nombre, apellido, email, telefono);
    }

    public String getEntidadFinanciera() {
        return entidadFinanciera;
    }

    public void setEntidadFinanciera(String entidadFinanciera) {
        this.entidadFinanciera = entidadFinanciera;
    }

    public String getEntidadBancariaString() {
        return entidadBancariaString;
    }

    public void setEntidadBancariaString(String entidadBancariaString) {
        this.entidadBancariaString = entidadBancariaString;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    

    

    
}
