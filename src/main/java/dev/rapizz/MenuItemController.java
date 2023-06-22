package dev.rapizz;

import dev.rapizz.model.Ingredient;
import dev.rapizz.model.Pizza;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

public class MenuItemController {
    @FXML
    private ImageView item_image;
    @FXML
    private Text item_title;
    @FXML
    private Text item_description;
    @FXML
    private Text item_price;

    private final Pizza pizza;
    public MenuItemController(Pizza pizza) {
        this.pizza = pizza;
    }

    @FXML
    public void initialize() {
        URL imgUrl = getClass().getResource(pizza.getPictureUrl());
        if(imgUrl != null) {
            try {
                item_image.setImage(new Image(new FileInputStream(imgUrl.getPath())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        item_title.setText(pizza.getName());
        StringBuilder description = new StringBuilder();
        for (Ingredient ing: pizza.getIngredients()) {
            description.append(ing.getName());
            description.append(", ");
        }
        item_description.setText(description.toString());
        item_price.setText(pizza.getPrice() + " €");
    }
}
