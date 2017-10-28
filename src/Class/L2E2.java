package Class;

public class L2E2 {
    public static void main(String[] args) {
        int num = 100;
        int a =0;
        for(num=100; num <=200; num++){

            if((num%5==0 && num%6!=0) || (num%6==0 && num%5!=0) ){
                System.out.print(num + " ");
                a++;
            }
            if(a == 10){
                System.out.print("\n");
                a = 0;
            }
        }
    }

}
