module com.example.ece_shopping {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ece_shopping to javafx.fxml;
    exports Controller;
    opens Controller to javafx.fxml;
    exports Model;
    opens Model to javafx.fxml;
    exports View;
    opens View to javafx.fxml;
}
