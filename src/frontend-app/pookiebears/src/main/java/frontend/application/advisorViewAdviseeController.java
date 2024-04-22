package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.RoadmapApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class advisorViewAdviseeController implements Initializable{

    private RoadmapApplication application;

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

    @FXML
    void logOutClicked(MouseEvent event) throws IOException{
        if(application.logout()) {
            App.setRoot("login");
        }

    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        application = application.getInstance();
    }

    
}
