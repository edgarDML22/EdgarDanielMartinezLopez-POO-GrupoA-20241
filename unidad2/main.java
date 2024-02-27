public class main {
    public static void main(String[] args) {
        System.out.println("HOLA MUNDO :)))");
        Rectangle r1 = new Rectangle();
        System.out.println("\nCLASE RECTÁNGULO");
        System.out.printf("Ejemplo área con enteros: %d \nEjemplo área con flotantes: %f", r1.Area(2, 5), r1.Area(2.532, 7.421));

        Empleado emp1 = new Empleado();
        System.out.println("\nCLASE EMPLEADO \n--------------------------------------");
        System.out.printf("Ejemplo 1: %f \nEjemplo 2: %f \nEjemplo 3: %f",
        emp1.calcularSalario(2045.78), emp1.calcularSalario(2045.78, 500.50), emp1.calcularSalario(2045.78, 500.50, 3.5));

        CalculadoraImpuestos calcuImpuestos1 = new CalculadoraImpuestos();
        System.out.println("\nCLASE CALCULADORAIMPUESTOS \n--------------------------------------");
        System.out.printf("Ejmplo 1: %f \nEjemplo 2: %f \nEjemplo 3: %f", calcuImpuestos1.Impuesto(3456), 
        calcuImpuestos1.Impuesto(2456.78, 30.56), calcuImpuestos1.Impuesto(456.98, 30.56, 600.43));


               
    }
    
}
