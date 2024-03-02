public class Persona {
    String name;
    private int age;
    int salary = 10000;

    //SOBRECARGA DE CONSTRUCTORES
    public Persona(String name, int age){
        this.name = name;
        this.age = age;       
    }

    public Persona(String name, int age, int salary){
        this.name = name;
        this.age = age;    
        this.salary = salary;   
    }


    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    


}
