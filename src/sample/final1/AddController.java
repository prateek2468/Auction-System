package sample.final1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AddController extends Firebase {


    @FXML
    private TextField sculpamt;
    @FXML
    private Text scultext;
    @FXML
    public void getInitSculp(ActionEvent event)throws IOException
    {   // taking the input written in the input Box and showing saved when we click on save
        String scamt = sculpamt.getText();
        scultext.setText("Saved");

        // uploading the initial value on the firebase realtime database under different field using REST Api method


        super.put("item" , scamt);
        System.out.println(super.get("item"));
    }

    @FXML
    private TextField coinamt;
    @FXML
    private Text cointext;
    @FXML
    public void getInitCoin(ActionEvent event)throws IOException
    {
        // taking the input written in the input Box and showing saved when we click on save
        String coamt = coinamt.getText();
        cointext.setText("Saved");


        // uploading the initial value on the firebase realtime database under different field using REST Api method

        super.put("item2" , coamt);
        System.out.println(super.get("item2"));

    }

    @FXML
    private TextField othamt;
    @FXML
    private Text othtext;
    @FXML
    public void getInitOth(ActionEvent event)throws IOException
    {
        // taking the input written in the input Box and showing saved when we click on save
        String otamt = othamt.getText();
        othtext.setText("Saved");

        // uploading the initial value on the firebase realtime database under different field using REST Api method

        super.put("item3" , otamt);
        System.out.println(super.get("item3"));
    }



    @FXML
    public void goHome(ActionEvent event) throws Exception
    {
        // going back to the home screen as we click on home button
        Parent pane;

        try
        {
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
    public void exit(ActionEvent event)throws IOException
    {
        // ending the function as we click on exit

        System.exit(0);
    }

    @FXML
    private Circle logo;
}
