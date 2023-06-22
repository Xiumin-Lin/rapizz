SELECT i.id_ingredient, i.name, COUNT(*) AS nb_occurrences
FROM Ingredient i JOIN Compose c ON i.id_ingredient = c.id_ingredient
GROUP BY i.id_ingredient, i.name
ORDER BY nb_occurrences DESC
LIMIT 1