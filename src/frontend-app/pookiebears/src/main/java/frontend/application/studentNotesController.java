package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class studentNotesController implements Initializable{


    @FXML
    void academicClicked(MouseEvent event) throws IOException{
        App.setRoot("studentAcademic");

    }

    @FXML
    void profileClicked(MouseEvent event) throws IOException {
        App.setRoot("studentHome");

    }

    @FXML
    void whatIfClicked(MouseEvent event) throws IOException {
        App.setRoot("studentWhatIf");

    }



    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     }
    
}
