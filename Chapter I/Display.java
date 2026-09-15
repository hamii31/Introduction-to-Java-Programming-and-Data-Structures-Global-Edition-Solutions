public class Display
{
    public static void main(String[] args){
        //1.1
        System.out.println("Welcome to Java");
        System.out.println("Learning Java Now");
        System.out.println("Programming is fun");

        //1.2
        for (int i = 0; i < 5; i++){
            System.out.println("I love Java");
        }

        //1.3
        System.out.println("   J ");
        System.out.println("J aaa  v  vaaa");
        System.out.println("J  J aa vv a a");
        System.out.println("J aaaa   v  aaaa");

        //1.4
        System.out.println("aa^2a^3a^4");
        System.out.println("1 1  1  1");
        System.out.println("2 4  8  16");
        System.out.println("3 9 27  81");
        System.out.println("4 16 64 256");

        //1.5
        System.out.println((7.5 * 6.5 - 4.5 * 3) / (47.5 - 5.5));

        //1.6
        int result = 0;
        for (int i = 1; i < 11; i++){
            result += i;
        }
        System.out.println(result);

        //1.7
        double a = 4 * (1.0 - (1.0 / 3.0) + (1.0 / 5.0) - (1.0 / 7.0) + (1.0 / 9.0) - (1.0 / 11.0));
        double b = 4 * (1.0 - (1.0 / 3.0) + (1.0 / 5.0) - (1.0 / 7.0) + (1.0 / 9.0) - (1.0 / 11.0) + (1.0 / 13.0));
        System.out.println((a + b) / 2);

        //1.8
        double pi = 3.14159;
        double radius = 6.5;
        double perimeter = 2 * radius * pi;
        double area = radius * radius * pi;

        System.out.println(perimeter);
        System.out.println(area);

        //1.9
        double width = 5.3;
        double height = 8.6;

        area = width * height;
        perimeter = 2 * (width + height);

        System.out.println(area);
        System.out.println(perimeter);

        //1.10
        int km = 15;
        int minutes = 50;
        int seconds = 30;

        double miles = km / 1.6;
        seconds += minutes * 60;

        int hours = seconds / 3600;

        double mph = miles / hours; 

        System.out.println(mph);

        //1.11
        
    }   
}
