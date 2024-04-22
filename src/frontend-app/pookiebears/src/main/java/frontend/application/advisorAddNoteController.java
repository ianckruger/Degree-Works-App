package frontend.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.RoadmapApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class advisorAddNoteController implements Initializable{

    @FXML
    private Text addNote;

    @FXML
    private Text noteAdded;
    private RoadmapApplication application;
    



    @FXML
    void backClicked(MouseEvent event) throws IOException {
        App.setRoot("advisorViewAdvisee");

    }

    @FXML
    void addNote(MouseEvent event) throws IOException{
        String note = addNote.getText();
        noteAdded.setText(note);

    }

    @FXML
    void logOutClicked(MouseEvent event) throws IOException{
        application.logout();
        App.setRoot("login");

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
