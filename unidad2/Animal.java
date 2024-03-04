public class Animal {
    String nombre;
    String especie;
    Habitat habitat;//CREAR UN OBJETO

    //Scanner sc = new Scanner();

    

    public Animal(String nombre, String especie, 
    boolean mantenimiento, String clima, String pais) {
        this.nombre = nombre;
        this.especie = especie;
        habitat = new Habitat(mantenimiento, clima, pais);
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public Habitat getHabitat() {
        return habitat;
    }
    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    

    



}

