package frontend.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import frontend.application.App;
import backend.*;



public class SignUpController implements Initializable {

    @FXML
    private MenuButton menuButton;

    @FXML
    private MenuItem advisor_type;

    @FXML
    private MenuItem student_type;

    @FXML
    private TextField txt_firstname;

    @FXML
    private TextField txt_lastname;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_username;

    @FXML
    private Label lbl_error;

    @FXML
    void handleMenuItem(ActionEvent event) throws IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        String selectedItem = menuItem.getText();
        menuButton.setText(selectedItem);

    }

    @FXML
    void SignUpClicked(MouseEvent event) throws  IOException{

        String username = txt_username.getText();
        String password = txt_password.getText();
        String firstName = txt_firstname.getText();
        String lastName = txt_lastname.getText();
        String userType = menuButton.getText();
        

        RoadmapApplication application = RoadmapApplication.getInstance();

        if (!application.register(username, firstName, lastName, password, userType))  {
            lbl_error.setText("Account couldn't be created !");
            return;

        }
        App.setRoot("login");


    }


     @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    
}
