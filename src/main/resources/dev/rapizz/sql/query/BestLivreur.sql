SELECT l.id_livreur, l.name, COUNT(*) AS nb_livraison
FROM Command c JOIN Livreur l ON c.id_livreur = l.id_livreur
WHERE status = 'finish' AND TIMESTAMPDIFF(MINUTE, date_start, date_end) < 30
GROUP BY id_livreur, l.name
ORDER BY nb_livraison DESC;