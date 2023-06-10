package dev.rapizz;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AppController {

    @FXML
    private Button menuBtn;
    @FXML
    private Button deliveryBtn;
    @FXML
    private Button statisticBtn;
    @FXML
    private Button testBtn;
    @FXML
    private Label connStateLabel;
    @FXML
    private TableView<String> mainTableView;

    @FXML
    protected void onMenuButtonClick() {
        Utils.Log.info("Click on menu");
    }

    @FXML
    protected void onDeliveryButtonClick() {
        Utils.Log.info("Click on delivery");
    }

    @FXML
    protected void onStatisticButtonClick() {
        Utils.Log.info("Click on Statistic");
    }

    @FXML
    protected void onTestButtonClick() {
        Utils.Log.info("Click on Test");
        try {
            ResultSet rs = Database.query("SHOW DATABASES;");
            if(rs == null) {
                connStateLabel.setText("No results !");
                connStateLabel.setTextFill(Color.ORANGE);
                mainTableView.setPlaceholder(new Label("No rows to display"));
                return;
            }
            connStateLabel.setText("Connected !");
            connStateLabel.setTextFill(Color.GREEN);

            Utils.populateTableView(mainTableView, rs);
        } catch (SQLException e) {
            Utils.Log.error("onTestButtonClick :", e);
            connStateLabel.setText("Failed !");
            connStateLabel.setTextFill(Color.RED);
        } finally {
            Database.disconnect();
        }
    }
}