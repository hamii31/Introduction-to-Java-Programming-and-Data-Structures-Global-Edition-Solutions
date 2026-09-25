import java.util.Scanner;

public class ComputingBodyMassIndex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your bodyweight in pounds:");
        double bw = input.nextDouble();
        System.out.println("Please enter your height in inches:");
        double height = input.nextDouble();

        double BMI = (bw * 0.45359237) / Math.pow((height * 0.0254), 2);
        System.out.println("Your BMI is " + BMI);

        if (BMI < 18.5)
            System.out.println("Underweight");
        else if (BMI >= 18.5 && BMI < 25.0)
            System.out.println("Normal");
        else if (BMI >= 25.0 && BMI < 30.0)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }
}
