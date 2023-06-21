package dev.rapizz;

import dev.rapizz.model.Pizza;
import dev.rapizz.model.PizzaDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class MenuListviewController {
    @FXML
    private VBox list_vbox;

    @FXML
    public void initialize() {
        List<Pizza> pizzas = new PizzaDao().getAll();
        if(pizzas.isEmpty()) {
            Text t = new Text("No pizza data in the database !");
            list_vbox.getChildren().add(t);
            return;
        }
        for (Pizza pizza: pizzas) {
            Utils.Log.info(pizza.getName() + " - " + pizza.getIngredients().iterator().next().getName());

            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("menuItemlist.fxml"));
                loader.setController(new MenuItemController(pizza)); // set new controller instance

                HBox connectionPane = loader.load();
                Separator separator = new Separator();
                list_vbox.getChildren().add(connectionPane);
                list_vbox.getChildren().add(separator);
            } catch (IOException e) {
                Utils.Log.error("Fail when loading menuItemlist.fxml for pizza " + pizza.getId() + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
