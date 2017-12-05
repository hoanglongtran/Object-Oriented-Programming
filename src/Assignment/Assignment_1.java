/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 1
  Author: Long H. Tran
  ID: s3635165
  Created date: 02/11/2017
*/

package Assignment;

import java.util.Scanner;

public class Assignment_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the string: ");
            String input = in.nextLine();
            int length = input.length();                                                                                //Calculate the length of the input string

            if (input.equals("-1")) {                                                                                   //If the input is "-1", break out of the while loop (exit the program)
                System.out.println("Exit code detected! Program exits");
                break;
            }

            if (check(input, length)) {                                                                                 //Run the method for checking the input string
                System.out.println("Sorted string: " + sortAlphabetical(input, length));                                //If the string contains only letters (the checking method returns TRUE), run the sorting method
            }
        }
    }

    private static boolean check(String in, int len) {                                                                  //This is the method for checking the input string
        for (int n = 0; n < len; n++) {                                                                                 //Run through each character of the input string
            if (!Character.isLetter(in.charAt(n)) || in.charAt(n) == ' ') {
                System.out.println("Invalid input! Please insert letters only");                                        //If detect a non-letter character, display error message
                return false;
            }
        }
        return true;
    }

    private static String sortAlphabetical(String in, int len) {                                                        //This is the method for sorting the input string
        char[] input = in.toCharArray();                                                                                //Turn the input string into character array
        char temp;
        /*The sorting algorithm used is Bubble sort for ease of implement and because of the simplicity of the program.
        It will run through the array, if the current element is smaller than the previous one (based on their ASCII codes),
        swap their position using the temporary variable. The result after one loop is that the largest character will be moved
        to the end of the array. After the loop, the variable "a" will be increase, making the number of array elements in
        sorting process reduce by one element, which is also the largest character at the end of the array*/
        for (int a = 0; a < len; a++) {
            for (int i = 1; i < (len - a); i++) {
                //Turn the uppercase character into lowercase in order to compare them equally and moves all the uppercase letter after the lowercase one (aAAaBbbcCc -> aaAAbbBcC)
                if (Character.toLowerCase(input[i - 1]) > Character.toLowerCase(input[i]) || (input[i - 1] < input[i] && Character.toLowerCase(input[i]) == Character.toLowerCase(input[i - 1]))) {
                    temp = input[i - 1];
                    input[i - 1] = input[i];
                    input[i] = temp;
                }
            }
        }
        return new String(input);                                                                                       //Recombine the character array into string again and return it
    }
}