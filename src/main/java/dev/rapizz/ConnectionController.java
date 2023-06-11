package dev.rapizz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionController {
    private Label connStateLabel;
    @FXML
    private TableView<String> mainTableView;

    public ConnectionController(Label label) {
        Utils.Log.info(label.getId());
        this.connStateLabel = label;
    }

    @FXML
    public void initialize() {
        try {
            ResultSet rs = Database.query("SHOW DATABASES;"); // create a connection to DB and apply query
            if(rs == null) {
                connStateLabel.setText("No results !");
                connStateLabel.setTextFill(Color.ORANGE);
                mainTableView.setPlaceholder(new Label("No rows to display"));
                return;
            }
            connStateLabel.setText("Connected !");
            connStateLabel.setTextFill(Color.GREEN);

//            Utils.populateTableView(mainTableView, rs);
        } catch (SQLException e) {
            connStateLabel.setText("Failed !");
            connStateLabel.setTextFill(Color.RED);
        } finally {
            Database.disconnect();
        }
    }
}
