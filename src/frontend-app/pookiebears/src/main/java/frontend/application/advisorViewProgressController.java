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
import javafx.scene.text.Text;
import javafx.util.Callback;
import backend.*;
import backend.Class;

public class advisorViewProgressController implements Initializable{
    private RoadmapApplication application;

    @FXML
    private TableView<Class> classTable;

    @FXML
    private TableColumn<Class, String> courseNumber;

    @FXML
    private TableColumn<Class, String> courseTitle;

    @FXML
    private TableColumn<Class, String> grade;

    @FXML
    private TableColumn<Class, String> status;

    @FXML
    private TableColumn<Class, String> subjectCode;

    

    @FXML
    private CheckBox completeBox;

    @FXML
    private CheckBox incompleteBox;




     @Override
    public void initialize(URL url, ResourceBundle rb) {
        application = RoadmapApplication.getInstance();

        UserList users = UserList.getInstance();
        Advisor advisor = (Advisor)users.getAdvisor();
        Student student = advisor.getStudentById("aa39ad3f-1cbc-4b14-8051-efb5500ff0b8");
        users.setActiveUser(student);
        CourseList courseList = CourseList.getInstance();
        Roadmap roadmap = Roadmap.getInstance();
        application.setRoadmap(roadmap);
        roadmap.setMajorState(student.getCurrentMajor());

        
         
         
        


       subjectCode.setCellValueFactory(new PropertyValueFactory<>("courseSubjectCode"));
       courseNumber.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
       courseTitle.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
       grade.setCellValueFactory(new PropertyValueFactory<>("grade"));

       status.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Class, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Class, String> param) {
            Class item = param.getValue();
            String value = item.getClassStatus();
            return new SimpleStringProperty(value);
        }
    });

        
 
       ArrayList<Class> studentClasses = application.getClasses();
       classTable.getItems().addAll(studentClasses);

        
        /*
         * Add listerner to checkbox
         */
       completeBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) { // If the checkbox is checked
            classTable.getItems().clear(); // Clear current items in the table
            // Get only completed classes and add them to the table
            ArrayList<Class> completedClasses = application.getCompletedClasses();
            classTable.getItems().addAll(completedClasses);
        } else { // If the checkbox is unchecked
            classTable.getItems().clear(); // Clear current items in the table
            // Add all classes back to the table
            ArrayList<Class> allClasses = application.getClasses();
            classTable.getItems().addAll(allClasses);
        }
    });

    incompleteBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) { // If the checkbox is checked
            classTable.getItems().clear(); // Clear current items in the table
            // Get only completed classes and add them to the table
            ArrayList<Class> completedClasses = application.getIncompletedClasses();
            classTable.getItems().addAll(completedClasses);
        } else { // If the checkbox is unchecked
            classTable.getItems().clear(); // Clear current items in the table
            // Add all classes back to the table
            ArrayList<Class> allClasses = application.getClasses();
            classTable.getItems().addAll(allClasses);
        }
    });

    






     }
    
}
