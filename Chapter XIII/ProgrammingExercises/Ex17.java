import java.util.Scanner;

public class Ex17 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first complex number:");
        double a = input.nextDouble();
        double b = input.nextDouble();

        Complex cn1 = new Complex(a, b);

        System.out.println("Enter the second complex number:");
        a = input.nextDouble();
        b = input.nextDouble();

        Complex cn2 = new Complex(a, b);

        Complex cn3 = cn1.add(cn2);
        System.out.printf("(%f + %fi) + (%f + %fi) = %f + %fi\n",
                cn1.getRealPart(), cn1.getImaginaryPart(),
                cn2.getRealPart(), cn2.getImaginaryPart(),
                cn3.getRealPart(), cn3.getImaginaryPart()
            );

        cn3 = cn1.subtract(cn2);
        System.out.printf("(%f + %fi) - (%f + %fi) = %f + %fi\n",
                cn1.getRealPart(), cn1.getImaginaryPart(),
                cn2.getRealPart(), cn2.getImaginaryPart(),
                cn3.getRealPart(), cn3.getImaginaryPart()
            );

        cn3 = cn1.multiply(cn2);
        System.out.printf("(%f + %fi) * (%f + %fi) = %f + %fi\n",
                cn1.getRealPart(), cn1.getImaginaryPart(),
                cn2.getRealPart(), cn2.getImaginaryPart(),
                cn3.getRealPart(), cn3.getImaginaryPart()
            );

        cn3 = cn1.divide(cn2);
        System.out.printf("(%f + %fi) / (%f + %fi) = %f + %fi\n",
                cn1.getRealPart(), cn1.getImaginaryPart(),
                cn2.getRealPart(), cn2.getImaginaryPart(),
                cn3.getRealPart(), cn3.getImaginaryPart()
            );

        System.out.printf("|%f + %fi| = %f\n", cn1.getRealPart(), cn1.getImaginaryPart(), cn1.abs());
        System.out.printf("|%f + %fi| = %f\n", cn2.getRealPart(), cn2.getImaginaryPart(), cn2.abs());

        System.out.printf("%s\n",cn1.compareTo(cn2) == 1 ? "false" : "true");

        System.out.println(cn1.getRealPart());
        System.out.println(cn1.getImaginaryPart());

        System.out.println(cn1.toString());
    }
}

class Complex implements Cloneable, Comparable<Complex> {
    private double a = 0; // real
    private double b = 0; // imaginary
    public static final Complex I = new Complex(0, 1);

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex(double a) {
        this.a = a;
    }

    public Complex() {}

    // Returns a new Complex number as a result of the addition of two Complex numbers
    public Complex add(Complex other) {
        return new Complex(
                (this.a + other.a), // real part
                (this.b + other.b) // imaginary part
            );
    }

    // Returns a new Complex number as a result of the subtraction of two Complex numbers
    public Complex subtract(Complex other) {
        return new Complex(
                (this.a - other.a),
                (this.b - other.b)
            );
    }

    // Returns a new Complex number as a result of the multiplication of two Complex numbers
    public Complex multiply(Complex other) {
        return new Complex(
                ((this.a * other.a) - (this.b * other.b)),
                ((this.b * other.a) + (this.a * other.b))
            );
    }

    // Returns a new Complex number as a result of the division of two Complex numbers
    public Complex divide(Complex other) {
        return new Complex(
                ((this.a * other.a) + (this.b * other.b)) / (Math.pow(other.a, 2) + Math.pow(other.b, 2)),
                ((this.b * other.a) + (this.a * other.b)) / (Math.pow(other.a, 2) + Math.pow(other.b, 2))
            );
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    public double getRealPart() {
        return this.a;
    }

    public double getImaginaryPart() {
        return this.b;
    }

    @Override
    public Object clone() {
        try {
            // Perform a shallow copy
            Complex complexClone = (Complex)super.clone();

            // Deep copy on a and b
            complexClone.a = this.a;
            complexClone.b = this.b;
            return complexClone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public int compareTo(Complex o) {
        return Double.compare(this.abs(), o.abs());
    }

    @Override
    public String toString() {
        if (this.b == 0) return "(" + this.a + ")";

        return "(" + this.a + " + " + this.b + "i)";
    }
}
