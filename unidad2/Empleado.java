public class Empleado {


    public double calcularSalario(double sueldoBase){
        return sueldoBase;
    }

    public double calcularSalario(double sueldoBase, double bono){
        return sueldoBase + bono;
    }

    public double calcularSalario(double sueldoBase, double bono, double horas){
        return sueldoBase + bono + (horas * 20);
    }
    
}
