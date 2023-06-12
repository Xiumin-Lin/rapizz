package dev.rapizz;

import javafx.event.ActionEvent;
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
    private SplitMenuButton databaseMenuBtn;
    @FXML
    private Label connStateLabel;
    @FXML
    private BorderPane mainViewPane;
    @FXML
    private Label mainTitleLabel;


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
    protected void onDatabaseMenuClick() {
        Utils.Log.info("Click on Default Database Button");
        loadDatabaseView(DatabaseController.ActionType.SHOW_DB);
    }

    @FXML
    protected void onDatabaseMenuItemClick(ActionEvent event) {
        String btnText = ((MenuItem)event.getSource()).getId();
        Utils.Log.info("Click on Database Menu Item : " + btnText);

        DatabaseController.ActionType actionType = switch (btnText) {
            case "createDBItem" -> DatabaseController.ActionType.CREATE_DB;
            case "addDBItem" -> DatabaseController.ActionType.ADD_DATA_BD;
            case "dropDBItem" -> DatabaseController.ActionType.DROP_DB;
            default -> DatabaseController.ActionType.SHOW_DB;
        };
        loadDatabaseView(actionType);
    }

    private void loadDatabaseView(DatabaseController.ActionType actionType) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("database.fxml"));
            loader.setController(new DatabaseController(connStateLabel, actionType)); // set new controller instance

            ScrollPane connectionPane = loader.load();
            connectionPane.setFitToHeight(true);

            mainViewPane.setCenter(connectionPane);
        } catch (IOException e) {
            Utils.Log.error("Fail when loading database.fxml :" + e.getMessage());
            e.printStackTrace();
        }
    }
}