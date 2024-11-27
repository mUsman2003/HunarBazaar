module JavaFxProject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;
	requires java.sql;

    exports scenecontroller to javafx.fxml; // This is optional if only FXML needs access
    opens scenecontroller to javafx.fxml;  // Necessary for FXML reflection
    opens application to javafx.graphics, javafx.fxml;
}
