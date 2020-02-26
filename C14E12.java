import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class C14E12 extends Application{

    /***
     * This method overrides Application start method.
     * It creates bar chart using label, rectangle and gridpane.
     * Label and rectangle are placed on Gridpane.
     * @param primaryStage specify stage where we can display UI (scene). In these case barchart.
     * @throws Exception exception occur while creating/loading UI. So exception is thrown to handle such situation.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,20,10,20));
        pane.setHgap(10);


        Label project =  createLabel("Project--20%");
        Rectangle projRect = createRectangle(pane, Color.RED, .20);

        Label quiz = createLabel("Quiz--10%");
        Rectangle quizRect = createRectangle(pane, Color.BLUE, .10);

        Label midterm = createLabel("Midterm--30%");
        Rectangle midtermRect = createRectangle(pane, Color.GREEN, .30);

        Label finalL = createLabel("Final--40%");
        Rectangle finalRect = createRectangle(pane, Color.ORANGE, .40);

        pane.add(project,3,2,1,1);
        pane.add(projRect,3,0,1,2);

        pane.add(quiz,2,1,1,1);
        pane.add(quizRect,2,0,1,1);

        pane.add(midterm,1,3,1,1);
        pane.add(midtermRect,1,0,1,3);

        pane.add(finalL,0,4,1,1);
        pane.add(finalRect,0,0,1,4);

        pane.setRotate(180);

        Scene s1 = new Scene(pane, 1000, 1000);
        primaryStage.setScene(s1);
        primaryStage.setTitle("Exercise14_12");
        primaryStage.show();

    }


    /***
     * This method create label of specified text.
      * @param labelText specify text of label.
     * @return rotate 180degree label.
     * @throws Exception to handle UI exception.
     */
    private Label createLabel (String labelText) throws Exception {
         Label label = new Label(labelText);
         label.setRotate(180);
         return label;
     }

    /***
     * This method create Rectangle of specified color and height.
     * It also specify height and width property with respect to gridpane.
     * @param pane specify gridpane where rectangle to be placed
     * @param color specify color of rectangle.
     * @param height specify double value of rectangle height ratio.
     * @return Rectangle of specified color and height.
     * @throws Exception to handle UI exception.
     */
     private Rectangle createRectangle (GridPane pane, Color color, double height) throws Exception {
         Rectangle rect = new Rectangle();
         rect.setFill(color);
         rect.widthProperty().bind(pane.widthProperty().divide(4));
         rect.heightProperty().bind(pane.heightProperty().multiply(height));
         return rect;
     }

    /***
     * Main function that contains application launch function.
     * This will launch and display UI.
     * @param args command line argument.
     */
    public static void main(String args[]) {
        try {
            Application.launch(args);
        } catch (Exception e) {
            System.out.println("Exception found: " + e.getMessage());
        }
    }
}
