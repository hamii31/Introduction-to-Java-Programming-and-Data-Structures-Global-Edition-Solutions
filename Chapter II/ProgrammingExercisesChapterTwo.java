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
    public static void main (String[] args) { 

    }
}
