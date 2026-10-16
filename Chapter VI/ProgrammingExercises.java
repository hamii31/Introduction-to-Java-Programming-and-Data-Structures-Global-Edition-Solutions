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
    

    // 6.7 Compute the future investment value
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int numberOfYears) {
        double futureInvestmentValue = investmentAmount * 
            Math.pow((1 + monthlyInterestRate), (numberOfYears * 12));

        return futureInvestmentValue;
    }
    public static void testFutureInvestmentValue() {
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        System.out.println("Enter annual interest rate in percentage: ");
        double annualInterestRate = input.nextDouble();
        double monthlyInterestRate = annualInterestRate / 1200;

        System.out.println("Years\tFuture Years\n");
        for (int years = 1; years <= 30; years++)
            System.out.printf("%d\t%10.2f\n", years, futureInvestmentValue(investmentAmount, monthlyInterestRate, years));
    }


    // 6.8 Celsius and Fahrenheit
    public static class CelsiusToFahrenheit {
        /** Convert from Celsius to Fahrenheit */
        public static double celsiusToFahrenheit(double celsius) {
            return (9.0 / 5) * (celsius + 32);
        }

        /** Convert from Fahrenheit to Celsius */
        public static double fahrenheitToCelsius(double fahrenheit) {
            return (5.0 / 9) * (fahrenheit - 32);
        }

        // test
        public static void testCelsiusToFahrenheit() {
            double celsius = 40.0;
            double fahrenheit = 120.0;

            System.out.println("Celsius\t\tFahrenheit\t|\tFahrenheit\tCelsius");
            System.out.println("---------------------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                System.out.printf("%2.2f\t\t%3.2f\t\t|\t%3.2f\t\t%2.2f\n", celsius, celsiusToFahrenheit(celsius), fahrenheit, fahrenheitToCelsius(fahrenheit));
                celsius -= 1.0;
                fahrenheit -= 10.0;
            }
        }
    }


    // 6.9 Meters to Feet
    public static class MetersToFeet {
        /** Convert from feet to meters */
        public static double footToMeter(double foot) {
            return 0.305 * foot;
        }

        /** Convert from meters to feet */
        public static double meterToFoot(double meter) {
            return 3.279 * meter;
        }

        // test
        public static void testMetersToFeet() {
            double feet = 0.0;
            double meters = 15.0;

            System.out.println("Celsius\t\tFahrenheit\t\tFahrenheit\tCelsius");
            System.out.println("---------------------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                System.out.printf("%2.2f\t\t%4.3f\t\t\t%2.2f\t\t%6.3f\n", feet+=1.0, footToMeter(feet), meters += 5.0, meterToFoot(meters));
            }
        }
    }

    // 6.10 IsPrime
    /** Check whether the number is prime */
    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0)
                return false;
        }
        return true;
    }

    // find the prime numbers < 10000
    public static int findAllPrimesWithinN(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    // test
    public static void testFindAllPrimesWithinN() {
        System.out.println(findAllPrimesWithinN(10000));
    }

    // 6.13 Sum series
    public static double computeM(int i) {
        return i / (double)(i + 1);
    }
    public static void displayM() {
        System.out.printf("i\t\t\tm(i)\n");
        double m = 0.0;
        for (int i = 1; i <= 20; i++) {
            m += computeM(i);
            System.out.printf("%d\t\t\t%2.4f\n",i,m);
        }
    }

    // 6.14 Estimate PI
    public static double computePI(int n) {
        double m = 0.0;
        for (int j = n; j > 0; j--) {
            if (j % 2 == 0)
                m -= 1 / (double) (2 * j - 1);
            else
                m += 1 / (double) (2 * j - 1);
        }
        return m;
    }
    public static void displayPI() {
        System.out.printf("i\t\t\tm(i)\n");
        for (int i = 1; i <= 901; i+=100) {
            double m = 4 * computePI(i);
            System.out.printf("%d\t\t\t%1.4f\n", i, m);
        }
    }
    

    public static void main(String[] args) {
        CelsiusToFahrenheit ctf = new CelsiusToFahrenheit();
        ctf.testCelsiusToFahrenheit();

        MetersToFeet mtf = new MetersToFeet();
        mtf.testMetersToFeet();
    }
}
