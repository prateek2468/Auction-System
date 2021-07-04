package sample.final1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//initailly we will load the main or the central page which is coded in the Sample.fxml
// and in the Sample.fxml we will have 3 options 1.>Admin- login
//                                                2.> Bid
//                                                  3.> Buy
//
//

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Final");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
