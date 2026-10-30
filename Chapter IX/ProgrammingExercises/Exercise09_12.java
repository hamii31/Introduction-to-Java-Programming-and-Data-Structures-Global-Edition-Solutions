import java.util.*;

public class Exercise09_12 {
    public static void main(String[] args) {
        double[] coordinates1 = getEndpoints();
        double[] coordinates2 = getEndpoints();

        List<Double> values1 = applyCramerRule(coordinates1);
        List<Double> values2 = applyCramerRule(coordinates2);

        LinearEquation le = new LinearEquation(values1.get(0), values1.get(1), values1.get(2),
            values2.get(0), values2.get(1), values2.get(2));

        if (!le.isSolvable()) {
            System.out.println("The equation has no solution");
            System.exit(1);
        }

        System.out.println("x = " + le.getX());
        System.err.println("y = " + le.getY());
    }

    public static double[] getEndpoints() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the endpoint coordinates for the line segment (x1, y1), (x2, y2): ");
        String s = input.nextLine();
        
        String[] arr = s.split(" ");
       
        double[] lineSegmentEndpoints = new double[4];
        
        for (int i = 0; i < arr.length; i++) {
            lineSegmentEndpoints[i] = Double.parseDouble(arr[i]);
        } 
        
        return lineSegmentEndpoints;
    }

    public static List<Double> applyCramerRule(double[] coordinates) {
        double a = coordinates[1] - coordinates[3];
        double b = -(coordinates[0] - coordinates[2]);
        double c = (a * coordinates[0]) + (b * coordinates[1]);

        return List.of(a, b, c);
    }
}
