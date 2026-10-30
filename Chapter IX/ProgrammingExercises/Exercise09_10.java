public class Exercise09_10 {
    public static void main (String[] args) {
        QuadraticEquation qe = new QuadraticEquation(-2.3, 4.7, 9.2);
        double discriminant = qe.getDiscriminant();
        if (discriminant > 0) {
            System.out.printf("r1: %.2f\n", qe.getRoot1());
            System.out.printf("r2: %.2f\n", qe.getRoot2());
        } else if (discriminant == 0) {
            System.out.printf("r1: %.2f\n", qe.getRoot1());
        } else {
            System.out.println("The equation has no roots.");
        }
    }
}

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * (a * c);
    }

    public double getRoot1() {
        if (getDiscriminant() > 0) {
            return (-this.b + Math.sqrt(Math.pow(this.b, 2) - 4 * (a * c))) / (2 * a);
        }
        return 0;
    }

    public double getRoot2() {
        if (getDiscriminant() > 0) {
            return (-this.b - Math.sqrt(Math.pow(this.b, 2) - 4 * (a * c))) / (2 * a);
        }
        return 0;
    }
}
