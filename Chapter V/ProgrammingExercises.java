
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
    
    public static void main(String[] args) {
        
    }
}
