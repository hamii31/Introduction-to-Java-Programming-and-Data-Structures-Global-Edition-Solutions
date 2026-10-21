/**
 * Generate an array of int values
 * Use selection sort to sort the values in an ascending order
 * Implement binary search
 */

public class BinarySearch {
    // Implement a selection sort algorithm
    public static void sortArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int index = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < minValue) {
                    minValue = numbers[j];
                    index = j;
                } 
            }
            // switch the position of the current element i with the smallest element j
            int temp = numbers[i];
            numbers[i] = numbers[index];
            numbers[index] = temp;
        }
    }

    // Generate an array of random numbers in an ascending order
    public static int[] generateSortedNumbersArray(int n) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = 1 + (int)(Math.random() * 100);
        }

        // sort in asc order in place
        sortArray(numbers);
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
        return -low -1; // not found
    }

    public static void main (String[] args) {
        int n = 20;
        int[] numbers = generateSortedNumbersArray(n);

        int key = 34;
        int index = binarySearch(numbers, key);
        if (index > -1)
            System.out.printf("%d is present in the array at index %d (%d=%d)", key, index, key, numbers[index]);
        else 
            System.out.printf("The key is not present in the array, but can be inserted at index %d", index);
    }
}
