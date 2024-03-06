# NOTAS PARA POO

## Método String.format
Método útil para evitar concatenar tantas cadenas en el mismo sout. Tiene la siguiente estructura:


Para mostrar ese código como bloque de código en Markdown, puedes hacer lo siguiente:

```java
String cadena = String.format("Se mostrará el primer parámetro %s, se mostrará el segundo parámetro %f", parametro1, parametro2);
```

Se deben separar por comas(,) los parámetros mostrados en la cadena.
Nótese que devuelve una cadena.
Los formatos para los diferentes tipos de datos son los siguientes:

- `%d` - int, long y short
- `%s` - String
- `%f` - float o double
- `%c` - carácter
- `%b` - boolean

**Nota**: Si se escribe % .nf, se mostrarán únicamente n decimales del número en cuestión.

---

## Métodos getters y setters
**Getter:** Es un método que devuelve como valor de retorno un atributo de la clase en cuestión.  
**Setter:** Es un método que no tiene un valor de retorno ya que únicamente asigna al atributo indicado el parámetro que se envía al invocar el método.  
Ejemplo:  
```java
double mount
```

```java
public double getAmount() {
    return amount;
}
```

```java
public void setAmount(double amount) {
    this.amount = amount;
}
```
**TRUCO:** Para generar de forma automática los getters, setters y constructores en Visual Studio Code, se debe teclear `Ctrl + .`. Por último debe especificar el método a crear.

---
## Sobrecarga de métodos
En el paradigma de POO es común que haya métodos con el mismo nombre, los cuáles únicamente **se diferencian por el número y tipo de parámetros que reciben**. A continuación un ejemplo:  

```java
public double pago(double salario) {
    return salario;
}
```

```java
public double pago(double salario, int horasExtra) {
    return salario + (horasExtra * 0.5);
}
```
***NOTA:*** Se puede hacer sobrecarga de métodos Constructores.

---

## Relación de agregación o composición 
En este tipo de relación una clase incluye en sus atributos un objeto de otra clase. 
Para esto debe indicarse en los atributos de la clase lo siguiente:

```java
public class Persona{
    String nombre;
    BankAccount account;
}
```
El atributo `account` en este caso es un objeto de la clase `BankAccount`. Ahora bien al momento de crear el constructor se pueden asignar valores a este objeto que hemos creado recien.

```java
public Persona(String nombre, double salario, long accountNumber){
    this.nombre = nombre;
    account = new BankAccount(salario, accountNumber);
}
```
Nótese que en el atributo `account` se inicializa un objeto de la clase `BankAccount`, al cuál se envían dos parámetros.  
**IMPORTANTE:** Cabe recordar que para utilizar los métodos y atributos de nuestro atributo account debemos realizar lo siguiente:
```java
Persona persona1 = new Persona("Edgar", 15000, 12345);
persona1.account.getSalario()
```
Ya que si únicamente escribimos `persona1.account` Java nos devolverá el espacio de memoria del objeto en cuestión.

---
## Relación de herencia
En este tipo de relación hay una clase Padre y una clase Hija que recibe atributos y métodos de su clase Padre. Para utilizar esta realción en Java debemos hacer lo siguiente:  
Nota: Usaremos las clases Persona y Empleado para este ejemplo:

```java
public class Persona {
    String nombre;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
}
```

```java
public class Empleado extends Persona{   
    String estadoCivil;
    
    public Empleado(String estadoCivil) {
        super(nombre);
        this.estadoCivil = estadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }


    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }   
}
```

1. Colocar en la primer línea del código `extends clasePadre`
2. En el constructor colocar `super(Parámetros)` para inicialiar los atributos de la clasePadre

---
## Polimorfismo
En Java se trabaja con variables con un tipo en específico. Si intentamos trabajar con datos diferentes a los del tipo de dato asignado Java mostrará de inmediato un error.
Sin embargo en el paradigma de POO esto es posible. Ya que si creamos variables de una clase Padre, estas pueden ser igualdas a objetos que sean de alguna de sus clases hijas. Observe el ejemplo

```java
//CLASE PADRE
Persona persona = new Persona(); 
//CLASES HIJAS
Empleado empleado = new Empleado();
Maestro maestro = new Maestro();
Gerente gerente = new Gerente();
Cocinero cocinero = new cocinero;

//ESTO ES CORRECTO
persona = empleado;
persona = maestro;
//ESTO ES INCORRECTO
empleado = persona;
maestro = persona

Persona array[] = new Persona[5]
array[0] = empleado;
array[1] = maestro;
array[2] = gerente;
array[3] = cocinero;
```

Nótese que una clase padre puede ser igualada con una clase hija. Pero una clase hija no puede ser igualada con su clase padre. Esto debido a que la clase padre tiene mayor jerarquía.  
Observe el arreglo `array` puede contener objetos de tipo persona. Ya que al tratarse de sus clases hijas son tomadas como el mismo tipo de dato.

---
## Método toString
Este método muestra todos los atributos de una clase en un solo método. Se puede generar de forma automática con el comando `Ctrl + .` seleccionando la opción **toString()**. Observe el ejemplo:
```java
@Override
public String toString() {
    return "Persona [edad=" + edad + ", nombre=" + nombre + ", apellido=" + apellido + "]";
}
```