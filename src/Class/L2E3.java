package Class;

import java.util.Scanner;

public class L2E3 {
    private static String sep = " ";

    private static String printPyramid(int n) {
        String output = "";
        for (int i=1; i<n+1; i++)
            output += spaceIt(n-i) + symmetricalize(i) + spaceIt(n-i) + "\n";
        return output;
    }

    /**
     * give n, returns : n n-1 n-2 ... n-2 n-1 n (e.g. give 3, return "3 2 1 2 3")
     */
    private static String symmetricalize(int i) {
        String result = "";
        int start = i;          //save the number
        while (i>0)             //keep decrementing until 1 and adding separator
            result += i-- + sep;
        i++;                    // from 0 skip 1
        while (++i<=start)      //keep incrementing and adding separator
            result += i + sep;
        return result;
    }

    /**
     * give n, returns : n*(" "+sep)
     */
    private static String spaceIt(int n) {
        String result = "";
        while (n-->0)
            result += " "+sep;
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please insert input number :");
        int input = s.nextInt();
        System.out.println(printPyramid(input));
        s.close();
    }
}