/***
 * This is super class for Rectangle and triangle.
 * This class provide generalize method getArea() and getPerimeter() to its subclasses.
 */
public class C10E13GeometricFigure {

    /***
     * Default constructor.
     * Can override by subclasses.
     */
    C10E13GeometricFigure(){ }

    /***
     * This method calculates area of geometric figure.
     * It provide default implementation.
     * Subclasses can override and provide specific implementation.
     * @return double value of area.
     * @throws IllegalTriangleException provide exception handling for subclasses.
     */
    public double getArea() throws IllegalTriangleException {
        return  0.0;
    }

    /***
     * This method calculates perimeter of geometric figure.
     * It provide default implementation.
     * Subclasses can override and provide specific implementation.
     * @return double value of perimeter.
     * @throws IllegalTriangleException provide exception handling for subclasses.
     */
    public double getPerimeter() throws IllegalTriangleException {
        return 0.0;
    }

    /***
     * This method used to display message.
     * @return string of message.
     */
    public  String toString(){
        return "";
    }

}
