public class IllegalTriangleException extends Exception {

    IllegalTriangleException(){
        getMessage();
    }

    @Override
    public String getMessage(){
        return "Invalid sides for Triangle. Cannot calculate area or perimeter of triangle.";
    }

}
