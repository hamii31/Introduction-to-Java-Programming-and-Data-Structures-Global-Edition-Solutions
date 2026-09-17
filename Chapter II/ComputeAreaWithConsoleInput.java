import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("Enter a number for radius: ");
        double radius = input.nextDouble();
        double pi = 3.14159;
        double area = radius * radius * pi;

        System.out.println(area);
    }
}
