public class NumberFormatter {

    //public double num;


    /*public NumberFormatter(double num){
              
    }*/

    public int numberFormatter(int num){
        return num; 
    }

    public double numberFormatter(double num){
        return num;
    }

    public String numberFormatter(double num,int k){
        String cad = String.valueOf(num);
        String numFinal = cad.substring(0, cad.indexOf(".")) + ".";

        for (int i = 0; i < k && i < cad.length(); i++) {
            numFinal += cad.charAt(cad.indexOf(".") + 1 + i);   
        }

     return numFinal;
    }
        
}
