
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise12_02 {
    public static void main(String[] args) {
        System.out.println(readIntegers());
    }

    public static int readIntegers() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter two integers: ");
            int n1 = input.nextInt();
            int n2 = input.nextInt();
            return n1 + n2;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            return readIntegers();
        }
    }
}
