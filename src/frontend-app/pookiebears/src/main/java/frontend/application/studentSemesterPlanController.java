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
    private TableColumn<Class, String> prereq;

    @FXML
    private TableColumn<Class, String> subjectCode;

    private RoadmapApplication application;

    @FXML
    private TableView<Class> classTable1;

    @FXML
    private TableColumn<Class, String> courseTitle1;

    @FXML
    private TableColumn<Class, String> courseNumber1;

    @FXML
    private TableColumn<Class, String> credits1;

    @FXML
    private TableColumn<Class, String> prereq1;

    @FXML
    private TableColumn<Class, String> subjectCode1;

    @FXML
    private CheckBox sem3and4CheckBox;

    @FXML
    private CheckBox sem5and6CheckBox;

    @FXML
    private CheckBox sem7and8CheckBox;

    @FXML
    private Text firstSemesterText;

    @FXML
    private Text secondSemesterText;




    @FXML
    void NoteClicked(MouseEvent event) {

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
        prereq.setCellValueFactory(cellData -> {
            ArrayList<Class> prereqs = cellData.getValue().getPrereqs();
            if (prereqs != null && !prereqs.isEmpty()) {
                StringBuilder prereqNames = new StringBuilder();
                for (Class prereq : prereqs) {
                    prereqNames.append(prereq.getCourseSubjectCode()).append(prereq.getCourseNumber()).append(", ");
                }
                return new SimpleStringProperty(prereqNames.toString());
            } else {
                return new SimpleStringProperty("None");
            }
        });
        
        

        

        subjectCode1.setCellValueFactory(new PropertyValueFactory<>("courseSubjectCode"));
        courseNumber1.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
        courseTitle1.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
        credits1.setCellValueFactory(new PropertyValueFactory<>("credits"));
        prereq1.setCellValueFactory(cellData -> {
            ArrayList<Class> prereqs = cellData.getValue().getPrereqs();
            if (prereqs != null && !prereqs.isEmpty()) {
                StringBuilder prereqNames = new StringBuilder();
                for (Class prereq : prereqs) {
                    prereqNames.append(prereq.getCourseSubjectCode()).append(prereq.getCourseNumber()).append(", ");
                }
                return new SimpleStringProperty(prereqNames.toString());
            } else {
                return new SimpleStringProperty("None");
            }
        });
        

        ArrayList<Class> semesterOnePlan = application.getSemesterOnePlan();
        ArrayList<Class> semesterTwoPlan = application.getSemesterTwoPlan();

        ArrayList<Class> semesterThreePlan = application.getSemesterThreePlan();
        ArrayList<Class> semesterFourPlan = application.getSemesterFourPlan();

        //Adding classes to the table
        classTable.getItems().addAll(semesterOnePlan);
        classTable1.getItems().addAll(semesterTwoPlan);


        sem3and4CheckBox.setOnAction(event -> {
            if (sem3and4CheckBox.isSelected()) {
                // Replace contents of TableView with courses for semesters 3 and 4
                classTable.getItems().clear();
                classTable1.getItems().clear();

                firstSemesterText.setText("Semester Three");
                secondSemesterText.setText("Semester Four");
                classTable.getItems().addAll(semesterThreePlan);
                classTable1.getItems().addAll(semesterFourPlan);

              
            } else {
                // If unchecked, display courses for semesters 1 and 2
                classTable.getItems().clear();
                classTable1.getItems().clear();
            
                firstSemesterText.setText("Semester One");
                secondSemesterText.setText("Semester Two");
                classTable.getItems().addAll(application.getSemesterOnePlan());
                classTable1.getItems().addAll(application.getSemesterTwoPlan());

              
            }
        
        });

        sem5and6CheckBox.setOnAction(event -> {
            if (sem5and6CheckBox.isSelected()) {
                // Replace contents of TableView with courses for semesters 3 and 4
                classTable.getItems().clear();
                classTable1.getItems().clear();
                firstSemesterText.setText("Semester Five");
                secondSemesterText.setText("Semester Six");
                classTable.getItems().addAll(application.getSemesterFivePlan());
                classTable1.getItems().addAll(application.getSemesterSixPlan());

               
                
            } else {
                // If unchecked, display courses for semesters 1 and 2
                classTable.getItems().clear();
                classTable1.getItems().clear();
                firstSemesterText.setText("Semester One");
                secondSemesterText.setText("Semester Two");
                classTable.getItems().addAll(semesterOnePlan);
                classTable1.getItems().addAll(semesterTwoPlan);
            }
        });

        sem7and8CheckBox.setOnAction(event -> {
            if (sem7and8CheckBox.isSelected()) {
                // Replace contents of TableView with courses for semesters 3 and 4
                classTable.getItems().clear();
                classTable1.getItems().clear();
                firstSemesterText.setText("Semester Seven");
                secondSemesterText.setText("Semester Eight");
                classTable.getItems().addAll(application.getSemesterSevenPlan());
                classTable1.getItems().addAll(application.getSemesterEightPlan());

            } else {
                // If unchecked, display courses for semesters 1 and 2
                classTable.getItems().clear();
                classTable1.getItems().clear();
                firstSemesterText.setText("Semester One");
                secondSemesterText.setText("Semester Two");
                classTable.getItems().addAll(semesterOnePlan);
                classTable1.getItems().addAll(semesterTwoPlan);
            }
        });

        

        

    }

    
}


