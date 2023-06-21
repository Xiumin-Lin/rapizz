package dev.rapizz.model;

public class Vehicle {
    private final int id_vehicle;
    private String name;
    private String type;

    public Vehicle(int id_vehicle, String name, String type) {
        this.id_vehicle = id_vehicle;
        this.name = name;
        this.type = type;
    }

    public int getIdVehicle() {
        return id_vehicle;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
