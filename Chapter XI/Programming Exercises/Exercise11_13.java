import java.util.*;

public class Exercise11_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        String s = input.nextLine();
        String[] arr = s.split("[,\\s]+"); 
        ArrayList<Integer> list = new ArrayList<>();

        for (String digit : arr) {
            list.add(Integer.valueOf(digit));
        }

        removeDuplicate(list);

        for (int num : list) {
            System.out.printf("%d ", num);
        }
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    indexes.add(j);
                }
            }
        }

        for (int i = 0; i < indexes.size(); i++) {
            list.remove(indexes.get(i) - i);
        }
    }
}
