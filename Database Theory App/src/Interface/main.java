package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        primaryStage.setTitle("Database Theory Tool");
        primaryStage.setScene(new Scene(root, 368, 283));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("iMac-icon.png")));
        primaryStage.show();
    }


}