public class main {
    public static void main(String[] args) {
        Employee empleado1 = new Employee("Edgar",
         "Martínez", 2345, "B");

         //System.out.printf("El número de cuenta es: %s", empleado1.getAccount().getType());
         //el empleado1.getAccount() crea una instancia de la clase BankAccount y el getAccountNumber invoca al método de la clase BankAccount ya que es un objeto de es clase

         empleado1.getAccount().cargarCuenta(356);

         empleado1.printAccount();
         
        //System.out.println("\nEl monto actual es: " + empleado1.getAccount().getAmount());
        //System.out.println(empleado1.getAccount());


    
    }

}
