package dev.rapizz.model;

public class Livreur {
    private final int id_livreur;
    private String name;

    public Livreur(int id_livreur, String name) {
        this.id_livreur = id_livreur;
        this.name = name;
    }

    public int getIdLivreur() {
        return id_livreur;
    }

    public String getName() {
        return name;
    }
}
