package dev.rapizz.model;

public class Client {
    private final int id_client;
    private String name;
    private double wallet;
    private String address;
    private boolean is_subscribe;

    public Client(int id_client, String name, double wallet, String address, boolean is_subscribe) {
        this.id_client = id_client;
        this.name = name;
        this.wallet = wallet;
        this.address = address;
        this.is_subscribe = is_subscribe;
    }
    public int getIdClient() {
        return id_client;
    }

    public String getName() {
        return name;
    }

    public double getWallet() {
        return wallet;
    }

    public String getAddress() {
        return address;
    }

    public boolean isSubscribe() {
        return is_subscribe;
    }
}
