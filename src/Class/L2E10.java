package Class;

import java.util.Scanner;
public class L2E10 {
    public static void main(String[] args) {
        //initialize things
        int row;
        int column;
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the the size of the array");
        System.out.print("Enter the number of row: ");
        row = s.nextInt();
        System.out.print("Enter the number of column: ");
        column = s.nextInt();
        int[][] Array = new int[row][column];
        int tem_row, tem_col;
        //Prompt users to enter the values
        for (tem_row = 0; tem_row <= (row - 1); tem_row++ ){
            for (tem_col=0;tem_col <= (column - 1);tem_col++){
                System.out.printf("Enter the value for row " + tem_row + " and column " + tem_col + ": ");
                Array[tem_row][tem_col] = s.nextInt();
            }
        }
        //Display the array
        for (tem_row = 0; tem_row <= (row - 1); tem_row++ ){
            for (tem_col = 0; tem_col <= (column - 1); tem_col++){
                System.out.print(Array[tem_row][tem_col] + " ");
            }
            System.out.println();
        }
        if (row < 4 && column >= 4){                                                                                    //if rows are less than 4, only check for horizontal
            System.out.printf("The row is less than 4, only check for horizontal match\n");
            check_Horizontal(Array, row, column);
        }else if (column < 4 && row >= 4){                                                                              //if columns are less than 4, only check for vertical
            System.out.printf("The column is less than 4, only check for vertical match\n");
            check_Vertical(Array, row, column);
        }else if (row < 4){                                                                                             //if both are less than 4, stop the program
            System.out.printf("There are not enough rows and columns to perform comparing");
            return;
        }
        else{                                                                                                           //if both are more than 4, check everything
            check_Horizontal(Array, row, column);
            check_Vertical(Array, row, column);
            check_Diagonal(Array, row, column);
        }
        if (!check_Horizontal(Array, row, column) && !check_Vertical(Array, row, column) && !check_Diagonal(Array, row, column)){                               //if there are no matches
            System.out.printf("There are no equal values in either 4 consecutive row or column ");

        }
    }
    //Function for checking horizontal
    private static Boolean check_Horizontal(int[][] Array, int row, int column ){
        boolean result = false;
        for (int tem_row = 0; tem_row <= (row-1 ); tem_row++){                                                          //check each row
            for (int tem_col = 0; tem_col <= (column-4 ); tem_col++){                                                   //start checking from the element that is 4 columns away from the last element
                if (Array[tem_row][tem_col] == Array[tem_row][tem_col+1] && Array[tem_row][tem_col]==Array[tem_row][tem_col+2] && Array[tem_row][tem_col]==Array[tem_row][tem_col+3]){  //compare the current elements with the next 3
                    System.out.format("There is 4 equal values horizontally starting from [%d][%d]\n", tem_row, tem_col); //notify the coordinate if there is a match
                    result = true;
                }
            }
        }
        return result;
    }
    //Function for checking vertical
    private static Boolean check_Vertical(int[][] Array, int row, int column ){
        boolean result = false;
        for (int tem_col = 0; tem_col <= (column-1 ); tem_col++){                                                       //check each column
            for (int tem_row = 0; tem_row <= (row-4 ); tem_row++){                                                      //start checking from the element that is 4 rows away from the last element
                if (Array[tem_row][tem_col] == Array[tem_row+1][tem_col] && Array[tem_row][tem_col]==Array[tem_row+2][tem_col] && Array[tem_row][tem_col]==Array[tem_row+3][tem_col]){  //compare the current elements with the next 3
                    System.out.format("There is 4 equal values vertically starting from [%d][%d]\n", tem_row, tem_col); //notify the coordinate if there is a match
                    result = true;
                }
            }
        }
        return result;
    }
    private static Boolean check_Diagonal(int[][] Array, int row, int column){
        boolean result = false;
        for (int tem_col = 0; tem_col <= (column-4); tem_col++){                                                        //check each column
            for (int tem_row = 0; tem_row <= (row-4); tem_row++){                                                      //start checking from the element that is 4 rows away from the last element
                if (Array[tem_row][tem_col] == Array[tem_row+1][tem_col+1] && Array[tem_row][tem_col]==Array[tem_row+2][tem_col+2] && Array[tem_row][tem_col]==Array[tem_row+3][tem_col+3]){  //compare the current elements with the next 3
                    System.out.format("There is 4 equal values Diagonally starting from [%d][%d]\n", tem_row, tem_col); //notify the coordinate if there is a match
                    result = true;
                }
            }
        }
        return result;
    }
}
