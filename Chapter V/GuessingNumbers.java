import java.util.Scanner;

public class GuessingNumbers {
    public static void main (String[] args) {
        // Generate random number outside of loop
        int rng = (int) (Math.random() * 101);

        // Init variable for userNumber outside of loop
        int userNumber = -1;

        // Init scanner obj outside of loop
        Scanner input = new Scanner (System.in);

        while(userNumber != rng) {
            System.out.print("Enter your guess: ");
            userNumber = input.nextInt();
            if (userNumber > rng)
                System.out.println("Your guess is too high.");
            else if (userNumber < rng)
                System.out.println("Your guess is too low.");
        }

        System.out.printf("Yes, the number is %d", userNumber);
    }
} 
