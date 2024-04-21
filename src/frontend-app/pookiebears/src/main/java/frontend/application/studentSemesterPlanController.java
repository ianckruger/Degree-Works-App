package frontend.application;

 
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import backend.*;
import backend.Class;
import java.io.IOException;



 
public class studentSemesterPlanController implements Initializable {
    @FXML
    private TableView<Class> classTable;

    @FXML
    private TableColumn<Class, String> courseNumber;

    @FXML
    private TableColumn<Class, String> courseTitle;

    @FXML
    private TableColumn<Class, String> credits;

    @FXML
    private TableColumn<Class, String> prereg;

    @FXML
    private TableColumn<Class, String> subjectCode;

    private RoadmapApplication application;


    void NoteClicked(MouseEvent event) throws IOException {
        App.setRoot("studentNotes");

    }

    @FXML
    void academicClicked(MouseEvent event) throws IOException {
        App.setRoot("studentAcademic");

    }

    @FXML
    void profileClicked(MouseEvent event) throws IOException{
        App.setRoot("studentHome");

    }

    @FXML
    void whatIfClicked(MouseEvent event) throws IOException {

        App.setRoot("studentWhatIf");

    }


    



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        application = RoadmapApplication.getInstance();

        UserList users = UserList.getInstance();
        Student student = (Student)users.getActive();

        subjectCode.setCellValueFactory(new PropertyValueFactory<>("courseSubjectCode"));
        courseNumber.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
        courseTitle.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
        credits.setCellValueFactory(new PropertyValueFactory<>("credits"));


        ArrayList<Class> semesterOneClasses = application.getClasses();
       classTable.getItems().addAll();


    }

        
 
    
    
}


