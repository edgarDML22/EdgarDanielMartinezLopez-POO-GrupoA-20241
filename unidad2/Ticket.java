public class Ticket {
    private String nombreCompleto;
    private double montoFinal, cuota;

    public Ticket(String nombreCompleto, double montoFinal, double cuota) {
        this.nombreCompleto = nombreCompleto;
        this.montoFinal = montoFinal;
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        System.out.println("\n------------------------------------");
        System.out.println("\nTicket generado");
        return String.format("Nombre completo: %s \nMonto total a pagar: % .2f \nMonto de cada cuota: % .2f", nombreCompleto, montoFinal, cuota);
    }

    

}
