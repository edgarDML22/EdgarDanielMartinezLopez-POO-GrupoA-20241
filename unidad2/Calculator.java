public class Calculator {
    double n1, n2;



public Calculator(double n1, double n2){
    this.n1 = n1;
    this.n2 = n2;
}

public double add(){
    double R = n1 + n2;
return R;
}

public double sub(){
    double R = n1 - n2;
return R;
}

public double prod(){
    double R = n1 * n2;
return R;
}

public double div(){
double R;
    if (n2 == 0){
        R = -1;
    }
    else{
        R = n1 / n2;

    }
    
return R;
}

}
