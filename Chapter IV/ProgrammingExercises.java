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
        final double earthRadius = 6_371.01;

        Scanner input = new Scanner(System.in);

        // Get first point coordinates
        System.out.print("Enter point 1 (latitude and longtitude) in degrees: ");
        String userInput = input.nextLine();
        String[] splitInput = userInput.split(" ");

        double x_1 = Double.parseDouble(splitInput[0]);
        double y_1 = Double.parseDouble(splitInput[1]);

        // Convert degrees to radians
        double xr_1 = x_1 * (Math.PI / 180);
        double yr_1 = y_1 * (Math.PI / 180);

        // Get second point coordinates
        System.out.print("Enter point 2 (latitude and longtitude) in degrees: ");
        userInput = input.nextLine();
        splitInput = userInput.split(" ");

        double x_2 = Double.parseDouble(splitInput[0]);
        double y_2 = Double.parseDouble(splitInput[1]);

        // Convert degrees to radians
        double xr_2 = x_2 * (Math.PI / 180);
        double yr_2 = y_2 * (Math.PI / 180);

        // Compute the great circle distance between the two points
        double d = earthRadius 
        * Math.acos(Math.sin(xr_1) * Math.sin(xr_2) 
                    + Math.cos(xr_1) * Math.cos(xr_2)
                    * Math.cos(yr_1 - yr_2));

        System.out.printf("The distance between the two points is %f km", d);
    }

    

    public static void main (String[] args) {

    }
}
