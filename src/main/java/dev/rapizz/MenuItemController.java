package dev.rapizz;

import dev.rapizz.model.Ingredient;
import dev.rapizz.model.Pizza;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MenuItemController {
    @FXML
    private ImageView picture;
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
//        picture.setImage(new Image(pizza.getPictureUrl()));
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
