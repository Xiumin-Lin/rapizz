package dev.rapizz.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Command {
    private final int id_command;
    private double price;
    private String status;
    private Date date_start;
    private Date date_end;
    private Pizza pizza;
    private Size size;
    private Client client;
    private Livreur livreur;
    private Vehicle vehicle;

    public Command(int idCommande, double price, String status, Date dateDebut, Date dateFin,
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

    public Date getDate_start() {
        return date_start;
    }

    public Date getDate_end() {
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
}
