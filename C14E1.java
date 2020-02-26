
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class C14E1 extends Application {

    /***
     * This method overrides Application start method.
     * It takes image url and create image.
     * Images are placed on Gridpane with centre alignment.
     * @param primaryStage specify stage where we can display UI (scene) and on which image components can be added.
     * @throws Exception exception occur while creating/loading UI or loading images. So exception is thrown to handle such situation.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        ImageView i1 = new ImageView(establishConnection("https://cdn.pixabay.com/photo/2017/03/14/21/00/american-flag-2144392_1280.png"));
        i1.fitHeightProperty().bind(pane.heightProperty().divide(4));
        i1.fitWidthProperty().bind(pane.widthProperty().divide(4));

        ImageView i2 = new ImageView(establishConnection("https://cdn.pixabay.com/photo/2015/11/06/13/29/union-jack-1027898_1280.jpg"));
        i2.fitHeightProperty().bind(pane.heightProperty().divide(4));
        i2.fitWidthProperty().bind(pane.widthProperty().divide(4));


        ImageView i3 = new ImageView(establishConnection("https://cdn.pixabay.com/photo/2012/04/10/23/27/canada-27003_1280.png"));
        i3.fitHeightProperty().bind(pane.heightProperty().divide(4));
        i3.fitWidthProperty().bind(pane.widthProperty().divide(4));


        ImageView i4 = new ImageView(establishConnection("https://cdn.pixabay.com/photo/2017/05/12/09/07/china-2306580_1280.png"));
        i4.fitHeightProperty().bind(pane.heightProperty().divide(4));
        i4.fitWidthProperty().bind(pane.widthProperty().divide(4));


        pane.add(i2, 0, 0, 1, 1);
        pane.add(i3, 1, 0, 1, 1);
        pane.add(i1, 1, 1, 1, 1);
        pane.add(i4, 0, 1, 1, 1);

        Scene s1 = new Scene(pane, 200, 200);
        primaryStage.setScene(s1);
        primaryStage.setTitle("Exercise14_01");
        primaryStage.show();


    }

    /***
     * This method creates url connection for loading image through URL.
      * @param url image url
     * @return Image after creating and establishing secure connection for image.
     * @throws IOException while loading image, exception can occur. So throw exception to handle such situation.
     */
    private Image establishConnection(String  url) throws IOException {

        String imgUrl = url;
        URLConnection connection = new URL(imgUrl).openConnection();
        connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        Image image = new Image(connection.getInputStream());
        return image;
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
