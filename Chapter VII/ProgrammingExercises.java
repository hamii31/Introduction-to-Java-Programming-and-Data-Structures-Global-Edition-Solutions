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
        /* Every student starts from their locker, and closes/opens the rest 
         * based on increasing position in increments (equal to the student index)
         * and if the locker's condition beforehand
         */
        public static void changeLockers(int[] lockers, int student) {
            for(int i = student; i < lockers.length; i++) {
                if (i % student == 0) {
                    if (lockers[i] == 1) {
                        // if open, close it
                        lockers[i] = 0;
                    } else if (lockers[i] == 0) {
                        // if closed, open it
                        lockers[i] = 1;
                    }
                }
            }
        }
        public static void runAllStudents(int[] lockers, int students) {
            for(int student = 1; student <= students; student++) {
                changeLockers(lockers, student);
            }

            // display the final result
            System.out.printf("Open lockers: ");
            for (int i = 0; i < lockers.length; i++) {
                if (lockers[i] == 1) {
                    System.out.printf("%d ", i);
                }
            }
        }
        public static void init() {
            // 100 "closed" lockers (array full of zeroes)
            int[] lockers = new int[100];
            runAllStudents(lockers, 100);
        }
    }
    
    public static class Exercise24 {
        public static class BuildDeck {
            /** Fills up a deck of four different suits */
            private static int[] fillDeck() {
                int[] deck = new int[52];
                for (int i = 0; i < 52; i++) {
                    deck[i] = i;
                }
                return deck;
            }
            private static int[] shuffleDeck(int[] deck) {
                for (int i = deck.length - 1; i > 0; i--) {
                    int j = (int)(Math.random() * (i + 1));

                    int temp = deck[i];
                    deck[i] = deck[j];
                    deck[j] = temp;
                }
                return deck;
            }
            /* Shuffles a deck of 52 cards */
            private static int[] init() {
                int[] deck = fillDeck();
                int[] shuffledDeck = shuffleDeck(deck);
                return shuffledDeck;
            }
        }
        public static class PickCard {
            private static String getRank(int card) {
                switch (card % 13) {
                    case 0 -> { return "Ace"; }
                    case 1 -> { return "2"; }
                    case 2 -> { return "3"; }
                    case 3 -> { return "4"; }
                    case 4 -> { return "5"; }
                    case 5 -> { return "6"; }
                    case 6 -> { return "7"; }
                    case 7 -> { return "8"; }
                    case 8 -> { return "9"; }
                    case 9 -> { return "10"; }
                    case 10 -> { return "Jack"; }
                    case 11 -> { return "Queen"; }
                    case 12 -> { return "King"; }
                }
                return null;
            }
            private static String getSuit(int card) {
                switch (card / 13) {
                    case 0 -> { return "Spades"; }
                    case 1 -> { return "Hearts"; }
                    case 2 -> { return "Diamonds"; }
                    case 3 -> { return "Clubs"; }
                }
                return null;
            }
            /* Returns the index of the first zero to occur in an array */
            private static int getIndexOfZero(int[] array) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 0) {
                        return i;
                    }
                }
                return -1;
            }
            private static void countSuit(int card, int[] spades, int[] hearts, int[] diamonds, int[] clubs) {
                String suit = getSuit(card);
                switch (suit) {
                    case "Spades" -> { 
                        int index = getIndexOfZero(spades);
                        spades[index] = card;
                    }
                    case "Hearts" -> { 
                        int index = getIndexOfZero(hearts); 
                        hearts[index] = card;
                        }
                    case "Diamonds" -> { 
                        int index = getIndexOfZero(diamonds);
                        diamonds[index] = card;
                    }
                    case "Clubs" -> { 
                        int index = getIndexOfZero(clubs);
                        clubs[index] = card;
                    }
                }
            }
            private static boolean checkCondition (int[] spades, int[] hearts, int[] diamonds, int[] clubs) {
                int countSpades = getIndexOfZero(spades);
                int countHearts = getIndexOfZero(hearts);
                int countDiamonds = getIndexOfZero(diamonds);
                int countClubs = getIndexOfZero(clubs);

                return countSpades >= 4 && countHearts >= 4 && countDiamonds >= 4 && countClubs >= 4;
            }
            /* Put the current card in the end of the deck, shift the deck to the left */
            private static void putCardInDeck(int[] deck) {
                int temp = deck[0];

                // shift deck to the left, ignoring index 0
                for (int i = 1; i < deck.length; i++) {
                    deck[i - 1] = deck[i];
                }

                deck[deck.length - 1] = temp;
            }
            private static void displayCards(int[] spades, int[] hearts, int[] diamonds, int[] clubs) {
                int countSpades = getIndexOfZero(spades);
                System.out.printf("There are %d spades\n", countSpades);
                for (int card : spades) {
                    if (card != 0) {
                        System.out.printf("Card number %d is the %s of %s\n", card, getRank(card), getSuit(card));
                    }
                }

                int countHearts = getIndexOfZero(hearts);
                System.out.printf("There are %d hearts\n", countHearts);
                for (int card : hearts) {
                    if (card != 0) {
                        System.out.printf("Card number %d is the %s of %s\n", card, getRank(card), getSuit(card));
                    }
                }

                int countDiamonds = getIndexOfZero(diamonds);
                System.out.printf("There are %d diamonds\n", countDiamonds);
                for (int card : diamonds) {
                    if (card != 0) {
                        System.out.printf("Card number %d is the %s of %s\n", card, getRank(card), getSuit(card));
                    }
                }

                int countClubs = getIndexOfZero(clubs);
                System.out.printf("There are %d clubs\n", countClubs);
                for (int card : clubs) {
                    if (card != 0) {
                        System.out.printf("Card number %d is the %s of %s\n", card, getRank(card), getSuit(card));
                    }
                }
            }
            /* Picks n cards */
            private static void init(int[] deck) {
                int[] spades = new int[deck.length / 4];
                int[] hearts = new int[deck.length / 4];
                int[] diamonds = new int[deck.length / 4];
                int[] clubs = new int[deck.length / 4];

                int picks = 0;
                while(!checkCondition(spades, hearts, diamonds, clubs)) {
                    // always pick the first card
                    int card = deck[0];
                    picks++;
                    // check which suit we drew and count its occurrence
                    countSuit(card, spades, hearts, diamonds, clubs);

                    // add card to the tail end of the deck, and move positions to the left
                    putCardInDeck(deck);
                }

                // display the cards
                displayCards(spades, hearts, diamonds, clubs);

                System.out.printf("Number of picks: %d", picks);
            }
        }
        public static void init() {
            int[] shuffledDeck = BuildDeck.init();
            PickCard.init(shuffledDeck);
        }
    }
    
    public static class Exercise25 {
        public static double[] solveQuadratic(double[] eqn, double[] roots) {
            double[] solutions = new double[roots.length];
            for (int i = 0; i < roots.length; i++) {
                solutions[i] = Math.pow(eqn[0] * roots[i], 2) + (eqn[1] * roots[i]) + eqn[2];
            }
            return solutions;
        }
        public static double[] getEqn() {
            double[] eqn = new double[3];
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the values for a, b, and c: ");
            for(int i = 0; i < eqn.length; i++) {
                eqn[i] = input.nextDouble();
            }
            return eqn;
        }
        private static double computeDiscriminant(double[] eqn) {
            double a = eqn[0];
            double b = eqn[1];
            double c = eqn[2];
            return Math.pow(b,2) - (4 * a * c);
        }
        private static int getRootCount(double discriminant) {
            if (discriminant > 0) {
                return 2;
            } else if (discriminant == 0) {
                return 1;
            }
            return 0;
        }
        private static double[] computeRoots(double[] eqn, double discriminant) {
            double a = eqn[0];
            double b = eqn[1];
            double c = eqn[2];
            int rootCount = getRootCount(discriminant);
            if (rootCount == 0) {
                System.out.println("The equation has no real roots.");
                System.exit(1);
            } 

            double[] roots = new double[rootCount];

            for (int i = 0; i < rootCount; i++) {
                roots[i] = (-b + Math.sqrt(Math.pow(b,2) - (4 * a * c))) / (2 * a);

                if (i == 1) {
                    roots[i] = (-b - Math.sqrt(Math.pow(b,2) - (4 * a * c))) / (2 * a);
                }
            }

            System.out.printf("There are %d roots: \n", rootCount);
            for (double root : roots) {
                System.out.println(root);
            }

            return roots;

        }
        public static void init() {
            double[] eqn = getEqn();
            double discriminant = computeDiscriminant(eqn);
            double[] roots = computeRoots(eqn, discriminant);
            double[] solutions = solveQuadratic(eqn, roots);
            System.out.printf("There are %d solutions: \n", solutions.length);
            for (double solution : solutions) {
                System.out.println(solution);
            }
        }
     }
    
    public static class Exercise26 {
        public static boolean equals(int[] list1, int[] list2) {
            for (int i = 0; i < list1.length; i++) {
                if (list1[i] != list2[i]) {
                    return false;
                }
            }
            return true;
        }
        public static int[] getArray(int n) {
            Scanner input = new Scanner(System.in);
            System.out.printf("\nEnter list%d: ", n);
            int size = input.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = input.nextInt();
            }
            return array;
        }
        public static void init() {
            int[] array1 = getArray(1);
            int[] array2 = getArray(2);
            if (equals(array1, array2))
                System.out.println("Two lists are strictly identical");
            else 
                System.out.println("The lists are not strictly identical.");
        }
    }
    
    public static class Exercise30 {
        public static boolean isConsecutiveFour(int[] values) {
            Exercise19.bubbleSortAsc(values);
            int value = values[0];
            int counter = 0;
            for (int i = 1; i < values.length; i++) {
                if (counter == 4) {
                    return true;
                }

                if (value == values[i]) {
                    counter++;
                } else {
                    value = values[i];
                }
            }
            return false;
        }
        public static int[] getArray() {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the number of values: ");
            int n = input.nextInt();

            int[] values = new int[n];
            System.out.println("Enter the values: ");
            for (int i = 0; i < values.length; i++) {
                values[i] = input.nextInt();
            }
            return values;
        }
        public static void init() {
            int[] values = getArray();
            if (isConsecutiveFour(values))
                System.out.println("The list has four consecutive values.");
            else 
                System.out.println("The list has no four consecutive values.");
        }
    }
    
    public static class Exercise31 {
        public static int[] merge(int[] list1, int[] list2) {
            int[] list3 = new int[list1.length + list2.length];
            System.arraycopy(list1, 0, list3, 0, list1.length);
            System.arraycopy(list2, 0, list3,  list1.length, list2.length);
            return list3;
        }
        public static void init() {
            int[] list1 = Exercise30.getArray();
            Exercise19.bubbleSortAsc(list1);

            int[] list2 = Exercise30.getArray();
            Exercise19.bubbleSortAsc(list2);

            int[] list3 = merge(list1, list2);
            Exercise19.bubbleSortAsc(list3);

            System.out.println("The merged list is: ");
            for(int num : list3) {
                System.out.printf("%d ", num);
            }
        }
    }
    
    public static class Exercise32 {
        private static int getIndexOfZero(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                     return i;
                }
            }
            return -1;
        }
        /* Reorders array by pivot in O(n) iterations 
         * Returns the index of the pivot in the reordered list
         */
        public static int partition(int[] list) {
            int[] arr1 = new int[list.length / 2];
            int[] arr2 = new int[list.length / 2];

            int pivot = list[0];
            int index1 = 0;
            int index2 = 0;
            for (int i = 1; i < list.length; i++) {
                if (pivot > list[i]) {
                    arr1[index1] = list[i];
                    index1++;
                } else if (pivot <= list[i]) {
                    arr2[index2] = list[i];
                    index2++;
                }
            }

            // apply the two partitions to the original list
            System.arraycopy(arr1, 0, list, 0, arr1.length);
            System.arraycopy(arr2, 0, list, arr1.length, arr2.length);

            // get index of the zero (where the pivot must be) and add the pivot there
            int pivotIndex = getIndexOfZero(list);
            if(pivotIndex == list.length - 1) {
                pivotIndex = (list.length / 2);

                // get the current value at pivotIndex
                int temp = list[pivotIndex];
                // switch the values
                list[pivotIndex] = pivot;
                list[list.length - 1] = temp;
            } else {
                list[pivotIndex] = pivot;
            }

            return pivotIndex;
        }
        public static void init() {
            int[] list = Exercise30.getArray();
            partition(list);
            for(int e : list) {
                System.out.printf("%d ", e);
            }
        }
    }
    public static void main (String[] args) {
        Exercise32.init();
    }
}
