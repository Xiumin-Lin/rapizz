USE Rapizz;

SELECT AVG(price) AS average_command_price
FROM Command
WHERE price > 0