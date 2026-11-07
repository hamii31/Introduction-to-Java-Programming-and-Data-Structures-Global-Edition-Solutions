import java.util.*;

public class Exercise11_18 {
    public static void main (String argsp[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        ArrayList<Character> chars = toCharacterArray(input.next());

        for (char ch : chars) {
            System.out.printf("%c, ", ch);
        }
    }

    public static ArrayList<Character> toCharacterArray(String s) {
        return toChars(s.getBytes());
    }

    /**
     * Methods taken straight from the String class and adapted to the exercise
     * Instead of a char array, the methods use an ArrayList<Character>
     */
    static ArrayList<Character> toChars(byte[] value) {
        ArrayList<Character> dst = new ArrayList<>();
        inflate(value, 0, dst, 0, value.length);
        return dst;
    }

    static void inflate(byte[] src, int srcOff, ArrayList<Character> dst, int dstOff, int len) {
        for (int i = 0; i < len; i++) {
            dst.add((char)(src[srcOff++] & 0xff));
        }
    }
}
