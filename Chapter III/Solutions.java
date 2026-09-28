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
    }
}
