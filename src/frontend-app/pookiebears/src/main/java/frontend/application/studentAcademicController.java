package frontend.application;

import javafx.fxml.Initializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import frontend.application.App;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.util.Callback;
import backend.*;
import backend.Class;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class studentAcademicController implements Initializable{
    @FXML
    private TextField textField;
    @FXML
    private TextArea studentProgress;
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

    private RoadmapApplication application;
 
    

    @FXML
    void profileClicked(MouseEvent event) throws IOException {
        App.setRoot("studentHome");

    }
 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       application = RoadmapApplication.getInstance();
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


        // studentProgress.setText(application.printStudentProgress());
        
    }


    
}
