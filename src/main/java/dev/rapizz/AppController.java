package dev.rapizz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

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
    private BorderPane mainViewPane;


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
        Utils.Log.info("Click on Test Connection");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("connection.fxml"));
            loader.setController(new ConnectionController(connStateLabel)); // set new controller instance

            ScrollPane connectionPane = loader.load();
            connectionPane.setFitToHeight(true);

            mainViewPane.setCenter(connectionPane);
        } catch (IOException e) {
            Utils.Log.error("Fail when loading connection.fxml :" + e.getMessage());
            e.printStackTrace();
        }
    }
}