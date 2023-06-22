SELECT c.id_client, c.name, regularity.total as nb_command
FROM Client c
JOIN (
    SELECT id_client, COUNT(*) AS total
    FROM Command
    GROUP BY id_client
) AS regularity ON c.id_client = regularity.id_client
JOIN (
    SELECT AVG(total_orders) AS avg_total
    FROM (
        SELECT COUNT(*) AS total_orders
        FROM Command
        GROUP BY id_client
    ) AS client_counts
) AS avg_table
WHERE regularity.total > avg_table.avg_total
ORDER BY regularity.total DESC, c.id_client