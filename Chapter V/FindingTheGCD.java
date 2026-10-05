public class FindingTheGCD {
    public static void main(String[] args) {
        int n1 = 16;
        int n2 = 24;
        int k = 1;
        int gcd = k;

        do { 
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
            k++;
        } while (k <= n1 || k <= n2);

        System.out.printf("The greatest common divisor of %d and %d is %d", n1, n2, gcd);
    }
}
