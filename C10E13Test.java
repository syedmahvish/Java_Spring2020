import java.util.InputMismatchException;
import java.util.Scanner;

public class C10E13Test {
    public static void main(String args[]){

        boolean flag = false;
        Scanner scan = new Scanner(System.in);
        int outerLoop = 1;
        boolean middleLoop = false, innerLoop = false;

        C10E13RectangleFigure baseRectangle = null;


        //Default constructor of rectangle.
        C10E13RectangleFigure r1 = new C10E13RectangleFigure();
        System.out.println("\nDefault " + r1.toString());
        System.out.println("Default area of rectangle = " + r1.getArea());
        System.out.println("Default perimeter of rectangle = " + r1.getPerimeter());

        try { // exception handling for Program loop continue input.
            while (outerLoop == 1){

                while (!middleLoop) {
                    try {// exception handling for Base Rectangle input.

                        //Prompt user to enter centre point, height & width of Base rectangle.
                        System.out.println("\nEnter centre points of Base rectangle x & y and height & width of Base rectangle (separated by one space) : ");
                        double x = scan.nextDouble();
                        double y = scan.nextDouble();
                        double height = scan.nextDouble();
                        double width = scan.nextDouble();

                        //Calls parameterised constructor and calculates area and perimeter of base rectangle.
                        baseRectangle = new C10E13RectangleFigure(x, y, height, width);
                        System.out.println("\nArea of rectangle = " + baseRectangle.getArea());
                        System.out.println("Perimeter of rectangle = " + baseRectangle.getPerimeter());
                        middleLoop = true;

                    } catch (InputMismatchException e) {

                        scan.nextLine();
                        System.out.println("\nInvalid input : " + e.getMessage());
                    }
                }

                    while (!innerLoop) { // Continue loop for test Rectangle.

                        try {// exception handling for Test Rectangle input.

                            //Prompt user to enter centre point, height & width of Test rectangle.
                            System.out.println("\nEnter centre points of test rectangle x & y and height & width of test rectangle (separated by one space) : ");
                            double x = scan.nextDouble();
                            double y = scan.nextDouble();
                            double height = scan.nextDouble();
                            double width = scan.nextDouble();

                            //Calls parameterised constructor.
                            C10E13RectangleFigure testRectangle = new C10E13RectangleFigure(x, y, height, width);

                            //Test whether test rectangle is inclusion, overlap and distinctions with base rectangle.
                            System.out.println("Contains point in base rectangle = " + baseRectangle.contains(testRectangle.getX(), testRectangle.getY()));
                            System.out.println("Inclusion test rectangle in base rectangle = " + baseRectangle.contains(testRectangle));
                            System.out.println("Overlaps test rectangle with base rectangle = " + baseRectangle.overlap(testRectangle));
                            System.out.println("Distinction test rectangle with base rectangle = " + baseRectangle.distinct(testRectangle));
                            System.out.println("Abut test rectangle with base rectangle = " + baseRectangle.abut(testRectangle));

                            innerLoop = true;

                        } catch (InputMismatchException e) {

                            scan.nextLine();
                            System.out.println("\nInvalid input : " + e.getMessage());
                        }

                        System.out.println("\nWant to test another rectangle (enter 1 for yes, 0 to quit)? : ");
                        innerLoop = !(scan.nextInt() == 1);
                    }

                System.out.println("\nProgram continue (enter 1 for yes, 0 to quit)? : ");
                outerLoop = scan.nextInt();
                middleLoop = innerLoop = false;
            }

        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println("\nInvalid input : " + e.getMessage());
        }

    }
}
