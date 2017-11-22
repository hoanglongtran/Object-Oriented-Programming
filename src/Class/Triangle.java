package Class;

import java.util.Scanner;
public class Triangle extends SimpleGeometricObject  {

    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    private Triangle() {
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    private double getArea(){
        double s = (side1 + side2 + side3);
        return Math.sqrt(s*(s - side1)*(s-side2)*(s-side3));
    }
    private double getPerimeter(){
        return side1 + side2 + side3;
    }

    public String toString(){
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

    public static void main(String[] args) {
        Triangle tri = new Triangle();
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter first side: ");
        double side1 = in.nextDouble();
        System.out.printf("Enter second side: ");
        double side2 = in.nextDouble();
        System.out.printf("Enter third side: ");
        double side3 = in.nextDouble();
        in.nextLine();
        System.out.printf("Enter color: ");
        String color = in.nextLine();
        System.out.printf("Filled or no filled? ");
        Boolean filled = in.nextBoolean();
        System.out.println(tri);
        tri.setColor(color);
        tri.setFilled(filled);
        System.out.println(tri.getArea());
        System.out.println(tri.getPerimeter());
        System.out.println(tri.isFilled());
        System.out.println(tri.getColor());
    }
}
