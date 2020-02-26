import javafx.geometry.Point2D;
import java.util.InputMismatchException;

/***
 * This class extends super class Geometric figure.
 * It uses super class method getArea() and getPerimeter().
 * It also perform function to verify if one rectangle is inclusion, overlap and distinctions with other rectangle.
 */

public class C10E13RectangleFigure extends C10E13GeometricFigure {

    private double x, y;
    private double width, height;

    /***
     * Default constructor.
     * Set default centre point = (0,0) and height = 1 and width = 1;
     * @throws InputMismatchException handles exception check.
     */
    C10E13RectangleFigure() throws InputMismatchException {
        super();
        setX(0.0);
        setY(0.0);
        setHeight(1.0);
        setWidth(1.0);
    }

    /***
     * Parameterised constructor set values for centre point of rectangle and width and height of rectangke.
     * @param x x- coordinate of centre point of rectangle.
     * @param y y- coordinate of centre point of rectangle.
     * @param height value of height of rectangle.
     * @param width value of width of rectangle.
     * @throws InputMismatchException handles exception check.
     */
    C10E13RectangleFigure(double x, double y, double height, double width) throws  InputMismatchException{
        setX(x);
        setY(y);
        setHeight(height);
        setWidth(width);
    }

    /***
     * Set x-coordinate of centre point of rectangle.
     * @param value x-coordinate value.
     * @throws InputMismatchException handles exception check.
     */
    public void setX(double value) throws InputMismatchException {
        this.x = value;
    }

    /***
     * Set y-coordinate of centre point of rectangle.
     * @param value y-coordinate value.
     * @throws InputMismatchException handles exception check.
     */
    public void setY(double value) throws InputMismatchException {
        this.y = value;
    }

    /***
     * Set height of rectangle.
     * It validates if height value is non-zero and positive.
     * If so assign height to rectangle else throws exception.
     * @param value height of rectangle.
     */
    public void setHeight(double value) {
        if(isValid(value)){
            this.height = value;
        } else {
            throw new InputMismatchException("Invalid value : Zero/Negative value not allowed for height and width of rectangle");
        }
    }

    /***
     * Set width of rectangle.
     * It validates if width value is non-zero and positive.
     * If so assign width to rectangle else throws exception.
     * @param value width of rectangle.
     */
    public void setWidth(double value)  {
        if(isValid(value)){
            this.width = value;
        } else {
            throw new InputMismatchException("Invalid value : Zero/Negative value not allowed for height and width of rectangle");
        }
    }

    /***
     * Provide access to x-coordinate of centre point of rectangle.
     * @return double value of x-coordinate of centre point of rectangle.
     */
    public double getX(){
        return x;
    }

    /***
     * Provide access to y-coordinate of centre point of rectangle.
     * @return double value of y-coordinate of centre point of rectangle.
     */
    public double getY(){
        return y;
    }

    /***
     * Provide access to height of rectangle.
     * @return double value of height of rectangle.
     */
    public double getHeight(){
        return height;
    }

    /***
     * Provide access to width of rectangle.
     * @return double value of width of rectangle.
     */
    public double getWidth(){
        return width;
    }

    /***
     * This method checks if given value is non-zero and positive.
     * @param value whose validation need to be perform. It can be height or width of rectangle.
     * @return true if value is valid, else false.
     */
    public boolean isValid(double value){
        if(value > 0 && value <= Double.MAX_VALUE)
            return true;
        return false;
    }

    /***
     * Overrides getArea() method of superclass to find area of rectangle.
     * @return double value of area of rectangle.
     */
    @Override
    public double getArea() {
        return height * width;
    }

    /***
     * Overrides getPerimeter() method of superclass to find perimeter of rectangle.
     * @return double value of perimeter of rectangle.
     */
    @Override
    public  double getPerimeter() {
        return 2 * (height + width);
    }

    /***
     * Checks if given point lies within Base Rectangle.
     * @param x1 x-coordinate of point.
     * @param y1 y-coordinate of point.
     * @return true if points lies within Base Rectangle else false.
     */
    public boolean contains(double x1, double y1) {
        Point2D bottomLeft =  getPoints(x, y , height, width, true);
        Point2D topRight =  getPoints( x, y , height, width, false);

        if((x1 >= bottomLeft.getX() && y1 >= bottomLeft.getY()) && ( x1 <= topRight.getX() && y1 <= topRight.getY())){
            return  true;
        }

        return false;
   }

    /***
     * Checks if given Test Rectangle lies completely within Base Rectangle.
     * @param R Object of Test Rectangle.
     * @return true if Test Rectangle lies completely within Base Rectangle else false.
     */
   public  boolean contains(C10E13RectangleFigure R){
      Point2D bottomLeft = getPoints(R.x, R.y , R.height, R.width, true);
      Point2D topRight = getPoints(R.x, R.y , R.height, R.width, false);

      return (contains(bottomLeft.getX() , bottomLeft.getY()) && contains( topRight.getX() , topRight.getY()));
  }

    /***
     * Checks if given Test Rectangle overlaps Base Rectangle.
     * @param R Object of Test Rectangle.
     * @return true if Test Rectangle overlaps Base Rectangle else false.
     */
  public boolean overlap(C10E13RectangleFigure R) {
      Point2D startPoints = getPoints(R.x, R.y , R.height, R.width, true);
      Point2D endPoints = getPoints(R.x, R.y , R.height, R.width, false);

      //if two rectangle shares only boundary points they will not overlaps.
      if(abut(R)) {
          return false;
      }

      if((contains(startPoints.getX() , startPoints.getY())) || (contains(endPoints.getX(), endPoints.getY()))){
          return true;
      }else {
          return false;
      }
  }

    /***
     *  Checks if given Test Rectangle distinction with Base Rectangle.
      * @param R Object of Test Rectangle.
     * @return true if Test Rectangle distinction with Base Rectangle else false.
     */
  public boolean distinct(C10E13RectangleFigure R) {
        Point2D startPoints = getPoints(R.x, R.y , R.height, R.width, true);
        Point2D endPoints = getPoints(R.x, R.y , R.height, R.width, false);

        if((contains(startPoints.getX() , startPoints.getY())) == false && (contains(endPoints.getX(), endPoints.getY())) == false){
            return true;
        }else {
            return false;
        }
    }

    /***
     * Checks if given Test Rectangle Abut with Base Rectangle.
     * @param R Object of Test Rectangle.
     * @return true if Test Rectangle Abut with Base Rectangle else false.
     */
    public boolean abut(C10E13RectangleFigure R){
        Point2D bottomLeft1 = getPoints(x, y , height, width, true);
        Point2D topRight1 = getPoints(x, y , height, width, false);

        Point2D bottomLeft2 = getPoints(R.x, R.y , R.height, R.width, true);
        Point2D topRight2 = getPoints(R.x, R.y , R.height, R.width, false);

        if(((bottomLeft2.getY() + R.getHeight()) == topRight1.getY()) && (bottomLeft2.getX() == topRight1.getX())) { return true; }
        if(((bottomLeft2.getX() + R.getWidth()) == topRight1.getX()) && (bottomLeft2.getY() == topRight1.getY())) { return true; }
        if(((topRight2.getY() - R.getHeight()) == bottomLeft1.getY()) && (topRight2.getX() == bottomLeft1.getX())) { return true; }
        if(((topRight2.getX() - R.getWidth()) == bottomLeft1.getX()) && (topRight2.getY() == bottomLeft1.getY()))   { return true; }

        return false;
     }

    /***
     * This method calculates bottomLeft or topRight corner points of rectangle.
     * @param x1 x-coordinate of centre point.
     * @param y1 y-coordinate of centre point.
     * @param height height value of rectangle.
     * @param width width value of rectangle.
     * @param isStartPoint if true, calculates bottomLeft point else topRight corner point of Rectangle.
     * @return Points of rectangle with x and y coordinate.
     */
    public Point2D getPoints (double x1, double y1, double height , double width, boolean isStartPoint){
      Point2D point;

        if(isStartPoint) {
            point = new Point2D((x1 - (width / 2)), (y1 - (height / 2)));
        }else{
            point  = new Point2D( (x1 + (width / 2)),   (y1 + (height / 2)));
        }

      return point;
  }

    /***
     * Overrides tostring() method of superclass to display message.
     * @return message string.
     */
  @Override
  public  String toString(){
       return "Rectangle : " + " Centre Point : (" + getX() + " ," + getY() + ") , Height : " +  getHeight() + ", Width : " + getWidth();
  }



}
