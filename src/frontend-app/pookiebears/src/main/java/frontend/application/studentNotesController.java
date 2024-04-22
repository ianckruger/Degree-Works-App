package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.RoadmapApplication;
import backend.Student;
import backend.UserList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

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
    private TextArea textField;
    
    private RoadmapApplication application;

    @FXML
    void logOutClicked(MouseEvent event) throws IOException{
        if(application.logout()) {
            App.setRoot("login");
        }
 
    }

    @FXML
    void semesterPlanClicked(MouseEvent event) throws IOException {
        App.setRoot("studentSemesterPlan");

    }


    @FXML
    private Text notes;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        application = RoadmapApplication.getInstance();
        UserList users = UserList.getInstance();
        Student student = (Student)users.getActive();
        
        
        

            textField.setText(student.getNote());
       


        



     }
    
}
