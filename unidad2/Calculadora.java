public class Calculadora {
    int n1, n2;
    double m1, m2;
    

    public String suma(int n1, int n2){
        return String.valueOf(n1 + n2);
    }

    public String resta(int n1, int n2){
        return String.valueOf(n1 - n2);
    }

    public String multiplicacion(int n1, int n2){
        return String.valueOf(n1 * n2);
    }

    public String division(int n1, int n2){
        if(n2 == 0){
            return "No fue posible la division";
        }
        else{
            return String.valueOf(n1 / n2);
        }
    }

    

    public String suma(double m1, double m2){
        return String.valueOf(m1 + m2);
    }

    public String resta(double m1, double m2){
        return String.valueOf(m1 - m2);
    }

    public String multiplicacion(double m1, double m2){
        return String.valueOf(m1 * m2);
    }

    public String division(double m1, double m2){
        if(m2 == 0){
            return "No fue posible la division";
        }
        else{
            
            return String.valueOf(n1 / n2);
        }
    }

    

    




    

    
    
    
}


