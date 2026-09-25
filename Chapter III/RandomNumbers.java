public class RandomNumbers {
    public static void main (String[] args) {

        // Generate random number between 0 and 20
        while(true) {
            int number = (int) (Math.random() * 100);
            if (number < 20) {
                System.out.println(number);
                break;
            }
        }

        // Generate random number between 10 and 20
        while(true) {
            int number = (int) (Math.random() * 100);
            if (number < 20 && number >= 10) {
                System.out.println(number);
                break;
            }
        }

        // Generate random number between 10 and 50
        while(true) {
            int number = (int) (Math.random() * 100);
            if (number <= 50 && number >= 10) {
                System.out.println(number);
                break;
            }
        }

        // return 0 or 1 randomly
        double rng = Math.random();
        int number = (rng >= 0.5) ? 1 : 0;
        System.out.println(number);
    }
}
