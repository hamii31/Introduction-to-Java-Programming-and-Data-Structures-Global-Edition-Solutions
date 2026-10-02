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

    // 4.3.3.1
    static {
        char[] chars = new char[] {
            '1', 'A', 'B', 'a', 'b'
        };

        System.out.println("ASCII:");
        for (int i = 0; i < chars.length; i++)
            System.out.println((int) chars[i]);

        int[] decimals = new int[] {
            40, 59, 79, 85, 90
        };

        System.out.println("chars:");
        for (int i = 0; i < decimals.length; i++)
            System.out.println((char) decimals[i]);

        String[] hexademicals = new String[] {
            "40", "5A", "71", "72", "7A"
        };

        System.out.println("hexademicals:");
        for (String hexademical : hexademicals)
            System.out.println(Integer.parseInt(hexademical, 16));
            
    }

    // 4.3.3.5 random lowercase letter
    static {
        // start from the ascii code for 'a' and end with the total count of ascii codes for lowercase letters
        int ascii = (int)  (97 + (Math.random() * 26));
        System.out.println((char) ascii);
    }

    
    public static void main (String[] args) {
        
    }
}
