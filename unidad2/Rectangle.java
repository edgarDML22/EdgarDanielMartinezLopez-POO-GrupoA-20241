public class Rectangle {
    public double height, width;
    

    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
        
    }

    public double perimeter(){
        double P = 2*height + 2*width;
    return P;    
    }

    public double area(){
        double A = height*width;
    return A;    
    }

    String getResults(){
        return String.format("Permiter = %.2f, Area = %.2f", perimeter(), area());
    }

    public void print(){
        System.out.println(getResults());
    }


}
