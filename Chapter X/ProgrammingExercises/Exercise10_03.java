public class Exercise10_03 {
    public static void main(String[] args) {
        // Normalize a rational
        Rational r1 = new Rational(6, 8);
        r1 = r1.normalize();
        System.out.printf("The numerator is %d\n", r1.getNumerator());
        System.out.printf("The denominator is %d\n", r1.getDenominator());
        System.out.printf("Is the rational a whole number? %b\n", r1.isWhole());

        // Create a rational object from char arrays
        char[] arr1 = {'1', '2', '5'};
        char[] arr2 = {'3', '5'};

        Rational r2 = Rational.parseRational(arr1, arr2);
        System.out.printf("The numerator is %d before normalization\n", r2.getNumerator());
        System.out.printf("The denominator is %d before normalization\n", r2.getDenominator());
        r2 = r2.normalize();
        System.out.printf("The numerator is %d\n", r2.getNumerator());
        System.out.printf("The denominator is %d\n", r2.getDenominator());
        System.out.printf("Is the rational a whole number? %b\n", r2.isWhole());

        // Create a rational object from a string
        String s = "9/3";
        Rational r3 = Rational.parseRational(s);
        System.out.printf("The numerator is %d before normalization\n", r3.getNumerator());
        System.out.printf("The denominator is %d before normalization\n", r3.getDenominator());
        r3 = r3.normalize();
        System.out.printf("The numerator is %d\n", r3.getNumerator());
        System.out.printf("The denominator is %d\n", r3.getDenominator());
        System.out.printf("Is the rational a whole number? %b\n", r3.isWhole());
    }
}

class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    private void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    
    private void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public Rational normalize() {
        if (this.numerator == 0) return new Rational(this.numerator, 1);

        int n = Math.min(Math.abs(this.numerator), Math.abs(this.denominator));

        // find current numerator and denominator gcd 
        int gcd = 1;
        for (int divisor = 1; divisor <= n; divisor++) {
            if (this.numerator % divisor == 0 && this.denominator % divisor == 0) {
                gcd = divisor;
            }
        }
        
        // divide the numerator and denominator by the gcd
        return new Rational(this.numerator / gcd, this.denominator / gcd);
    }

    /**
     * isWhole() does the job for isDecimal()
     */
    public boolean isWhole() {
        return this.numerator % this.denominator == 0;
    }

    public boolean equals(int numerator, int denominator) {
        return numerator == denominator;
    }

    public boolean equals(Rational r) {
        return r.getNumerator() == r.getDenominator();
    }

    public static Rational parseRational(char[] numeratorChars, char[] denominatorChars) {
        String s = new String(numeratorChars);
        int numerator = Integer.parseInt(s);

        s = new String(denominatorChars);
        int denominator = Integer.parseInt(s);

        return new Rational(numerator, denominator);
    }

    public static Rational parseRational(String s) {
        String[] arr = s.split("/");
        int numerator = Integer.parseInt(arr[0]);
        int denominator = Integer.parseInt(arr[1]);

        return new Rational(numerator, denominator);
    }

}
