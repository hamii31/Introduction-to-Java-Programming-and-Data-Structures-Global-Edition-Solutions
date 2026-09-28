import java.util.Scanner;

public class Solutions {
    public static void main (String[] args) {
        // 3.10.1 
        int x = 1;
        System.out.println("Exercise 3.10.1");
        System.out.println((true) && (3 > 4));
        System.out.println(!(x > 0) && (x > 0));
        System.out.println((x > 0) || (x < 0));
        System.out.println((x != 0) || (x == 0));
        System.out.println((x >= 0) || (x < 0));
        System.out.println((x != 1) == !(x == 1));

        // 3.10.2
        int num = -50;
        System.out.println("Exercise 3.10.2");
        System.out.println((num > 0 && num < 100) || num < 0);

        // 3.10.3
        System.out.println("Exercise 3.10.3");
        System.out.println(Math.abs(x - 5) < 4.5);
        System.out.println(Math.abs(x - 5) > 4.5);

        // 3.10.6 
        x = 101;
        System.out.println("Exercise 3.10.6");
        System.out.println(x >= 50 && x <= 100);

        // 3.10.8
        int age = 15;
        System.out.println("Exercise 3.10.8");
        System.out.println(age > 13 && age < 18);

        // 3.10.9
        int weight = 45;
        int inches = 80;
        System.out.println("Exercise 3.10.9");
        System.out.println(weight > 50 && inches > 60);

        // 3.10.11
        System.out.println("Exercise 3.10.11");
        System.out.println(weight > 50 || inches > 60);

        // 3.13.5
        int day = 0;

        switch (day){
            case 0 -> System.out.println("Sunday");
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
        }

        // 3.13.6 (Someone had to...)
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = input.nextInt();

        if (year % 12 == 0) System.out.println("The year of the Monkey");
        else if (year % 12 == 1) System.out.println("The year of the Rooster");
        else if (year % 12 == 2) System.out.println("The year of the Dog");
        else if (year % 12 == 3) System.out.println("The year of the Pig");
        else if (year % 12 == 4) System.out.println("The year of the Rat");
        else if (year % 12 == 5) System.out.println("The year of the Ox");
        else if (year % 12 == 6) System.out.println("The year of the Tiger");
        else if (year % 12 == 7) System.out.println("The year of the Rabbit");
        else if (year % 12 == 8) System.out.println("The year of the Dragon");
        else if (year % 12 == 9) System.out.println("The year of the Snake");
        else if (year % 12 == 10) System.out.println("The year of the Horse");
        else if (year % 12 == 11) System.out.println("The year of the Sheep");
    }
}
