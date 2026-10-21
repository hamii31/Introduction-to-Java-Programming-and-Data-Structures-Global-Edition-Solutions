/**
 * Generate 100 lowercase letters
 * Assign them to an array
 * Count the occurences of each letter in the array
 */

public class CountingLetterOccurrences {
    // Generate 100 lowercase letters
    private static char[] generateLetterArray(int n) {
        char[] letters = new char[n];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = (char) ('a' + Math.random() * ('z' - 'a' + 1));
        }
        return letters;
    }
    // Count occurrence of each letter within the array
    public static int[] countOccurrences(char[] letters) {
        int[] counts = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            int count = 0;
            Character currentLetter = letters[i];
            for (int j = i; j < letters.length; j++) {
                if (currentLetter.equals(letters[j])) {
                    count++;
                }
            }
            // store count of occurrences of current letter
            counts[i] = count;
        }
        return counts;
    }
    public static void displayCounts(char[] letters, int[] counts) {
        for (int i = 0; i < letters.length; i++) {
            System.out.printf("%c appears %d times in the array\n", letters[i], counts[i]);
        }
    }
    public static void main (String[] args) {
        int n = 100;
        char[] letters = generateLetterArray(n);
        int[] counts = countOccurrences(letters);
        displayCounts(letters, counts);
    }
}
