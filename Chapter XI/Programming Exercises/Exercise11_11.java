import java.util.*;

public class Exercise11_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");
        String s = input.nextLine();
        String[] arr = s.split("[,\\s]+");
        ArrayList<Integer> list = new ArrayList<>();

        for (String digit : arr) {
            list.add(Integer.valueOf(digit));
        }

        sort(list);

        for (int digit : list) {
            System.out.println(digit);
        }
    }

    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    // switch their positions
                    int temp1 = list.get(j);
                    int temp2 = list.get(i);
                    list.add(i, temp1);
                    list.add(j, temp2);
                }
            }
        }
    }
}
