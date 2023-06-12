-- Table creation script --
CREATE DATABASE IF NOT EXISTS Rapizz CHARACTER SET utf8mb4;
USE Rapizz;

-- Table containing pizzas available for order
CREATE TABLE Pizza (
   id_pizza INT,
   name CHAR(30),
   price REAL NOT NULL,
   picture_url TEXT(300),
   PRIMARY KEY(id_pizza)
);

-- Table of possible ingredients for creating a pizza
CREATE TABLE Ingredient (
   id_ingredient INT,
   name CHAR(20),
   PRIMARY KEY(id_ingredient)
);

-- Table containing the company's customers
CREATE TABLE Client (
   id_client INT,
   name CHAR(30),
   wallet REAL NOT NULL,
   address CHAR(150) NOT NULL,
   is_subscribe BOOLEAN NOT NULL,
   PRIMARY KEY(id_client)
);

-- Table containing the company's delivery personnel
CREATE TABLE Livreur (
   id_livreur INT,
   name CHAR(30) NOT NULL,
   PRIMARY KEY(id_livreur)
);

-- Table containing company vehicles
CREATE TABLE Vehicle (
   id_vehicule VARCHAR(50),
   name CHAR(20) NOT NULL,
   type ENUM('voiture','moto') NOT NULL,
   PRIMARY KEY(id_vehicule)
);

-- Table containing all customer orders
CREATE TABLE Command (
   id_command INT,
   size ENUM('naine','humaine','ogresse') NOT NULL,
   price REAL,
   status ENUM('in progress','finish') NOT NULL,
   date_start DATETIME NOT NULL,
   date_end DATETIME NOT NULL,
   id_pizza INT NOT NULL,
   id_client INT NOT NULL,
   id_vehicule VARCHAR(50) NOT NULL,
   id_livreur INT NOT NULL,
   PRIMARY KEY(id_command)
);

-- Table for linking pizzas with ingredients
CREATE TABLE Compose (
   id_pizza INT,
   id_ingredient INT,
   PRIMARY KEY(id_pizza, id_ingredient)
);

-- Script adding foreign keys to Command and Compose tables
ALTER TABLE Command ADD CONSTRAINT fk_pizza_command FOREIGN KEY (id_pizza) REFERENCES Pizza(id_pizza);
ALTER TABLE Command ADD CONSTRAINT fk_client_command FOREIGN KEY (id_client) REFERENCES Client(id_client);
ALTER TABLE Command ADD CONSTRAINT fk_vehicle_command FOREIGN KEY (id_vehicule) REFERENCES Vehicle(id_vehicule);
ALTER TABLE Command ADD CONSTRAINT fk_livreur_command FOREIGN KEY (id_livreur) REFERENCES Livreur(id_livreur);

ALTER TABLE Compose ADD CONSTRAINT fk_pizza_compose FOREIGN KEY (id_pizza) REFERENCES Pizza(id_pizza);
ALTER TABLE Compose ADD CONSTRAINT fk_ingredient_compose FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient);
