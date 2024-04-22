package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class advisorViewAdviseeController implements Initializable{

    @FXML
    void noteClicked(MouseEvent event) throws IOException {
        App.setRoot("advisorAddNote");

    }

    @FXML
    void planClicked(MouseEvent event) throws IOException {
        App.setRoot("advisorViewSemesterPlan");

    }

    @FXML
    void progressClicked(MouseEvent event) throws IOException{
        App.setRoot("advisorViewProgress");

    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    
}
