package dev.rapizz.model;

import dev.rapizz.Utils;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class Command {
    private final int id_command;
    private double price;
    private String status;
    private Timestamp date_start;
    private Timestamp date_end;
    private Pizza pizza;
    private Size size;
    private Client client;
    private Livreur livreur;
    private Vehicle vehicle;

    public Command(int idCommande, double price, String status, Timestamp dateDebut, Timestamp dateFin,
                   Pizza pizza, Size size, Client client, Livreur livreur, Vehicle vehicle) {
        this.id_command = idCommande;
        this.price = Math.round(price * 100.0) / 100.0;
        this.status = status;
        this.date_start = dateDebut;
        this.date_end = dateFin;
        this.pizza = pizza;
        this.size = size;
        this.client = client;
        this.livreur = livreur;
        this.vehicle = vehicle;
    }

    public int getIdCommande() {
        return id_command;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getDate_start() {
        return date_start;
    }

    public Timestamp getDate_end() {
        return date_end;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public Size getSize() {
        return size;
    }

    public Client getClient() {
        return client;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getDurationInMinutes() {
        if(date_end == null) return 0;

        long durationInMillis = date_end.getTime() - date_start.getTime();
        long min = TimeUnit.MILLISECONDS.toMinutes(durationInMillis);
        return Math.max(min, 0);
    }
}
