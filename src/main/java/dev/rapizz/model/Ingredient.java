package dev.rapizz.model;

public class Ingredient {
    private final int id;
    private String name;

    /**
     * Constructs an Ingredient object with the specified ID and name.
     *
     * @param id   the ID of the ingredient
     * @param name the name of the ingredient
     */
    public Ingredient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
