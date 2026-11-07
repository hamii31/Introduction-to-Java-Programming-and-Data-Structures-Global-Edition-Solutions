
import java.util.Scanner;

public class Exercise11_17 {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer m: ");
        int m = input.nextInt();
        for (int n = 1; n <= m; n++) {
            if (Math.sqrt(m * n) % 2 == 0) {
                System.out.printf("The smalles number n for m * n to be a perfect square is %d\n", n);
                System.out.printf("m * n is %d", m * n);
                break;
            }
        }
    }
}
