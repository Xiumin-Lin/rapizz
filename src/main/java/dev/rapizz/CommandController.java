package dev.rapizz;

import dev.rapizz.model.Command;
import dev.rapizz.model.CommandDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

public class CommandController {
    @FXML
    private ComboBox<Command> command_box;
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
    }
}
