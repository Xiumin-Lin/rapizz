USE Rapizz;

SELECT c.id_client, c.name, SUM(cmd.price) AS total_amount
FROM Client c
    JOIN Command cmd ON c.id_client = cmd.id_client
GROUP BY c.id_client, c.name
ORDER BY total_amount DESC
LIMIT 1