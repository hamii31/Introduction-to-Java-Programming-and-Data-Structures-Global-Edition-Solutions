
import java.util.*;

public class Exercise11_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points:");
        int n = Integer.parseInt(input.nextLine()); // to avoid leftover newline causing issues
        if (n < 3) {
            System.out.println("Cannot form a convex polygon with two points.");
            System.exit(1);
        }
        
        System.out.println("Enter the coordinates of the points:");
        String s = input.nextLine();
        String[] arr = s.split("[,\\s]+"); 
        ArrayList<Double> list = new ArrayList<>();

        for (String digit : arr) {
            list.add(Double.valueOf(digit));
        }

        System.out.printf("The total area is %.2f", areaConvexPolygon(list));
    }

    /**
     * Builds a matrix out of the coordinates for easier navigation later
     */
    public static double[][] coordinateMatrix(ArrayList<Double> list) {
        double[][] matrix = new double[list.size() / 2][2];
        
        int index = -1;
        for (double[] row : matrix) for (int col = 0; col < row.length; col++) row[col] = list.get(++index);

        return matrix;
    }

    public static double areaConvexPolygon(ArrayList<Double> list) {
        double[][] matrix = coordinateMatrix(list);

        // Shoelace formula
        double sum1 = matrix[(list.size() / 2) - 1][0] * matrix[0][1];
        for (int i = 0; i < list.size() / 2; i++) {
            if (i + 1 < list.size() / 2) sum1 += (matrix[i][0] * matrix[i+1][1]);
        }

        double sum2 = matrix[(list.size() / 2) - 1][1] * matrix[0][0];
        for (int i = 0; i < list.size() / 2; i++) {
            if (i + 1 < list.size() / 2) sum2 += (matrix[i][1] * matrix[i+1][0]);
        }

        return Math.abs((sum1 - sum2) / 2.0);
    }
}
