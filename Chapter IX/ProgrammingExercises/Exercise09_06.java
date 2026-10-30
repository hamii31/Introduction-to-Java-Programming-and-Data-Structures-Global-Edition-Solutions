
import java.util.Random;

public class Exercise09_06 {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        sw.start();
        SortedArray _ = new SortedArray(100_000);
        sw.end();
        System.out.printf("Time elapsed: %.3f seconds", sw.getElapsedTime() * 1e-9);
    }
}

class SortedArray {
    int n;
    int[] numbers;

    public SortedArray(int n) {
        this.n = n;
        this.createAndPopulateArray();
        this.selectionSort(this.numbers);
    }

    private int[] createAndPopulateArray() {
        Random rng = new Random();
        rng.setSeed(1000);

        this.numbers = new int[this.n];
        for (int i = 0; i < this.numbers.length; i++) {
            this.numbers[i] = rng.nextInt();
        }

        return this.numbers;
    }

    private void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            
            int min_index = i;
            
            for(int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[min_index]) {
                    min_index = j;
                }
            }

            int temp = numbers[i];
            numbers[i] = numbers[min_index];
            numbers[min_index] = temp;
        }
    }
}

class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.nanoTime();
    }

    public void start() {
        this.startTime = System.nanoTime();
    }

    public void end() {
        this.endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        if (this.endTime != 0)
            return endTime - startTime;
        return 0;
    }
}
