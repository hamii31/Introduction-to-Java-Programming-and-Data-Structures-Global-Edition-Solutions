import java.util.*;
public class ProgrammingExercises {
    public static class MatrixOperations {
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
        /* Add 2 3x3 matrices */
        public static double[][] addMatrix(double[][] a, double[][] b) {
            double[][] c = new double[a.length][a.length];
            for(int row = 0; row < a.length; row++) {
                for (int col = 0; col < a[row].length; col++) {
                    c[row][col] = a[row][col] + b[row][col];
                }
            }
            return c;
        }
        public static double multRowByColumn(double[][] a, double[][] b, int currentRow, int currentCol) {
            double mult = 0.0;
            for (int i = 0; i < 3; i++) {
                mult += a[currentRow][i] * b[i][currentCol];
            }
            return mult;
        }
        /* Multiply 2 3x3 matrices */
        public static double[][] multMatrix(double[][] a, double[][] b) {
            double[][] c = new double[a.length][a.length];
            for(int row = 0; row < c.length; row++) {
                for (int col = 0; col < c[row].length; col++) {
                    c[row][col] = multRowByColumn(a, b, row, col);
                }
            }
            return c;
        }
        public static void sort2DAsc(int m[][]) {
            for (int node = 0; node < m.length; node++) {
                for (int next = node + 1; next < m.length; next++) {
                    // sort by primary col
                    if (m[node][0] > m[next][0]) {
                        int[] temp = m[node];
                        m[node] = m[next];
                        m[next] = temp;
                    }

                    // sort by secondary col
                    if (m[node][0] == m[next][0] && m[node][1] > m[next][1]) {
                        int[] temp = m[node];
                        m[node] = m[next];
                        m[next] = temp;
                    }
                }
            }
        }
        public static void displayMatrix(double[][] m) {
            for(int row = 0; row < m.length; row++) {
                for (int col = 0; col < m[row].length; col++) {
                    System.out.printf("%.1f ", m[row][col]);
                }
                System.out.println();
            }
        }
        public static void displayMatrix(int[][] m) {
            for(int row = 0; row < m.length; row++) {
                for (int col = 0; col < m[row].length; col++) {
                    System.out.printf("%d ", m[row][col]);
                }
                System.out.println();
            }
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
        /* Create two 3x3 matrices and sum them */
        public static void test3() {
            Scanner input = new Scanner(System.in);
            int rows = 3;
            int columns = 3;
            System.out.println("Enter the first 3 by 3 matrix row by row: ");
            double[][] matrix1 = buildMatrix(input, rows, columns);
            System.out.println("Enter the second 3 by 3 matrix row by row: ");
            double[][] matrix2 = buildMatrix(input, rows, columns);
            displayMatrix(addMatrix(matrix1, matrix2));
        }
        /* Create two 3x3 matrices and multiply them */
        public static void test4() {
            Scanner input = new Scanner(System.in);
            int rows = 3;
            int columns = 3;
            System.out.println("Enter the first 3 by 3 matrix row by row: ");
            double[][] matrix1 = buildMatrix(input, rows, columns);
            System.out.println("Enter the second 3 by 3 matrix row by row: ");
            double[][] matrix2 = buildMatrix(input, rows, columns);
            displayMatrix(multMatrix(matrix1, matrix2));
        }
        /* Sort a two-dimensional array */
        public static void test5() {
            int[][] arr = {
                {4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}
            };
            sort2DAsc(arr);
            displayMatrix(arr);
        }
    }

    public static class PointOperations {
        /* Compute distance between two points in a 3D space */
        public static double compute3DDistance(double x1, double x2, double y1, double y2, double z1, double z2) {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
        }
        public static void iterateThreeDimensionalSpace(double[][] points) {
            double smallestDistance = Double.MAX_VALUE;
            int[] closestPoints = new int[2];
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    
                    double distance = compute3DDistance(points[i][0], points[j][0], points[i][1], points[j][1], points[i][2], points[j][2]);
                    
                    if (distance < smallestDistance) {
                        smallestDistance = distance;
                        closestPoints[0] = i;
                        closestPoints[1] = j;
                    }
                }
            }

            System.out.printf("The closest points are (%.1f, %.1f, %.1f) and (%.1f, %.1f, %.1f)\n", 
            points[closestPoints[0]][0],  points[closestPoints[0]][1],  points[closestPoints[0]][2],
            points[closestPoints[1]][0],  points[closestPoints[1]][1],  points[closestPoints[1]][2]);

            System.out.printf("The distance between them is %.2f", smallestDistance);
        }
        public static void test1() {
            double[][] points = {
                {-1, 0, 3}, {-1, -1, -1}, 
                {4, 1, 1}, {2, 0.5, 9}, 
                {3.5, 2, -1}, {3, 1.5, 3},
                {-1.5, 4, 2}, {5.5, 4, -0.5}
            };
            iterateThreeDimensionalSpace(points);
        }
    }
    
    public static class HeadsAndTails {
        public static String buildBinaryString(int userInput) {
            String s = "000000000";
            String binary = Integer.toBinaryString(userInput);
            s = s.substring(binary.length()) + binary;
            return s;
        }
        public static String mapCoins(String character) {
            switch (character) {
                case "0" -> { return "H"; }
                case "1" -> { return "T"; }
            }
            return null;
        }
        public static String[][] buildProbabilityMatrix(String s) {
            String[] arr = s.split("");
            int index = 0;
            String[][] matrix = new String[3][3];
            for (int row = 0; row < matrix.length; row++) 
                for(int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = mapCoins(arr[index]);
                    index++;
                }
            return matrix;
        }
        public static void displayMatrix(String[][] m) {
            for(int row = 0; row < m.length; row++) {
                for (int col = 0; col < m[row].length; col++) {
                    System.out.printf("%s ", m[row][col]);
                }
                System.out.println();
            }
        }
        public static void init() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a number between 0 and 511: ");
            int userInput = input.nextInt();
            if (userInput >= 0 && userInput <= 511) {
                String s = buildBinaryString(userInput);
                displayMatrix(buildProbabilityMatrix(s));
            } else {
                System.out.println("Invalid input");
            }
        }
    }
    
    public static void main(String[] args) {
        MatrixOperations.test5();
    }
}
