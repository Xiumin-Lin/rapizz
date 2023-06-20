-- PROCEDURE to calculate the price of the pizza base on his size
# DELIMITER $$
-- Disable Delimiter if using sql script from JDBC, don't forget to split on regex '$$\\s*'
USE Rapizz $$
DROP PROCEDURE IF EXISTS calculate_pizza_price $$
CREATE PROCEDURE calculate_pizza_price(new_id_size INT, new_id_pizza INT, OUT new_price DECIMAL(10, 2))
BEGIN
    DECLARE modifier DECIMAL(10, 2);
    DECLARE base_price DECIMAL(10, 2);
    SELECT price_modifier INTO modifier FROM Size WHERE id_size = new_id_size;
    SELECT price INTO base_price FROM Pizza WHERE id_pizza = new_id_pizza;
    SET new_price = base_price * modifier;
END $$

-- Calculate Pizza Price AFTER INSERT trigger
DROP TRIGGER IF EXISTS calculate_pizza_price_after_insert ::
CREATE TRIGGER calculate_price_after_insert
    BEFORE INSERT ON Command
    FOR EACH ROW
BEGIN
    CALL calculate_pizza_price(NEW.id_size, NEW.id_pizza, @new_price);
    SET NEW.price = @new_price;
END $$

-- Calculate Pizza Price AFTER UPDATE trigger
DROP TRIGGER IF EXISTS calculate_pizza_price_after_update ::
CREATE TRIGGER calculate_price_after_update
    BEFORE UPDATE ON Command
    FOR EACH ROW
BEGIN
    CALL calculate_pizza_price(NEW.id_size, NEW.id_pizza, @new_price);
    SET NEW.price = @new_price;
END $$

# DELIMITER ;