-- PROCEDURE to calculate the price of the pizza base on his size
-- DELIMITER ::
-- Disable delimiter if using sql script from JDBC, don't forget to split on regex '{delimiter}\\s*'
USE Rapizz ::
DROP PROCEDURE IF EXISTS calculate_client_total_command ::
CREATE PROCEDURE calculate_client_total_command(id_client INT, OUT total_command INT)
BEGIN
    SELECT COUNT(*) INTO total_command FROM Command c WHERE c.id_client = id_client GROUP BY c.id_client;
END ::

DROP PROCEDURE IF EXISTS calculate_delivery_time_in_minutes ::
CREATE PROCEDURE calculate_delivery_time_in_minutes(new_date_start DATETIME, new_date_end DATETIME,
    OUT delivery_time INT)
BEGIN
    IF new_date_end IS NOT NULL THEN
        SELECT TIMESTAMPDIFF(MINUTE, new_date_start, new_date_end) INTO delivery_time;
    ELSE
        SET delivery_time = 0;
    END IF;
END ::

DROP PROCEDURE IF EXISTS calculate_pizza_price ::
CREATE PROCEDURE calculate_pizza_price(new_id_client INT, new_date_start DATETIME, new_date_end DATETIME,
    new_id_size INT, new_id_pizza INT, OUT new_price DECIMAL(10, 2))
BEGIN
    DECLARE modifier DECIMAL(10, 2);
    DECLARE base_price DECIMAL(10, 2);
    DECLARE total_command INT;

    CALL calculate_delivery_time_in_minutes(new_date_start, new_date_end, @delivery_time);

    CALL calculate_client_total_command(new_id_client, @total_command);
    SET total_command = @total_command;

    IF (total_command % 10) = 0 THEN
        SET new_price = 0;
    ELSEIF @delivery_time > 30 THEN
        SET new_price = 0;
    ELSE
        SELECT price_modifier INTO modifier FROM Size WHERE id_size = new_id_size;
        SELECT price INTO base_price FROM Pizza WHERE id_pizza = new_id_pizza;
        SET new_price = base_price * modifier;
    END IF;
END ::

-- Calculate Pizza Price AFTER INSERT trigger
DROP TRIGGER IF EXISTS calculate_pizza_price_after_insert ::
CREATE TRIGGER calculate_price_after_insert
    BEFORE INSERT ON Command
    FOR EACH ROW
BEGIN
    CALL calculate_pizza_price(NEW.id_client,NEW.date_start, NEW.date_end,
        NEW.id_size, NEW.id_pizza, @new_price);
    SET NEW.price = @new_price;
END ::

-- Calculate Pizza Price AFTER UPDATE trigger
DROP TRIGGER IF EXISTS calculate_pizza_price_after_update ::
CREATE TRIGGER calculate_price_after_update
    BEFORE UPDATE ON Command
    FOR EACH ROW
BEGIN
    CALL calculate_pizza_price(NEW.id_client,NEW.date_start, NEW.date_end,
        NEW.id_size, NEW.id_pizza, @new_price);
    SET NEW.price = @new_price;
END ::

-- DELIMITER ;