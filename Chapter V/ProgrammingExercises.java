import java.util.HashMap;
import java.util.Map;
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

    // 5.6 Conversion from miles to kilometers
    static {
        System.out.printf("Miles         Pounds      |   Pounds       Miles\n");
        int kilometers = 20;
        for (int miles = 1; miles <= 10; miles++) {
            System.out.printf("%-3d            %-7.3f    |   %d          %.3f \n", miles, miles * 1.609, kilometers, kilometers / 1.609);
            kilometers += 5;
        }
    }

    // 5.7 Compute future tuition
    static {
        int tuition = 10_000;
        double yearlyRate = 0.06;

        int futureTuition = tuition;
        int totalCost = 0;
        for (int i = 0; i < 14; i++) {
            // Compute tuition in 10 years
            if (i < 10)
                futureTuition += tuition * yearlyRate;

            // After the 10th year, compute total cost for four years
            if (i >= 10)
                totalCost += futureTuition;
        }
        System.out.printf("The tuition will increase to $%,d to $%,d at a yearly rate of %d%%. \n", futureTuition, tuition, (int) (yearlyRate * 100));
        System.out.printf("The total cost of four years of tuition would then be $%,d.", totalCost);
    }

    // 5.8 Find the highest score
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = input.nextInt();

        if (n > 0) {
            if (n == 1) {
                System.out.printf("Since there is only one student, they have the highest score.");
                System.exit(1);
            }

            // Use a hashmap as a dictionary for better performance
            HashMap<String, Integer> students = new HashMap<>();

            for (int i = 0; i < n; i++) {
                System.out.println("Enter the name and score of each student (e.g. Alex 20): ");
                String name = input.next();
                int score = input.nextInt();

                students.put(name, score);
            }

            String bestStudent = "";
            int highestScore = 0;
            // use for-each loop to check highest score
            for(Map.Entry<String, Integer> entry : students.entrySet()) {
                if (entry.getValue() > highestScore) {
                    bestStudent = entry.getKey();
                    highestScore = entry.getValue();
                }
                    
            }

            System.out.printf("The best student is %s with a score of %d", bestStudent, highestScore);
        }
        else
            System.out.println("There should be at least one student.");
    }

    // 5.9 Find the two lowest scores
    static {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = input.nextInt();

        if (n > 1) {
            // Use a hashmap as a dictionary for better performance
            HashMap<String, Integer> students = new HashMap<>();

            for (int i = 0; i < n; i++) {
                System.out.println("Enter the name and score of each student (e.g. Alex 20): ");
                String name = input.next();
                int score = input.nextInt();

                students.put(name, score);
            }

            int lowestScore, secondLowestScore;
            lowestScore = secondLowestScore = Integer.MAX_VALUE;

            String worstStudent, secondWorstStudent;
            worstStudent = secondWorstStudent = "";

            // use for-each loop to check highest score
            for(Map.Entry<String, Integer> entry : students.entrySet()) {
                int studentScore = entry.getValue();
                if (studentScore < lowestScore) {
                    worstStudent = entry.getKey();
                    lowestScore = entry.getValue();
                }
                else if (studentScore < secondLowestScore) {
                    secondWorstStudent = entry.getKey();
                    secondLowestScore = entry.getValue();
                }
                    
            }

            System.out.printf("The worst student is %s with a score of %d \n", worstStudent, lowestScore);
            System.out.printf("The second worst student is %s with a score of %d", secondWorstStudent, secondLowestScore);
        }
        else
            System.out.println("There should be at least two students.");
    }

    // 5.10 Find numbers divisible by 3 and 4
    static {
        // holds 10 digits divisible by 3 and 4
        int[] divisible = new int[10];
        int index = 0; // tracks position in the array
        int printIndex = 0; // counts to 10, used as a sentinel to print
        
        for (int i = 100; i <= 1000; i++) {
            // check if i / 3 && i / 4
            if (i % 3 == 0 && i % 4 == 0)  {
                // append (or overwrite over previous) divisble digits
                divisible[index] = i; 

                // increase counters
                printIndex++;
                index++;
            }

            // print 10 digits at a time
            if (printIndex == 10) {
                for (int j = 0; j < divisible.length; j++) {
                    System.out.printf("%d ", divisible[j]);
                }
                System.out.printf("\n");

                // reset counters
                printIndex = 0;
                index = 0;
            }
        }

        // Print whatever is left in the array on a new line
        for (int j = 0; j < printIndex; j++) {
            System.out.printf("%d ", divisible[j]);
        }
        
    }

    // 5.11 Find numbers divisible by 3 XOR 4
    static {
        int[] divisible = new int[10];
        int index = 0; 
        int printIndex = 0; 
        for (int i = 100; i <= 200; i++) {
            if (i % 3 == 0 ^ i % 4 == 0)  {
                divisible[index] = i; 
                printIndex++;
                index++;
            }

            // print 10 digits at a time
            if (printIndex == 10) {
                for (int j = 0; j < divisible.length; j++) {
                    System.out.printf("%d ", divisible[j]);
                }
                System.out.printf("\n");
                printIndex = 0;
                index = 0;
            }
        }

        for (int j = 0; j < printIndex; j++) {
            System.out.printf("%d ", divisible[j]);
        }
    }

    // 5.12 Find the smallest n such that n^2 > 12,000
    static {
        int lowestValue = Integer.MAX_VALUE;
        int n = 12_000;
        while (n != 0) {
            if (Math.pow(n, 2) > 12_000 && n < lowestValue)
                lowestValue = n;

            n--;
        }
        System.out.printf("The smallest n is %d", lowestValue);
    }

    
    
    public static void main(String[] args) {
        
    }
}
