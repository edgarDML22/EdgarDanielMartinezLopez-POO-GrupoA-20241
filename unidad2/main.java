public class main {
    public static void main(String[] args) {
        System.out.println("HOLA MUNDO :)))");

        Producto producto1 = new Producto("Libro", 328.565445, 12);
    
            System.out.printf("Nombre: %s \nStock: %d \nPrecio: % .2f", producto1.getNombre(), producto1.getStock(), producto1.getPrecio());

            //PARA COMPROBAR LAS EXCPECIONES
            producto1.setNombre("");
            producto1.reducirStock(15);
            producto1.aumentarStock(-3);
            producto1.setPrecio(-321.45);

            System.out.printf("Nombre: %s \nStock: %d \nPrecio: % .2f", producto1.getNombre(), producto1.getStock(), producto1.getPrecio());
       
        
    }
    
}
