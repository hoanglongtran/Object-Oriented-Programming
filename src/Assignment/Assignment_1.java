package Assignment;

import java.util.Scanner;

public class Assignment_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the string: ");
            String input = in.next();
            int len = input.length();
            if (input.equals("-1")) {
                System.out.println("Exit code detected! Exit the program");
                break;
            }
            if (check(input, len)) {
                System.out.printf("Sorted string: ");
                System.out.println(sortAlphabetical(input));
            }
        }

    }

    private static boolean check(String input, int length) {

        for (int n = 0; n < length; n++) {
            if (!Character.isLetter(input.charAt(n))) {
                System.out.println("Invalid input! Please insert letters only");
                return false;
            }
        }
        return true;
    }

    private static String sortAlphabetical(String n) {
        char[] input = n.toCharArray();
        int length = input.length;

        char temp;
        for (int a = 0; a < length; a++) {
            for (int i = 1; i < (length - a); i++) {
                if (Character.toLowerCase(input[i - 1]) > Character.toLowerCase(input[i])) {
                    temp = input[i - 1];
                    input[i - 1] = input[i];
                    input[i] = temp;

                }
            }

        }
        return new String(input);
    }
}