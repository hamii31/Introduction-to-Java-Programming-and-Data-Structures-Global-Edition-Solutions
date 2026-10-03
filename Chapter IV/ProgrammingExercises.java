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

    // 4.3 estimate areas
    static {
        final double earthRadius = 6_371.01;

        // Atlanta, Georgia
        double x_1 = 33.749;
        double y_1 = 84.388;

        // Orlando, Florida
        double x_2 = 28.538;
        double y_2 = 81.379;

        // Savannah, Georgia
        double x_3 = 32.081;
        double y_3 = 81.091;

        // Charlotte, North Carolina
        double x_4 = 35.227;
        double y_4 = 80.843;

        // Convert degrees to radians
        double xr_1 = x_1 * (Math.PI / 180);
        double xr_2 = x_2 * (Math.PI / 180);
        double yr_1 = y_1 * (Math.PI / 180);
        double yr_2 = y_2 * (Math.PI / 180);
        double xr_3 = x_3 * (Math.PI / 180);
        double xr_4 = x_4 * (Math.PI / 180);
        double yr_3 = y_3 * (Math.PI / 180);
        double yr_4 = y_4 * (Math.PI / 180);
        
        // Compute the distance between Atlanta and Orlando
        double d_1 = computeGreatCircleDistance(earthRadius, xr_1, xr_2, yr_1, yr_2);
        
        // Compute the distance between Orlando and Savannah
        double d_2 = computeGreatCircleDistance(earthRadius, xr_2, xr_3, yr_2, yr_3);

        // Compute the distance between Savannah and Charlotte
        double d_3 = computeGreatCircleDistance(earthRadius, xr_3, xr_4, yr_3, yr_4);

        // Compute the distance between Charlotte and Atlanta
        double d_4 = computeGreatCircleDistance(earthRadius, xr_1, xr_4, yr_1, yr_4);

        // Compute the distance between Atlanta and Savannah 
        double d_5 = computeGreatCircleDistance(earthRadius, xr_1, xr_3, yr_1, yr_3);

        // Find the area of the triangle between Atlanta, Orlando and Savannah
        double s_1 = (d_1 + d_2 + d_5) / 2;
        double area_1 = Math.sqrt(s_1 * (s_1 - d_1) * (s_1 - d_2) * (s_1 - d_5));

        // Find the area of the triangle between Atlanta, Charlotte and Savannah
        double s_2 = (d_3 + d_4 + d_5) / 2;
        double area_2 = Math.sqrt(s_2 * (s_2 - d_3) * (s_2 - d_4) * (s_2 - d_5));

        System.out.printf("The area covered between the four cities is %f km2", area_1 + area_2);
    }
    private static double computeGreatCircleDistance(double earthRadius, double xr_1, double xr_2, double yr_1, double yr_2) {
        return earthRadius * Math.acos(Math.sin(xr_1) * Math.sin(xr_2) 
                    + Math.cos(xr_1) * Math.cos(xr_2)
                    * Math.cos(yr_1 - yr_2));
    }
    

    public static void main (String[] args) {

    }
}
