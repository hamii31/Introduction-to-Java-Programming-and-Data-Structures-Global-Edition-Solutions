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

    // 6.15 print a tax table
    public static double computeTax(int status,double taxableIncome) {
        double tax = 0.0;
        switch (status) {
            case 0 -> {
                tax += (taxableIncome - (taxableIncome - 8_350)) * 0.10;
                tax += (33_950 - 8_350) * 0.15; 
                tax += (taxableIncome - 33_950) * 0.25;
            }
            case 1 -> {
                tax += (taxableIncome - (taxableIncome - 16_700)) * 0.10; 
                tax += (taxableIncome - 16_700) * 0.15;
            }
            case 2 -> {
                tax += (taxableIncome - (taxableIncome - 8_350)) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (taxableIncome - 33_950) * 0.25;
            }
            case 3 -> {
                tax += (taxableIncome - (taxableIncome - 11_950)) * 0.10;
                tax += (45_500 - 11_950) * 0.15;
                tax += (taxableIncome - 45_500) * 0.25;
            }
        }
        return tax;
    }
    public static void DisplayTax() {
        System.out.printf("Taxable\t\tSingle\t\tMarried\t\tMarried\t\tHead of\n");
        System.out.printf("Income\t\t\t\tJoint\t\tSeparate\ta House\n");
        for (int i = 50_000; i <= 60_000; i+=50) {
            System.out.printf("%d\t\t%5d\t\t%d\t\t%5d\t\t%4d\n", 
            i, Math.round(computeTax(0, i)), Math.round(computeTax(1, i)), 
            Math.round(computeTax(2, i)), Math.round(computeTax(3, i)));
        }
    }
    
    // 6.16 Number of days in a year
    public static int numberOfDaysInAYear(int year) {
        int month = 1;
        int days = 0;
        do { 
            YearMonth ym = YearMonth.of(year, month);
            days += ym.lengthOfMonth();
            month++;
        } while (month <= 12);
        return days;
    }
    public static void displayTotalDaysPerYear() {
        for (int i = 2014; i <= 2034; i++) {
            System.out.printf("%d has %d days.\n",i, numberOfDaysInAYear(i));
        }
    }

    // 6.17 Display matrix
    //** Generate 0 or 1 randomly */
    public static int generateRandomMatrixValue() {
        return (int) (Math.random() + 0.5);
    }
    /** Print a nxn matrix comprised of randomly generated values */
    public static void printMatrix(int n) {
        for(int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.printf("%d ", generateRandomMatrixValue());
            }
            System.out.println();
        }
    }

    // 6.18 Check password
    /** checks if the password length is at least 8 */
    public static boolean hasEightCharacters(String password) {
        return password.length() >= 8;
    }
    /** converts each char in the password and checks its ascii code */
    public static boolean hasOnlyLettersAndNumbers(String password) {
        password = password.toLowerCase();
        for (int i = 0; i < password.length(); i++) {
            // if the ascii code of the character is not within the range for digits or lowercase letters
            if (((int) password.charAt(i) < 48 && (int) password.charAt(i) > 57) ||
            ((int) password.charAt(i) < 97 && (int) password.charAt(i) > 122)) {
                return false;
            }
        }
        return true;
    }
    /** Checks if the password contains at least two digits */
    public static boolean hasTwoDigits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
           if (((int) password.charAt(i) >= 48 && (int) password.charAt(i) <= 57)) {
                count++;
           }
        }
        return count >= 2;
    }
    public static void checkPassword(String password) {
        if (hasEightCharacters(password) && hasOnlyLettersAndNumbers(password) && hasTwoDigits(password)) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
    }


    public static void main(String[] args) {
        CelsiusToFahrenheit ctf = new CelsiusToFahrenheit();
        ctf.testCelsiusToFahrenheit();

        MetersToFeet mtf = new MetersToFeet();
        mtf.testMetersToFeet();
    }
}
