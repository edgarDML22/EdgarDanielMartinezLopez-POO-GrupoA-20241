public class Auto {
    private String matricula;
    private String color;

    
    public Auto(String matricula, String color) {
        this.matricula = matricula;
        this.color = color;
    }

   

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public String toString() {
        return "Auto [matricula=" + matricula + ", color=" + color + "]";
    }

    

    
    
}
