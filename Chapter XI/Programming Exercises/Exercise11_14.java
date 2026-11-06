
import java.util.*;

public class Exercise11_14 {
    public static void main(String[] args) {
        System.out.print("Enter integers for list1: \n");
        ArrayList<Integer> list1 = createList();

        System.out.print("Enter integers for list2: \n");
        ArrayList<Integer> list2 = createList();

        ArrayList<Integer> list3 = union(list1, list2);
        for (int num : list3) {
            System.out.printf("%d ", num);
        }
    }

    public static ArrayList<Integer> createList() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] arr = s.split("[,\\s]+"); 
        ArrayList<Integer> list = new ArrayList<>();

        for (String digit : arr) {
            list.add(Integer.valueOf(digit));
        }

        return list;
    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list3 = new ArrayList<>();
        
        for (int num : list1) {
            list3.add(num);
        }

        for (int num : list2) {
            list3.add(num);
        }

        return list3;
    }
}
