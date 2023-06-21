package dev.rapizz.model;

public class Size {
    private final int id_size;
    private String name;
    private double price_modifier;

    public Size(int id_size, String name, double price_modifier) {
        this.id_size = id_size;
        this.name = name;
        this.price_modifier = price_modifier;
    }

    public int getIdSize() {
        return id_size;
    }

    public String getName() {
        return name;
    }

    public double getPrice_modifier() {
        return price_modifier;
    }
}
