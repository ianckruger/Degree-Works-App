package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.Advisor;
import backend.RoadmapApplication;
import backend.Student;
import backend.UserList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class advisorAddNoteController implements Initializable{

    @FXML
    private TextArea addNote;

    @FXML
    private TextArea previousNote;

    private RoadmapApplication application;
    



    @FXML
    void backClicked(MouseEvent event) throws IOException {
        App.setRoot("advisorViewAdvisee");

    }

    @FXML
    void addNote(MouseEvent event) throws IOException{
        String note = addNote.getText();

        String previousNoteText = previousNote.getText();
    
        // Append the new note to the existing text, with a delimiter if needed
        if (!previousNoteText.isEmpty()) {
            // If there's existing text, add a delimiter (e.g., newline) before appending the new note
            previousNoteText += "\n"; // You can use any delimiter you prefer
        }
        previousNoteText += note;
        application.addNoteToStudent(note);
        
        
        // Set the concatenated text back to the previousNote TextArea
        previousNote.setText(previousNoteText);

 
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        application = RoadmapApplication.getInstance();
        UserList users = UserList.getInstance();
        Advisor advisor = (Advisor)users.getAdvisor();
        Student student = advisor.getStudentById("aa39ad3f-1cbc-4b14-8051-efb5500ff0b8");
        users.setActiveUser(student);
         
        
    
        previousNote.setText(student.getNote());
    }
    
}
