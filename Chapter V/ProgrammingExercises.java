import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class ProgrammingExercises {
    // 5.1 Pass or fail
    static {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your score: ");
            int score = input.nextInt();

            if (score == -1) {
                System.out.println("No numbers are entered except 0.");
                break;
            }
            
            if (score >= 60)
                System.out.println("You pass the exam.");
            else 
                System.out.println("You don't pass the exam.");
        }
    }

    // 5.2 Repeat multiplications
    static {
        Scanner input = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < 10; i++) {
            // Generate two numbers between 1 and 12
            int rng1 = 2 + (int) (Math.random() * 12);
            int rng2 = 2 + (int) (Math.random() * 12);

            System.out.printf("Question %d \n", i + 1);
            System.out.printf("What is the product of %d and %d?", rng1, rng2);
            int userInput = input.nextInt();

            score += userInput == rng1 * rng2 ? 1 : 0;
        }
        System.out.printf("Your score is %d", score);
    }

    // 5.3 Conversion from Celsius to Fahrenheit
    static {
        System.out.println("Celsius     Fahrenheit");
        for(int celsius = 0; celsius < 102; celsius+=2)
            System.out.printf("%d           %3.1f\n", celsius, (celsius * (9 / 5.0)) + 32);
    }

    // 5.4 Conversion from inch to centimeter
    static {
        System.out.println("Inches      Centimetres");
        for(int inches = 1; inches <= 10; inches++)
            System.out.printf("%d           %.2f \n", inches, inches * 2.54);
    }

    // 5.5 Conversion from kilograms to pounds and vice versa
    static {
        System.out.println("Kilograms       Pounds   |   Pounds       Kilograms");
        int pounds = 20;
        int kilograms = 1;
        for (int i = 0; i < 100; i++) {
            System.out.printf("%d            %.1f    |   %d              %.2f \n", kilograms, kilograms * 2.2, pounds, pounds / 2.2);
            pounds += 5;
            kilograms += 2;
        }
    }

    // 5.6 Conversion from miles to kilometers
    static {
        System.out.printf("Miles         Pounds      |   Pounds       Miles\n");
        int kilometers = 20;
        for (int miles = 1; miles <= 10; miles++) {
            System.out.printf("%-3d            %-7.3f    |   %d          %.3f \n", miles, miles * 1.609, kilometers, kilometers / 1.609);
            kilometers += 5;
        }
    }

    // 5.7 Compute future tuition
    static {
        int tuition = 10_000;
        double yearlyRate = 0.06;

        int futureTuition = tuition;
        int totalCost = 0;
        for (int i = 0; i < 14; i++) {
            // Compute tuition in 10 years
            if (i < 10)
                futureTuition += tuition * yearlyRate;

            // After the 10th year, compute total cost for four years
            if (i >= 10)
                totalCost += futureTuition;
        }
        System.out.printf("The tuition will increase to $%,d to $%,d at a yearly rate of %d%%. \n", futureTuition, tuition, (int) (yearlyRate * 100));
        System.out.printf("The total cost of four years of tuition would then be $%,d.", totalCost);
    }

    // 5.8 Find the highest score
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = input.nextInt();

        if (n > 0) {
            if (n == 1) {
                System.out.printf("Since there is only one student, they have the highest score.");
                System.exit(1);
            }

            // Use a hashmap as a dictionary for better performance
            HashMap<String, Integer> students = new HashMap<>();

            for (int i = 0; i < n; i++) {
                System.out.println("Enter the name and score of each student (e.g. Alex 20): ");
                String name = input.next();
                int score = input.nextInt();

                students.put(name, score);
            }

            String bestStudent = "";
            int highestScore = 0;
            // use for-each loop to check highest score
            for(Map.Entry<String, Integer> entry : students.entrySet()) {
                if (entry.getValue() > highestScore) {
                    bestStudent = entry.getKey();
                    highestScore = entry.getValue();
                }
                    
            }

            System.out.printf("The best student is %s with a score of %d", bestStudent, highestScore);
        }
        else
            System.out.println("There should be at least one student.");
    }

    // 5.9 Find the two lowest scores
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = input.nextInt();

        if (n > 1) {
            // Use a hashmap as a dictionary for better performance
            HashMap<String, Integer> students = new HashMap<>();

            for (int i = 0; i < n; i++) {
                System.out.println("Enter the name and score of each student (e.g. Alex 20): ");
                String name = input.next();
                int score = input.nextInt();

                students.put(name, score);
            }

            int lowestScore, secondLowestScore;
            lowestScore = secondLowestScore = Integer.MAX_VALUE;

            String worstStudent, secondWorstStudent;
            worstStudent = secondWorstStudent = "";

            // use for-each loop to check highest score
            for(Map.Entry<String, Integer> entry : students.entrySet()) {
                int studentScore = entry.getValue();
                if (studentScore < lowestScore) {
                    worstStudent = entry.getKey();
                    lowestScore = entry.getValue();
                }
                else if (studentScore < secondLowestScore) {
                    secondWorstStudent = entry.getKey();
                    secondLowestScore = entry.getValue();
                }
                    
            }

            System.out.printf("The worst student is %s with a score of %d \n", worstStudent, lowestScore);
            System.out.printf("The second worst student is %s with a score of %d", secondWorstStudent, secondLowestScore);
        }
        else
            System.out.println("There should be at least two students.");
    }

    // 5.10 Find numbers divisible by 3 and 4
    static {
        // holds 10 digits divisible by 3 and 4
        int[] divisible = new int[10];
        int index = 0; // tracks position in the array
        int printIndex = 0; // counts to 10, used as a sentinel to print
        
        for (int i = 100; i <= 1000; i++) {
            // check if i / 3 && i / 4
            if (i % 3 == 0 && i % 4 == 0)  {
                // append (or overwrite over previous) divisble digits
                divisible[index] = i; 

                // increase counters
                printIndex++;
                index++;
            }

            // print 10 digits at a time
            if (printIndex == 10) {
                for (int j = 0; j < divisible.length; j++) {
                    System.out.printf("%d ", divisible[j]);
                }
                System.out.printf("\n");

                // reset counters
                printIndex = 0;
                index = 0;
            }
        }

        // Print whatever is left in the array on a new line
        for (int j = 0; j < printIndex; j++) {
            System.out.printf("%d ", divisible[j]);
        }
        
    }

    // 5.11 Find numbers divisible by 3 XOR 4
    static {
        int[] divisible = new int[10];
        int index = 0; 
        int printIndex = 0; 
        for (int i = 100; i <= 200; i++) {
            if (i % 3 == 0 ^ i % 4 == 0)  {
                divisible[index] = i; 
                printIndex++;
                index++;
            }

            // print 10 digits at a time
            if (printIndex == 10) {
                for (int j = 0; j < divisible.length; j++) {
                    System.out.printf("%d ", divisible[j]);
                }
                System.out.printf("\n");
                printIndex = 0;
                index = 0;
            }
        }

        for (int j = 0; j < printIndex; j++) {
            System.out.printf("%d ", divisible[j]);
        }
    }

    // 5.12 Find the smallest n such that n^2 > 12,000
    static {
        int lowestValue = Integer.MAX_VALUE;
        int n = 12_000;
        while (n != 0) {
            if (Math.pow(n, 2) > 12_000 && n < lowestValue)
                lowestValue = n;

            n--;
        }
        System.out.printf("The smallest n is %d", lowestValue);
    }

    // 5.13 Find the largest n such that n^3 < 12,000
    static {
        int largestValue = Integer.MIN_VALUE;
        int n = 1;

        while (n != 25) {
            if (Math.pow(n, 3) < 12_000 && n > largestValue)
                largestValue = n;

            n++;
        }
        System.out.printf("The biggest n is %d", largestValue);
    }

    // 5.14 Compute GCD 2.0
    static {
        int n1 = 2;
        int n2 = 4;
        int gcd = Math.min(n1, n2); // Find the minimum of n1 and n2

        while (gcd > 0) {
            if (n1 % gcd == 0 && n2 % gcd == 0)
                break;
            gcd--;
        }

        System.out.printf("The greatest common divisor of %d and %d is %d", n1, n2, gcd);
    }

    // 5.15 Display the ASCII table from ! to ~
    static {    
        int start = 33; // decimal representation of !
        int end = 126; // decimal representation of ~
        int length = end - start;

        char[] ascii = new char[length + 1];

        // Convert decimals to ascii characters
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = (char) start;
            start++;
        }

        for (int i = 0; i < ascii.length; i++) {
            System.out.printf("%s ", Character.toString(ascii[i]));

            if ((i + 1) % 10 == 0) 
                System.out.printf("\n");
            
        }
    }

    // 5.16 Find the PRIME factors of an integer
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int integer = input.nextInt();
        int factor = 2;

        do { 
            if ((integer / (double) factor) % 2 == 0) {
                integer /= factor;
                System.out.printf("%d / %d = %d\n", integer * factor, factor, integer);
                if (factor > integer)
                    break;
                
                factor = 2;
            } else {
                factor++;
            }
        } while (factor <= integer || integer != 1);
    }

    // 5.17 Display pyramid
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");
        int lines;
        // Ensure lines are from 1 to 15
        while(true) {
            lines = input.nextInt();
            if (lines > 0 && lines <= 15)
                break;
            else
                System.out.println("Lines can be from 1 to 15 only.");
        }

        
        for (int rows = 0; rows < lines; rows++) {
            // Format the row
            String row = "";
            row = formatRow(lines, rows, row);
            System.out.println(row);
        }
    }

    private static String formatRow(int lines, int rows, String row) {
        // left padding
        for (int i = 0; i < lines - rows; i++) {
            row += "  ";
        }
        
        // build pyramid
        if (rows == 0)
            row += rows + 1;
        else {
            for (int i = rows; i > 0; i--) {
                row += i + 1 + " ";
            }
            for (int i = 0; i <= rows; i++) {
                row += i + 1 + " ";
            }
        }
        return row;
    }

    // 5.18 Display four patterns
    static {
        final int PYRAMID_SIZE = 6;
        
        // print first pyramid
        for (int i = 0; i < PYRAMID_SIZE; i++)
            System.out.println(buildFirstPyramid(i));
        System.out.println();

        // print second pyramid
        for (int i = PYRAMID_SIZE; i > 0; i--)
            System.out.println(buildSecondPyramid(i));
        System.out.println();

        // print third pyramid
        for (int i = 0; i < PYRAMID_SIZE; i++)
            System.out.println(buildThirdPyramid(i, PYRAMID_SIZE));
        System.out.println();

        // print fourth pyramid
        for (int i = PYRAMID_SIZE; i > 0; i--)
            System.out.println(buildFourthPyramid(i, PYRAMID_SIZE));
    }

    private static String buildFourthPyramid(int rows, int size) {
        String row = "";

        // add left padding
        for (int i = 0; i < size - rows; i++)
            row += "  ";

        // reuse second method
        row += buildSecondPyramid(rows);

        return row;
    }

    private static String buildThirdPyramid(int rows, int size) {
        String row = "";

        // add left padding
        for (int i = 0; i < size - rows - 1; i++)
            row += "  ";

        // reuse first method
        row += buildFirstPyramid(rows);

        return row;
    }

    private static String buildSecondPyramid(int rows) {
        String row = "";

        for (int i = 0; i < rows; i++) 
            row += i + 1 + " ";

        return row;
    }

    private static String buildFirstPyramid(int rows) {
        String row = "";

        for (int i = 0; i <= rows; i++)
            row += i + 1 + " ";

        return row;
    }

    // 5.19 Display numbers as a pyramid
    static {
        int rows = 8;
        int column = 1;

        String pyramid = "";
        String row = "";
        
        for (int i = 0; i < rows; i++) {
            // append column values in asc order
            row += column + "   ";
            // append a pyramid row by concatenating the spaces, asc and desc row, and a newline
            pyramid += spacing(rows, i) + row + reverse(row) + "\n";
            // update column value and substring index value
            column += column;
        }
        System.out.print(pyramid);
        
    }
    private static String spacing(int rows, int index) {
        String spaces = "";
        for (int i = 0; i < rows - index; i++) {
            spaces += "    ";
        }
        return spaces;
    }

    private static String reverse(String row) {
        String reversed = "";
        int length = row.length() - 1;
        String[] arr = row.split("   ");

        if (length> 1) {
            // skip the last element of the array
            for(int i = arr.length - 1; i > 0; i--) {
                reversed += arr[i - 1] + "   ";
            }
        }

        return reversed;
    }

    // 5.20 Find divisible numbers by 3 XOR 4
    static {
        int index = 0;
        for (int i = 100; i <= 200; i++) {
            if(i % 3 == 0 ^ i % 4 == 0) {
                System.out.printf("%d ", i);
                index++;
            }
            
            if(index % 10 == 0) {
                System.out.println();
                index = 0;
            }
                
        }
    }

    // 5.21 Compare loans
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter loan amount: ");
        double loan = input.nextDouble();

        System.out.println("Enter loan period in years: ");
        int years = input.nextInt();

        double annualInterestRate = 0.05;
        
        System.out.println("Interest Rate\t\tMonthly Payment\t\tTotal Payment");
       do {
            // Calculate monthly interest rate 
            double monthlyInterestRate = annualInterestRate / 12;
            
            // Utilize the monthly payment formula from Listing 2.9
            double monthlyPayment = loan * monthlyInterestRate 
            / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
            
            
            // Calculate total payment
            double totalPayment = monthlyPayment * years * 12;

            // Display
            System.out.printf("%.3f%%\t\t\t%.2f\t\t\t%.2f\n", annualInterestRate * 100, monthlyPayment, totalPayment);

            // Increase annual rate by 0.125
            annualInterestRate += 0.125 / 100;

            if (annualInterestRate > 0.08001)
                break;
                
       } while (true);
    }

    // 5.22 Loan amortization schedule
    static {
        // Get loan, years, interest rate
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the loan amount: ");
        double loan = input.nextDouble();

        System.out.println("Enter the number of years to pay out the loan: ");
        int years = input.nextInt();

        System.out.println("Enter the yearly interest rate: ");
        double yearlyInterestRate = input.nextDouble() / 100.0;

        // Compute monthly interest rate
        double monthlyInterestRate = yearlyInterestRate / 12;
        
        // Compute monthly payment and apply the monthly interest rate
        double monthlyPayment = 
            loan * monthlyInterestRate 
            / 
            (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
            
        // Compute the amortizated total
        double total = (monthlyPayment * 12) * years;
        
        // Display monthly and total payment prediction, and labels for the schedule
        System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
        System.out.printf("Total Payment: %.2f\n", total);
        System.out.printf("Payment#\tInterest\tPrincipal\tBalance\n");

        // Initial monthly interest, principal and balance values
        double monthlyInterest = loan * monthlyInterestRate;
        double principal = monthlyPayment - monthlyInterest;
        double balance = loan - principal;
        // Compute the amortization schedule over the payments
        int paymentId = 1;
        do { 
            System.out.printf(
                "%d\t\t%.2f\t\t%.2f\t\t%.2f\n", 
                paymentId, 
                monthlyInterest, 
                principal, 
                balance
            );

            // monthly interest gets smaller with each payment
            monthlyInterest = balance * monthlyInterestRate;

            // principal increases as interest decreases on each payment
            principal = monthlyPayment - monthlyInterest;

            // pay off the monthly payment and interest
            balance -= principal;

            // update payment Id
            paymentId++;

        } while (paymentId <= (12 * years));
        
    }

    // 5.23 Demonstrated cancellation errors
    static {
        int n = 50_000;

        // compute from left to right
        double leftSum = 1.0;
        for (int i = 2; i <= n; i++)
            leftSum += (1 / (double) i);

        // compute from right to left
        double rightSum = 1 / (double) n;
        for (int i = n; i > 1; i--)
            rightSum += (1 / (double) i);

        String equal = (leftSum == rightSum) ? "Yes" : "No";
        System.out.printf("Are %.9f and %.9f equal ? %s", leftSum, rightSum, equal);
    }

    // 5.24 Sum a series (from left to right)
    static {
        int b = 99;
        int a = 97;
        double sum = a / (double) b;
        do { 
            b = a;
            a -= 2;
            sum += a / (double) b;
        } while (a > 0);
        
        System.out.print("Sum: " + sum);
    }

    // 5.25 Approximate PI for i = 10,000, 20,000, ..., 10,000
    static {
        int n = 10;
        int k = 10_000;
        for (int j = 0; j < 10; j++) {
            double sum = 0.0;
            for (int i = k; i > 0; i--) {
                if (i % 2 == 0)
                    sum -= 1 / (double) (2 * i - 1);
                else
                    sum += 1 / (double) (2 * i - 1);
                
            }
            System.out.printf("The value for PI at i = %d is %.10f\n", k, 4 * sum);
            k += 10_000;
        }
    }

    // 5.26 Compute e for i = 1, 2, 3, ..., 20
    static {
        for (int i = 1; i <= 20; i++) {
            double e = 1.0;
            // compute e from right to left for each i
            for (int j = i; j > 0; j--) {
                int factorial = j;
                // recursively compute the factorial for each i
                for (int k = j - 1; k > 0; k--) {
                    factorial = recursiveFactorial(factorial, k);
                }
                e += 1 / (double) factorial;
            }
            System.out.printf("e for i = %d is %.16f\n", i, e);
        }
    }
    
    private static Integer recursiveFactorial(int x, int y) {
        if (y == 0)
            return x;
        else
            return x * y;
    }

    // 5.27 Display leap years
    static {
        int leapYearCounter = 0;
        // for each year, get the total days
        for (int year = 2014; year <= 2114; year++) {
            if ((year % 4 == 0 && year % 100 != 0) 
                || year % 200 == 0) {

                System.out.printf("%d ", year);
                leapYearCounter++;
    
                if (leapYearCounter % 10 == 0)
                    System.out.printf("\n");
            }
        }
        System.out.printf("\nThe total count of leap years from 2014 to 2114 is %d", leapYearCounter);
    }

    // 5.28 Display the first days of each month
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = input.nextInt();

        for (int month = 1; month <= 12; month++) {
            YearMonth ym = YearMonth.of(year, month);
            String dayOfWeek = ym.atDay(1).getDayOfWeek()
                            .toString().toLowerCase();

            // make the first letter capital
            char first = Character.toUpperCase(dayOfWeek.charAt(0));
            dayOfWeek = dayOfWeek.replace(dayOfWeek.charAt(0), first);
                            
            System.out.printf("%s 1, %d is %s\n", 
            convertToMonth(month), year, dayOfWeek);
        }
    }

    private static String convertToMonth(int month) {
        switch (month) {
            case 1 -> { return "January"; }
            case 2 -> { return "February"; }
            case 3 -> { return "March"; }
            case 4 -> { return "April"; }
            case 5 -> { return "May"; }
            case 6 -> { return "June"; }
            case 7 -> { return "July0"; }
            case 8 -> { return "August"; }
            case 9 -> { return "September"; }
            case 10 -> { return "October"; }
            case 11 -> { return "November"; }
            case 12 -> { return "December"; }
        }

        return null;
    }

    // 5.29 Display calendars
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = input.nextInt();

        for (int month = 1; month <= 12; month++) {
            YearMonth ym = YearMonth.of(year, month);
                
            // Display Month and Year
            System.out.printf("\t\t%s %d\t\t\n", convertToMonth(month), year);

            // Display Days of Week
            System.out.printf("___________________________________________________\n");
            System.out.printf("Sun\tMon\tTue\tWed\tThu\tFri\tSat\n");
            
            // Build month with separate lists for each weekday / weekend
            Map<Integer, List<String>> monthDict = new HashMap<>();
            List<String> sundays = new ArrayList<>();
            List<String> mondays = new ArrayList<>();
            List<String> tuesdays = new ArrayList<>();
            List<String> wednesdays = new ArrayList<>();
            List<String> thursdays = new ArrayList<>();
            List<String> fridays = new ArrayList<>();
            List<String> saturdays = new ArrayList<>();

            String dayOfWeek = "";
            String lastDayOfWeek = "";
            // Iterate over 35 days because there are 5 weeks * 7 days in a Calendar
            for (int day = 1; day <= 35; day++) {
                // Check if the day is within the month
                if (day <= ym.lengthOfMonth()) {
                    // find what day of the week it is
                    dayOfWeek = ym.atDay(day).getDayOfWeek().toString().toLowerCase();    
                } else {
                    // set the last day of the week as the last value for dayOfWeek
                    lastDayOfWeek = dayOfWeek;
                }
                    
                // check if dayOfWeek is a specific day, append it to the corresponding list
                if (dayOfWeek.equals("sunday") && day <= ym.lengthOfMonth()) {
                    sundays.add(day + "\t");
                    continue;
                } else if (!dayOfWeek.equals("sunday") && day == 1) {
                    // if the last day of the week was on saturday, there won't be a need to print an empty week after
                    sundays.add("\t");
                }
                    

                if (dayOfWeek.equals("monday") && day <= ym.lengthOfMonth()) {
                    mondays.add(day + "\t");
                    continue;
                } else if ((!dayOfWeek.equals("monday") && day == 1) || (day > ym.lengthOfMonth() && lastDayOfWeek.equals("sunday"))) {
                    // if the last day of the week was on sunday, we will need to print an entire empty week
                    // with each following day, we will need to check even more possible values for lastDayOfWeek
                    mondays.add("\t");
                }
                    
                
                if (dayOfWeek.equals("tuesday") && day <= ym.lengthOfMonth()) {
                    tuesdays.add(day + "\t");
                    continue;
                } else if (!dayOfWeek.equals("tuesday") && day == 1 || (day > ym.lengthOfMonth() && lastDayOfWeek.equals("sunday") || lastDayOfWeek.equals("monday"))) {
                    tuesdays.add("\t");
                }
                    
                
                if (dayOfWeek.equals("wednesday") && day <= ym.lengthOfMonth()) {
                    wednesdays.add(day + "\t");
                    continue;
                } else if (!dayOfWeek.equals("wednesday") && day == 1 || (day > ym.lengthOfMonth() && lastDayOfWeek.equals("sunday") || lastDayOfWeek.equals("monday") || lastDayOfWeek.equals("tuesday"))) {
                    wednesdays.add("\t");
                }
                    
                
                if (dayOfWeek.equals("thursday") && day <= ym.lengthOfMonth()) {
                    thursdays.add(day + "\t");
                    continue;
                } else if (!dayOfWeek.equals("thursday") && day == 1 || (day > ym.lengthOfMonth() && lastDayOfWeek.equals("sunday") || lastDayOfWeek.equals("monday") || lastDayOfWeek.equals("tuesday") || lastDayOfWeek.equals("wednesday"))) {
                    thursdays.add("\t");
                }
                    
                    
                if (dayOfWeek.equals("friday") && day <= ym.lengthOfMonth()) {
                    fridays.add(day + "\t");
                    continue;
                } else if (!dayOfWeek.equals("friday") && day == 1 || (day > ym.lengthOfMonth() && lastDayOfWeek.equals("sunday") || lastDayOfWeek.equals("monday") || lastDayOfWeek.equals("tuesday") || lastDayOfWeek.equals("wednesday") || lastDayOfWeek.equals("thursday"))) {
                    fridays.add("\t");
                }
                    
                
                if (dayOfWeek.equals("saturday") && day <= ym.lengthOfMonth()) {
                    saturdays.add(day + "\t");
                } else if (!dayOfWeek.equals("saturday")&& day == 1 || (day > ym.lengthOfMonth() && lastDayOfWeek.equals("sunday") || lastDayOfWeek.equals("monday") || lastDayOfWeek.equals("tuesday") || lastDayOfWeek.equals("wednesday") || lastDayOfWeek.equals("thursday") || lastDayOfWeek.equals("friday"))) {
                    saturdays.add("\t");
                }
            }

            // this order is crucial for the logic of the calendar
            monthDict.put(0, sundays);
            monthDict.put(1, mondays);
            monthDict.put(2, tuesdays);
            monthDict.put(3, wednesdays);
            monthDict.put(4, thursdays);
            monthDict.put(5, fridays);
            monthDict.put(6, saturdays);

            // print the days for each week
            for (int week = 0; week < 5; week++) {
                for (Map.Entry<Integer, List<String>> entries : monthDict.entrySet())
                    System.out.printf("%s ", entries.getValue().get((week)).replaceAll("[\\[\\],]", ""));
                System.out.println("\n");
            }
        }
    }

    private static String convertToMonth(int month) {
        switch (month) {
            case 1 -> { return "January"; }
            case 2 -> { return "February"; }
            case 3 -> { return "March"; }
            case 4 -> { return "April"; }
            case 5 -> { return "May"; }
            case 6 -> { return "June"; }
            case 7 -> { return "July"; }
            case 8 -> { return "August"; }
            case 9 -> { return "September"; }
            case 10 -> { return "October"; }
            case 11 -> { return "November"; }
            case 12 -> { return "December"; }
        }
        return null;
    }

    // 5.30 Compound value
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount (e.g. 100.56): ");
        double amount = input.nextDouble();

        System.out.println("Enter the annual interest rate (e.g. 5.25): ");
        double annualInterestRate = input.nextDouble() / 100.0;

        System.out.println("Enter the amount of months: ");
        int months = input.nextInt();

        double monthlyInterestRate = annualInterestRate / 12.0;
        double savings = amount * (1 + monthlyInterestRate);

        for(int i = 1; i < months; i++) {
            savings = (amount + savings) * (1 + monthlyInterestRate);
        }

        System.out.printf("After the %dth month, the account value is %.16f", months, savings);
    }

    // 5.31 Compute CD value
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount (e.g. 10000.54): ");
        double cd = input.nextDouble();

        System.out.println("Enter the annual percentage yield (e.g. 5.75): ");
        double yield = input.nextDouble() / 100;

        System.out.println("Enter the number of months (e.g. 18): ");
        int months = input.nextInt();

        double monthlyYield = yield / 12;
        System.out.printf("Month\t\tCD Value\n");
        for (int i = 1; i <= months; i++) {
            cd += cd * monthlyYield;
            System.out.printf("%d\t\t%.2f\n", i, cd);
        }
    }

    // 5.32 Lottery revisited
    static {
        // Generate first digit
        int firstDigit = (int) (Math.random() * 10);
        String generated = Integer.toString(firstDigit);

        while(true) {
            int secondDigit = (int) (Math.random() * 10);
            if (firstDigit != secondDigit) {
                generated += Integer.toString(secondDigit);
                break;
            }
        }

        // Prompt user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a two-digit number (01, 09, 25, 89): ");
        String userInput = input.nextLine();


        System.out.println("The generated number is " + generated);

        if (generated.equals(userInput))
            System.out.println("Wow, you are a lucky person! You just won $10,000!");
        else if (allDigitsMatch(generated, userInput))
            System.out.println("Wow, you almost guessed it! Here are $3,000 for your effort!");
        else if (someDigitsMatch(generated, userInput))
             System.out.println("Wow, you guessed one of the digits! Here are $1,000 for your effort!");
        else
             System.out.println("Better luck next time!");
    }

    private static boolean allDigitsMatch(String generated, String userInput) {
        return (generated.charAt(0) == userInput.charAt(1) 
        && generated.charAt(1) == userInput.charAt(0));
    }

    private static boolean someDigitsMatch(String generated, String userInput) {
        return (generated.charAt(0) == userInput.charAt(1) 
        || generated.charAt(1) == userInput.charAt(0));
    }

    // 5.33 Perfect number
    static {
        for (int i = 1; i < 10_000; i++) {
            // find all divisors, sum them and check the sum
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0)
                    sum += j;
            }
            if (sum == i)
                System.out.printf("%d is a perfect number!\n", i);
        }
    }

    // 5.34 Rock, paper, scissor revisited
    static {
        Scanner input = new Scanner(System.in);
        int computerWins = 0;
        int userWins = 0;
        System.out.println("Playing until best of three");
        while (true) {
            // Generate move
            int computerMove = 0;
            while (true) {
                computerMove = (int) (Math.random() * 10);
                if (computerMove < 3)
                    break;
            }
            // Get user move
            System.out.println("rock (0), paper (1), scissor (2): ");
            int userInput = input.nextInt();
            if (userInput > 2 || userInput < 0)
                System.out.println("Invalid input!");

            // Display Status
            gameStatus(userInput, computerMove);

            // Update score
            switch (gameEngine(userInput, computerMove)) {
                case 0 -> {
                    // Purely cosmetic
                    if (userWins > computerWins)
                        System.out.printf("Current score - User: %d, Computer: %d\n", userWins, computerWins);
                    else if (computerWins > userWins)
                        System.out.printf("Current score - Computer: %d, User: %d\n", computerWins, userWins);
                    else
                        System.out.printf("Current score - Computer: %d, User: %d\n", computerWins, userWins);
                }
                case 1 -> {
                    userWins++;
                    System.out.printf("Current score - User: %d, Computer: %d\n", userWins, computerWins);
                }
                case 2 -> {
                    computerWins++;
                    System.out.printf("Current score - Computer: %d, User: %d\n", computerWins, userWins);
                }
            }
            
            // Sentinels
            if ((computerWins / 3.0) - (userWins / 3.0) == 1) {
                System.out.printf("The computer wins! Computer: %d, User: %d\n", computerWins, userWins);
                break;
            } else if ((userWins / 3.0) - (computerWins / 3.0) == 1) {
                System.out.printf("The user wins! User: %d, Computer: %d\n", userWins, computerWins);
                break;
            }
        }
        
    }
    private static Integer gameEngine(int userInput, int computerMove) {
        switch (userInput) {
            case 0 -> {
                switch (computerMove) {
                    case 0 -> { return 0; } // its a draw
                    case 1 -> { return 2; } // computer wins
                    case 2 -> { return 1; } // user wins
                }
            }
            case 1 -> {
                switch (computerMove) {
                    case 0 -> { return 1; }
                    case 1 -> { return 0; }
                    case 2 -> { return 2; }
                }
            }
            case 2 -> {
                switch (computerMove) {
                    case 0 -> { return 2; }
                    case 1 -> { return 1; }
                    case 2 -> { return 0; }
                }
            }
        }

        return -1;
    }

    private static void gameStatus(int userInput, int computerMove) {
        switch (userInput) {
            // rock
            case 0 -> {
                switch (computerMove) {
                    // rock
                    case 0 -> System.out.println("The computer chose rock. You chose rock too. It is a draw.");
                    // paper
                    case 1 -> System.out.println("The computer chose paper. You chose rock. The computer wins.");
                    // scissors
                    case 2 -> System.out.println("The computer chose scissors. You chose rock. You win.");
                }
            }
            // paper
            case 1 -> {
                switch (computerMove) {
                    // rock
                    case 0 -> System.out.println("The computer chose rock. You chose paper. You win.");
                    // paper
                    case 1 -> System.out.println("The computer chose paper. You chose paper too. It is a draw.");
                    // scissors
                    case 2 -> System.out.println("The computer chose scissors. You chose paper. The computer wins.");
                }
            }
             // scissors
            case 2 -> {
                switch (computerMove) {
                    // rock
                    case 0 -> System.out.println("The computer chose rock. You chose scissors. The computer wins.");
                    // paper
                    case 1 -> System.out.println("The computer chose paper. You chose scissors. You win.");
                    // scissors
                    case 2 -> System.out.println("The computer chose scissors. You chose scissors too. It is a draw.");
                }
            }
        }
    }
    

    
    public static void main(String[] args) {
        
    }
}
