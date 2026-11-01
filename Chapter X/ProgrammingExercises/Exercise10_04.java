public class Exercise10_04 {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 30.5);
        System.out.printf("The distance between p1 and p2 is: %.2f", MyPoint.distance(p1, p2));
    }
}

class MyPoint {
    private double x = 0;
    private double y = 0;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distance(MyPoint p2) {
        return distance(p2.getX(), p2.getY());
    }

    public double distance(double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - this.x, 2) + Math.pow(y2 - this.y, 2));
    }

    public static double distance(MyPoint p1, MyPoint p2) {
        return p1.distance(p2);
    }
}
