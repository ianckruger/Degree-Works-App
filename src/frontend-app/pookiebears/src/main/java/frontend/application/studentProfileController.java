package frontend.application;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import frontend.application.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import backend.*;



public class studentProfileController implements Initializable {
    @FXML
    private Text studentClass;

    @FXML
    private Text studentDegree;

    @FXML
    private Text studentID;

    @FXML
    private Text studentMajor;

    @FXML
    private Text studentName;
    
    @FXML
    private Text studentGPA;

    private RoadmapApplication application;


    @FXML
    void academicClicked(MouseEvent event) throws IOException {
        App.setRoot("studentAcademic");

    }

    @FXML
    void notesClicked(MouseEvent event) throws IOException{
        App.setRoot("studentNotes");
    }

    @FXML
    void whatIfClicked(MouseEvent event) throws IOException {
        App.setRoot("studentWhatIf");

    }

    @FXML
    void semesterPlanClicked(MouseEvent event) throws IOException {
        App.setRoot("studentSemesterPlan");

    }

    @FXML
    void logOutClicked(MouseEvent event) throws IOException {
       

    }

    

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        application = RoadmapApplication.getInstance();
        UserList users = UserList.getInstance();
        Student student = (Student)users.getActive();
        if(student != null) {
            studentClass.setText( student.getYear());
            studentID.setText("XXX3423");
            studentMajor.setText(student.getCurrentMajor().toUpperCase());
            studentName.setText(student.getFirstName() + " " + student.getLastName());
            studentGPA.setText(Double.toString(student.getGPA()));
            studentDegree.setText("Bachelor of " + student.getCurrentMajor().toUpperCase());
            
        }

    }


}
