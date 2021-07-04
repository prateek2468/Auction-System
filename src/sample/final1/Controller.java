package sample.final1;

import com.google.zxing.WriterException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Controller {
    // in this we will call all the classes corresponding to the options displayed
    // first one we will have the login page for the user where they will enter there password
    @FXML
    public void adminlogin(ActionEvent event) throws Exception
    {
        //msg.setText("yolo");
        Parent pane;

        try
        {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Admin_login.fxml"));
            Scene scene = new Scene(pane);
            Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            curStage.setScene(scene);
            curStage.show();
        }catch(IOException e)
        {
            System.out.println(e);
        }

    }
    //Here we will directly go to the bidding area for all 3 objects and register our bids
    //if the bids are highest then we can proceed to the payment area

    @FXML
    public void bid(ActionEvent event) throws Exception
    {

        Parent pane;

        try
        {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Bidding.fxml"));
            Scene scene = new Scene(pane);
            Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            curStage.setScene(scene);
            curStage.show();
        }catch(IOException e)
        {
            System.out.println(e);
        }

    }

    // in this QR code is generated for the money to be paid
    @FXML
    public void sell(ActionEvent event)
    {
        // before the start of this final window in which we do payment we will first generate the Qr code
        try {
            Random rand = new Random();
            int rant = rand.nextInt(1000);
            String a = Integer.toString(rant);
            Qr qr = new Qr(a);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
        // calling the sale window

        Parent pane;

        try
        {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Sale.fxml"));
            Scene scene = new Scene(pane);
            Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            curStage.setScene(scene);
            curStage.show();
        }catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
