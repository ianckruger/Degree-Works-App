package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import frontend.application.App;
import backend.*;


public class startScreenController implements Initializable {

    @FXML
    void getStarted(MouseEvent event) throws Exception{
        App.setRoot("login");


    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
