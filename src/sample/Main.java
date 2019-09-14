package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = new AnchorPane();
        primaryStage.setTitle("ROBOCON CLIENT");
        Scene scene = new Scene(root,1800,900);
        primaryStage.setScene(scene);
        PlayGame.play(root);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
