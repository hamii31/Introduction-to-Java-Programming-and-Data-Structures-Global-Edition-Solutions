import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GuessingBirthdays {
    public static void main (String[] args) {
        // Create immutable map of sets
        Map<Integer, Set<Integer>> sets = new HashMap<>() {{
            put(0, new HashSet<>(Set.of(            
                1, 3, 5, 7, 
                9, 11, 13, 15,
                17, 19, 21, 23,
                25, 27, 29, 31)));
            put(1, new HashSet<>(Set.of(            
                2, 3, 6, 7,
                10, 11, 14, 15,
                18, 19, 22, 23,
                26, 27, 30, 31)));
            put(2, new HashSet<>(Set.of(
                4, 5, 6, 7,
                12, 13, 14, 15,
                20, 21, 22, 23,
                28, 29, 30, 31)));
            put(3, new HashSet<>(Set.of(
                8, 9, 10, 11,
                12, 13, 14, 15,
                24, 25, 26, 27,
                28, 29, 30, 31)));
            put(4, new HashSet<>(Set.of(
                16, 17, 18, 19,
                20, 21, 22, 23,
                24, 25, 26, 27,
                28, 29, 30, 31)));
        }};

        // Init Scanner object
        Scanner input = new Scanner(System.in);

        // Init variable to hold the guessed day
        String bdayBinary = "";

        // Recursively go through the sets and append the user answer to form the binary
        for (int i = 0; i < sets.size(); i++) {
            bdayBinary = iterateSetsRecursive(i, sets.get(i), input) + bdayBinary; // prepend so the 0 lands on the right
        }

        // 10011 = 19
        String temp = String.valueOf(bdayBinary);
        System.out.println(temp);
        int bday = Integer.parseInt(temp, 2);
        System.out.println("Your birthday is: " + bday);
    }

    private static int iterateSetsRecursive(int setCount, Set set, Scanner input) {

        System.out.println("Is your birthday in set " + ++setCount + " ?");
        // Convert to Object and sort
        Object[] arr1 = set.toArray();
        Arrays.sort(arr1);

        // Print and prompt user for input
        System.out.println(Arrays.toString(arr1));
        System.out.println("Type 0 for No and 1 for Yes: ");
        int answer = input.nextInt();

        // Return answer
        if (answer == 1)
            return answer;
        
        return answer;
    }
}
