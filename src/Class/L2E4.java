package Class;
import java.util.Scanner;
public class L2E4 {
    public static void main(String[] args) {
        System.out.print("Insert the number: ");
        Scanner s = new Scanner(System.in);
        float input = s.nextInt();
        System.out.println("The result from right to left: " + calculate_Right_To_Left(input));
        System.out.println("The result from left to right: " + calculate_Left_To_Right(input));
    }
    private static Double calculate_Right_To_Left(float n){
        double result;
        result = 0;
        while (n>0){
            result += 1/n;
            n--;
        }
        return result;
    }

    private static Double calculate_Left_To_Right(float m){
        double result = 0;
        for (float a = 1; a <= m; a++ ){
            result += 1/a;
        }
        return result;
    }
}
