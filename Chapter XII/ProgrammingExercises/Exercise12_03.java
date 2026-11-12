
import java.util.*;

public class Exercise12_03 {
    public static void main(String[] args) {
        int[] array = buildArray(100);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an index: ");
        int index = input.nextInt();
        try {
            System.out.println(array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");
        }
    }

    public static int[] buildArray(int n) {
        Random rng = new Random();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = rng.nextInt();
        }

        return array;
    }
}
