import java.util.InputMismatchException;
import java.util.Scanner;

public class C11E1Test {
    public static void main(String args[]) throws IllegalTriangleException {

        boolean flag = false;
        Scanner scan = new Scanner(System.in);
        int outerLoop = 1;



        //Calls default constructor.
        //assign default value of 1 to all sides of triangle.
        //handle exception for invalid side value which encounter while calculating area or perimeter of Triangle.
        try {

            C11E1TriangleFigure t1 = new C11E1TriangleFigure();
            System.out.println("\nDefault sides of triangle : " + t1.toString());
            System.out.println("Default area of triangle = " + t1.getArea());
            System.out.println("Default perimeter of triangle = " + t1.getPerimeter());

        } catch (InputMismatchException | IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

        while (outerLoop == 1) {
            try {// handles InputMismatchException and IllegalTriangleException exceptions.

                //Prompt user to enter sides of triangle.
                System.out.println("\nEnter side1, side2 , side3 of triangle (separated by one space) : ");
                double side1 = scan.nextDouble();
                double side2 = scan.nextDouble();
                double side3 = scan.nextDouble();

                //Prompt user to enter triangle color and isfill value.
                System.out.println("\nEnter color of triangle and Is filled or not (separated by one space) : ");
                String color = scan.next();
                boolean fill = scan.nextBoolean();

                //Calls parameterised constructor and set color and fill.
                C11E1TriangleFigure t2 = new C11E1TriangleFigure(side1, side2 , side3);
                t2.setColor(color);
                t2.setFill(fill);

                System.out.println(t2.toString());
                System.out.println("Color of triangle = " + t2.getColor());
                System.out.println("Is color filled in triangle = " + t2.getFilled());
                System.out.println("Area of triangle = " + t2.getArea());
                System.out.println("Perimeter of triangle = " + t2.getPerimeter());


            } catch (InputMismatchException | IllegalTriangleException e) {
                scan.nextLine();
                System.out.println(e.getMessage());
            }

            System.out.println("\nProgram continue (enter 1 for yes, 0 to quit)? : ");
            outerLoop = scan.nextInt();
        }

    }
}
