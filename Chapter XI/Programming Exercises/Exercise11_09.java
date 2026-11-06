import java.util.*;

public class Exercise11_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n for n x n matrix: ");
        int n = input.nextInt();

        int[][] matrix = buildMatrix(n);
        printMatrix(matrix);
        System.out.println("The largest row index: " + findLargestRows(matrix));
        System.out.println("The largest column index: " + findLargestCols(matrix));
    }

    public static ArrayList<Integer> findLargestRows(int[][] matrix) { 
        int largestSum = Integer.MIN_VALUE;
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            int rowSum = 0;

            for (int col = 0; col < matrix[row].length; col++) rowSum += matrix[row][col];
            
            if (rowSum > largestSum) {
                largestSum = rowSum;
                indexes.clear();
            }
            if (rowSum >= largestSum) indexes.add(row);
        }

        return indexes;
    }

    public static ArrayList<Integer> findLargestCols(int[][] matrix) {
        int largestSum = Integer.MIN_VALUE;
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int col = 0; col < matrix.length; col++) {
            int colSum = 0;

            for (int row = 0; row < matrix[col].length; row++) colSum += matrix[row][col];
            
            if (colSum > largestSum) { 
                largestSum = colSum;
                indexes.clear();
            }
            if (colSum >= largestSum) indexes.add(col);
        }

        return indexes;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) System.out.printf("%d ", matrix[row][col]);
            System.out.println("");
        }
    }

    public static int[][] buildMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random rng = new java.util.Random();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = rng.nextInt(2);
            }
        }

        return matrix;
    }
}
