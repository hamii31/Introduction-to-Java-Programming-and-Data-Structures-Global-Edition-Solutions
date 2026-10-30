
import java.util.Random;

public class Exercise09_04 {
    public static void main (String[] args) {
        Random rng = new Random();
        rng.setSeed(1000);

        for (int i = 0; i < 50; i++) {
            System.out.println(rng.nextInt(100));
        }
    }
}
