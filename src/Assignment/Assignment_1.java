package Assignment;
import java.util.Scanner;

public class Assignment_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter the string: ");
        String input = in.next();
        int len = input.length();
        if (check(input, len)) {
            System.out.println(sortAlphabetical(input, len));
        }
    }

    private static boolean check(String input, int length) {

        for (int n = 0; n <= length; n++) {
            if (!Character.isLetter(input.charAt(n))) {
                System.out.println("Please insert letters only");
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private static String sortAlphabetical(String n, int length) {
        String result = "";
        for (int a = 0; a < length; a++) {
            if (n.charAt(a) > n.charAt(a + 1)) {
                result += n.charAt(a) + n.charAt(a + 1);
            }
            return result;

        }
        return null;
    }
}