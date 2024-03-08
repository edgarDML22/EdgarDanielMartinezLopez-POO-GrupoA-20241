import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Employee>employeeList = new ArrayList<>();
        Bank bank = new Bank();

        Employee empleado1 = new Employee("Juan", "Pérez", 12345, "A");
        employeeList.add(empleado1);
        Employee empleado2 = new Employee("Ana", "Ramírez", 452312, "B");
        employeeList.add(empleado2);
        Employee empleado3 = new Employee("Luis", "González", 907856, "C");
        employeeList.add(empleado3);

        empleado1.agregarCuenta(310912, "C");
        empleado1.agregarCuenta(907812, "B");
        empleado1.agregarCuenta(147902, "A");


        boolean flag = true;
        while (flag) {
            showOptions();
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Ingrese el nombre del empleado");
                    String name = sc.next();
                    System.out.println("Ingrese el apellido del empeleado");
                    String lastName = sc.next();
                    System.out.println("Ingrese el número de cuenta");
                    long num = sc.nextLong();
                    System.out.println("Ingrese el tipo de cuenta");
                    String tipo = sc.next();

                    Employee empleado = new Employee(name, lastName, num, tipo);

                        if(empleado.getName() != null){
                            employeeList.add(empleado);
                        }
                        else{
                            System.out.println("No se agregó ningún empleado  la lista");
                        }

                break;

                case 2:
                    System.out.println("Ingrese el índice del empleado para agregar la cuenta");
                    int index = sc.nextInt();
                    System.out.println("Agregue el número de cuenta");
                    long numCuenta = sc.nextLong();
                    System.out.println("Ingrese el tipo de cuenta");
                    String tipoCuenta = sc.next();

                    employeeList.get(index).agregarCuenta(numCuenta, tipoCuenta);

                break;

                case 3:
                    for (Employee employeeBase : employeeList) {
                        employeeBase.showData();
                        employeeBase.showAccountList();      
                    } 
                break;

                case 4:
                    System.out.println("Ingrese el índice del empleado");
                    int i = sc.nextInt();
                    employeeList.get(i).showData();
                    employeeList.get(i).showAccountList();
                break;

                case 5:
                    for (Employee employee : employeeList) {
                        for (BankAccount bankAccount  : employee.AccountList) {//MUY BUENA LÓGICA :)
                        bank.agregarCuentaBanco(bankAccount);
                        }         
                    }
                        System.out.println("Las cuentas existentes en el sistema son las siguientes: \n");
                        bank.showBankAccountList();
                break;

                case 6:
                    System.out.println("Ingrese el índice de la cuenta que desea ver");
                    int n = sc.nextInt();
                    bank.showBankAccountData(n);
                break;
                
                default:
                flag = false;
                break;  
            }

            
            
        }

        /*public static void fillBankAccountList(){
            for (Employee employee : employeeList) {
                for (BankAccount bankAccount  : employee.AccountList) {//MUY BUENA LÓGICA :)
                bank.agregarCuentaBanco(bankAccount);
                }         
            }
        }*/            
        
    }

        public static void showOptions(){
            System.out.println("Elija una opción");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Agregar cuenta a un empleado");
            //System.out.println("3. Realizar un depósito a la cuenta de un empleado");
            //System.out.println("4. Realizar un retiro de la cuenta de un empleado");
            System.out.println("3. Mostrar a todos los usuarios con su información");
            System.out.println("4. Mostrar la información de un usuario");
            System.out.println("5. Mostrar lista de todas las cuentas existentes");
            System.out.println("6. Mostrar la información de una cuenta");
            System.out.println("7. Finalizar programa");


    }

    
    
}
