public class CalculadoraImpuestos {

    public double Impuesto(int ingresos){
        return ingresos + 0.15;
    }

    public double Impuesto(double ventas, double porcentajeImpuestos){
        return ventas * (porcentajeImpuestos / 100);
    }

    public double Impuesto(double div, double porcentajeImpuesto, double exencion){
        double impuestos = div * (porcentajeImpuesto / 100);

        if(impuestos > exencion){
            return impuestos - exencion;
        }
        else{
            return 0;
        }
    }
    
}
