package frontend.application;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import frontend.application.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import backend.*;

public class studentProfileController implements Initializable {
    @FXML
    void academicClicked(MouseEvent event) throws IOException {
        App.setRoot("studentAcademic");

    }
    

     @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


}
