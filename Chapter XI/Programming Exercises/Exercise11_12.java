import java.util.*;

public class Exercise11_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        String s = input.nextLine();
        String[] arr = s.split("[,\\s]+");
        ArrayList<Double> list = new ArrayList<>();

        for (String digit : arr) {
            list.add(Double.valueOf(digit));
        }

        System.out.printf("The sum is %.2f", sum(list));
        
    }

    public static double sum(ArrayList<Double> list) {
        double sum = 0.0;
        for (double num : list) {
            sum += num;
        }

        return sum;
    }
}
