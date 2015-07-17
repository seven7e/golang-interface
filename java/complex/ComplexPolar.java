package complex;

public class ComplexPolar implements Complex {
    
    private double abs;
    private double arg;

    public ComplexPolar(double abs, double arg) {
        this.abs = abs;
        this.arg = arg;
    }

    @Override
    public double real() {
        return abs * Math.cos(arg);
    }

    public double image() {
        return abs * Math.sin(arg);
    }

    public double abs() {
        return abs;
    }

    public double arg() {
        return arg;
    }

    public String toString() {
        return String.valueOf(abs) + "*exp(" + arg + "i)";
    }
}