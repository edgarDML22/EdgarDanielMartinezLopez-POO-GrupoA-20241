public class Habitat {
    boolean mantenimiento;
    String clima, pais;
    


    public Habitat(boolean mantenimiento, String clima, String pais) {
        this.mantenimiento = mantenimiento;
        this.clima = clima;
        this.pais = pais;
    }
    
    public boolean isMantenimiento() {
        return mantenimiento;
    }
    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    public String getClima() {
        return clima;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    
    
}
