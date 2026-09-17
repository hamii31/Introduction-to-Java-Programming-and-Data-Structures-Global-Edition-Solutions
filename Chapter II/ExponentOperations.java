public class ExponentOperations {
    public static void main(String[] args) {
        // 2.9.2
        System.out.println(56 % 6);
        System.out.println(78 % -4);
        System.out.println(-34 % 5);
        System.out.println(-34 % -5);
        System.out.println(5 % 1);
        System.out.println(1 % 5);

        // 2.9.3
        double weeks = 100 / 7.0;
        System.out.println(weeks); // There are 14.286 weeks in 100 days

        // We need an integer representing the exact days that are in 14 weeks
        int days = 7 * (int) weeks; // We convert the double into an int 
        System.out.println(days);

        /* It will be a Tuesday in 98 days, so when we add 2 more days it turns out
        that it will be Thursday in 100 days if today is a Tuesday. */

        // 2.9.4
        System.out.println(25.0 / 4.0);

        // 2.9.5
        System.out.println(2 * (5 / 2 + 5 / 2));
        System.out.println(2 * 5 / 2 + 2 * 5 / 2);
        System.out.println(2 * (5 / 2));
        System.out.println(2 * 5 / 2);

        // 2.9.6
        System.out.println("25 / 4 is " + 25 / 4); // No
        System.out.println("25 / 4.0 is " + 25 / 4.0); 
        System.out.println("3 * 2 / 4 is " + 3 * 2 / 4); // No
        System.out.println("3.0 * 2 / 4 is " + 3.0 * 2 / 4);

        // 2.9.7
        System.out.println(Math.pow(2, 3.5));

        // 2.9.8
        int m = 2;
        int r = 4;
        System.out.println(m * Math.pow(r, 2));
    }
}
