public class main {
    public static void main(String[] args) {
        System.out.println("CLASE PERSONA -- EJERCICIO 1");
        Person p1 = new Person("Luis", 25, "male");
        p1.print();

        Person p2 = new Person("Ana", 40, "female");
        p2.print();

        Person p3 = new Person("Blanca", 18, "female");
        p3.print();

        Person p4 = new Person("Gabriel", 3, "male");
        p4.print();
        
        System.out.println("------------------------------------------");

        System.out.println("CLASE LIBRO -- EJERCICIO 2");
        Book b1 = new Book();
        b1.print();

        Book b2 = new Book();
        b2.title = "The Lord of the Rings";
        b2.year = 1954;
        b2.author = "Tolkien";
        b2.print();

        Book b3 = new Book();
        b3.title = "Animal Farm";
        b3.year = 1945;
        b3.author = "George Orwell";
        b3.print();
        
        Book b4 = new Book();
        b4.title = "Tuesdays With Morrie";
        b4.year = 1997;
        b4.author = "Mitch Albom";
        b4.print();

        System.out.println("------------------------------------------");

        System.out.println("CLASE RECTÁNGULO -- EJERCICIO 3");
        Rectangle r1 = new Rectangle(2.45, 3.89);
        r1.print();

        Rectangle r2 = new Rectangle(91.12, 0.89);
        r2.print();

        Rectangle r3 = new Rectangle(41.78, 13.14);
        r3.print();

        Rectangle r4 = new Rectangle(3.1416, 154.187);
        r4.print();
        
    }
    
}
