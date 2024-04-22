package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.RoadmapApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    @FXML
    private TableView<Class> classTable;
    
    private RoadmapApplication application;

    @FXML
    private TableColumn<Class, String> notes;



    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        application = RoadmapApplication.getInstance();
        
     }
    
}
