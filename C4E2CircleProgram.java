package DoneProgram.C9E1Rectangle;

import java.util.Scanner;

/**
 * This program accepts latitude and longitude of two
 * points on the earth in degrees.
 * It displays its great circle distance between two points.
 */

public class C4E2CircleProgram {
    public static void main(String[] args) {

        final double EARTH_RADIUS = 6371.01;
        //double x1, y1, x2, y2;
        double distance;
        double x1Radian, x2Radian, y1Radian, y2Radian;

        int repeatProgram = 1;

        Scanner readInput = new Scanner(System.in);

        //loop program
        while (repeatProgram == 1) {

            //Accepts first point latitude and longitude of earth in degree and convert it to Radian.
            System.out.println("Enter point 1 (latitude and longitude) in degrees(separated by one space) :");
            x1Radian =  Math.toRadians(readInput.nextDouble());
            y1Radian = Math.toRadians(readInput.nextDouble());

            //Accepts first point latitude and longitude of earth in degree and convert it to Radian.
            System.out.println("Enter point 2 (latitude and longitude) in degrees(separated by one space) :");
            x2Radian = Math.toRadians(readInput.nextDouble());
            y2Radian = Math.toRadians(readInput.nextDouble());


            //Calculate distance between two points.
            double sinValueofX = Math.sin(x1Radian) * Math.sin(x2Radian);
            double cosValueofX = Math.cos(x1Radian) * Math.cos(x2Radian);
            double cosValueofY = Math.cos(y1Radian - y2Radian);

            distance = EARTH_RADIUS * Math.acos(sinValueofX + cosValueofX * cosValueofY);

            System.out.println("The distance between the two points is " + distance + " km.");

            System.out.println("Program continue (enter 1 for yes, 0 to quit)? : ");
            repeatProgram = readInput.nextInt();
        }
    }
}
