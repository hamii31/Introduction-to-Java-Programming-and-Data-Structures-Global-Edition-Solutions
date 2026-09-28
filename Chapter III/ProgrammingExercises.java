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

    public static void main(String[] args) {

    }
}
