public class main {
    public static void main(String[] args) {
        Calculator calc1 = new Calculator(10, 3);

        System.out.printf("La suma es: %f", calc1.suma());
        System.out.printf("\nLa resta es: %f", calc1.resta());
        System.out.printf("\nEl producto es: %f", calc1.multiplicacion());
        System.out.printf("\nLa división es: %f", calc1.division());

        NumberFormatter nf = new NumberFormatter();

        System.out.printf("Número mostrado: %d", nf.numberFormatter(5));
        System.out.printf("\nEl número mostrado es: % .2f", nf.numberFormatter(2.24235235));
        System.out.printf("\nEl número mostrado es: %s ", nf.numberFormatter(2.382732864, 25));

    }

}
