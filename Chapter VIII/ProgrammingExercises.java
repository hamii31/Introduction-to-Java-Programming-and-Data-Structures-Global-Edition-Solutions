import java.util.*;
public class ProgrammingExercises {
    public static class Exercise1 {
        /*
        * Matrix operations
         */
        public static double sumColumn(double[][] m, int columnIndex) {
            double sum = 0.0;
            for(int row = 0; row < m.length; row++) {
                sum += m[row][columnIndex];
            }
            return sum;
        }
        public static double sumMajorDiagonal(double[][] m) {
            double sum = 0.0;
            int columnIndex = 0;
            for (int row = 0; row < m.length; row++) {
                sum += m[row][columnIndex];
                columnIndex++;
            }
            return sum;
        }
        public static double[] convertStringToDoubleArray(String[] arr) {
            double[] columnValues = new double[arr.length];
            for(int i = 0; i < arr.length; i++) {
                columnValues[i] = Double.parseDouble(arr[i]);
            }
            return columnValues;
        }
        public static double[][] buildMatrix(Scanner input, int rows, int columns) {
            double[][] matrix = new double[rows][columns];
            for (int row = 0; row < matrix.length; row++) {
                String s = input.nextLine();
                double[] columnValues = convertStringToDoubleArray(s.split((" ")));
                for (int column = 0; column < matrix[row].length; column++) {
                    matrix[row][column] = columnValues[column];
                }
            }
            return matrix;
        }
        /* Create a 3x4 matrix from user input and sum columns */
        public static void test1() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a 3 by 4 matrix row by row: ");
            int rows = 3;
            int columns = 4;
            double[][] matrix = buildMatrix(input, rows, columns);
            for(int column = 0; column < matrix[0].length; column++) {
                System.out.printf("Sum of the elements at column %d is %.1f\n", column, sumColumn(matrix, column));
            }
        }
        /* Create a 4x4 matrix and sum the major diagonal */
            public static void test2() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a 4 by 4 matrix row by row: ");
            int rows = 4;
            int columns = 4;
            double[][] matrix = buildMatrix(input, rows, columns);
            System.out.printf("Sum of the elements in the major diagonal is %.1f\n", sumMajorDiagonal(matrix));
        }
    }

    public static void main(String[] args) {
        Exercise1.test2();
    }
}
