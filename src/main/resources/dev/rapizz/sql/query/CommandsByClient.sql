SELECT c.id_client, c.name, COUNT(*) AS nb_command
FROM Client c
    JOIN Command cmd ON c.id_client = cmd.id_client
GROUP BY c.id_client, c.name
ORDER BY nb_command DESC, c.id_client;