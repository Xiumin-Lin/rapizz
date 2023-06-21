module dev.rapizz {
    requires javafx.controls;
    requires javafx.fxml;

    requires io.github.cdimascio.dotenv.java;
    requires java.sql;
    requires mysql.connector.java;

    opens dev.rapizz to javafx.fxml;
    exports dev.rapizz;
    exports dev.rapizz.model;
}