public class main {
    public static void main(String[] args) {
        //System.out.println("HOLA MUNDO :)))");
        //System.out.println("develop");
        
        //Empleado emple = new Empleado("Edgar", "Martínez", 18, 15000, true, "Soltero", 50000, 123456, "A");
        //System.out.println(emple.account.getType());

        /*Persona persona = new Persona();
        persona = emple;*/  

        Tarjeta card = new Tarjeta("CasterMard", "Bancomer", 123456, 15000, 
        "Ejemplo de DNI", "Edgar", "Martínez", "ejemplo@email.com", "+524490764");

        Posnet posnet = new Posnet();
        System.out.println(posnet.abonar(card, 10000, 5));


        
    }
    
}
