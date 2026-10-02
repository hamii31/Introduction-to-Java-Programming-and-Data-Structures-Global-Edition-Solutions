public class Solutions {
    // 4.2.1.3 Degrees to radians
    static {
        int degrees = 47;
        double radians = degrees * (Math.PI / 180);
        System.out.println(radians);
    }

    // 4.2.1.4 Radians to degrees
    static {
        double radians = Math.PI / 7;
        double degrees = radians * (180 / Math.PI);
        System.out.println(degrees); 
    }

    // 4.2.5.1 Random integers
    static {
        int rng1 = 34 + (int) (Math.random() * 56);
        System.out.println("random int in the 34-55 range: " + rng1);
        int rng2 = 0 + (int) (Math.random() * 1000);
        System.out.println("random int in the 0-999 range: " + rng2);
        double rng3 = 5.5 + (int) (Math.random() * 55.5);
        System.out.println("random number in the 5.5-55.5 range: " + rng3);
    }
    public static void main (String[] args) {
        
    }
}
