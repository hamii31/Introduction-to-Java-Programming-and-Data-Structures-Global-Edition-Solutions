import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.time.YearMonth;

public class ProgrammingExercises {
    // 4.1 area of pentagon
    static {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the length from the center of a pentagon to a vertex: \n");
        double r = input.nextDouble();

        // Compute length of a side of the pentagon
        double s = 2 * r * Math.sin(Math.PI / 5);

        // Compute area
        double area = (5 * Math.pow(s, 2))
        / (4 * Math.tan(Math.PI / 5));

        // Display area with a width of 4 and precision of 2
        System.out.printf("The area of the pentagon is %4.2f", area);
    }

    // 4.2 great circle distance
    static {    
        final double earthRadius = 6_371.01;

        Scanner input = new Scanner(System.in);

        // Get first point coordinates
        System.out.print("Enter point 1 (latitude and longtitude) in degrees: ");
        String userInput = input.nextLine();
        String[] splitInput = userInput.split(" ");

        double x_1 = Double.parseDouble(splitInput[0]);
        double y_1 = Double.parseDouble(splitInput[1]);

        // Convert degrees to radians
        double xr_1 = x_1 * (Math.PI / 180);
        double yr_1 = y_1 * (Math.PI / 180);

        // Get second point coordinates
        System.out.print("Enter point 2 (latitude and longtitude) in degrees: ");
        userInput = input.nextLine();
        splitInput = userInput.split(" ");

        double x_2 = Double.parseDouble(splitInput[0]);
        double y_2 = Double.parseDouble(splitInput[1]);

        // Convert degrees to radians
        double xr_2 = x_2 * (Math.PI / 180);
        double yr_2 = y_2 * (Math.PI / 180);

        // Compute the great circle distance between the two points
        double d = earthRadius 
        * Math.acos(Math.sin(xr_1) * Math.sin(xr_2) 
                    + Math.cos(xr_1) * Math.cos(xr_2)
                    * Math.cos(yr_1 - yr_2));

        System.out.printf("The distance between the two points is %f km", d);
    }

    // 4.3 estimate areas
    static {
        final double earthRadius = 6_371.01;

        // Atlanta, Georgia
        double x_1 = 33.749;
        double y_1 = 84.388;

        // Orlando, Florida
        double x_2 = 28.538;
        double y_2 = 81.379;

        // Savannah, Georgia
        double x_3 = 32.081;
        double y_3 = 81.091;

        // Charlotte, North Carolina
        double x_4 = 35.227;
        double y_4 = 80.843;

        // Convert degrees to radians
        double xr_1 = x_1 * (Math.PI / 180);
        double xr_2 = x_2 * (Math.PI / 180);
        double yr_1 = y_1 * (Math.PI / 180);
        double yr_2 = y_2 * (Math.PI / 180);
        double xr_3 = x_3 * (Math.PI / 180);
        double xr_4 = x_4 * (Math.PI / 180);
        double yr_3 = y_3 * (Math.PI / 180);
        double yr_4 = y_4 * (Math.PI / 180);
        
        // Compute the distance between Atlanta and Orlando
        double d_1 = computeGreatCircleDistance(earthRadius, xr_1, xr_2, yr_1, yr_2);
        
        // Compute the distance between Orlando and Savannah
        double d_2 = computeGreatCircleDistance(earthRadius, xr_2, xr_3, yr_2, yr_3);

        // Compute the distance between Savannah and Charlotte
        double d_3 = computeGreatCircleDistance(earthRadius, xr_3, xr_4, yr_3, yr_4);

        // Compute the distance between Charlotte and Atlanta
        double d_4 = computeGreatCircleDistance(earthRadius, xr_1, xr_4, yr_1, yr_4);

        // Compute the distance between Atlanta and Savannah 
        double d_5 = computeGreatCircleDistance(earthRadius, xr_1, xr_3, yr_1, yr_3);

        // Find the area of the triangle between Atlanta, Orlando and Savannah
        double s_1 = (d_1 + d_2 + d_5) / 2;
        double area_1 = Math.sqrt(s_1 * (s_1 - d_1) * (s_1 - d_2) * (s_1 - d_5));

        // Find the area of the triangle between Atlanta, Charlotte and Savannah
        double s_2 = (d_3 + d_4 + d_5) / 2;
        double area_2 = Math.sqrt(s_2 * (s_2 - d_3) * (s_2 - d_4) * (s_2 - d_5));

        System.out.printf("The area covered between the four cities is %f km2", area_1 + area_2);
    }
    private static double computeGreatCircleDistance(double earthRadius, double xr_1, double xr_2, double yr_1, double yr_2) {
        return earthRadius * Math.acos(Math.sin(xr_1) * Math.sin(xr_2) 
                    + Math.cos(xr_1) * Math.cos(xr_2)
                    * Math.cos(yr_1 - yr_2));
    }

    // 4.4 Area ofa five-pointed star
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of the circle inscribing the star: ");
        double radius = input.nextDouble();

        double area = 10 *
        (Math.tan(Math.PI / 10)
        / 
        (3 - Math.tan(Math.PI / 10) * Math.tan(Math.PI / 10))) 
        * Math.pow(radius, 2);

        System.out.printf("The area of the star is %f", area);
    }

    // 4.5 Area of a regular polygon
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        int sides = input.nextInt();

        System.out.print("Enter the length of a side: ");
        double length = input.nextDouble();

        double area = (sides * Math.pow(length, 2))
        /
        (4 * Math.tan(Math.PI / sides));

        System.out.printf("The area of the polygon is %f", area);
    }

    // 4.6 Random points on a circle
    static {
        final int radius = 40;

        // Generate a random angle alpha in radians
        double rng_alpha = Math.random() * (Math.PI * 2);
        // Find the coordinates of the point determined by the random angle alpha
        double x_1 = radius * Math.cos(rng_alpha);
        double y_1 = radius * Math.sin(rng_alpha);

        // Generate a random angle beta in radians
        double rng_beta = Math.random() * (Math.PI * 2);
        // Find the coordinates of the point determined by the angle beta
        double x_2 = radius * Math.cos(rng_beta);
        double y_2 = radius * Math.sin(rng_beta);

        // Generate a random angle gamma in radians
        double rng_gamma = Math.random() * (Math.PI * 2);
        // Find the coordinates of the point determined by the angle gamma
        double x_3 = radius * Math.cos(rng_gamma);
        double y_3 = radius * Math.sin(rng_gamma);

        // Find side1 between points 2 and 3 using the distance formula
        double a = Math.sqrt(
            Math.pow((x_3-x_2), 2) + Math.pow((y_3 - y_2), 2));

        // Find side2 between points 1 and 3
        double b = Math.sqrt(
            Math.pow((x_3 - x_1), 2) + Math.pow((y_3 - y_1), 2));

        // Find side3 between points 1 and 2
        double c = Math.sqrt(
            Math.pow((x_2 - x_1), 2) + Math.pow((y_2 - y_1), 2));


        // Find angle alpha based on the three sides
        double alpha = Math.acos(
            (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2))
            / 
            (2 * b * c)
        );

        // Find anlge beta based on the three sides
        double beta = Math.acos(
            (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2))
            /
            (2 * a * c)
        );

        // Find angle gamma based on the three sides
        double gamma = Math.acos(
            (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2))
            /
            (2 * a * b)
        );

        // Convert angles to degrees
        alpha = alpha * (180 / Math.PI);
        beta = beta * (180 / Math.PI);
        gamma = gamma * (180 / Math.PI);

        System.out.printf("A triangle has been formed with angle alpha = %f degrees, beta = %f degrees, and gamma = %f degrees", alpha, beta, gamma);
    }

    // 4.7 Corner point coordinates
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Etner the radius of the bounding circle: ");
        double radius = input.nextDouble();

        // Generate 5 points
        for (int i = 0; i < 5; i++) {
            double rng_angle = Math.random() * (Math.PI * 2);
            double x = radius * Math.cos(rng_angle);
            double y = radius * Math.sin(rng_angle);

            System.out.printf("(%4.2f, %4.2f)\n", x, y);
        }
    }

    // 4.8 Find the char of an ASCII code
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = input.nextLine().charAt(0);

        System.out.printf("The ASCII code for character %c is %d", ch, (int) ch);
    }

    // 4.9 Find the Unicode of a character
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = input.nextLine().charAt(0);

        System.out.printf("The Unicode code for character %c is %d", ch, (int) ch);
    }

    // 4.10 Guess birthday
    static {
        // Create immutable map of sets
        Map<Integer, Set<Integer>> sets = new HashMap<>() {{
            put(0, new HashSet<>(Set.of(            
                1, 3, 5, 7, 
                9, 11, 13, 15,
                17, 19, 21, 23,
                25, 27, 29, 31)));
            put(1, new HashSet<>(Set.of(            
                2, 3, 6, 7,
                10, 11, 14, 15,
                18, 19, 22, 23,
                26, 27, 30, 31)));
            put(2, new HashSet<>(Set.of(
                4, 5, 6, 7,
                12, 13, 14, 15,
                20, 21, 22, 23,
                28, 29, 30, 31)));
            put(3, new HashSet<>(Set.of(
                8, 9, 10, 11,
                12, 13, 14, 15,
                24, 25, 26, 27,
                28, 29, 30, 31)));
            put(4, new HashSet<>(Set.of(
                16, 17, 18, 19,
                20, 21, 22, 23,
                24, 25, 26, 27,
                28, 29, 30, 31)));
        }};

        // Init Scanner object
        Scanner input = new Scanner(System.in);

        // Init variable to hold the guessed day
        String bdayBinary = "";

        // Recursively go through the sets and append the user answer to form the binary
        for (int i = 0; i < sets.size(); i++) {
            bdayBinary = iterateSetsRecursive(i, sets.get(i), input) + bdayBinary; // prepend so the 0 lands on the right
        }

        String temp = String.valueOf(bdayBinary);
        int bday = Integer.parseInt(temp, 2);
        System.out.println("Your birthday is: " + bday);
    }

    private static int iterateSetsRecursive(int setCount, Set set, Scanner input) {

        System.out.println("Is your birthday in set " + ++setCount + " ?");
        // Convert to Object and sort
        Object[] arr1 = set.toArray();
        Arrays.sort(arr1);

        // Print and prompt user for input
        System.out.println(Arrays.toString(arr1));
        System.out.println("Type N for No and Y for Yes: ");
        Character answer = input.nextLine().charAt(0);

        int answerToInt = answer.equals('N') ? 0 : 1;

        // Return answer
        if (answerToInt == 1)
            return answerToInt;
        
        return answerToInt;
    }

    // 4.11 Binary to decimal
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter binary digits (0000 to 1111): ");
        String binary = input.next();

        String temp = String.valueOf(binary);
        int binaryToDecimal = Integer.parseInt(temp, 2);
        System.out.printf("The decimal value of %s is %d", binary, binaryToDecimal);
    }

    // 4.12 Hex to binary
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex digit: ");
        String hexString = input.nextLine();

        // Check if hexString contains multiple characters
        if (hexString.length() != 1) {
            System.out.println("Invalid input.");
            System.exit(1);
        }

        int value = 0;
        // Display binary value for the hex digit
        char ch = Character.toUpperCase(hexString.charAt(0));
        if ('A' <= ch && ch <= 'F') {
            value = ch - 'A' + 10;
        }
        else if (Character.isDigit(ch)) {
            value = ch - '0';
        }
        else {
            System.out.println("Invalid input.");
            System.exit(1);
        }

        String binary = Integer.toBinaryString(value);
        System.out.println("The binary value for hex digit " 
            + hexString + " is " + binary);
    }

    // 4.13 Vowel or consonant
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        Character character = input.nextLine().charAt(0);

        char ch = Character.toLowerCase(character);

        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";

        if (vowels.indexOf(ch) != -1)
            System.out.printf("%c is a vowel", character);
        else if (consonants.indexOf(ch) != -1)
            System.out.printf("%c is a consonant", character);
        else
            System.out.print("Invalid input.");
    }

    // 4.14 Letter grade to number 
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        Character ch = input.nextLine().charAt(0);

        ch = Character.toUpperCase(ch);
        switch (ch) {
            case 'A' -> {System.out.printf("The numeric value for %c is %d", ch, 4);}
            case 'B' -> {System.out.printf("The numeric value for %c is %d", ch, 3);}
            case 'C' -> {System.out.printf("The numeric value for %c is %d", ch, 2);}
            case 'D' -> {System.out.printf("The numeric value for %c is %d", ch, 1);}
            case 'F' -> {System.out.printf("The numeric value for %c is %d", ch, 0);}
            default -> {System.out.print("Invalid grade");}
        }
    }

    // 4.15 Phone key pads
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        Character ch = input.nextLine().charAt(0);

        ch = Character.toUpperCase(ch);
        switch (ch) {
            case 'A', 'B', 'C' -> {System.out.printf("The corresponding number is %d", 2);}
            case 'D', 'E', 'F' -> {System.out.printf("The corresponding number is %d", 3);}
            case 'G', 'H', 'I' -> {System.out.printf("The corresponding number is %d", 4);}
            case 'J', 'K', 'L' -> {System.out.printf("The corresponding number is %d", 5);}
            case 'M', 'N', 'O' -> {System.out.printf("The corresponding number is %d", 6);}
            case 'P', 'Q', 'R', 'S' -> {System.out.printf("The corresponding number is %d", 7);}
            case 'T', 'U', 'V' -> {System.out.printf("The corresponding number is %d", 8);}
            case 'W', 'X', 'Y', 'Z' -> {System.out.printf("The corresponding number is %d", 9);}
            default -> {System.out.print("Invalid input");}
        }
    }

    // 4.16 random lowercase letter
    static {
        // start from the ascii code for 'a' and end with the total count of ascii codes for lowercase letters
        int ascii = (int)  (97 + (Math.random() * 26));
        System.out.println((char) ascii);
    }

    // 4.17 Days of a month
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        System.out.print("Enter the first three letters of a month: ");
        String month = input.next();

        switch (month) {
            case "Jan" -> {
                YearMonth yearMonth = YearMonth.of(year, 1);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Feb" -> {
                YearMonth yearMonth = YearMonth.of(year, 2);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Mar" -> {
                YearMonth yearMonth = YearMonth.of(year, 3);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Apr" -> {
                YearMonth yearMonth = YearMonth.of(year, 4);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "May" -> {
                YearMonth yearMonth = YearMonth.of(year, 5);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Jun" -> {
                YearMonth yearMonth = YearMonth.of(year, 6);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Jul" -> {
                YearMonth yearMonth = YearMonth.of(year, 7);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Aug" -> {
                YearMonth yearMonth = YearMonth.of(year, 8);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Sep" -> {
                YearMonth yearMonth = YearMonth.of(year, 9);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Oct" -> {
                YearMonth yearMonth = YearMonth.of(year, 10);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Nov" -> {
                YearMonth yearMonth = YearMonth.of(year, 11);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            case "Dec" -> {
                YearMonth yearMonth = YearMonth.of(year, 12);
                System.out.printf("%s %d has %d days", month, year, yearMonth.lengthOfMonth());
                }
            default -> {
                System.out.print("The month is not a correct month name");
            }
        }
    }

    // 4.18 Student major and status
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two characters: ");
        String userInput = input.next();

        if (userInput.length() != 2) {
            System.out.print("Invalid input");
            System.exit(1);
        }

        String major = userInput.substring(0,1);
        switch (major) {
            case "I" -> System.out.printf("Information Management %s", getStudentStatus(userInput.substring(1)));
            case "C" -> System.out.printf("Computer Science %s", getStudentStatus(userInput.substring(1)));
            case "A" -> System.out.printf("Accounting %s", getStudentStatus(userInput.substring(1)));
            default -> System.out.print("Invalid input");
        }
    }

    private static String getStudentStatus(String status) {
        switch (status) {
            case "1" -> { return "Freshman"; }
            case "2" -> { return "Sophomore"; }
            case "3" -> { return "Junior"; }
            case "4" -> { return "Senior"; }
        }

        return "Unknown";
    }

    // 4.19 Check ISBN-10
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first 9 digits of an ISBN as integer: ");
        String userInput = input.next();
        int isbn = Integer.parseInt(userInput);

        int[] d = new int[10];
        for (int i = 0; i < d.length; i++) {
            if (9-i == 0) {
                int checkSum = calculateChecksum(d);
                String isbn_10 = Arrays.toString(d).replaceAll("\\D", "");

                isbn_10 = isbn_10.substring(0, isbn_10.length() - 1);

                isbn_10 += (checkSum != 10) ? Integer.toString(checkSum).charAt(0) : 'X';
                System.out.println("The ISBN-10 number is " + isbn_10);
                break;
            }

            d[9-i - 1] = isbn % 10;
            isbn = isbn / 10;
        }
    }
    private static int calculateChecksum(int[] d) {
        int checkSum = 0;
        for(int i = 1; i < d.length; i++) {
            checkSum += d[i] * i;
        }
        return checkSum % 11;
    }
    

    public static void main (String[] args) {

    }
}
