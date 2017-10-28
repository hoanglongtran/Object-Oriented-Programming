package Class;

public class L2E1 {
    public static void main(String[] args) {
        System.out.println("Miles   Kilometers  |   Kilometers  Miles");
        double mile = 0;
        double km = 0;
        for(mile = 1, km = 25; mile <11; mile++, km+=5){
            System.out.format("%f  %f   |   %f      %f\n",mile,mile*1.689,km,km*1.689);
        }
    }
}

