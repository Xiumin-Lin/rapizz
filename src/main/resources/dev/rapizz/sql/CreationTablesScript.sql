-- Table creation script --
CREATE DATABASE IF NOT EXISTS Rapizz CHARACTER SET utf8mb4;
USE Rapizz;

-- Table containing pizzas available for order
CREATE TABLE Pizza
(
    id_pizza    INT            NOT NULL AUTO_INCREMENT,
    name        CHAR(30),
    price       DECIMAL(10, 2) NOT NULL,
    picture_url TEXT(300),
    PRIMARY KEY (id_pizza)
);

-- Table of possible ingredients for creating a pizza
CREATE TABLE Ingredient
(
    id_ingredient INT NOT NULL AUTO_INCREMENT,
    name          CHAR(20),
    PRIMARY KEY (id_ingredient)
);

-- Table containing the company's customers
CREATE TABLE Client
(
    id_client    INT            NOT NULL AUTO_INCREMENT,
    name         CHAR(30),
    wallet       DECIMAL(10, 2) NOT NULL,
    address      CHAR(150)      NOT NULL,
    is_subscribe BOOLEAN        NOT NULL,
    PRIMARY KEY (id_client)
);

-- Table containing the company's delivery personnel
CREATE TABLE Livreur
(
    id_livreur INT      NOT NULL AUTO_INCREMENT,
    name       CHAR(30) NOT NULL,
    PRIMARY KEY (id_livreur)
);

-- Table containing company vehicles
CREATE TABLE Vehicle
(
    id_vehicle INT                     NOT NULL AUTO_INCREMENT,
    name        CHAR(20)                NOT NULL,
    type        ENUM ('voiture','moto') NOT NULL,
    PRIMARY KEY (id_vehicle)
);

-- Table containing all customer orders
CREATE TABLE Size
(
    id_size        INT      NOT NULL AUTO_INCREMENT,
    name           CHAR(20) NOT NULL,
    price_modifier FLOAT DEFAULT 1,
    PRIMARY KEY (id_size)
);

-- Table containing all customer orders
CREATE TABLE Command
(
    id_command  INT                           NOT NULL AUTO_INCREMENT,
    price       DECIMAL(10, 2) DEFAULT -1,
    status      ENUM ('in progress','finish') NOT NULL,
    date_start  DATETIME                      NOT NULL,
    date_end    DATETIME       DEFAULT NULL,
    id_pizza    INT                           NOT NULL,
    id_size     INT            DEFAULT 1      NOT NULL,
    id_client   INT                           NOT NULL,
    id_vehicle INT,
    id_livreur  INT                           NOT NULL,
    PRIMARY KEY (id_command)
);

-- Table for linking pizzas with ingredients
CREATE TABLE Compose
(
    id_pizza      INT NOT NULL,
    id_ingredient INT NOT NULL,
    PRIMARY KEY (id_pizza, id_ingredient)
);

-- Script adding foreign keys to Command and Compose tables
ALTER TABLE Command
    ADD CONSTRAINT fk_pizza_command FOREIGN KEY (id_pizza) REFERENCES Pizza (id_pizza),
    ADD CONSTRAINT fk_size_command FOREIGN KEY (id_size) REFERENCES Size (id_size),
    ADD CONSTRAINT fk_client_command FOREIGN KEY (id_client) REFERENCES Client (id_client),
    ADD CONSTRAINT fk_vehicle_command FOREIGN KEY (id_vehicle) REFERENCES Vehicle (id_vehicle),
    ADD CONSTRAINT fk_livreur_command FOREIGN KEY (id_livreur) REFERENCES Livreur (id_livreur);

ALTER TABLE Compose
    ADD CONSTRAINT fk_pizza_compose FOREIGN KEY (id_pizza) REFERENCES Pizza (id_pizza),
    ADD CONSTRAINT fk_ingredient_compose FOREIGN KEY (id_ingredient) REFERENCES Ingredient (id_ingredient);