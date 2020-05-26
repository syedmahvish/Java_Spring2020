package DoneProgram.C9E1Rectangle;

import java.util.InputMismatchException;
import java.util.Scanner;

class LinearEquation {
    private double a, b, c, d, e, f ;

    LinearEquation(double a, double b, double c, double d, double e, double f){
        setA(a);
        setB(b);
        setC(c);
        setD(d);
        setE(e);
        setF(f);
    }

    LinearEquation(){

    }

    /***
     * This method set value of variable a.
     * It also handle null pointer exception.
     * @param a value for variable a.
     */
    public void setA(double a) {
        this.a = a;
    }

    /***
     * This method set value of variable b.
     * It also handle null pointer exception.
     * @param b value for variable a.
     */
    public void setB(double b) {
        this.b = b;
    }

    /***
     * This method set value of variable c.
     * It also handle null pointer exception.
     * @param c value for variable a.
     */
    public void setC(double c) {
        this.c = c;
    }

    /***
     * This method set value of variable d.
     * It also handle null pointer exception.
     * @param d value for variable a.
     */
    public void setD(double d) {
        this.d = d;
    }

    /***
     * This method set value of variable e.
     * It also handle null pointer exception.
     * @param e value for variable a.
     */
    public void setE(double e) {
        this.e = e;
    }

    /***
     * This method set value of variable f.
     * It also handle null pointer exception.
     * @param f value for variable a.
     */
    public void setF(double f) {
        this.f = f;
    }

    /***
     * This method returns value of variable a.
     * @return double value of a.
     */
     public double getA(){
        return a;
    }

    /***
     * This method returns value of variable b.
     * @return double value of b.
     */
    public double getB(){
        return b;
    }

    /***
     * This method returns value of variable c.
     * @return double value of c.
     */
    public double getC(){
        return c;
    }

    /***
     * This method returns value of variable d.
     * @return double value of d.
     */
    public double getD(){
        return d;
    }

    /***
     * This method returns value of variable e.
     * @return double value of e.
     */
    public double getE(){
        return e;
    }

    /***
     * This method returns value of variable f.
     * @return double value of f.
     */
    public double getF(){
        return f;
    }

    /**
     * This method checks whether given linear Equation has solution or not.
     * If not found any solution, it prompts message.
     * @return boolean value indicating true if equation has solution else false.
     */
    public boolean isSolvable(){
        if(((a * d) - (b * c)) == 0){
            System.out.println("This equatiom has no solution");
            return false;
        }else
            return true;
    }


    /***
     * This method checks if eqution has solution, if so return solution for linear eqution.
     * Else  return 0.
     * @return x-value of equation.
     */
    public double getX(){
       if(isSolvable())
           return ((e * d - b * f) / (a * d - b * c));
       else
           return 0;
    }

    /***
     * This method checks if eqution has solution, if so return solution for linear eqution.
     * Else  return 0.
     * @return y-value of equation.
     */
    public double getY(){
        if(isSolvable())
            return ((a * f - e * c) / (a * d - b * c));
        else
            return 0;
    }


}

public class C9E11LinearEquationProgram {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int loopProgram = 1;
        double a = 0 , b = 0, c = 0, d = 0, e = 0, f = 0 ;
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0 , y3 = 0, x4 = 0, y4 = 0;
        boolean flag = false;


        while (loopProgram == 1) {
            System.out.println("\nEnter value for Linear Equation variable a,b,c,d,e,f (separated by one space) : ");
            while (!flag) {
                try {
                    a = scan.nextDouble();
                    b = scan.nextDouble();
                    c = scan.nextDouble();
                    d = scan.nextDouble();
                    e = scan.nextDouble();
                    f = scan.nextDouble();
                    flag = true;
                } catch(InputMismatchException e1){
                  scan.nextLine(); // clears buffer
                  System.out.println(e1.getMessage());
                  System.out.println("\n Enter valid numeric value (separated by one space):");
            }
          }

                LinearEquation l1 = new LinearEquation(a, b, c, d, e, f);
                if (l1.isSolvable()) {
                    System.out.println("Solution for linear Equation X-Value = " + l1.getX());
                    System.out.println("Solution for linear Equation Y-Value = " + l1.getY());
                }
               flag = false;


                System.out.println("\nEnter x1, y1, x2, y2, x3, y3, x4, y4 (separated by one space) : ");

               while (!flag) {
                   try {
                       x1 = scan.nextDouble();
                       y1 = scan.nextDouble();
                       x2 = scan.nextDouble();
                       y2 = scan.nextDouble();
                       x3 = scan.nextDouble();
                       y3 = scan.nextDouble();
                       x4 = scan.nextDouble();
                       y4 = scan.nextDouble();
                       flag = true;
                   } catch (InputMismatchException e1) {
                       scan.nextLine(); // clears buffer
                       System.out.println(e1.getMessage());
                       System.out.println("\n Enter valid numeric value (separated by one space):");
                   }
               }

                LinearEquation l2 = new LinearEquation();

                l2.setA(y4 - y3);
                l2.setB(x4 - x3);
                l2.setC(y2 - y1);
                l2.setD(x2 - x1);
                l2.setE((x4 * y3) - (x3 * y4));
                l2.setF((x2 * y1) - (x1 * y2));

                if (l2.isSolvable()) {
                    System.out.println("The intersecting point is at (" + -(l2.getX()) + ", " + l2.getY() + " )");
                } else {
                    System.out.println("The two lines are parallel.");
                }

                System.out.println("\n" + "Program continue (enter 1 for yes, 0 to quit)? : ");
                loopProgram = scan.nextInt();
                flag = false;
            }

    }

}
