package dev.rapizz;

import dev.rapizz.model.Command;
import dev.rapizz.model.CommandDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class CommandController {
    @FXML
    private ComboBox<Command> command_box;
    @FXML
    private Label commandTitle;
    @FXML
    private Text pizzaName;
    @FXML
    private Text pizzaPrice;
    @FXML
    private Text livreurName;
    @FXML
    private Text sizeName;
    @FXML
    private Text vehicleName;
    @FXML
    private Text dateStart;
    @FXML
    private Text statusValue;
    @FXML
    private Text deliveryTime;
    @FXML
    private Label totalPrice;

    @FXML
    public void initialize() {
        command_box.setConverter(new StringConverter<>() {
            @Override
            public String toString(Command c) {
                return "[Id " + c.getIdCommande() + "] " + c.getPizza().getName() + " for " + c.getClient().getName();
            }

            @Override
            public Command fromString(String string) {
                return null; // not necessary
            }
        });

        command_box.getItems().clear();
        command_box.setItems(FXCollections.observableArrayList(new CommandDao().getAll()));

        if (!command_box.getItems().isEmpty()) {
            Command c = command_box.getItems().get(0);
            command_box.setValue(c);
            setDeliveryNote(c);
        }
    }

    public void setDeliveryNote(Command c) {
        commandTitle.setText("Fiche de Livraison de " + c.getClient().getName());
        pizzaName.setText(c.getPizza().getName());
        pizzaPrice.setText(c.getPizza().getPrice() + " €");
        sizeName.setText(c.getSize().getName());
        livreurName.setText(c.getLivreur().getName());
        if(c.getVehicle() != null) vehicleName.setText(c.getVehicle().getName());
        else vehicleName.setText("Pas de vehicule");
        dateStart.setText(c.getDate_start().toString());
        statusValue.setText(c.getStatus());
        deliveryTime.setText(c.getDurationInMinutes() + " min");
        totalPrice.setText(c.getPrice() + " €");
    }

    @FXML
    public void updateDeliveryNote() {
        setDeliveryNote(command_box.getValue());
    }
}
