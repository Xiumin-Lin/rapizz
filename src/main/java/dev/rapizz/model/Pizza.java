package dev.rapizz.model;

import java.util.HashSet;
import java.util.Set;

public class Pizza {
    private final int id;
    private String name;
    private double price;
    private String pictureUrl;
    private Set<Ingredient> ingredients;

    /**
     * Constructs a Pizza with his ID, name, price, and picture URL.
     *
     * @param id         the ID of the pizza
     * @param name       the name of the pizza
     * @param price      the price of the pizza
     * @param pictureUrl the URL of the pizza's picture
     */
    public Pizza(int id, String name, double price, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.price = Math.round(price * 100.0) / 100.0;;
        this.pictureUrl = pictureUrl;
        this.ingredients = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}
