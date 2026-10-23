import java.util.*;

/* Restrictions: can only use arrays */
public class ProgrammingExercises {
    public static class Exercise1 { 
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
    }

    public static class Exercise2 { 
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
    }

    public static class Exercise3 { 
        public static boolean isInRange(int number, int boundary) {
            return number >= 1 && number <= boundary;
        }
        /** Gets an unknown number of digits within a boundary */
        public static String getNumbersAsString(int threshold, int boundary) {
            Scanner input = new Scanner(System.in);
            String s = "";
            int number;
            int boundsCounter = 0;
            // Set a threshold that when passed terminates the loop
            // Set a boundary that when reached terminates the loop
            do {
                number = input.nextInt();
                if (isInRange(number, boundary)) {
                    s += Integer.toString(number) + " ";
                }
                boundsCounter++;

                if (boundsCounter == boundary)
                    break;

            } while (number != threshold);

            return s;
        }
        public static int[] convertStringToIntArray(String s) {
            String[] arr = s.split(" ");
            int[] numbers = new int[arr.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(arr[i]);
            }
            return numbers;
        }
        public static int[] getNumbers (int threshold, int boundary) {
            String s = getNumbersAsString(threshold, boundary);
            return convertStringToIntArray(s);
        }
        public static void sort(int[] numbers) {
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
        public static void sortAndCount(int[] numbers) {
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
            System.out.println("Enter numbers between 1 and 100, enter 0 to stop: ");
            int threshold = 0;
            int boundary = 1000;
            int[] numbers = getNumbers(threshold, boundary);
            sortAndCount(numbers);
        }
    }

    public static class Exercise4 {
        public static double getAverage(int[] scores) {
            double averageScore = 0.0;
            for (int score : scores) {
                averageScore += score;
            }
            return averageScore / (double) scores.length;
        }
        public static void checkScores(int[] scores, double averageScore) {
            int aboveAverage = 0;
            int belowAverage = 0;
            for (int score : scores) {
                if (score >= averageScore)
                    aboveAverage++;
                else
                    belowAverage++;
            }
            System.out.printf("Out of %d scores with an average of %d, %d are above average, and %d are below average.", scores.length, averageScore, aboveAverage, belowAverage);
        }
        public static void readNumbers() {
            // get n <= 100 scores
            System.out.println("Enter scores, type -1 to stop: ");
            int threshold = -1;
            int boundary = 100;
            int[] scores = Exercise3.getNumbers(threshold, boundary);

            // get average score
            double averageScore = getAverage(scores);

            // determine how many scores are >= average || < average
            checkScores(scores, averageScore);
        }
    }

    public static class Exercise5 {
        public static String getDistinctNumbersAsString(int[] integers) {
            String s = "";
            for(int i = 0; i < integers.length; i++) {
                if (!s.contains(Integer.toString(integers[i])))
                    s += integers[i] + " ";
            }
            return s;
        }
    
        public static int[] getDistinctNumbers() {
            int threshold = -1;
            int boundary = 10;
            int[] integers = Exercise3.getNumbers(threshold, boundary);
            String s = getDistinctNumbersAsString(integers);
            int[] distinctIntegers = Exercise3.convertStringToIntArray(s);
            return distinctIntegers;
        }
        public static void printArray(int[] array) {
            for (int number : array) {
                System.out.printf("%d ", number);
            }
        }
        public static void init() {
            System.out.println("Enter ten integers: ");
            int[] distinctIntegers = getDistinctNumbers();
            printArray(distinctIntegers);
        }
    }

    public static class Exercise7 {
        public static int[] generateAndSortDigits(int n) {
            int[] digits = new int[n];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = 0 + (int) (Math.random() * n);
            }
            Exercise3.sort(digits);
            return digits;
        }
        public static int[] countDigitOccurrences(int[] digits) {
            int[] counts = new int[10];
            int index = 0;
            for(int i = 0; i < counts.length; i++) {
                int count = 0;
                for (int j = index; j < digits.length; j++) {
                    if (digits[j] == i) {
                        count++;
                    } else {
                        index = j;
                        break;
                    }
                }
                counts[i] = count;
            }
            return counts;
        }
        public static void printCounts(int[] counts) {
            for(int i = 0; i < counts.length; i++) {
                System.out.printf("%d occurs %d times\n", i, counts[i]);
            }
        }
        public static void init() {
            int[] digits = generateAndSortDigits(200);
            int[] counts = countDigitOccurrences(digits);
            printCounts(counts);
        }
    }
    
    public static class Exercise8 {

        public static double average(double[] array) {
            double average = 0.0;
            for (int i = 0; i < array.length; i++) {
                average += array[i];
            }
            return average / (double) array.length;
        }
        public static int[] getIntegerArray(int n) {
            Scanner input = new Scanner(System.in);
            System.out.printf("Enter %d integers: ", n);
            int[] integers = new int[n];
            for (int i = 0; i < integers.length; i++) {
                integers[i] = input.nextInt();
            }
            return integers;
        }
        public static double[] getDoubleArray(int n) {
            Scanner input = new Scanner(System.in);
            System.out.printf("Enter %d double values: ", n);
            double[] integers = new double[n];
            for (int i = 0; i < n; i++) {
                integers[i] = input.nextDouble();
            }
            return integers;
        }
        public static void init() {
            int[] integers = getIntegerArray(10);
            System.out.printf("The average of the first array is %.2f.\n", Exercise4.getAverage(integers));
            double[] dValues = getDoubleArray(10);
            System.out.printf("The average of the second array is %.2f.\n", average(dValues));
        }
    }

    public static class Exercise9 {
        public static double min(double[] array) {
            double smallestElement = Double.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < smallestElement) {
                    smallestElement = array[i];
                }
            }
            return smallestElement;
        }
        public static void init() {
            double[] array = Exercise8.getDoubleArray(10);
            System.out.printf("The smallest element in the array is %.2f", Exercise9.min(array));
        }
    }

    public static class Exercise10 {
        public static int indexOfLargestElement(double[] array) {
            int index = -1;
            double largestElement = Double.MIN_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > largestElement) {
                    largestElement = array[i];
                    index = i;
                }
            }
            return index;
        }
        public static void init() {
            double[] array = Exercise8.getDoubleArray(10);
            int index = indexOfLargestElement(array);
            System.out.printf("The largest element in the array is %.2f at index %d", array[index], index);
        }
        
    }
    
    public static class Exercise11 {
        /* Compute the mean of an array of double values */
        public static double mean(double[] x) {
            double mean = 0.0;
            for (int i = 0; i < x.length; i++) {
                mean += x[i];
            }
            return mean / (double) x.length;
        }
        /* Compute the deviation of double values */
        public static double deviation(double[] x) {
            double mean = mean(x);
            double deviation = 0.0;
            for (int i = 0; i < x.length; i++) {
                deviation += Math.pow((x[i] - mean),2);
            }
            
            return Math.sqrt(deviation / (double) (x.length - 1));
        }
        public static void init() {
            double[] x = Exercise8.getDoubleArray(10);
            System.out.printf("The mean is %f\n", mean(x));
            System.out.printf("The std is %f\n", deviation(x));
        }
    }
    
    public static class Exercise12 {
        /* Reverse an array inplace */
        public static void reverse(int[] array) {
            int n = array.length - 1;
            for (int i = n; i > (n / 2); i--) {
                int temp = array[i];
                array[i] = array[n - i];
                array[n - i] = temp;
            }
        }
        public static void init() {
            int[] integers = Exercise8.getIntegerArray(10);
            reverse(integers);
            Exercise5.printArray(integers);
        }
    }
    
    public static class Exercise13 {
        public static int getRandom(int...numbers) {
            int rngIndex = 0 + (int)(Math.random() * numbers.length);
            return numbers[rngIndex];
        }
        public static void init() {
            System.out.println(getRandom(1, 2, 3));
        }
    }
    
    public static class Exercise14 {
        public static int min(int...numbers) {
            int smallestElement = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] < smallestElement) {
                    smallestElement = numbers[i];
                }
            }
            return smallestElement;
        }
        /* Finds the greatest common divisor of n numbers */
        public static int gcd(int...numbers) {
            int gcd = 0;
            int divisor = 1;
            int smallestElement = Exercise14.min(numbers);
            while(divisor <= smallestElement) {
                boolean commonDivisor = true;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % divisor != 0) {
                        commonDivisor = false;
                    }
                }
                if (commonDivisor) {
                    if (divisor > gcd) {
                        gcd = divisor;
                    }
                }

                divisor++;
            }

            return gcd;
        }
        public static int multiply(int...numbers) {
            int multiple = 1;
            for (int i = 0; i < numbers.length; i++) {
                multiple *= numbers[i];
            }
            return multiple;
        }
        public static int lcm(int...numbers) {
            int gcd = gcd(numbers);
            int multiple = multiply(numbers);
            return multiple / gcd;
        }
        public static void init() {
            int[] integers = Exercise8.getIntegerArray(5);
            System.out.println(lcm(integers));
        }
    }

    public static class Exercise16 {
        public static int binarySearch(int[] sortedIntegers, int key) {
             int low = 0;
            int high = sortedIntegers.length - 1;
            while (high >= low) {
                int mid = (low + high) / 2;
                if (key < sortedIntegers[mid]) {
                high = mid - 1;
                } else if (key == sortedIntegers[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
            return -low -1; 
        }
        public static void init() {
            int n = 100_000;
            int key = 1 + (int)(Math.random() * n);
            int[] sortedIntegers = Exercise7.generateAndSortDigits(n);

            long startTime = System.nanoTime();
            int index = binarySearch(sortedIntegers, key);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.printf("It took %d nanoseconds to execute the binary search\n", executionTime);
            if (index > -1)
                System.out.printf("%d is present in the array at index %d (%d=%d)", key, index, key, sortedIntegers[index]);
            else 
                System.out.printf("The key is not present in the array, but can be inserted at index %d", index);
            }
    }

    public static class Exercise17 {
        public static int getNumberOfStudents(Scanner input) {
            System.err.println("Enter the number of students: ");
            return input.nextInt();
        }
        public static String[] getStudentNames(Scanner input, int n) {
            System.out.printf("Enter %d student names: \n", n);
            String[] names = new String[n];
            for (int i = 0; i < names.length; i++) {
                names[i] = input.next();
            }
            return names;
        }
        /** This method assumes that the scores for each student 
         * are entered at the same index as their names...which is
         * not very efficient. 
         */
        public static double[] getStudentScores(Scanner input, int n) {
            System.out.printf("Enter %d student scores: \n", n);
            double[] scores = new double[n];
            for (int i = 0; i < scores.length; i++) {
                scores[i] = input.nextDouble();
            }
            return scores;
        }
        /** Bubble sorts an array in descending order and returns a list of 
         * the current index order
         */
        public static int[] bubbleSortDesc(double[] scores) {
            int[] indexes = new int[scores.length];
            for(int i = 0; i < scores.length; i++) {
                for (int j = i; j < scores.length; j++) {
                    if (scores[i] < scores[j]) {
                        double temp = scores[i];
                        scores[i] = scores[j];
                        scores[j] = temp;
                        indexes[i] = j - i;
                    } 
                }
            }
            return indexes;
        }
        /* Print the names in descending order, based on the scores */
        public static void printByDescScore(String[] names, double[]scores) {
            int[] indexes = bubbleSortDesc(scores);
            for(int i = 0; i < indexes.length; i++) {
                System.out.println(names[indexes[i]]);
            }
            
        }
        public static void init() {
            Scanner input = new Scanner(System.in);
            int n = getNumberOfStudents(input);
            String[] names = getStudentNames(input, n);
            double[] scores = getStudentScores(input, n);
            printByDescScore(names, scores);
        }
    }

    public static class Exercise19 {
        public static int getSize(Scanner input) {
            System.out.println("Enter the size of the list: ");
            return input.nextInt();
        }
        public static int[] getList(Scanner input, int n) {
            System.out.println("Enter the contents of the list: ");
            int[] list = new int[n];
            for (int i = 0; i < list.length; i++) {
                list[i] = input.nextInt();
            }

            System.out.printf("The list has %d integers ", list.length);
            for (int integer : list) {
                System.out.printf("%d ", integer);
            }

            return list;
        }
        public static int[] getCopyOfList(int[] list) {
            int[] copy = new int[list.length];
            System.arraycopy(list, 0, copy, 0, copy.length);
            return copy;
        }
        /* Bubble sorts an array in ascending order */
        public static void bubbleSortAsc(int[] list) {
            for(int i = 0; i < list.length; i++) {
                for (int j = i; j < list.length; j++) {
                    if (list[i] > list[j]) {
                        int temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                    } 
                }
            }
        }
        /* Check if the arrays are the same */
        public static boolean bothAreSortedAsc(int[] list, int[] copy) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] != copy[i])
                    return false;
            }
            return true;
        }
        public static void init() {
            Scanner input = new Scanner(System.in);
            int n = getSize(input);
            int[] list = getList(input, n);
            // copy before inplace sorting
            int[] copy = getCopyOfList(list);
            bubbleSortAsc(list);
            String s = bothAreSortedAsc(list, copy) ? "\nThe list is sorted" : "\nThe list is not sorted";
            System.out.println(s);
        }
    }
    
    public static class Exercise21 {
        public static void normalizeArray(double [] array, double largestElement) {
            for (int i = 0; i < array.length; i++) {
                array[i] /= largestElement;
            }
        }
        public static void printNormalizedArray(double[] array) {
            for (double number : array) {
                System.out.printf("%.2f ", number);
            }
        }
        public static void init() {
            double[] array = Exercise8.getDoubleArray(10);
            int index = Exercise10.indexOfLargestElement(array);
            normalizeArray(array, array[index]);
            printNormalizedArray(array);
        }
    }
    
    public static class Exercise23 {
        
    }
    public static void main (String[] args) {
        Exercise21.init();
    }
}
