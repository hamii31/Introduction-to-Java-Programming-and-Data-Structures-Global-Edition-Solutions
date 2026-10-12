public class Solutions {
    // 6.2.1
    private static int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    // 6.3.2
    private static double method(double i, double j) {
        while (true) {
            if (i > j) {
                return j;
            }
            
            j--;
        }
    }

    // 6.4.4
    private static double salesCommission(double salesAmount, double commissionRate) { return 0.0;}
    private static void displayCalendar(int month, int year) {}
    private static double sqrt(double number) { return 0.0; }
    private static boolean isEven(int number) { return true; }
    private static void display(String message, int n) {}
    private static double monthlyPayment(double loanAmount, int years, double annualRate) { return 0.0; }
    private static char correspondingUppercase(char letter) { return 0; }

    // 6.4.5
    private static void method1(int n, int m) {
        n += m;
        System.out.println(method2(n));
    }
    private static int method2(int n) {
        if (n < 0) 
            return 1;
        else if (n == 0) 
            return 0;
        return -1;
    }

    // 6.5.2
    private static void nPrintln(String message, int n) {
        for (int i = 0; i < n; i++)
            System.out.println(message);
    }


    public static void main(String[] args) {
        // 6.2.1
        System.out.println(max(3, 5));
        System.out.println(max(-2, 1));

        // 6.4.5
        method1(2, 3);

        // 6.5.2
        nPrintln("Welcome to Java!", 5);
    }
}
