module dev.rapizz {
    requires javafx.controls;
    requires javafx.fxml;

    opens dev.rapizz to javafx.fxml;
    exports dev.rapizz;
}