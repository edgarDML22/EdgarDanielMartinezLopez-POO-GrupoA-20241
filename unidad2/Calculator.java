public class Calculator {
    public int n1, n2;
    public double R;

    public Calculator(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public double suma() {
        return n1 + n2;
    }

    public double resta() {
        return n1 - n2;
    }

    public double multiplicacion() {
        return n1 * n2;
    }

    public double division() {
        if (n2 == 0) {
            return -1;
        } else {
            return n1 / n2;
        }
    }

}// public class
