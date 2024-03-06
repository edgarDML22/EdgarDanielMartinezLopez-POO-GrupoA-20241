public class Posnet {
    Tarjeta tarjeta;
    double monto;
    int cantidadCuotas;


    public Posnet() {
    }
    
    public String abonar(Tarjeta tarjeta, double monto, int cantidadCuotas){
        this.tarjeta = tarjeta;
        this.monto = monto;
        this.cantidadCuotas = cantidadCuotas;

        calcularMonto();        
        if(monto > tarjeta.saldo){
            return null;
        }
        else{
            return String.format(" %s %s\n% .2f\n% .2f", getTarjeta().getTitular().getNombre(), getTarjeta().getTitular().getApellido(), this.monto, pagoCuota());
            //actualizarSaldo();
        }

    }
    





    //Checar que haya suficiente saldo en la tarjeta
    //Teniendo la consideración del recargo


    private void calcularMonto(){     
        this.monto = monto + ((cantidadCuotas - 1) * 0.03) * monto;
    }

    private double pagoCuota(){
        return monto / cantidadCuotas;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }


    
}
