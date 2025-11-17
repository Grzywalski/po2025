module org.example.auto_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.auto_gui to javafx.fxml;
    exports org.example.auto_gui;
}