# TAREA Y EJERCICIOS DE POO
## EJERCICIO PROPUESTO 1

Se desea implementar la lógica de un dispositivo *POSNET* que procesa pagos con tarjetas de crédito.

Las tarjetas de crédito guardan el nombre de la entidad financiera a la que pertenecen (únicamente Birza o CasterMard), el nombre de la entidad bancaria, el número de tarjeta, el saldo disponible y los datos del titular (DNI, nombre, apellido, teléfono y mail). Cada vez que se cree una nueva tarjeta, deberán indicarse todos estos datos.  

A la hora de abonar, el *POSNET* recibiría la tarjeta con la que desea hacerse el pago, junto con el
monto que se desea abonar y la cantidad de cuotas (de 1 a 6).
Si el pago es en 1 cuota, no se genera ningún recargo, de lo contrario, el monto se incrementará en un 3% por cada cuota superior a 1. (Ejemplo: Pagar en 4 cuotas representará un 9% de incremento).

El *POSNET* debe chequear que la tarjeta tenga saldo suficiente para poder efectuar el pago junto
con el recargo, si hubiese. En caso de éxito, debe generar y retornar (no mostrar) un ticket donde
consten los siguientes datos:
- Nombre y apellido del cliente.
- Monto total a pagar.
- Monto de cada cuota.

Si la operación no tuvo éxito, se retornará `null`

---