import java.util.*;

public class Exercise09_11 {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the values for a, b, c, d, e, and f separated by space: ");
        String s = input.nextLine();
        String[] arr = s.split(" ");
        Double[] values = new Double[6];
        for (int i = 0; i < arr.length; i++) {
            values[i] = Double.valueOf(arr[i]);
        } 

        LinearEquation le = new LinearEquation(values[0], values[1], values[2],
            values[3], values[4], values[5]);

        if (!le.isSolvable()) {
            System.out.println("The equation has no solution");
            System.exit(1);
        }

        System.out.println("x = " + le.getX());
        System.err.println("y = " + le.getY());
     }
 }

class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d,
        double e, double f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getD() {
        return this.d;
    }

    public double getE() {
        return this.e;
    }

    public double getF() {
        return this.f;
    }

    public boolean isSolvable() {
        return (this.a * this.d) - (this.b * this.c) != 0;
    }

    public double getX() {
        return ((this.e * this.d) - (this.b * this.f)) / ((this.a * this.d) - (this.b * this.c));
    }

    public double getY() {
        return ((this.a * this.f) - (this.e * this.c)) / ((this.a * this.d) - (this.b * this.c));
    }
}
