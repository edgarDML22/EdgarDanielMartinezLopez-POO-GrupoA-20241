public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre != null && nombre != ""){
        this.nombre = nombre;
        }
        else{
            System.out.println("Nombre no válido");
        }
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0){
        this.precio = precio;
        }
        else{
            System.out.println("Precio no válido");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0){
            this.stock = stock;
            }
            else{
                System.out.println("Stock no válido");
            }
    }

    public void aumentarStock(int cantidad){
        if(cantidad < 0){
            System.out.println("Cantidad no válida");
        }
        else{
            stock += cantidad;
        }
    }

    public void reducirStock(int cantidad){
        if(cantidad > 0 && cantidad <= stock){
            stock -= cantidad;
        }
        else{
            System.out.println("No es posible reducir el stock");
        }
    }





    
    
}
