import java.util.Scanner;

public class ComputeTaxes { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter filing status (0 for single, 1 for married filing jointly or qualified widow(er), 2 for married filing separately, and 3 for head of household): ");
        int status = input.nextInt();

        System.out.println("Please enter taxable income: ");
        double income = input.nextDouble();

        double tax = 0.0;
        if (status == 0) {
            double remainder = income - 8_350;

            if (remainder < 0) {
                tax += income * 0.10;
            }
            else if (income > 8_350 && income <= 33_950) {
                tax += (income - remainder) * 0.10; // tax the income within the 10% marginal tax rate
                tax += remainder * 0.15; // tax the rest within the 15% range
            }
            else if (income > 33_950 && income <= 82_250) {
                tax += (income - remainder) * 0.10; // tax the income within the 10%
                tax += (33_950 - 8_350) * 0.15; // tax the income wthin the 15% range
                tax += (income - 33_950) * 0.25; // tax the income within the 25% range
            }
            else if (income > 82_550 && income <= 171_550) {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (82_550 - 33_950) * 0.25;
                tax += (income - 82_550) * 0.28;
            }
            else if (income > 171_550 && income <= 372_950) {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (82_550 - 33_950) * 0.25;
                tax += (171_550 - 82_550) * 0.28;
                tax += (income - 171_550) * 0.33;
            }
            else {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (82_550 - 33_950) * 0.25;
                tax += (171_550 - 82_550) * 0.28;
                tax += (372_950 - 171_550) * 0.33;
                tax += (income - 372_950) * 0.35;
            }
        }
        else if (status == 1) {
             double remainder = income - 16_700;

            if (remainder < 0) {
                tax += income * 0.10;
            }
            else if (income > 16_700 && income <= 67_900) {
                tax += (income - remainder) * 0.10; 
                tax += remainder * 0.15;
            }
            else if (income > 67_900 && income <= 137_050) {
                tax += (income - remainder) * 0.10;
                tax += (67_900 - 16_700) * 0.15;
                tax += (income - 67_900) * 0.25;
            }
            else if (income > 137_050 && income <= 208_850) {
                tax += (income - remainder) * 0.10;
                tax += (67_900 - 16_700) * 0.15;
                tax += (137_050 - 67_900) * 0.25;
                tax += (income - 137_050) * 0.28;
            }
            else if (income > 208_850 && income <= 372_950) {
                tax += (income - remainder) * 0.10;
                tax += (67_900 - 16_700) * 0.15;
                tax += (137_050 - 67_900) * 0.25;
                tax += (208_850 - 137_050) * 0.28;
                tax += (income - 208_850) * 0.33;
            }
            else {
                tax += (income - remainder) * 0.10;
                tax += (67_900 - 16_700) * 0.15;
                tax += (137_050 - 67_900) * 0.25;
                tax += (208_850 - 137_050) * 0.28;
                tax += (372_950 - 288_850) * 0.33;
                tax += (income - 372_950) * 0.35;
            }
        }
        else if (status == 2) {
             double remainder = income - 8_350;

            if (remainder < 0) {
                tax += income * 0.10;
            }
            else if (income > 8_350 && income <= 33_950) {
                tax += (income - remainder) * 0.10; 
                tax += remainder * 0.15;
            }
            else if (income > 33_950 && income <= 68_525) {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (income - 33_950) * 0.25;
            }
            else if (income > 68_525 && income <= 104_425) {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (68_525 - 33_950) * 0.25;
                tax += (income - 68_525) * 0.28;
            }
            else if (income > 104_425 && income <= 186_475) {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (68_525 - 33_950) * 0.25;
                tax += (104_425 - 68_525) * 0.28;
                tax += (income - 104_425) * 0.33;
            }
            else {
                tax += (income - remainder) * 0.10;
                tax += (33_950 - 8_350) * 0.15;
                tax += (68_525 - 33_950) * 0.25;
                tax += (104_425 - 68_525) * 0.28;
                tax += (186_475 - 104_425) * 0.33;
                tax += (income - 186_475) * 0.35;
            }
        }
        else if (status == 3) {
             double remainder = income - 11_950;

            if (remainder < 0) {
                tax += income * 0.10;
            }
            else if (income > 11_950 && income <= 45_500) {
                tax += (income - remainder) * 0.10; 
                tax += remainder * 0.15;
            }
            else if (income > 45_500 && income <= 117_450) {
                tax += (income - remainder) * 0.10;
                tax += (45_500 - 11_950) * 0.15;
                tax += (income - 45_500) * 0.25;
            }
            else if (income > 117_450 && income <= 190_200) {
                tax += (income - remainder) * 0.10;
                tax += (45_500 - 11_950) * 0.15;
                tax += (117_450 - 45_500)* 0.25;
                tax += (income - 117_450) * 0.28;
            }
            else if (income > 190_200 && income <= 372_950) {
                tax += (income - remainder) * 0.10;
                tax += (45_500 - 11_950) * 0.15;
                tax += (117_450 - 45_500)* 0.25;
                tax += (190_200 - 117_450) * 0.28;
                tax += (income - 190_200) * 0.33;
            }
            else {
                tax += (income - remainder) * 0.10;
                tax += (45_500 - 11_950) * 0.15;
                tax += (117_450 - 45_500)* 0.25;
                tax += (190_200 - 117_450) * 0.28;
                tax += (372_950 - 190_200) * 0.33;
                tax += (income - 372_950) * 0.35;
            }
        }
        else {
            System.out.println("Error: invalid status");
            System.exit(1);
        }
        System.out.println("Tax is " + (int)(tax * 100) / 100.0);
    }
}
