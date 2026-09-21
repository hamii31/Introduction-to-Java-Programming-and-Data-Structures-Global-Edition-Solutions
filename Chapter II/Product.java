
import java.util.*;

public class Product {
    public static void main (String[] args) {
        // Get user input
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter annual interest rate (e.g., 4.5):");
        double annualInterestRate = scan.nextDouble();

        System.out.println("Enter number of years:");
        int numberOfYears = scan.nextInt();

        System.out.println("Enter loan ammount:");
        int loanAmount = scan.nextInt();

        // Find monthlyInterestRate
        double monthlyInterestRate = annualInterestRate / 12;

        // Compute monthlyPayment
        double monthlyPayment = loanAmount * monthlyInterestRate 
        / (1 - 1 / Math.pow((1 + monthlyInterestRate), (numberOfYears * 12)));
        double totalPayment = monthlyPayment * numberOfYears * 12;

        // Display
        System.out.println("Monthly Payment: " + (int)(monthlyPayment * 100) / 100.0);
        System.out.println("Total Payment: " + (int)(totalPayment * 100) / 100.0);
    }
}
