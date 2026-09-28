import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = input.nextInt();

        switch (year % 12){
            case 0 -> System.out.println("The year of the Monkey");
            case 1 -> System.out.println("The year of the Rooster");
            case 2 -> System.out.println("The year of the Dog");
            case 3 -> System.out.println("The year of the Pig");
            case 4 -> System.out.println("The year of the Rat");
            case 5 -> System.out.println("The year of the Ox");
            case 6 -> System.out.println("The year of the Tiger");
            case 7 -> System.out.println("The year of the Rabbit");
            case 8 -> System.out.println("The year of the Dragon");
            case 9 -> System.out.println("The year of the Snake");
            case 10 -> System.out.println("The year of the Horse");
            case 11 -> System.out.println("The year of the Sheep");
            default -> System.out.println("Something went wrong.");
        }
    }
}
