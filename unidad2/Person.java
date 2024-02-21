
public class Person {
    public String name, gender;
    public int age;    


    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    String getPersonInfo(){
        return String.format("Name: %s, Age: %d, Gender: %s", name, age, gender);
    }

    public void print(){
        System.out.println(getPersonInfo());
    }
    

}