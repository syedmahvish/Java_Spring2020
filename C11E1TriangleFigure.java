import java.util.InputMismatchException;

/***
 * This class extends super class Geometric figure.
 * It uses super class method getArea() and getPerimeter().
 * It also perform function to verify given sides of triangle are valid or not.
 */
public class C11E1TriangleFigure extends C10E13GeometricFigure{

    private double side1, side2, side3;
    String color;
    boolean filled;

    /***
     * Default constructor.
     * Set default sides value = 1 of triangle;
     * @throws InputMismatchException handles exception check for illegal sides of triangle.
     */
    C11E1TriangleFigure() throws IllegalTriangleException {
        super();
        setSide1(1.0);
        setSide2(1.0);
        setSide3(1.0);
    }

    /***
     * Parameterised constructor set values for sides of triangle.
     * @param side1 first side of triangle.
     * @param side2 second side of triangle.
     * @param side3 third side of triangle.
     * @throws IllegalTriangleException handles exception check for illegal sides of triangle.
     */
    C11E1TriangleFigure(double side1, double side2, double side3) throws IllegalTriangleException {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }

    /***
     * Assign value to first side of triangle.
     * It also checks if side of triangle is non-zero and positive.
     * Perform exception handling for invalid input.
     * @param side1  value of first side of triangle.
     * @throws InputMismatchException handles exception check for invalid value of sides of triangle.
     */
    public void setSide1(double side1) throws InputMismatchException {
        if(isValid(side1)){
            this.side1 = side1;
        }else{
            throw new InputMismatchException("Invalid value : Zero/Negative value not allowed for length of triangle");
        }

    }

    /***
     * Assign value to second side of triangle.
     * It also checks if side of triangle is non-zero and positive.
     * Perform exception handling for invalid input.
     * @param side2 value of second side of triangle.
     * @throws InputMismatchException handles exception check for invalid value of sides of triangle.
     */
    public void setSide2(double side2) throws InputMismatchException {
        if(isValid(side2)){
            this.side2 = side2;
        }else{
            throw new InputMismatchException("Invalid value : Zero/Negative value not allowed for length of triangle");
        }
    }

    /***
     * Assign value to third side of triangle.
     * It also checks if side of triangle is non-zero and positive.
     * Perform exception handling for invalid input.
     * @param side3 value of third side of triangle.
     * @throws InputMismatchException handles exception check for invalid value of sides of triangle.
     */
    public void setSide3(double side3) throws InputMismatchException{
        if(isValid(side3)){
            this.side3 = side3;
        }else{
            throw new InputMismatchException("Invalid value : Zero/Negative value not allowed for length of triangle");
        }
    }

    /***
     * Set color of triangle to given color.
     * @param color string value specifies color of triangle.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /***
     * Specify if triangle is filled with given color or not.
     * @param fill true if triangle is filled else false.
     */
    public void setFill(boolean fill) {
        this.filled = fill;
    }

    /***
     * To get of color of triangle
     * @return string value of triangle color.
     */
    public String getColor() {
        return color;
    }

    /***
     * To determine of triangle is filled with given color or not.
     * @return boolean value true if filled else false.
     */
    public boolean getFilled() {
        return filled;
    }

    /***
     * Provide access to the value of first side of triangle.
     * @return double value of first side of triangle.
     */
    public double getSide1(){
        return side1;
    }

    /***
     * Provide access to the value of second side of triangle.
     * @return double value of second side of triangle.
     */
    public double getSide2(){
        return side2;
    }

    /***
     * Provide access to the value of third side of triangle.
     * @return double value of third side of triangle.
     */
    public double getSide3(){
        return side3;
    }

    /***
     * Determine given value is valid side of triangle.
     * It checks if value is greater than zero and positive.
     * @param value whose validation need to be perform.
     * @return true if valid, else false.
     */
    public boolean isValid(double value){
        if(value > 0 && value <= Double.MAX_VALUE)
            return true;
        return false;
    }

    /***
     * Determine if all sides of triangle are valid or not.
     * It checks sum of any two sides should be greater than third side.
     * @return true if valid else false.
     */
    public boolean isValidTriangle() {
       if(((side1 + side2 ) > side3) && ((side2 + side3 ) > side1) && ((side1 + side3 ) > side2)){
           return true;
       } else {
           return false;
       }
    }

    /***
     * Overrides getArea() method of superclass to find area of triangle.
     * @return double value of area of rectangle.
     * @throws IllegalTriangleException If invalid sides of triangle are given then cannot calculate area of triangle.
     * Hence exception is thrown.
     *
     */

    @Override
    public double getArea() throws IllegalTriangleException {
        if(isValidTriangle()) {
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }else{
            throw new IllegalTriangleException();
        }
    }

    /***
     * Overrides getPerimeter() method of superclass to find area of triangle.
     * @return double value of perimeter of rectangle.
     * @throws IllegalTriangleException If invalid sides of triangle are given then cannot calculate perimeter of triangle.
     * Hence exception is thrown.
     *
     */
    @Override
    public double getPerimeter() throws IllegalTriangleException {
        if(isValidTriangle()) {
            return  (side1 + side2 + side3);
        }else{
            throw new IllegalTriangleException();
        }
    }

    /***
     * Overrides tostring() method of superclass to display message.
     * @return message string.
     */
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}
