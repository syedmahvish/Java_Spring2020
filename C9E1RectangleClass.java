package DoneProgram.C9E1Rectangle;

import java.util.InputMismatchException;

/***
 * @author Syed Mahvish
 * This program accepts height and width of Rectangle
 * Calculate area and perimeter of Rectangle.
 */
class C9E1RectangleClass {

    private double height;
    private double width;

    /***
     * Default constructor which initialize height and width of Rectangle to 1.0 and 1.0 respectively.
     */
    C9E1RectangleClass(){
        setHeight(1.0);
        setWidth(1.0);
    }

    /***
     * This constructor initialize height and width of Rectangle with given value.
     * @param height value of height of rectangle.
     * @param width value of width of rectangle.
     */
    C9E1RectangleClass(double height, double width) throws InputMismatchException {
        setHeight(height);
        setWidth(width);
    }



    /***
     * Setter method for rectangel height.
     * It perform validation and then assign value.
     * If value is unexceptable it prompts message.
     * @param height value of height of rectangle.
     */
    public void setHeight(double height) throws  InputMismatchException {
        this.height = getValidValue(height);
    }

    /***
     * Setter method for rectangel width.
     * It perform validation and then assign value.
     * If value is unexceptable it prompts message.
     * @param width value of width of rectangle.
     */
    public void setWidth(double width) throws  InputMismatchException {
        this.width = getValidValue(width);
    }

    /***
     * This method provides value of rectangle's height.
     * @return double value of height of rectangle.
     */
    public double getHeight(){
        return height;
    }

    /***
     * This method provides value of rectangle's width.
     * @return double value of width of rectangle.
     */
    public double getWidth(){
        return width;
    }

    /***
     * This method calculates area of rectangle.
     * @return double value of area of rectangle.
     */
    public double getArea() {
        return height * width;
    }

    /***
     * This method calculates perimeter of rectangle.
     * @return double value of perimeter of rectangle.
     */
    public double getPerimeter(){
        return (2 * (height + width));
    }

    /***
     * This method handles exception and returns valid value.
     * @param value checks validation. If valid returns value, else prompt user to enter valid value.
     * @return
     */
    public double getValidValue(double value) {
        if (isValid(value)) {
            return value;
        }
        throw new InputMismatchException("Invalid value : Zero/Negative value not allowed for height and width of rectangle");
    }

    /***
     * Perform validation of given value.
     * It checks if value is positive and within limit.
     * It throws NumberFormatException to avoid any crash when input is invalid.
     * @param value whose validation need to be check.
     * @return boolean result, true if provided value is valid else false.
     */
    public boolean isValid(double value) {
        if(value > 0 && value <= Double.MAX_VALUE)
            return true;
        return false;
    }


}

