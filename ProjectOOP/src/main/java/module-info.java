module com.example.switchscene {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.datatransfer;


    opens com.example.Taskmanage to javafx.fxml;
    exports com.example.Taskmanage;
}