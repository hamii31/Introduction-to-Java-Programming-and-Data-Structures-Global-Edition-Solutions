public class DecimalsToHex {
    public static void main(String[] args) {
        final int N = 16;
        int d = 1234;
        String hexademical = "";
        int quotent = d;

        do { 
            // Get the quotent and remainder
            quotent = quotent / N;
            int remainder = d - (quotent * N);

            // update d to hold the current quotent
            d = quotent;
            System.out.printf("The quotent is %d and the remainder is %d\n", quotent, remainder);
            // Convert the remainder to hexademical
            if (remainder != 0) {
                // Append the old hexademical value to the back of the new one and assign to the variable
                hexademical = convertDecimalValueToHexademical(remainder) + hexademical;
            }
        } while (quotent != 0);

        System.out.printf("%s is the hexademical number for %d", hexademical, d);
    }

    private static String convertDecimalValueToHexademical(int decimal) {
        switch (decimal) {
            case 0 -> { return "0";}
            case 1 -> { return "1";}
            case 2 -> { return "2";}
            case 3 -> { return "3";}
            case 4 -> { return "4";}
            case 5 -> { return "5";}
            case 6 -> { return "6";}
            case 7 -> { return "7";}
            case 8 -> { return "8";}
            case 9 -> { return "9";}
            case 10 -> { return "A";}
            case 11 -> { return "B";}
            case 12 -> { return "C";}
            case 13 -> { return "D";}
            case 14 -> { return "E";}
            case 15 -> { return "F";}
        }

        return null;
    }
}
