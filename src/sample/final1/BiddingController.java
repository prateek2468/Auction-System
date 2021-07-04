package sample.final1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BiddingController {

    @FXML
    public void goHome(ActionEvent event) throws Exception
    //goes back to the main page
    {
        Parent pane;
        System.out.println("Bidding go to home");
        try
        {
            // loads the home screen
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(pane);
            Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            curStage.setScene(scene);
            curStage.show();
        }catch(IOException e)
        {
            System.out.println(e);
        }

    }

    @FXML
    Label label1;

    @FXML
    Label label2;

    @FXML
    Label label3;
    @FXML
    private TextField CBid;

    @FXML
    private TextField SBid;

    @FXML
    private TextField OBid;

    Firebase fb = new Firebase();
    Double a = 0.0 , b = 0.0 , c = 0.0;

    public void initialize(){
        // showing of the price in the 3 labels below the 3 photos
        // getting all the highest bid from the firebase database
         a = fb.get("item");
         b = fb.get("item2");
         c = fb.get("item3");

        label1.setText( "$ " + a.toString());
        label2.setText("$ " + b.toString());
        label3.setText("$ "+ c.toString());
    }



    double sqlPresentBid(int i)//This returns the present bid value of all the three items
    {
        String s = "";
        if(i == 1) {
             s = CBid.getText();
             CBid.setText(" ");
        }else if(i == 2){
            s = SBid.getText();
            SBid.setText(" ");
        }else{
            s = OBid.getText();
            OBid.setText(" ");
        }
        return Double.parseDouble(s);
    }


    @FXML
    public void Exit(ActionEvent event) throws Exception
    {
        // exiting the program
        System.exit(0);
    }

    // for Coins

    @FXML
    private void CshowBid(ActionEvent event)throws Exception
    {
        // getting the current value and bidding value and comparing them and if the new bid value is larger then get
        // it to be displayed on the screen
        double CPreValue = sqlPresentBid(1);

        if(CPreValue > a){
            fb.put("item" , String.valueOf(CPreValue));
            initialize();
        }
    }

    //For Sculptures
    @FXML
    private void SshowBid(ActionEvent event)throws Exception
    {
        // getting the current value and bidding value and comparing them and if the new bid value is larger then get
        // it to be displayed on the screen
        double SPreValue = sqlPresentBid(2);//Pre-present
        if(SPreValue > b){
            fb.put("item2" , String.valueOf(SPreValue));
            initialize();
        }
    }

    //For Others

    @FXML
    private void OshowBid(ActionEvent event)throws Exception
    {
        // getting the current value and bidding value and comparing them and if the new bid value is larger then get
        // it to be displayed on the screen
        double OPreValue = sqlPresentBid(3);//Pre-present
        if(OPreValue > c){
            fb.put("item3" , String.valueOf(OPreValue));
            initialize();
        }

    }

}
