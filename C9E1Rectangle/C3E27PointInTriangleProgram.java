package DoneProgram.C9E1Rectangle;

import java.util.Scanner;

/**
 * In this program a triangle is given.
 * It accepts a point form user.
 * Checks whether points lies within or outside the triangle.
 */

public class C3E27PointInTriangleProgram {
    public static void main(String[] args) {

        final double X1 = 0 ,X2 =200, X3 = 0;
        final double Y1 = 0 ,Y2 = 0 , Y3 = 100;
        double areaOfTriangle , area1 , area2, area3, totalArea;

        double newPointX, newPointY;
        int repeatProgram = 1;

        Scanner readInput = new Scanner(System.in);

        System.out.println("The given triangle coordinates are (separated by one space): " + X1 + " " + Y1 + " " + X2 + " " + Y2 + " " + X3 + " " + Y3);

        //Calculating area of original triangle.
        areaOfTriangle = areaTriangle(X1, Y1, X2, Y2, X3, Y3);

        while(repeatProgram == 1) {

            //Accepts a new point to determine it lies within or outside given traingle.
            System.out.println("Enter a point's x- and y-coordinates (separated by one space): ");
            newPointX = readInput.nextDouble();
            newPointY = readInput.nextDouble();

            //Calculating area of triangle with new a Point.
             area1 = areaTriangle(X1, Y1, X2, Y2, newPointX, newPointY);
             area2 = areaTriangle(X1, Y1, X3, Y3, newPointX, newPointY);
             area3 = areaTriangle(X2, Y2, X3, Y3, newPointX, newPointY);

             //Sum of all areas of traingles.
             totalArea = area1 + area2 + area3;

             //If area of all triangles is equals to original one, then
             //New Point lie within traingle else outside.
            if(totalArea == areaOfTriangle){
                System.out.println("The point is in the triangle.");
            }else{
                System.out.println("The point lies outside the triangle.");
            }

            System.out.println("\n" + "Program continue (enter 1 for yes, 0 to quit)? : ");
            repeatProgram = readInput.nextInt();
        }

    }

       /***
     * It accepts three points and calculate area of triangle.
     * @param x1  x-coordinate of first point of triangle.
     * @param y1  y-coordinate of first point of triangle.
     * @param x2  x-coordinate of second point of triangle.
     * @param y2  y-coordinate of second point of triangle.
     * @param x3  x-coordinate of third point of triangle.
     * @param y3  y-coordinate of third point of triangle.
     * @return area of Right angled triangle.
     */
    static double areaTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs(((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2))) / 2.0);
    }

}
