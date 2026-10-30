public class Exercise09_08 {
    public static void main (String args[]) {
        Fan fan1 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOnValue(true);
        System.out.println(fan1.toString());

        Fan fan2 = new Fan();
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOnValue(false);
        System.out.println(fan2.toString());
    }
}

class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = (speed <= 3) ? speed : SLOW;
    }

    public boolean getOnValue() {
        return this.on;
    }

    public void setOnValue(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
    }

    public String toString() {
        if (getOnValue()) {
            return "The fan is on. Fan speed is " + this.speed 
            + ", fan color is " + this.color 
            + ", and fan radius is " + this.radius;
        }

        return "The fan is off. The color of the fan is " + this.color
        + " and the radius of the fan is " + this.radius;
    }
}
