public class Empleado extends Persona{
    boolean isMale;
    String estadoCivil;
    BankAccount account;

    
    



    public Empleado(String nombre, String apellido, int edad, double salario) {
        super(nombre, apellido, edad, salario);
    }


    public Empleado(String nombre, String apellido, int edad, double salario, boolean isMale, String estadoCivil,
         double monto, long numeroCuenta, String type) {
        super(nombre, apellido, edad, salario);
        this.isMale = isMale;
        this.estadoCivil = estadoCivil;
        this.account = new BankAccount(monto, numeroCuenta, type);
    }


    public boolean isMale() {
        return isMale;
    }


    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }


    public String getEstadoCivil() {
        return estadoCivil;
    }


    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


    public BankAccount getAccount() {
        return account;
    }


    public void setAccount(BankAccount account) {
        this.account = account;
    }

    

    




    

    


    
}
