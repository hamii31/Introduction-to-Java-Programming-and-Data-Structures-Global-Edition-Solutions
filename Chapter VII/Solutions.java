public class Solutions {
    // 7.2.8
    static {
        // a
        Double[] arr = new Double[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 10;
        }
        // b
        arr[9] = 5.5;

        // c
        System.out.printf("The sum of the first two elements: %.2f\n", arr[0] + arr[1]);

        // d
        double sum = 0.0;
        for (double e : arr) {
            sum += e;
        }
        System.out.printf("The sum of all elements: %.2f\n", sum);

        // e
        double min = Double.MAX_VALUE;
        for (double e : arr) {
            if (e < min)
                min = e;
        }
        System.out.printf("The smallest element is: %.2f\n", min);

        // f
        int index = 0 + (int)(Math.random() * arr.length - 1);
        System.out.printf("The randomly chosen element at index %d is %.2f\n", index, arr[index]);

        // g
        Double[] _ = {3.5, 5.5, 4.52, 5.6};
    }

    // 7.2.10
    static {
        Double[] r = new Double[100];

        for (int i = 0; i < r.length; i++) {
            r[i] = Math.random() * 100;
        }
    }

    public static void main (String[] args) {
    }
}
