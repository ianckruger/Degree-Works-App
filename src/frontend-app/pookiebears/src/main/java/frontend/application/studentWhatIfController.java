package frontend.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backend.*;

public class studentWhatIfController implements Initializable {
    @FXML
    private MenuItem ceItem;

    @FXML
    private MenuItem cisItem;

    @FXML
    private MenuItem csItem;

    @FXML
    private MenuButton majorPick;

    @FXML
    private Text studentMajor;

    private RoadmapApplication application;

    @FXML
    void handleMenuItem(ActionEvent event) throws IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        String selectedItem = menuItem.getText();
        majorPick.setText(selectedItem);



    }

    @FXML
    void profileClicked(MouseEvent event) throws IOException {
        App.setRoot("studentHome");

    }
    @FXML
    void academicClicked(MouseEvent event) throws IOException {
        App.setRoot("studentAcademic");

    }
    
    @FXML
    void notesClicked(MouseEvent event) throws IOException{
        App.setRoot("studentNotes");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        application = RoadmapApplication.getInstance();
        UserList users = UserList.getInstance();
        Student student = (Student)users.getActive();
        if(student != null) {
            studentMajor.setText(student.getCurrentMajor().toUpperCase());
        }

        
    }

    
}
