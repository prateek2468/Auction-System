package sample.final1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SaleController {

    @FXML
    private TextField phno;

    @FXML

    private TextField amt;
    @FXML
    public void Exit(ActionEvent event) throws Exception
    {
        // these 2 information can be further used for id information and development
        String pno = phno.getText();
        String am = amt.getText();


        System.exit(0);
    }

}
