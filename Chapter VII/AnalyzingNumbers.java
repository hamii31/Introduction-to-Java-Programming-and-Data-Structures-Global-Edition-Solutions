import java.util.Scanner;

/** 
 * Write a program that finds the number of items above
 * the average of all items
 */
public class AnalyzingNumbers{
    public static double findAverage(double[] arr) {
        double average = 0;
        for (double e : arr) {
            average += e;
        }
        return average / arr.length;
    }

    public static double[] buildArray(int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1 + (Math.random() * 10);
        }
        return arr;
    }

    public static boolean isAboveAverage(double e, double average) {
        return e > average;
    }

    public static int countNumbersAboveAverage(int n) {
        double[] arr = buildArray(n);
        double average = findAverage(arr);
        System.out.printf("The average is %f\n", average);

        int count = 0;
        for (double e : arr) {
            if (isAboveAverage(e, average))
                count++;
        }
        return count;
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount of elements wanted: ");
        int n = input.nextInt();
        System.out.printf("The amount of elements above the average is %d", countNumbersAboveAverage(n));
    }
}
