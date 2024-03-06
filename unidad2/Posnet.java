public class Posnet {
    double monto;
    int cantidadCuotas;

    public Posnet() {
    }
    
    public Ticket abonar(Tarjeta tarjeta, double monto, int cantidadCuotas){
        Ticket ticket = null;
        this.monto = monto;
        this.cantidadCuotas = cantidadCuotas;

        calcularMonto(cantidadCuotas);

         if(tarjeta.datosValidos(tarjeta, monto, cantidadCuotas)){
            if(tarjeta.saldoDisponible(monto)){          
                tarjeta.actualizarSaldo(this.monto);
                ticket = new Ticket(tarjeta.nombreCompleto(), this.monto, pagoCuota());
            }
         }

        return ticket;
    }

    private void calcularMonto(int cantidadCuotas){    
        this.monto = monto + ((cantidadCuotas - 1) * 0.03)*monto;
    }

    private double pagoCuota(){
        return monto / cantidadCuotas;
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

}
