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

    // 4.4 Area ofa five-pointed star
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of the circle inscribing the star: ");
        double radius = input.nextDouble();

        double area = 10 *
        (Math.tan(Math.PI / 10)
        / 
        (3 - Math.tan(Math.PI / 10) * Math.tan(Math.PI / 10))) 
        * Math.pow(radius, 2);

        System.out.printf("The area of the star is %f", area);
    }

    // 4.5 Area of a regular polygon
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        int sides = input.nextInt();

        System.out.print("Enter the length of a side: ");
        double length = input.nextDouble();

        double area = (sides * Math.pow(length, 2))
        /
        (4 * Math.tan(Math.PI / sides));

        System.out.printf("The area of the polygon is %f", area);
    }

    // 4.6 Random points on a circle
    static {
        final int radius = 40;

        // Generate a random angle alpha in radians
        double rng_alpha = Math.random() * (Math.PI * 2);
        // Find the coordinates of the point determined by the random angle alpha
        double x_1 = radius * Math.cos(rng_alpha);
        double y_1 = radius * Math.sin(rng_alpha);

        // Generate a random angle beta in radians
        double rng_beta = Math.random() * (Math.PI * 2);
        // Find the coordinates of the point determined by the angle beta
        double x_2 = radius * Math.cos(rng_beta);
        double y_2 = radius * Math.sin(rng_beta);

        // Generate a random angle gamma in radians
        double rng_gamma = Math.random() * (Math.PI * 2);
        // Find the coordinates of the point determined by the angle gamma
        double x_3 = radius * Math.cos(rng_gamma);
        double y_3 = radius * Math.sin(rng_gamma);

        // Find side1 between points 2 and 3 using the distance formula
        double a = Math.sqrt(
            Math.pow((x_3-x_2), 2) + Math.pow((y_3 - y_2), 2));

        // Find side2 between points 1 and 3
        double b = Math.sqrt(
            Math.pow((x_3 - x_1), 2) + Math.pow((y_3 - y_1), 2));

        // Find side3 between points 1 and 2
        double c = Math.sqrt(
            Math.pow((x_2 - x_1), 2) + Math.pow((y_2 - y_1), 2));


        // Find angle alpha based on the three sides
        double alpha = Math.acos(
            (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2))
            / 
            (2 * b * c)
        );

        // Find anlge beta based on the three sides
        double beta = Math.acos(
            (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2))
            /
            (2 * a * c)
        );

        // Find angle gamma based on the three sides
        double gamma = Math.acos(
            (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2))
            /
            (2 * a * b)
        );

        // Convert angles to degrees
        alpha = alpha * (180 / Math.PI);
        beta = beta * (180 / Math.PI);
        gamma = gamma * (180 / Math.PI);

        System.out.printf("A triangle has been formed with angle alpha = %f degrees, beta = %f degrees, and gamma = %f degrees", alpha, beta, gamma);
    }

    // 4.7 Corner point coordinates
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Etner the radius of the bounding circle: ");
        double radius = input.nextDouble();

        // Generate 5 points
        for (int i = 0; i < 5; i++) {
            double rng_angle = Math.random() * (Math.PI * 2);
            double x = radius * Math.cos(rng_angle);
            double y = radius * Math.sin(rng_angle);

            System.out.printf("(%4.2f, %4.2f)\n", x, y);
        }
    }

    // 4.8 Find the char of an ASCII code
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = input.nextLine().charAt(0);

        System.out.printf("The ASCII code for character %c is %d", ch, (int) ch);
    }

    // 4.9 Find the Unicode of a character
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = input.nextLine().charAt(0);

        System.out.printf("The Unicode code for character %c is %d", ch, (int) ch);
    }
    

    public static void main (String[] args) {

    }
}
