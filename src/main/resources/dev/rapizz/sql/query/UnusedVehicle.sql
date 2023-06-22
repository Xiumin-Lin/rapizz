SELECT *
FROM Vehicle
WHERE id_vehicle NOT IN (
    SELECT id_vehicle
    FROM Command
)
ORDER BY id_vehicle;