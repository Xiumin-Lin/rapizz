SELECT p.id_pizza, p.name, COUNT(*) AS nb_commandes
FROM Pizza p JOIN Command c ON p.id_pizza = c.id_pizza
GROUP BY p.id_pizza, p.name
ORDER BY nb_commandes DESC
LIMIT 1;