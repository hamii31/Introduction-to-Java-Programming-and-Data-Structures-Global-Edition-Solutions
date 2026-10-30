public class Exercise09_09 {
    public static void main (String[] args) {
        RegularPolygon rp1 = new RegularPolygon();
        System.out.printf("The perimeter for rp1 is %.2f\n", rp1.getPerimeter());
        System.out.printf("The area for rp1 is %.2f\n", rp1.getArea());

        RegularPolygon rp2 = new RegularPolygon(6, 4);
        System.out.printf("The perimeter for rp2 is %.2f\n", rp2.getPerimeter());
        System.out.printf("The area for rp2 is %.2f\n", rp2.getArea());

        RegularPolygon rp3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.printf("The perimeter for rp3 is %.2f\n", rp3.getPerimeter());
        System.out.printf("The area for rp3 is %.2f\n", rp3.getArea());
    }
}

class RegularPolygon {

    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    public RegularPolygon() {
    }

    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return getN() * getSide();
    }

    public double getArea() {
        return (getN() * Math.pow(getSide(), 2)) / (4 * Math.tan(Math.PI / getN()));
    }
    
}
