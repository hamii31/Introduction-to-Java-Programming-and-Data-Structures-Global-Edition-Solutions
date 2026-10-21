/**
 * Generate an array of int values
 * Implement binary search
 */
import java.util.*;

public class BinarySearch {
    // Generate an array of random numbers in an ascending order
    public static int[] generateNumberArrayAsc(int n) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = 1 + (int)(Math.random() * n);
        }

        // sort in asc order
        Arrays.sort(numbers);
        return numbers;
    }

    public static int binarySearch(int[] numbers, int key) {
        int low = 0;
        int high = numbers.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < numbers[mid]) {
            /* if the key is less than the mid value 
            continue the search in the first half 
            of the array only */
            high = mid - 1;
            } else if (key == numbers[mid]) {
                return mid;
            } else {
                /* if the key is more than the mid value 
                continue the search in the second half 
                of the array only */
                low = mid + 1;
            }
        }
        return -1; // not found
    }

    public static void main (String[] args) {
        int n = 100;
        int[] numbers = generateNumberArrayAsc(n);

        int key = 56;
        int index = binarySearch(numbers, key);
        if (index != -1)
            System.out.printf("%d is present in the array at index %d (%d=%d)", key, index, key, numbers[index]);
        else 
            System.out.println("The key is not present in the array.");
    }
}
