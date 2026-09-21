import java.util.*;

public class CountingMonetaryUnits {
    public static void main (String[] args) {
        // Get user input
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an amount (e.g. 11.56)");
        double amount = scan.nextDouble();

        // Convert amount into cents
        double temp = amount * 100;
        int cents = (int)temp;
        System.out.println("Cents: " + cents);

        // Convert cents to dollars
        int dollars = cents / 100;
        System.out.println("Dollars: $" + dollars);

        // OBtain the quarters count
        int remainingCents = cents % 100;
        int quarters = remainingCents / 25;
        System.out.println("Quarters: " + quarters);

        // Obtain the dimes
        remainingCents = cents % 25;
        int dimes = remainingCents / 10;
        System.out.println("Dimes: " + dimes);

        // Obtain the nickels
        remainingCents = cents % 10;
        int nickels = remainingCents / 5;
        System.out.println("Nickels: " + nickels);

        // Obtain pennies
        int pennies = remainingCents;
        System.out.println("Pennies: " + pennies);
    }
}
