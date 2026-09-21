import java.util.*;

public class Quadratic {
    public static void main (String[] args) {
        // Get user input
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a (e.g. 1.25, 7, 35)");
        double a = scan.nextDouble();

        System.out.println("Enter b (e.g. 1.25, 7, 35): ");
        double b = scan.nextDouble();

        System.out.println("Enter c (e.g. 1.25, 7, 35)");
        double c = scan.nextDouble();

        // Compute formula
        double disc = Math.pow(b, 2) - 4 * a * c;

        if (disc < 0) {
            System.out.println("No real roots (discriminant is negative).");
        } else {
            double x1 = (-b + Math.sqrt(disc)) / (2 * a);
            double x2 = (-b - Math.sqrt(disc)) / (2 * a);
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        }
    }
}
