import java.util.Scanner;

public class Lottery { 
    public static void main (String[] args) {
        // Generate two-digit number
        String generated = "0";
        while(true) {
            int number = (int) (Math.random() * 100);
            if (number < 100) {
                if (number < 10)
                    generated += Integer.toString(number);
                else
                    generated = Integer.toString(number);
                break;
            }
        }

        if (generated.equals("0")) {
            System.out.println("There was an errror.");
            return;
        }

        // Prompt user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a two-digit number (00, 09, 25, 89): ");
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
}
