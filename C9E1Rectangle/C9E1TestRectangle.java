package DoneProgram.C9E1Rectangle;

import java.util.Scanner;

public class C9E1TestRectangle {

    public static void main(String[] args) {

        int loopProgram = 1;
        Scanner scan = new Scanner(System.in);
        boolean flag = false;

        C9E1RectangleClass r1 = new C9E1RectangleClass();
        System.out.println("Default value of rectangle height and width (separated by one space) : " + r1.getHeight() + " "+ r1.getWidth());
        System.out.println("Default area of rectangle : " + r1.getArea());
        System.out.println("Default perimeter of rectangle : " + r1.getPerimeter());

        try {
            while (loopProgram == 1) {

                while (!flag) {

                    try {

                        System.out.println("\nEnter Rectangle height and width (separated by one space): ");
                        double height = scan.nextDouble();
                        double width = scan.nextDouble();

                        C9E1RectangleClass r2 = new C9E1RectangleClass(height, width);
                        System.out.println("Default area of rectangle : " + r2.getArea());
                        System.out.println("Default perimeter of rectangle : " + r2.getPerimeter());
                        flag = true;

                    } catch (Exception e) {
                        scan.nextLine(); // clears buffer
                        System.out.println("Entered an invalid input : Zero/String/Negative value not allowed for height and width of rectangle.");
                    }
                }

                System.out.println("\nDo you want to continue Program (enter 1 for yes, 0 to quit)? : ");
                loopProgram = scan.nextInt();
                flag = false;

            }
        } catch(Exception e){
            scan.nextLine(); // clears buffer
            System.out.println("Entered an invalid input : " + e.getMessage());
        } // for looping program exception handling.

    }
}
