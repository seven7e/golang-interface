package complex;

public class ComplexRect implements Complex {
    
    private double real;
    private double image;

    public ComplexRect(double real, double image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public double real() {
        return real;
    }

    public double image() {
        return image;
    }

    public double abs() {
        return Math.sqrt(real * real + image * image);
    }

    public double arg() {
        return Math.atan(image / real);
    }

    public String toString() {
        String sgn = image < 0 ? "" : "+";
        return String.valueOf(real) + sgn + image + "i";
    }
}