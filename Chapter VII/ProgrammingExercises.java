import java.util.*;

public class ProgrammingExercises {
    // 7.1
    private static double[] getScores() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = input.nextInt();

        double[] scores = new double[n];
        System.out.printf("Enter %d scores: ", n);
        for (int i = 0; i < n; i++) {
            scores[i] = input.nextDouble();
        }

        return scores;

    }
    private static double getBestScore(double[] scores) {
        double bestScore = Double.MIN_VALUE;
        for (double score : scores) {
            if (score > bestScore) {
                bestScore = score;
            }
        }
        return bestScore;
    }
    private static String scoreToGrade(double grade, double bestScore) {
        if (grade >= bestScore - 10) {
            return "A";
        } else if (grade >= bestScore - 20) {
            return "B";
        } else if (grade >= bestScore - 30) {
            return "C";
        } else if (grade >= bestScore - 40) {
            return "D";
        }
        return "F";
    }
    private static void printGrades(double[] scores, double bestScore) {
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %d score is %.1f and grade is %s\n", i, scores[i], scoreToGrade(scores[i], bestScore));
        }
    }
    public static void assignGrades() {
        double[] scores = getScores();
        double bestScore = getBestScore(scores);
        System.out.println(bestScore);
        printGrades(scores, bestScore);
    }

    // 7.2 
    private static int[] readNumbers() {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        System.out.println("Enter 10 numbers: ");
        for (int i = 0; i < 10; i++) {
            numbers[i] = input.nextInt();
        }
        return numbers;
    }
    private static void displayInReverse(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            System.out.println(numbers[i]);
        }
    }
    public static void reverseEnteredNumbers() {
        int[] numbers = readNumbers();
        displayInReverse(numbers);
    }

    // 7.3
    private static boolean isInRange(int number) {
        return number >= 1 && number <= 100;
    }
    private static String getNumbersAsString() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers between 1 and 100: ");
        String s = "";
        int number;
        do {
            number = input.nextInt();
            if (isInRange(number)) {
                s += Integer.toString(number) + " ";
            }

        } while (number != 0);

        return s;
    }
    private static int[] convertStringToIntArray(String s) {
        String[] arr = s.split(" ");
        int[] numbers = new int[arr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        return numbers;
    }
    private static int[] getInfiniteNumbers () {
        String s = getNumbersAsString();
        return convertStringToIntArray(s);
    }
    private static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int index = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < minValue) {
                    minValue = numbers[j];
                    index = j;
                } 
            }
           
            int temp = numbers[i];
            numbers[i] = numbers[index];
            numbers[index] = temp;
        }
    }
    private static void sortAndCount(int[] numbers) {
        sort(numbers);

        int index = 0;
        while(true) {
            int key = numbers[index];
            int count = 0;
            for (int i = index; i <= numbers.length; i++) {
                if (i + count > numbers.length) {
                    System.out.printf("%d occurs %d times\n", key, count);
                    return;
                } else if (numbers[i] == key) {
                    count++;
                } else {
                    index = i;
                    break;
                }
            }
            System.out.printf("%d occurs %d times\n", key, count);
        }
    }
    public static void countNumberOccurrences() {
        int[] numbers = getInfiniteNumbers();
        sortAndCount(numbers);
    }
    public static void main (String[] args) {
        countNumberOccurrences();
    }
}
