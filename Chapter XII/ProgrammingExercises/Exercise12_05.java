import java.util.Date;
import java.util.Scanner;

public class Exercise12_05 {
    public static void main(String[] args) 
        throws IllegalTriangleException {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three sides of a triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);

        System.out.println("Enter a color: ");
        String color = input.next();
        triangle.setColor(color);

        System.out.println("True or false -> Is the triangle filled?");
        Boolean filled = input.nextBoolean();
        triangle.setFilled(filled);

        System.out.println("Area of triangle: " + triangle.getArea());
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
        System.out.println("Triangle color: " + triangle.getColor());
        System.out.println("Triangle is filled? " + triangle.isFilled());
    }
}

class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDate() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}

class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) 
        throws IllegalTriangleException {
        
        if (isValid(side1, side2, side3) 
            && isValid(side2, side3, side1) 
            && isValid(side3, side1, side2)) {

            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else {
            throw new IllegalTriangleException("The sum of any two sides must be greater than the third.");
        }
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }
    
    public double getSide3() {
        return side3;
    }

    public double getArea() {
        return (side1 + side2 + side3) / 2.0;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }
        
    public static boolean isValid(double x, double y, double z) {
        return x + y > z;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }
}

class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}
