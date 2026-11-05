import java.util.*;

public class Exercise11_04 {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter numbers: ");
        while (true) {
            int num = input.nextInt();

            if (num == 0) break;

            list.add(num);
        }

        System.out.println("The max element is: " + max(list));
    }

    public static Integer max(ArrayList<Integer> list) {
        if (list.isEmpty()) return null;

        int max = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > max) max = num;
        }

        return max;
    }
}
