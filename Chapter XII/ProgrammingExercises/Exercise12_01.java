public class Exercise12_01 {
    public static void main(String[] args) {
        if (args.length != 0) {
            if (args.length == 3) {
                try {
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[2]);
                    char operator = args[1].charAt(0);

                    Calculator calc = new Calculator(x, y, operator);
                    String result = calc.compute();

                    if (result != null) System.out.printf("%d %c %d = %s", x, operator, y, result);
                    else System.out.println("The operation could not be carried on due to an invalid operator.");

                } catch (NumberFormatException e) {
                    String[] splitted = e.getMessage().split(":");
                    System.out.println("Wrong Input: " + splitted[1]);
                }
            }
        } else {
            System.out.println("Usage: java Exercise12_01 <x> <operator> <y>");
        }
    }
}

class Calculator {
    private int x;
    private int y;
    private char operator;

    public Calculator(int x, int y, char operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }

    public String compute() {
        switch (operator) {
            case '-' -> {
                return Integer.toString(x - y);
            }
            case '+' -> {
                return Integer.toString(x + y);
            }
            case '/' -> {
                return Double.toString(x / (double) y);
            }
            case '*' -> {
                return Integer.toString(x * y);
            }
        }
        return null;
    }
}
