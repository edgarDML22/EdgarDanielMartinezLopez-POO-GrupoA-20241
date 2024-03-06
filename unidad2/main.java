import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Auto a1 = new Auto("ABCDE", "Verde");

        ArrayList<Auto> misAutos = new ArrayList<>();
        misAutos.add(a1);
        misAutos.add(new Auto("JIJIJA", "Rojo"));

        System.out.println(misAutos);
        System.out.println("Size: " + misAutos.size());
        */
        
        ArrayList<String> myList = new ArrayList<>();
        System.out.println(myList.isEmpty());

        String cad = "";

        while (true) {
            System.out.println("Agregue palabra");
            cad = sc.nextLine();

            if(cad.equalsIgnoreCase("stop"))
            break;
            else
            myList.add(cad);
            
        }
        System.out.println(myList);
        System.out.println(myList.size());

        Collections.sort(myList);
        
        System.out.println("---------------PALABRAS ORDENADAS-----------------");
        System.out.println(myList);
        System.out.println(myList.size());

        /* EJERCICIO PROPUESTO
        Posnet posnet = new Posnet();
        Tarjeta card = new Tarjeta("CasterMard", "Bancomer", 123456, 15000, 
        "Ejemplo de DNI", "Edgar", "Martínez", "ejemplo@email.com", "+524490764");


        System.out.printf("Saldo actual: % .2f", card.getSaldo());

        Ticket ticketGenerado = posnet.abonar(card, 10000, 5);
        System.out.println(ticketGenerado);

        System.out.printf("Saldo actual: % .2f", card.getSaldo());
        */

        //System.out.println("HOLA MUNDO :)))");
        //System.out.println("develop");
        
        //Empleado emple = new Empleado("Edgar", "Martínez", 18, 15000, true, "Soltero", 50000, 123456, "A");
        //System.out.println(emple.account.getType());

        /*Persona persona = new Persona();
        persona = emple;*/  

        









    }
    
}
