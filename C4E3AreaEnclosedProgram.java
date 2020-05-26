package DoneProgram.C9E1Rectangle;

import java.util.Scanner;



/**
 * In this program latitude and longitude of four cities are provided in degree.
 * It calculates area enclosed by four cities.
 */

public class C4E3AreaEnclosedProgram {
    final static  double EARTH_RADIUS = 6371.01;

    public static void main(String[] args){
        //Declare lattitude and longitude of all four cities.
        final double ATLANTA_LATTITUDE = 33.7490, ATLANTA_LONGITUDE = 84.3880;
        final double ORLANDO_LATTITUDE = 28.5383, ORLANDO_LONGITUDE = 81.3792;
        final double SAVANNAH_LATTITUDE = 32.0809, SAVANNAH_LONGITUDE = 81.0912;
        final double  CHARLOTTE_LATTITUDE = 35.2271, CHARLOTTE_LONGITUDE = 80.8431;


        double side1, side2, side3 ;
        double areaBetweenCities = 0;

        int repeatProgram = 1;

        Scanner readInput = new Scanner(System.in);

        //Convert degree value into radian.
        double ATLANTA_X = Math.toRadians(ATLANTA_LATTITUDE), ATLANTA_Y =  Math.toRadians(ATLANTA_LONGITUDE);
        double CHARLOTTE_X = Math.toRadians(CHARLOTTE_LATTITUDE), CHARLOTTE_Y = Math.toRadians(CHARLOTTE_LONGITUDE);
        double SAVANNAH_X = Math.toRadians(SAVANNAH_LATTITUDE), SAVANNAH_Y = Math.toRadians(SAVANNAH_LONGITUDE);
        double ORLANDO_X = Math.toRadians(ORLANDO_LATTITUDE), ORLANDO_Y = Math.toRadians(ORLANDO_LONGITUDE);


        while(repeatProgram == 1) {

            System.out.println("Lattitude and Longitude values of four cities are (in degree) : ");
            System.out.println("Atlanta,Georgia : " + ATLANTA_LATTITUDE + " " + ATLANTA_LONGITUDE);
            System.out.println("Orlando, Florida : " + ORLANDO_LATTITUDE + " " + ORLANDO_LONGITUDE);
            System.out.println("Savannah, Georgia : " + SAVANNAH_LATTITUDE + " " + SAVANNAH_LONGITUDE);
            System.out.println("Charlotte, North Carolina : " + CHARLOTTE_LATTITUDE+ " " + CHARLOTTE_LONGITUDE);


            //calculating distance between two cities using great circle distance formula.
            side1 = C4E3AreaEnclosedProgram.distanceBetweenTwoPoints(ATLANTA_X, ATLANTA_Y, CHARLOTTE_X, CHARLOTTE_Y);
            side2 = C4E3AreaEnclosedProgram.distanceBetweenTwoPoints(ATLANTA_X, ATLANTA_Y, SAVANNAH_X, SAVANNAH_Y);
            side3 = C4E3AreaEnclosedProgram.distanceBetweenTwoPoints(CHARLOTTE_X, CHARLOTTE_Y, SAVANNAH_X, SAVANNAH_Y);

            //Displaying distance between cities.
            System.out.println("\n" + "Distance between four cities are (in km) : ");
            System.out.println("The distance between Atlanta and Charlotte is: " + side1);
            System.out.println("The distance between Atlanta and Savannah is: " + side2);
            System.out.println("The distance between Savannah and Charlotte is: " + side3);

            //Calculating area formed by three cities Atlanta, Charlotte and Savannah using area of Triangle formula.
            areaBetweenCities += C4E3AreaEnclosedProgram.triangleArea(side1, side2, side3);

            //calculating distance between two cities using great circle distance formula.
            side1 = C4E3AreaEnclosedProgram.distanceBetweenTwoPoints(ATLANTA_X,ATLANTA_Y,ORLANDO_X,ORLANDO_Y);
            side2 = C4E3AreaEnclosedProgram.distanceBetweenTwoPoints(ATLANTA_X,ATLANTA_Y,SAVANNAH_X,SAVANNAH_Y);
            side3 = C4E3AreaEnclosedProgram.distanceBetweenTwoPoints(ORLANDO_X,ORLANDO_Y,SAVANNAH_X,SAVANNAH_Y);

            //Displaying distance between cities.
            System.out.println("The distance between Atlanta and Orlando is: " + side1);
            System.out.println("The distance between Savannah and Orlando is: " + side3);

            //Calculating area formed by three cities Atlanta, Orlando and Savannah using area of Triangle formula and
            //final area between four cities.
            areaBetweenCities += C4E3AreaEnclosedProgram.triangleArea(side1, side2, side3);

            System.out.println("\n" + "Area formed by four cities namely Atlanta,Charlotte,Savannah and orlando is " + areaBetweenCities + "kms");

            System.out.println("\n" + "Program continue (enter 1 for yes, 0 to quit)? : ");
            repeatProgram = readInput.nextInt();
        }
    }

    /***
     * Calculates distance between two city using great circle distance formula.
     * @param x1 X- coordinate of city 1.
     * @param y1 Y- coordinate of city 1.
     * @param x2 X- coordinate of city 2.
     * @param y2 Y- coordinate of city 2.
     * @return distance between two city.
     */
    public static double distanceBetweenTwoPoints(double x1,double y1,double x2,double y2) {
       return EARTH_RADIUS * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
    }

    /***
     * Calculates area formed by three cities using area of Triangle formula..
     * @param side1 value of first side of triangle
     * @param side2 value of second side of triangle
     * @param side3 value of third side of triangle
     * @return area of triangle.
     */
    public static double triangleArea(double side1,double side2,double side3) {
        double intermediateResult = (side1 + side2 + side3) / 2;
        return Math.sqrt(intermediateResult * (intermediateResult - side1) * (intermediateResult - side2)
                * (intermediateResult - side3));
    }
}
