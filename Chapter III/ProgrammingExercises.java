import java.util.Scanner;

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

    public static void main(String[] args) {

    }
}
