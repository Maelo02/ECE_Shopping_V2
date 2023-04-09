module com.example.ece_shopping {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ece_shopping to javafx.fxml;
    exports com.example.ece_shopping;
}