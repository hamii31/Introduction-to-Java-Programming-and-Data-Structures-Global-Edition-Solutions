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

    // 3.13 Compute taxes
    static {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter filing status (0 for single, 1 for married filing jointly or qualified widow(er), 2 for married filing separately, and 3 for head of household): ");
        int status = input.nextInt();

        System.out.println("Please enter taxable income: ");
        double income = input.nextDouble();

        double tax = 0.0;

        
        switch (status) { 
            case 0 -> {
                double remainder = income - 8_350;

                if (remainder < 0) {
                tax += income * 0.10;
                }
                else if (income > 8_350 && income <= 33_950) {
                tax += (income - remainder) * 0.10; // tax the income within the 10% marginal tax rate
                tax += remainder * 0.15; // tax the rest within the 15% range
                }
                else if (income > 33_950 && income <= 82_250) {
                tax += (income - remainder) * 0.10; // tax the income within the 10%
                tax += (33_950 - 8_350) * 0.15; // tax the income wthin the 15% range
                tax += (income - 33_950) * 0.25; // tax the income within the 25% range
                }
                else if (income > 82_550 && income <= 171_550) {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (82_550 - 33_950) * 0.25;
                tax += (income - 82_550) * 0.28;
                }
                else if (income > 171_550 && income <= 372_950) {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (82_550 - 33_950) * 0.25;
                tax += (171_550 - 82_550) * 0.28;
                tax += (income - 171_550) * 0.33;
                }
                else {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (82_550 - 33_950) * 0.25;
                tax += (171_550 - 82_550) * 0.28;
                tax += (372_950 - 171_550) * 0.33;
                tax += (income - 372_950) * 0.35;
                }
            }
            case 1 -> {
                double remainder = income - 16_700;
                if (remainder < 0) {
                tax += income * 0.10;
                }
                else if (income > 16_700 && income <= 67_900) {
                tax += (income - remainder) * 0.10;
                tax += remainder * 0.15;
                }
                else if (income > 67_900 && income <= 137_050) {
                tax += (income - remainder) * 0.10;
                tax += (67_900 - 16_700) * 0.15;
                tax += (income - 67_900) * 0.25;
                }
                else if (income > 137_050 && income <= 208_850) {
                tax += (income - remainder) * 0.10;
                tax += (67_900 - 16_700) * 0.15;
                tax += (137_050 - 67_900) * 0.25;
                tax += (income - 137_050) * 0.28;
                }
                else if (income > 208_850 && income <= 372_950) {
                tax += (income - remainder) * 0.10;
                tax += (67_900 - 16_700) * 0.15;
                tax += (137_050 - 67_900) * 0.25;
                tax += (208_850 - 137_050) * 0.28;
                tax += (income - 208_850) * 0.33;
                }
                else {
                tax += (income - remainder) * 0.10;
                tax += (67_900 - 16_700) * 0.15;
                tax += (137_050 - 67_900) * 0.25;
                tax += (208_850 - 137_050) * 0.28;
                tax += (372_950 - 288_850) * 0.33;
                tax += (income - 372_950) * 0.35;
                }
            }
            case 2 -> {
                double remainder = income - 8_350;

                if (remainder < 0) {
                    tax += income * 0.10;
                }
                else if (income > 8_350 && income <= 33_950) {
                    tax += (income - remainder) * 0.10; 
                    tax += remainder * 0.15;
                }
                else if (income > 33_950 && income <= 68_525) {
                    tax += (income - remainder) * 0.10;
                    tax += (33_950 - 8_350) * 0.15;
                    tax += (income - 33_950) * 0.25;
                }
                else if (income > 68_525 && income <= 104_425) {
                    tax += (income - remainder) * 0.10;
                    tax += (33_950 - 8_350) * 0.15;
                    tax += (68_525 - 33_950) * 0.25;
                    tax += (income - 68_525) * 0.28;
                }
                else if (income > 104_425 && income <= 186_475) {
                    tax += (income - remainder) * 0.10;
                    tax += (33_950 - 8_350) * 0.15;
                    tax += (68_525 - 33_950) * 0.25;
                    tax += (104_425 - 68_525) * 0.28;
                    tax += (income - 104_425) * 0.33;
                }
                else {
                    tax += (income - remainder) * 0.10;
                    tax += (33_950 - 8_350) * 0.15;
                    tax += (68_525 - 33_950) * 0.25;
                    tax += (104_425 - 68_525) * 0.28;
                    tax += (186_475 - 104_425) * 0.33;
                    tax += (income - 186_475) * 0.35;
                }
            }
            case 3 -> {
                double remainder = income - 11_950;

                if (remainder < 0) {
                    tax += income * 0.10;
                }
                else if (income > 11_950 && income <= 45_500) {
                    tax += (income - remainder) * 0.10; 
                    tax += remainder * 0.15;
                }
                else if (income > 45_500 && income <= 117_450) {
                    tax += (income - remainder) * 0.10;
                    tax += (45_500 - 11_950) * 0.15;
                    tax += (income - 45_500) * 0.25;
                }
                else if (income > 117_450 && income <= 190_200) {
                    tax += (income - remainder) * 0.10;
                    tax += (45_500 - 11_950) * 0.15;
                    tax += (117_450 - 45_500)* 0.25;
                    tax += (income - 117_450) * 0.28;
                }
                else if (income > 190_200 && income <= 372_950) {
                    tax += (income - remainder) * 0.10;
                    tax += (45_500 - 11_950) * 0.15;
                    tax += (117_450 - 45_500)* 0.25;
                    tax += (190_200 - 117_450) * 0.28;
                    tax += (income - 190_200) * 0.33;
                }
                else {
                    tax += (income - remainder) * 0.10;
                    tax += (45_500 - 11_950) * 0.15;
                    tax += (117_450 - 45_500)* 0.25;
                    tax += (190_200 - 117_450) * 0.28;
                    tax += (372_950 - 190_200) * 0.33;
                    tax += (income - 372_950) * 0.35;
                }
            }
            default -> {
                System.out.println("Error: invalid status");
                System.exit(1); 
            }
        }
        System.out.println("Tax is " + (int)(tax * 100) / 100.0);
    }

    // 3.14 Heads or tails
    static {
        // Toss coin
        int coin = (Math.abs(Math.random()) >= 0.5) ? 1 : 0;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Heads or tails? Enter 0 for heads and 1 for tails: ");
        int guess = input.nextInt();

        if (coin == 0)
            System.out.println((coin == guess) ? "Correct, it is heads!" : "Sorry, it is heads.");
        else
            System.out.println((coin == guess) ? "Correct, it is tails!" : "Sorry, it is tails."); 
    }

    // 3.15 Lottery
    static {
            // Generate three-digit number
            String generated = "0";
            while(true) {
                int number = (int) (Math.random() * 1000);
                if (number > 99 && number < 1000) {
                    generated = Integer.toString(number);
                    break;
                }
            }

            if (generated.equals("0")) {
                System.out.println("There was an errror.");
            }

            // Prompt user
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a two-digit number (101, 999, 253, 891): ");
            String userInput = input.nextLine();

            System.out.println("The generated number is " + generated);

            if (generated.equals(userInput))
                System.out.println("Wow, you are one lucky person! You just won $12,000!");
            else if (allDigitsNoOrder(generated, userInput))
                System.out.println("Wow, you almost guessed it! Here are $5,000 for your effort!");
            else if (someDigitsMatch(generated, userInput))
                System.out.println("Wow, you guessed one of the digits! Here are $2,000 for your effort!");
            else
                System.out.println("Better luck next time!");
    }

    private static boolean allDigitsNoOrder(String generated, String userInput) {
        return matchCounterFunc(generated, userInput) == 3;
    }

    private static boolean someDigitsMatch(String generated, String userInput) {
        return matchCounterFunc(generated, userInput) > 0;
    }

    private static int matchCounterFunc(String generated, String userInput) {
        int matchCounter = 0;
        int length = generated.length();
        
        for (int i = 0; i < length; i++) {

            boolean match = false;
            char digit = generated.charAt(i);

            for (int j = 0; j < length; j++) {
                if (digit == userInput.charAt(j))
                    match = true;
            }

            if (match)
                matchCounter++;
        }

        return matchCounter;
    }

    // 3.16 Random point
    static {
        while(true) {
            int height = (int) (Math.random() * 100);
            int width = (int) (Math.random() * 1000);

            if (width <= 50 && height <= 150) {
                System.out.println("Coordinates in rectangle: (" + width + ", " + height + ")");
                break;
            }
        }
    }
    
    // 3.17 Rock, paper, scissor
    static {
        // Generate move
        int computerMove = 0;
        while (true) {
            computerMove = (int) (Math.random() * 10);
            if (computerMove < 3)
                break;
        }

        // Get user move
        Scanner input = new Scanner(System.in);
        System.out.println("rock (0), paper (1), scissor (2): ");
        int userInput = input.nextInt();

        switch (userInput) {
            // rock
            case 0 -> {
                switch (computerMove) {
                    // rock
                    case 0 -> System.out.println("The computer is rock. You are rock too. It is a draw.");
                    // paper
                    case 1 -> System.out.println("The computer is paper. You are rock. The computer wins.");
                    // scissors
                    case 2 -> System.out.println("The computer is scissors. You are rock. You win.");
                }
            }
            // paper
            case 1 -> {
                switch (computerMove) {
                    // rock
                    case 0 -> System.out.println("The computer is rock. You are paper. You win.");
                    // paper
                    case 1 -> System.out.println("The computer is paper. You are paper too. It is a draw.");
                    // scissors
                    case 2 -> System.out.println("The computer is scissors. You are paper. The computer wins.");
                }
            }
             // scissors
            case 2 -> {
                switch (computerMove) {
                    // rock
                    case 0 -> System.out.println("The computer is rock. You are scissors. The computer wins.");
                    // paper
                    case 1 -> System.out.println("The computer is paper. You are scissors. You win.");
                    // scissors
                    case 2 -> System.out.println("The computer is scissors. You are scissors too. It is a draw.");
                }
            }
        }
    }

    // 3.18 Cost of shipping
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the weight (w) of the package in pounds: ");
        double w = input.nextDouble();

        double c_w = 0.0;
        if (w > 0 && w <= 2)
            c_w = 2.5;
        else if (w > 2 && w <= 4)
            c_w = 4.5;
        else if (w > 4 && w <= 10)
            c_w = 7.5;
        else if (w > 10 && w <= 20)
            c_w = 10.5;
        else {
            System.out.println("The package cannot be shipped");
            System.exit(1);
        }

        System.out.println("The cost for a package weighing " + w + " will be " + c_w);
    }

    // 3.19 Perimeter of rectange
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length and width: ");
        String userInput = input.nextLine();
        String[] splitInput = userInput.split(" ");
        
        double length = Double.parseDouble(splitInput[0]);
        double width = Double.parseDouble(splitInput[1]);

        if (length != width) {
            System.out.println(2 * (length * width));
        }
        else
            System.out.println("Invalid input");
    }

    // 3.20 Wind-chill temperature
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the temperature is Fahrenheit between -58°F and 41°F: ");
        double t_a = input.nextDouble();

        System.out.println("Enter the wind speed (> = 2) in mph: ");
        double v = input.nextDouble();

        if ((t_a <= 41 && t_a >= -58) && v >= 2){
            double t_wc = 35.74 + (0.6215 * t_a) - (35.75 * Math.pow(v, 0.16)) + (0.4275 * t_a * Math.pow(v, 0.16));
            System.out.println("The wind chill index is " + t_wc);
        }
        else {
            if (t_a > 41)
                System.out.println("The temperature is higher than 41°F.");
            if (t_a < -58)
                System.out.println("The temperature is lower than -58°F.");
            if (v < 2)
                System.out.println("The wind speed is lower than 2.");
        }
    }

    // 3.21 Day of the week
    static {
        // Get user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter year (e.g. 2008): ");
        int year = input.nextInt();

        System.out.println("Enter month (1-12): ");
        int month = input.nextInt();
        if (month > 12 || month < 1) {
            System.out.println("Invalid month.");
            System.exit(1);
        }

        // January is counted as month 13 of the previous year in the algorithm
        month = (month == 1) ? 13 : month;
        year = (month == 13) ? year - 1 : year;

        // February is counted as month 14 of the previous year in the algorithm
        month = (month == 2) ? 14 : month;
        year = (month == 14) ? year - 1 : year;

        System.out.println(year);

        System.out.println("Enter the day of the month (1-31): ");
        int day = input.nextInt();
        if (day > 31 || day < 1) {
            System.out.println("Invalid day.");
            System.exit(1);
        }

        // Computer Zeller's congruence
        int q = day;
        int m = month;
        int j = year / 100;
        int k = year % 100;

        int h = (q 
        + ((26 * (m + 1)) / 10)
        + k + (k / 4) + (j / 4)
        + (5 * j)) % 7;

        switch (h) {
            case 0 -> System.out.println("Saturday");
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
        }
    }

    // 3.22 Point in a circle
    static {
        double x_1 = 0.0;
        double y_1 = 0.0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the coordinates of a point: ");
        String userInput = input.nextLine();
        String[] splitInput = userInput.split(" ");

        double x_2 = Double.parseDouble(splitInput[0]);
        double y_2 = Double.parseDouble(splitInput[1]);

        // Compute the distance between the center (0, 0) and the point
        double distance = Math.sqrt(
            Math.pow((x_2 - x_1), 2)
            + 
            Math.pow((y_2 - y_1), 2)
        );

        // Check if the point is within a circle with radius 10
        if (distance <= 10)
            System.out.println("The point is within the circle.");
        else 
            System.out.println("The point is outside of the circle.");
    }

    // 3.23 Point in a rectangle
    static {
        int height = 5;
        int width = 10;

        double x_1 = 1.0;
        double y_1 = 1.0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the coordinates of a point: ");
        String userInput = input.nextLine();
        String[] splitInput = userInput.split(" ");

        double x_2 = Double.parseDouble(splitInput[0]);
        double y_2 = Double.parseDouble(splitInput[1]);

        // Compute the distance between the center (0, 0) and the point
        double distance = Math.sqrt(
            Math.pow((x_2 - x_1), 2)
            + 
            Math.pow((y_2 - y_1), 2)
        );

        // Check if the point is within a circle with radius 10
        if (distance <= (width / 2) && distance <= (height / 2))
            System.out.println("The point is within the rectangle.");
        else 
            System.out.println("The point is outside of the rectangle.");
    }
    
    public static void main(String[] args) {

    }
}
