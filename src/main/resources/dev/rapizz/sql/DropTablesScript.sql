USE Rapizz;
-- Table drop script --
DROP TABLE IF EXISTS Compose;
DROP TABLE IF EXISTS Command;
DROP TABLE IF EXISTS Size;
DROP TABLE IF EXISTS Vehicle;
DROP TABLE IF EXISTS Livreur;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Ingredient;
DROP TABLE IF EXISTS Pizza;

DROP PROCEDURE IF EXISTS calculate_client_total_command;
DROP PROCEDURE IF EXISTS calculate_delivery_time_in_minutes;
DROP PROCEDURE IF EXISTS calculate_pizza_price;
DROP TRIGGER IF EXISTS calculate_pizza_price_after_insert;
DROP TRIGGER IF EXISTS calculate_pizza_price_after_update;