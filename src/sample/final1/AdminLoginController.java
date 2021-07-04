package sample.final1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

// In this we will enter the password which is "password" and user name is displayed and the photo of the user also
// displayed and all these fields can be further used to enhance the experience
public class AdminLoginController {

    @FXML
    private Label msg;
    @FXML
    private PasswordField pass;
    @FXML
    public void getpassword(ActionEvent event) throws IOException
    {
        Parent pane;
        String password = pass.getText();
        System.out.println(password);
        // accessing the entered password and checking it
        if(password.equals("password"))
        {
            System.out.println("Correct");
            msg.setText("valid");
            //FROM HERE WE NAVIGATE TO INITIAL BID PAGE
            try
            {
                pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Add.fxml"));
                Scene scene = new Scene(pane);
                Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                curStage.setScene(scene);
                curStage.show();
            }catch(IOException e)
            {
                System.out.println(e);
            }
        }

        else
        {
            System.out.println("Incorrect");
            msg.setText("Invalid!");
        }
    }

}
