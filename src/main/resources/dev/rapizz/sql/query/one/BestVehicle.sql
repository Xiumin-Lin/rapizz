SELECT v.id_vehicle, v.name, COUNT(*) AS nb_utilisations
FROM Command c JOIN Vehicle v on v.id_vehicle = c.id_vehicle
GROUP BY id_vehicle
ORDER BY nb_utilisations DESC
LIMIT 1;