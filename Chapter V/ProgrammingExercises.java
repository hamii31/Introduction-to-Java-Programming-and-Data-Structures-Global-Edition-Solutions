
import java.util.Scanner;

public class ProgrammingExercises {
    // 5.1 Pass or fail
    static {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your score: ");
            int score = input.nextInt();

            if (score == -1) {
                System.out.println("No numbers are entered except 0.");
                break;
            }
            
            if (score >= 60)
                System.out.println("You pass the exam.");
            else 
                System.out.println("You don't pass the exam.");
        }
    }

    // 5.2 Repeat multiplications
    static {
        Scanner input = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < 10; i++) {
            // Generate two numbers between 1 and 12
            int rng1 = 2 + (int) (Math.random() * 12);
            int rng2 = 2 + (int) (Math.random() * 12);

            System.out.printf("Question %d \n", i + 1);
            System.out.printf("What is the product of %d and %d?", rng1, rng2);
            int userInput = input.nextInt();

            score += userInput == rng1 * rng2 ? 1 : 0;
        }
        System.out.printf("Your score is %d", score);
    }

    // 5.3 Conversion from Celsius to Fahrenheit
    static {
        System.out.println("Celsius     Fahrenheit");
        for(int celsius = 0; celsius < 102; celsius+=2)
            System.out.printf("%d           %3.1f\n", celsius, (celsius * (9 / 5.0)) + 32);
    }

    // 5.4 Conversion from inch to centimeter
    static {
        System.out.println("Inches      Centimetres");
        for(int inches = 1; inches <= 10; inches++)
            System.out.printf("%d           %.2f \n", inches, inches * 2.54);
    }

    // 5.5 Conversion from kilograms to pounds and vice versa
    static {
        System.out.println("Kilograms       Pounds   |   Pounds       Kilograms");
        int pounds = 20;
        int kilograms = 1;
        for (int i = 0; i < 100; i++) {
            System.out.printf("%d            %.1f    |   %d              %.2f \n", kilograms, kilograms * 2.2, pounds, pounds / 2.2);
            pounds += 5;
            kilograms += 2;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
