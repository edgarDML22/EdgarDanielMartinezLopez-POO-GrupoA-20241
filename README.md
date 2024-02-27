# TAREA 6 - UNIDAD 2
## Instrucciones
Se desea crear una clase `Producto` que represente un artículo en un inventario. La clase debe tener los siguientes atributos privados:
1. `nombre`: Una cadena que representa el nombre del producto
2. `precio`: Un número de punto flotante que representa el precio del producto.
3. `stock`: Un número entero que representa la cantidad de existencias disponibles del prodcuto. 
---
Se deben propocionar los siguientes métodos públicos:
1. Constructores:
    - Un constructor que tome tres parámetros(`nombre`,`precio` y `stock`) para inicializar todos los atributos del producto.
    - Un constructor que tome dos paráemtros(`nombre` y `precio`) y establezca el stock en 0 por defecto.
2. Getter y setters para todos los atributos:
    - `getNombre()` y `setNombre(String nombre)`
    - `getPrecio()` y `setPrecio(double precio)` 
    - `getStock()` y `setStock(int Stock)`
3. Métodos adicionales:
    - `aumentarStock(int cantidad)`: Aumenta el stock del producto en la catndiad especificada, con validación para asegurarse de que la cantidad sea mayor que cero.
    - `reducirStock(int cantidad)`: Reduce el stock del producto en la cantidad especificada, con validación para asegurarse de que la cantidad sea mayor que cero y menor o igual al stock actual.
 ---   
Además, se deben incluir las siguientes validaciones en los setters:
- El precio y el stock no pueden ser negativos
- El nombre no puede ser nulo
- La cantidad a reducir del stock debe ser menor o igual al stock actual

