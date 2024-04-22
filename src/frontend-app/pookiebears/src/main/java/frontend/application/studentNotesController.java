package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.RoadmapApplication;
import backend.Student;
import backend.UserList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
=======
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


>>>>>>> 5e4df092a20bc022e25e3034d7119fc89c040c1f

public class studentNotesController implements Initializable{

    

    @FXML
    private Text notesText;


    private RoadmapApplication application;


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

<<<<<<< HEAD
    @FXML
    private TextArea textField;
    
    private RoadmapApplication application;

    @FXML
    private Text notes;
=======

>>>>>>> 5e4df092a20bc022e25e3034d7119fc89c040c1f

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
<<<<<<< HEAD
        application = RoadmapApplication.getInstance();
        UserList users = UserList.getInstance();
        Student student = (Student)users.getActive();

        System.out.println(application.GetNotes());
        String note = application.GetNote();
        System.out.println("Note: "+note);
        application.addNoteToStudent("Advised");
        System.out.println(application.GetNotes());
        String note2 = application.GetNote();
        System.out.println("Note: "+note2);

        if(textField != null) {

            textField.setText(application.GetNote());
        }
        else {
            textField.setText("note is nothing");
        }


=======

       application = RoadmapApplication.getInstance();

       UserList users = UserList.getInstance();
       Student student = (Student)users.getActive();

       String notes = student.getNote();
       
       notesText.setText(notes);
>>>>>>> 5e4df092a20bc022e25e3034d7119fc89c040c1f
        



     }
    
}
