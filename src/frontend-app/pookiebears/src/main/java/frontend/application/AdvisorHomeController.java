package frontend.application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import backend.*;



public class AdvisorHomeController implements Initializable {

    @FXML
    private Text advisorName;
    private RoadmapApplication application;

    


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        application = RoadmapApplication.getInstance();
        UserList users = UserList.getInstance();
        Advisor advisor = (Advisor)users.getAdvisor();
        if(advisor != null) {
         advisorName.setText(advisor.getFirstName() + advisor.getLastName());
        }  
    }
}
