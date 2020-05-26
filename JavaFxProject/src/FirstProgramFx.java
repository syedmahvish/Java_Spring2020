import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class FirstProgramFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button bt = new Button("Ok");
        Scene s1 = new Scene(bt, 200, 300);
        primaryStage.setTitle("FirstProgram");
        primaryStage.setScene(s1);
        primaryStage.show();

        Stage stage2 = new Stage();

        Button bt1 = new Button("Ok");
        Scene s2 = new Scene(bt1, 100, 300);
        stage2.setTitle("Second");
        stage2.setScene(s2);
        stage2.show();


        stage2.show();


    }

    public static void main(String args[]) {
        Application.launch(args);
    }
}
