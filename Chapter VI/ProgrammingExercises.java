import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgrammingExercises {

    // 6.1 Pentagonal numbers
    public static int getPentagonalNumbers(int n) {
        return n * ((3 * n) - 1) / 2;
    }
    // call from the main method to invoke getPentagonalNumbers(int n)
    public static void testPentagonalNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.printf("%7d ", getPentagonalNumbers(i));
            if (i % 10 == 0)
                System.out.printf("\n");
        }
    }


    // 6.2 Sum digits in an integer
    public static int sumDigits(long n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    // call from the main method
    public static void testSumDigits() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        long n = input.nextLong();
        System.out.println(sumDigits(n));
    }


    // 6.3 and 6.4 Palindrome integer and Display reversed integer
    // Return the reversal of an integer, e.g., reverse(456) returns 654
    public static int reverse(int number) {
        String temp = "";
        while(number != 0) {
            temp += Integer.toString(number % 10);
            number /= 10;
        }
        return Integer.parseInt(temp);
    }
    // Return true if number is a palindrome
    public static boolean isPalindrome(int number) {
        int reversed = reverse(number);
        return number == reversed;
    }
    // test
    public static void testIsPalindrome() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = input.nextInt();
        System.out.println(reverse(number));
        System.out.println(isPalindrome(number));
    }


    // 6.5 Sort three numbers
    public static void displaySortedNumbers(double num1, double num2, double num3) {
        System.out.println(findBiggestNumber(num1, num2, num3));
    }
    // find biggest number
    public static List<Double> findBiggestNumber(double...nums) {
        List<Double> sorted = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            double biggest = Double.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > biggest && !sorted.contains(nums[j])) {
                    biggest = nums[j];
                }
            }
            sorted.add(biggest);
        }

        return sorted;
    }
    // test
    public static void testDisplaySortedNumbers() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three numbers separated by space: ");
        String s = input.nextLine();
        String[] arr = s.split(" ");
        if (arr.length == 3)
            displaySortedNumbers(Double.parseDouble(arr[0]),
                                Double.parseDouble(arr[1]), 
                                Double.parseDouble(arr[2]));
    }


    // 6.6 Display patterns
    public static void displayPattern(int n) {
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j <= i; j++) {
                row = j + 1 + " " + row;
            }
            String fmt = String.format("%%%ds\n",  2 * n + (n - 2));
            System.out.printf(fmt, row);
        }
    }
    public static void testDisplayPattern() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the height of the pyramid: ");
        int n = input.nextInt();
        displayPattern(n);
    }
    public static void main(String[] args) {

    }
}
