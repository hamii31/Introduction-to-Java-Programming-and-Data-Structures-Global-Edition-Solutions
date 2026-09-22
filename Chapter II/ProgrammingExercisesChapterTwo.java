import java.util.*;
public class ProgrammingExercisesChapterTwo {

    // 2.1 Convert mile to kilometer
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter miles: ");
        double miles = input.nextDouble();
        double kilometers = miles * 1.6;
        System.out.println(miles + " miles in " + kilometers + " kilometers");
    }
    // 2.2 Compute the area and volume of an equilateral triangle
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length of the sides and height of the equilateral triangle: ");
        double lengthOfSides = input.nextDouble();

        double area = (Math.sqrt(3) / 4) * Math.pow(lengthOfSides, 2);
        double volume = area * lengthOfSides;

        System.out.println("The area is " + area);
        System.out.println("The volume of the Triangular prism is " + volume);
    }
    // 2.3 Convert meters into feet
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a value for meter: ");
        double meters = input.nextDouble();
        double feet = meters * 3.2786;
        System.out.println(meters + " meters is " + feet + " feet");
    }
    // 2.4 Convert square meter into ping
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number in square meters: ");
        double squareMeters = input.nextDouble();
        double pings = squareMeters * 0.3025;
        System.out.println(squareMeters + " square meters is " + pings + " pings");
    }
    // 2.5 Calculate tips
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the subtotal and a gratuity rate: ");
        double subtotal = input.nextDouble();
        double gratuityRate = input.nextDouble();

        double gratuity = gratuityRate / subtotal;
        double total = subtotal + gratuity;
        
        System.out.println("The gratuity is $" + gratuity + " and total is $" + total);
    }
    // 2.6 Multiply by int
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer between 0 and 1000: ");
        int n = input.nextInt();

        if(n < 9) {
            System.out.println(n);
        } else {
            String s = Integer.toString(n);
            int l = s.length();

            int temp = n;
            int multiplied = 1;
            for(int i = 0; i < l; i++) { 
                multiplied *= temp % 10;
                temp = temp / 10;
            }

            System.out.println("The multiplication of all digits in " + n + " is " + multiplied);
        }
    }
    // 2.7 Find the number of years
    static {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter minutes (e.g. 1000000000)");
        long minutes = input.nextLong();
        double hours = minutes / 60.0;
        double days = hours / 24;
        double years = days / 365;
        double remainingDays = days % 365;
        
        System.out.println(minutes + " minutes is approximately " + (int)years + " years and " + (int)remainingDays + " days");
    }
    // 2.8 Current Time
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the time zone offset to GMT: ");
        int offset = input.nextInt();

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minutes = c.get(Calendar.MINUTE);
        int seconds = c.get(Calendar.SECOND);

        System.out.println("The current time is " + Math.abs(hour + offset) +":"+ minutes +":"+ seconds);
    }
    // 2.9 Physics: Motion
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter u(m/s), t(s), and a(m/s^2): ");
        double u = input.nextDouble();
        double t = input.nextDouble();
        double a = input.nextDouble();

        // Calculate distance covered using Newton's equation
        double s = u * t + 1/2 * a * Math.pow(t, 2);

        System.out.println("The distance covered is " + s);
    }
    // 2.10 Science: calculating energy
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount of water in kilogram: ");
        double M = input.nextDouble();
        
        System.out.println("Enter the initial temperature in Celsius: ");
        double initialTemperature = input.nextDouble();

        System.out.println("Enter the final temperature in Celsius: ");
        double finalTemperature = input.nextDouble();

        // Compute the formula for energy
        double Q = M * (finalTemperature - initialTemperature) * 4184;

        System.out.println("The energy needed is " + Q);
    }
    // 2.11 Population Projection
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of years: ");
        int years = input.nextInt();

        long nonLeapSeconds = 31536000;
        long leapSeconds = 31622400; // every 4 years

        long currentPopulation = 312032486;

        for (int j = 0; j < years; j++)
        {
            long n = nonLeapSeconds;

            // Leap year roughly every 4 years
            if (j % 4 == 0)
            {
                n = leapSeconds;
            }

            for(int i = 0; i < n; i++)
            {
                // one birth every 7 seconds
                if (i % 7 == 0)
                {
                    currentPopulation++;
                }

                // one death every 13 seconds
                if (i % 13 == 0)
                {
                    currentPopulation--;
                }

                // one new migrant every 45 seconds
                if (i % 45 == 0)
                {
                    currentPopulation++;
                }
            }

        }
        System.out.println("The population in 5 years is " + currentPopulation);
    }
    // 2.12 Physics: finding runway length
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter speed v (m/s) and acceleration a (m/s^2): ");
        double v = input.nextDouble();
        double a = input.nextDouble();

        // Compute the formula to find the length
        double length = Math.pow(v, 2) / (2 * a);

        System.out.println("The minimum runway length for this airplane is " + length);
    }
    // 2.13 Financial application: Compound value
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the monthly saving amount");
        double monthlySavingAmount = input.nextDouble();

        double annualInterestRate = 0.0375;
        double monthlyInterestRate = annualInterestRate / 12;

        int months = 6;

        double accountValue = monthlySavingAmount * (1 + monthlyInterestRate);
        for(int i = 0; i < months - 1; i++) {
            accountValue = (accountValue + monthlySavingAmount) * (1 + monthlyInterestRate);
        }

        System.out.println("After the sixth month, the account value is " + accountValue);
    }
    // 2.14 Health application: BMI computing
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter weight in pounds: ");
        double weightInPounds = input.nextDouble();

        System.out.println("Enter height in inches: ");
        double heightInInches = input.nextDouble();

        double weightInKilograms = weightInPounds * 0.45359237;
        double heightInMeters = heightInInches * 0.0254;

        double BMI = weightInKilograms / Math.pow(heightInMeters, 2);

        System.out.println("BMI is " + BMI);
    }
    // 2.15 Geometry: Distance of two points
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter x1 and y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.println("Enter x2 and y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        double distance = Math.sqrt(Math.pow((x2 - x1), 2) 
        + Math.pow((y2 - y1), 2));

        System.out.println("The distance between the two points is " + distance);
    }
    // 2.16 Geometry: Area of hexagon
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of the side of a hexagon: ");
        double s = input.nextDouble();

        double area = (3 * Math.sqrt(3)) / 2 * Math.pow(s, 2);

        System.out.println("The area of the hexagon is " + area);
    }
    // 2.17 Science: wind-chill temperature
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the temperature is Fahrenheit between -58°F and 41°F: ");
        double t_a = input.nextDouble();

        System.out.println("Enter the wind speed (> = 2) in mph: ");
        double v = input.nextDouble();

        double t_wc = 35.74 + (0.6215 * t_a) - (35.75 * Math.pow(v, 0.16)) + (0.4275 * t_a * Math.pow(v, 0.16));

        System.out.println("The wind chill index is " + t_wc);
    }
    // 2.18 Print a table
    static {
        // Initialize both tables a and b as Multi-Dimensional Collections
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(0, 0)));
        a.add(new ArrayList<>(Arrays.asList(1, 4)));
        a.add(new ArrayList<>(Arrays.asList(2, 7)));
        a.add(new ArrayList<>(Arrays.asList(3, 9)));
        a.add(new ArrayList<>(Arrays.asList(4, 11)));

        int size = a.size();

        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        b.add(new ArrayList<>(Arrays.asList(2, 1)));
        b.add(new ArrayList<>(Arrays.asList(4, 2)));
        b.add(new ArrayList<>(Arrays.asList(6, 3)));
        b.add(new ArrayList<>(Arrays.asList(10, 5)));
        b.add(new ArrayList<>(Arrays.asList(12, 7)));

        // Create the Middle Point Collection
        ArrayList<ArrayList<Double>> middlePoints = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            // Get individual rows from both collections
            ArrayList<Integer> row_a = a.get(i);
            ArrayList<Integer> row_b = b.get(i);

            // Derive the first and second value from both rows
            int x1 = row_a.get(0);
            int y1 = row_a.get(1);

            int x2 = row_b.get(0);
            int y2 = row_b.get(1);
            
            // Get the middle points 
            double middleX = (x1 + x2) / 2.0;
            double middleY = (y1 + y2) / 2.0;

            middlePoints.add(new ArrayList<>(Arrays.asList(middleX, middleY)));
        }

        // Display all three tables
        System.out.println("   a        b       Middle Point");
        for (int i = 0; i < size; i++) {
            System.out.println(a.get(i) + "   " + b.get(i) + "          " + middlePoints.get(i));
        }
    }
    // 2.19 Geometry: area of a triangle
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the coordinates of three points separated by spaceslike x1 y1 x2 y2 x3 y3: ");
        String inputString = input.nextLine();
        
        // Format input
        String[] arr = inputString.split(" ");
        int length = arr.length;

    // Initialize array for values of dataType double using arr's length
        double[] points = new double[length];
    // Append the parsed values to the new array
        for (int i = 0; i < length; i++) {
            points[i] = Double.parseDouble(arr[i]);
        }
    // Derive the points from the array
        double x1 = points[0];
        double y1 = points[1];

        double x2 = points[2];
        double y2 = points[3];

        double x3 = points[4];
        double y3 = points[5];

        // Find side1 between points 2 and 3 using the distance formula
        double side1 = Math.sqrt(Math.pow((x3-x2),2) + Math.pow((y3-y2),2));

        // Find side2 between points 1 and 3
        double side2 = Math.sqrt(Math.pow((x3-x1),2) + Math.pow((y3-y1),2));

        // Find side3 between points 1 and 2
        double side3 = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));

        // Find the area
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        System.out.println("The area of the triangle is " + area);
    }
    // 2.20 Financial application: calculate interest
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter balance and interest rate (e.g., 3 for 3%): ");
        String inputString = input.nextLine();

        // Format input
        String[] arr = inputString.split(" ");
        int length = arr.length;

        double[] values = new double[length];
        for (int i = 0; i < length; i++) { 
            values[i] = Double.parseDouble(arr[i]);
        }

        double balance = values[0];
        double annualInterestRate = values[1];

        double interest = balance * (annualInterestRate / 1200);

        System.out.println("The interest is " + interest);
    }
    // 2.21 Financial application: calculate future investment value
    static {
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        System.out.println("Enter annual interest rate in percentage: ");
        double annualInterestRate = input.nextDouble();

        System.out.println("Enter number of years: ");
        int numberOfYears = input.nextInt();

        double monthlyInterestRate = annualInterestRate / 1200;

        double futureInvestmentValue = investmentAmount * Math.pow((1 + monthlyInterestRate), (numberOfYears * 12));

        System.out.println("Future value is $" + futureInvestmentValue);
    }
    // 2.23 Cost of driving
    static {
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter the driving distance: ");
        double drivingDistance = input.nextDouble();

        System.out.println("Enter miles per gallon: ");
        double milesPerGallon = input.nextDouble();

        System.out.println("Enter price per gallon: ");
        double pricePerGallon = input.nextDouble();

        double gallons = drivingDistance / milesPerGallon;
        double cost = gallons * pricePerGallon;

        System.out.println("The cost of driving is $" + cost);
    }

    public static void main (String[] args) { 

    }
}
