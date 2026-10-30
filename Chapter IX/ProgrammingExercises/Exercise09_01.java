public class Exercise09_01 {
  public static void main(String[] args) {
    Rectangle rectangle1 = new Rectangle(4, 40);
    System.out.println("Rectangle 1:");
    System.out.printf("  width: %.2f\n", rectangle1.width);
    System.out.printf("  height: %.2f\n", rectangle1.height);
    System.out.printf("  area: %.2f\n", rectangle1.getArea());
    System.out.printf("  perimeter: %.2f\n", rectangle1.getPerimeter());

    Rectangle rectangle2 = new Rectangle(3.5, 35.9);
    System.out.println("Rectangle 2:");
    System.out.printf("  width: %.2f\n", rectangle2.width);
    System.out.printf("  height: %.2f\n", rectangle2.height);
    System.out.printf("  area: %.2f\n", rectangle2.getArea());
    System.out.printf("  perimeter: %.2f\n", rectangle2.getPerimeter());
  }
}

class Rectangle {
    double width;
    double height;

    public Rectangle() {
      this.width = 1;
      this.height = 1;
    }

    public Rectangle(double width, double height) {
      this.width = width;
      this.height = height;
    }
    
    public double getArea() {
      return this.width * this.height;
    }
    
    public double getPerimeter() {
      return 2 * (this.width + this.height); 
    }

}
