module frontend.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires javafx.graphics;

    opens frontend.application to javafx.fxml;
    exports frontend.application;
    
    opens backend to javafx.fxml;
    exports backend;





}
