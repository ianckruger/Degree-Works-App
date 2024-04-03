module frontend.application {
    requires javafx.controls;
    requires javafx.fxml;

    opens frontend.application to javafx.fxml;
    exports frontend.application;
}
