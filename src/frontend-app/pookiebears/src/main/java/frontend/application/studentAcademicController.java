package frontend.application;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import frontend.application.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class studentAcademicController implements Initializable{
    @FXML
    private TextField textField;

    @FXML
    private TextArea studentProgress;

    private RoadmapApplication application;
 
    

    @FXML
    void profileClicked(MouseEvent event) throws IOException {
        App.setRoot("studentHome");

    }
 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       application = RoadmapApplication.getInstance();
        studentProgress.setText(application.printStudentProgress());
        
    }


    
}
