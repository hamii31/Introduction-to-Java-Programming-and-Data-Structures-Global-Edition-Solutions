import java.util.Scanner;

public class DeterminingLeapYear {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ");

        int year = input.nextInt();

        // A leap year is divisible by 4 and 400, but not 100
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            System.out.println("The year " + year + " is a leap year.");
        else
            System.out.println("The year " + year + " is not a leap year.");
    }
}
