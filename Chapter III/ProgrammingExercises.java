import java.util.Arrays;
import java.util.Scanner;
import java.time.YearMonth;

public class ProgrammingExercises {
    // 3.1 Solve quadratic equation
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a value for a: ");
        double a = input.nextDouble();

        System.out.println("Enter a value for b: ");
        double b = input.nextDouble();

        System.out.println("Enter a value for c: ");
        double c = input.nextDouble();

        double discriminant = Math.pow(b,2) - (4 * a * c);
        if (discriminant > 0) {
            double r_1 = (-b + Math.sqrt(Math.pow(b,2) - (4 * a * c))) / (2 * a);
            double r_2 = (-b - Math.sqrt(Math.pow(b,2) - (4 * a * c))) / (2 * a);
            System.out.println("The discriminant is positive, and therefore the quadratic equation has two roots.");
            System.out.println("r_1: " + r_1);
            System.out.println("r_2: " + r_2);
        }
        else if (discriminant == 0) {
            double r_1 = (-b + Math.sqrt(Math.pow(b,2) - (4 * a * c))) / (2 * a);
            System.out.println("The discriminant is equal to zero, therefore the quadratic equation has one root.");
            System.out.println("r_1: " + r_1);
        }
        else
            System.out.println("The equation has no real roots.");

    }

    // 3.2 multiply three numbers
    static {
        Scanner input = new Scanner(System.in);
        int rng_1 = (int) (Math.random() * 10);
        int rng_2 = (int) (Math.random() * 10);
        int rng_3 = (int) (Math.random() * 10);

        System.out.println("What is the product of " + rng_1 + ", " + rng_2 + ", " + rng_3 + "?");
        int userProduct = input.nextInt();
        int product = rng_1 * rng_2 * rng_3;

        if (userProduct == product)
            System.out.println("Well done!");
        else
            System.out.println("Not quite.");
    }

    // 3.3 solve 2 x 2 linear equations
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a value for a: ");
        double a = input.nextDouble();

        System.out.println("Enter a value for b: ");
        double b = input.nextDouble();

        System.out.println("Enter a value for c: ");
        double c = input.nextDouble();

        System.out.println("Enter a value for d: ");
        double d = input.nextDouble();

        System.out.println("Enter a value for e: ");
        double e = input.nextDouble();

        System.out.println("Enter a value for f: ");
        double f = input.nextDouble();

        // Apply Cramer's rule
        if ((a * d) - (b * c) != 0)
        {
            double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
            double y = ((a * f) - (e * c)) / ((a * d) - (b * c));

            System.out.println(x);
            System.out.println(y);
        }
        else
            System.out.println("The equation has no solution.");
    }

    // 3.4 Random color
    static {
        int colorIndex = 0;
        while(true) {
            colorIndex = (int) (Math.random() * 10);
            if (colorIndex > 0 && colorIndex < 8)
                break;
        }

        switch (colorIndex){
            case 1 -> System.out.println("violet");
            case 2 -> System.out.println("indigo");
            case 3 -> System.out.println("blue");
            case 4 -> System.out.println("green");
            case 5 -> System.out.println("yellow");
            case 6 -> System.out.println("orange");
            case 7 -> System.out.println("red");
        }
    }

    // 3.5 Find future dates
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number corresponding to the current day of the week (0 -> Sunday, 1 -> Monday, 2 -> Tuesday, ..., 6 -> Saturday): ");
        int currentDay = input.nextInt();

        System.out.println("Enter the number of days until a future day to be displayed: ");
        int numberOfDays = input.nextInt();
        
        int futureDay = currentDay + numberOfDays;
        System.out.println("Today is " + helperFunc(currentDay) + " and the future day is " + helperFunc(futureDay % 6));
    }

    private static String helperFunc(int dayOfWeek) {
        return switch (dayOfWeek % 6) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Unwknown date";
        };
    }

    // 3.6 BMI
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your bodyweight in pounds:");
        double bw = input.nextDouble();
        System.out.println("Please enter feet:");
        double feet = input.nextDouble();
        System.out.println("Please enter inches:");
        double inches = input.nextDouble();

        inches += (feet * 12);

        double BMI = (bw * 0.45359237) / Math.pow((inches * 0.0254), 2);
        System.out.println("Your BMI is " + BMI);

        if (BMI < 18.5)
            System.out.println("Underweight");
        else if (BMI >= 18.5 && BMI < 25.0)
            System.out.println("Normal");
        else if (BMI >= 25.0 && BMI < 30.0)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }

    // 3.7 Monetary units
    static {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an amount (e.g. 11.56)");
        double amount = scan.nextDouble();

        double temp = amount * 100;
        int cents = (int)temp;
        if (cents != 0) {
            if (cents > 1)
                System.out.println(cents + " cents");
            else
                System.out.println(cents + " cent");
        }

        int dollars = cents / 100;
        if (dollars != 0) {
            if (dollars > 1)
                System.out.println(dollars + " dollars");
            else
                System.out.println(dollars + " dollar");
        }

        int remainingCents = cents % 100;
        int quarters = remainingCents / 25;
        if (quarters != 0) {
            if (quarters > 1)
                System.out.println(quarters + " quarters");
            else
                System.out.println(quarters + " quarter");
        }

        remainingCents = cents % 25;
        int dimes = remainingCents / 10;
        if (dimes != 0) { 
            if (dimes > 1)
                System.out.println(dimes + " dimes");
            else
                System.out.println(dimes + " dime");
        }

        remainingCents = cents % 10;
        int nickels = remainingCents / 5;
        if (nickels != 0) {
            if (nickels > 1)
                System.out.println(nickels + " nickels");
            else
                System.out.println(nickels + " nickel");
        }

        int pennies = remainingCents;
        if (pennies != 0) {
            if (pennies > 1)
                System.out.println(pennies + " pennies");
            else
                System.out.println(pennies + " penny");
        }
    }

    // 3.8 Sort three integers
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three integers separated by space: ");
        String userInput = input.nextLine();
        String[] arr = userInput.split(" ");

        int arr_length = arr.length;
        int[] integers = new int[arr_length];
        for (int i = 0; i < arr_length; i++) {
            integers[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(integers);

        System.out.println("The sorted numbers are " + Arrays.toString(integers));
    }
    
    // 3.9 ISBN-10
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first 9 digits of an ISBN as integer: ");
        int userInput = input.nextInt();

        int[] d = new int[10];
        for (int i = 0; i < d.length; i++) {
            // Check if we are at the final iteration
            if (9-i == 0) {
                // Get the checksum
                int checkSum = calculateChecksum(d);

                // Convert to string and replace all non-digit characters
                String isbn_10 = Arrays.toString(d).replaceAll("\\D", "");

                // Remove the trailing zero as a result of the iterations (9-digits vs int[10])
                isbn_10 = isbn_10.substring(0, isbn_10.length() - 1);

                // In its place, using a conditional expression, add either the checksum or X
                isbn_10 += (checkSum != 10) ? Integer.toString(checkSum).charAt(0) : 'X';
                System.out.println("The ISBN-10 number is " + isbn_10);
                break;
            }

            // Put the last digit to the end of the array, creeping forward with each iteration
            d[9-i - 1] = userInput % 10;

            // Remove the last digit that we just added to the array
            userInput = userInput / 10;
        }
    }

    private static int calculateChecksum(int[] d) {
        int checkSum = 0;
        for(int i = 1; i < d.length; i++) {
            checkSum += d[i] * i;
        }
        return checkSum % 11;
    }

    // 3.10 Multiplication quiz
    static {
        int x, y;
        x = y = -1;
        while(true) {
            int number = (int) (Math.random() * 1000);
            if (number < 1000 & x == -1)
                x = number;
            else if (number < 1000 & y == -1) {
                y = number;
                break;
            }
        }

        System.out.println(x + " * " + y + " = ?");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        
        System.out.println((userInput == (x * y) ? "Well done!" : "Not quite."));
    }

    // 3.11 Number of days in a month
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Ebter a month of the year (e.g., 1 for Jan): ");
        int month = input.nextInt();

        System.out.println("Enter a year: ");
        int year = input.nextInt();

        YearMonth yearMonthobj = YearMonth.of(year, month);
        switch (month) {
            case 1 -> System.out.println("January " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 2 -> System.out.println("February " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 3 -> System.out.println("March " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 4 -> System.out.println("April " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 5 -> System.out.println("May " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 6 -> System.out.println("June " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 7 -> System.out.println("July " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 8 -> System.out.println("August " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 9 -> System.out.println("September " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 10 -> System.out.println("October " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 11 -> System.out.println("November " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            case 12 -> System.out.println("December " + year + " has " + yearMonthobj.lengthOfMonth() + " days");
            default -> System.out.println("Invalid month.");
        }
    }

    // 3.12 Palindrome integer
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a three-digit integer: ");
        int userInput = input.nextInt();

        // negative ints are treated as positive integers
        String s = Integer.toString(Math.abs(userInput));
        System.out.println((s.charAt(0) == s.charAt(2)) ? userInput + " is a palindrome" : userInput + " is not a palindrome");
    }

    public static void main(String[] args) {

    }
}
