package complex;

public class ComplexUtil {
 
    public static Complex add(Complex a, Complex b) {
        return new ComplexRect(a.real() + b.real(), a.image() + b.image());
    }

    private static void printIt(Complex c) {
        System.out.println("======================");
        System.out.println("Complex: " + c);
        System.out.println("real: " + c.real() + " image: " + c.image());
        System.out.println("abs: " + c.abs() + " arg: " + c.arg());
    }

    public static void main(String[] args) {
        double sqrtHalf = Math.sqrt(0.5);

        Complex a = new ComplexRect(sqrtHalf, sqrtHalf);
        Complex b = new ComplexPolar(1.0, -Math.PI/4);
        Complex c = add(a, b);
        printIt(a);
        printIt(b);
        printIt(c);
    }
}