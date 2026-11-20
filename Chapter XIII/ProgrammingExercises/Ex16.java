/**
* Rational-number calculator
*/
import java.util.ArrayList;

public class Ex16 {
    public static void main(String[] args) {
        if (args.length != 1) System.out.println("USAGE: java Ex16 <expression>");
        else if (args.length == 1) {
            String[] expr = args[0].split(" ");
            Rational operand1 = Rational.parseRational(expr[0]);
            Rational operand2 = Rational.parseRational(expr[2]);

            Rational result = computeRationalExpression(operand1, operand2, expr[1]);

            System.out.println(
                expr[0] + " " + expr[1] + " " + expr[2] + " = " + result.getNumerator() + "/" + result.getDenominator()
            );
        }
    }

    public static Rational computeRationalExpression(Rational operand1, Rational operand2, String operator) {

        switch(operator) {
            case "+" -> {
                int lcm = operand1.computeLCM(operand2);
                return new Rational(
                    (operand1.getNumerator() * operand2.getDenominator()) + (operand2.getNumerator() * operand1.getDenominator()),
                    lcm);
            }
            case "-" -> {
                int lcm = operand1.computeLCM(operand2);
                return new Rational(
                    (operand1.getNumerator() * operand2.getDenominator()) - (operand2.getNumerator() * operand1.getDenominator()),
                    lcm);
            }
            case "*" -> {
                Rational rational = new Rational(
                    operand1.getNumerator() * operand2.getNumerator(),
                    operand1.getDenominator() * operand2.getDenominator());
                return rational.normalize();
            }
            case "/" -> {
                return new Rational(
                    operand1.getNumerator() * operand2.getDenominator(),
                    operand1.getDenominator() * operand2.getNumerator()
                );
            }
        }

        return new Rational(0, 0);
    }
}

// Reusing ex03, chapter 10
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

    // Finds the common denominator by computing the least common multiple
    public int computeLCM(Rational operand2) {
        ArrayList<Integer> commonMultiples1 = computeMultiples(this.denominator);
        ArrayList<Integer> commonMultiples2 = computeMultiples(operand2.denominator);
        for (int i = 1; i < commonMultiples1.size(); i++) {
            int x = commonMultiples1.get(i);

            if (commonMultiples2.contains(x)) {
                return x;
            }
        }

        return 0;
    }

    private ArrayList<Integer> computeMultiples(int denominator) {
        ArrayList<Integer> commonMultiples = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            commonMultiples.add(denominator * i);
        }

        return commonMultiples;

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
