public class Exercise12_07 {
    public static void main(String[] args) 
        throws NullDenominatorException {
        
        Fraction frac1 = new Fraction(1, 2);
        System.out.println(frac1.computeFraction());

        Fraction frac2 = new Fraction(1, 0);
        System.out.println(frac2.computeFraction());
    }
}

class Fraction {
    private int numerator = 0;
    private int denominator = 0;

    public Fraction (int numerator, int denominator) 
        throws NullDenominatorException {
        
        if (denominator == 0) throw new NullDenominatorException("Denominator cannot be zero.");

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double computeFraction() {
        return numerator / (double) denominator;
    }
}

class NullDenominatorException extends Exception {
    public NullDenominatorException(String message) {
        super(message);
    }
}
