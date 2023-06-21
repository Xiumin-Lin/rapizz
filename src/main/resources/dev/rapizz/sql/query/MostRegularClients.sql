SELECT c.id_client, c.name
FROM Client c
    JOIN Command cmd ON c.id_client = cmd.id_client
WHERE cmd.price > (
    SELECT AVG(price)
    FROM Command
    WHERE price > 0
)
ORDER BY cmd.price DESC;