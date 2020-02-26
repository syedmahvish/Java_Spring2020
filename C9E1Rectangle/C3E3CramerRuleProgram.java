package DoneProgram.C9E1Rectangle;

import java.util.Scanner;

/**
 * This program accepts six number and apply Cramer's Rule.
 * The result shows whether equation has solution or not.
 */

public class C3E3CramerRuleProgram {
    public static void main(String[] args){

        double a, b, c, d, e, f;
        double intermediateResult;

        int repeatProgram = 1;

        Scanner readInput = new Scanner(System.in);

        //loop program
        while(repeatProgram == 1) {
            //Accepts input from user.
            System.out.println("Enter six numbers value for a,b,c,d,e,f (separated by single space) : ");
            a = readInput.nextDouble();
            b = readInput.nextDouble();
            c = readInput.nextDouble();
            d = readInput.nextDouble();
            e = readInput.nextDouble();
            f = readInput.nextDouble();

            System.out.println("Entered value for a,b,c,d,e,f are : " + a + " " + b + " " + c + " " + d + " " + e + " " + f);

            intermediateResult = (a * d) - (b * c);

            // if intermediateResult is zero, print no solutions and quit
            if (intermediateResult == 0)
                System.out.println("The equation has no solution");
            else {
                // apply cramer's rule to find value of x and y.
                double x = (e * d - b * f) / intermediateResult;
                double y = (a * f - e * c) / intermediateResult;

                System.out.println("x is " + x + " and y is " + y);
            }

            System.out.println("Program continue (enter 1 for yes, 0 to quit)? : ");
            repeatProgram = readInput.nextInt();
        }
    }
}
