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

    public String getEntidadBancariaString() {
        return entidadBancariaString;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Titular getTitular() {
        return titular;
    }

    public boolean saldoDisponible(double montoFinal){
        if(montoFinal <= saldo){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean datosValidos(Tarjeta tarjeta, double monto, int cantidadCuotas){
        return validarTarjeta(tarjeta) && validarMonto(monto) && validarCantidadCuotas(cantidadCuotas);
    }

    private boolean validarTarjeta(Tarjeta tarjeta){
        return tarjeta != null;

    }
    
    private boolean validarMonto(double monto){
        return monto > 0;
    }

    private boolean validarCantidadCuotas(int c){
        return c >= 1 && c <= 6;
    }

    public void actualizarSaldo(double montoFinal){
        saldo -= montoFinal;
    }

    public String nombreCompleto(){
        return titular.nombreCompleto();
    }

    
}
