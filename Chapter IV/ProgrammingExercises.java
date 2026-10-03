import java.util.Scanner;

public class ProgrammingExercises {
    // 4.1 area of pentagon
    static {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the length from the center of a pentagon to a vertex: \n");
        double r = input.nextDouble();

        // Compute length of a side of the pentagon
        double s = 2 * r * Math.sin(Math.PI / 5);

        // Compute area
        double area = (5 * Math.pow(s, 2))
        / (4 * Math.tan(Math.PI / 5));

        // Display area with a width of 4 and precision of 2
        System.out.printf("The area of the pentagon is %4.2f", area);
    }
    // 4.2 great circle distance
    static {
        
    }

    public static void main (String[] args) {

    }
}
