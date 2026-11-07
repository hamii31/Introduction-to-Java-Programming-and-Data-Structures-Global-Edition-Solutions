import java.util.*;

public class Exercise11_16 {
    public static void main(String[] args) {
        Random rng = new Random();
        int num1 = rng.nextInt(100);
        int num2 = rng.nextInt(100);
        int sum = num1 + num2;

        Scanner input = new Scanner(System.in);
        System.out.printf("What is %d + %d ?\n", num1, num2);

        if (sum == input.nextInt()) {
            System.out.println("You got it!");
            System.exit(1);
        } else {
            ArrayList<Integer> userInputs = new ArrayList<>();
            while (true) {
                System.out.printf("Wrong. Try again. What is %d + %d ?\n", num1, num2);
                int userSum = input.nextInt();
                if (userInputs.contains(userSum)) {
                    System.out.printf("You already entered %d\n", userSum);
                } else if (sum == userSum) {
                    System.out.println("You got it!");
                    break;
                } else {
                    userInputs.add(userSum);
                }
            }
        }
    }
}
