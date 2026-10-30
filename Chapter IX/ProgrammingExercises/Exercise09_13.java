
import java.util.Scanner;

public class Exercise09_13 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows of the matrix: ");
        int rows = input.nextInt();
        System.out.println("Enter the number of columns of the matrix: ");
        int columns = input.nextInt();

        double[][] matrix = buildMatrix(rows, columns, input);
        Location loc = locateLargest(matrix);
        System.out.printf("The largest element is %.1f, located at (%d, %d)", loc.maxValue, loc.row, loc.column);
    }

    public static double[][] buildMatrix(int rows, int columns, Scanner input) {
        double[][] matrix = new double[rows][columns];
        System.out.println("Enter the array: ");
        for (int row = 0; row < rows; row++) {
            System.out.println("Enter row values (1 per line)");
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = input.nextDouble();
            }
        }
        return matrix;
    }

    public static Location locateLargest(double[][] a) {
        int maxRow = -1;
        int maxCol = -1;
        double maxValue = Double.MIN_EXPONENT;

        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if (a[row][col] > maxValue) {
                    maxValue = a[row][col];
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        return new Location(maxRow, maxCol, maxValue);
    }
}

class Location {
    int row;
    int column;
    double maxValue;

    public Location(int row, int column, double maxValue) {
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }
}
