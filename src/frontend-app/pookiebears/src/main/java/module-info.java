module frontend.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens frontend.application to javafx.fxml;
    exports frontend.application;
}
