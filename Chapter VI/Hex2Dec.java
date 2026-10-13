import java.util.Scanner;

// A reworked version of Listing 6.8

public class Hex2Dec {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();

        System.out.printf("The decimal value for hex number %s is %d", hex, hexToDecimal(hex.toUpperCase()));
    }

    private static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++)
            decimalValue = decimalValue * 16 + hexCharToDecimal(hex.charAt(i));

        return decimalValue;
    }

    private static int hexCharToDecimal(char ch) {
        if (Character.isDigit(ch))
            return ch - '0';
        else if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';

        return -1;
    }
}
