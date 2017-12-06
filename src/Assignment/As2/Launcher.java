/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 2
  Purpose: Get the file directory and launch the program
  Author: Long H. Tran
  ID: s3635165
  Created date: 5/12/2017
  Acknowledgement:


*/

package Assignment.As2;

import java.util.Scanner;
public class Launcher {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //main method of the program
        System.out.printf("Please enter the desired location for the output file: ");
        DataProcessing.setPathDir(input.nextLine());
        System.out.println("Please wait for the program to process the data...");
        DataProcessing.getData();
        DataProcessing.sortData();
        DataProcessing.writeStandingsToFile();
        System.out.println("Done! The text file for teams' standings is now available in your chosen directory");
    }


}

