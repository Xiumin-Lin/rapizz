USE Rapizz;
-- Adding data to tables

-- Add ingredients
INSERT INTO Ingredient (id_ingredient, name)
VALUES (1, 'Sauce Tomate'),
       (2, 'Fromage Mozzarella'),
       (3, 'Pepperoni'),
       (4, 'Champignons'),
       (5, 'Oignons'),
       (6, 'Poivrons'),
       (7, 'Olives'),
       (8, 'Bacon'),
       (9, 'Jambon'),
       (10, 'Ananas'),
       (11, 'Épinards'),
       (12, 'Fromage Feta'),
       (13, 'Parmesan'),
       (14, 'Fromage Cheddar'),
       (15, 'Ail'),
       (16, 'Saucisse Italienne'),
       (17, 'Poulet'),
       (18, 'Piment'),
       (19, 'Artichaut'),
       (20, 'Basilic');

-- Add pizzas
INSERT INTO Pizza (id_pizza, name, price, picture_url)
VALUES (1, 'Margherita', 9.99, 'https://assets.afcdn.com/recipe/20200206/107152_w1024h1024c1cx176cy267.webp'),
       (2, 'Pepperoni', 11.99, 'https://assets.afcdn.com/recipe/20190319/89655_w1024h1024c1cx3680cy2456.webp'),
       (3, 'Végétarienne', 10.99, 'https://assets.afcdn.com/recipe/20170427/39421_w1024h1024c1cx831cy571.jpg'),
       (4, 'Hawaïenne', 12.99, 'https://assets.afcdn.com/recipe/20161005/3905_origin.jpg'),
       (5, 'Meet Lovers', 13.99, 'https://assets.afcdn.com/recipe/20170323/11766_w1024h768c1cx1728cy1152.webp'),
       (6, 'Poulet BBQ', 11.99, 'https://cdn.shopify.com/s/files/1/0408/5655/1588/articles/bbq_pizza_6534116b-0905-492b-b8c2-3492929cced2.jpg?crop=center&height=800&v=1616496778&width=800'),
       (7, 'Champignons', 10.99, 'https://assets.afcdn.com/recipe/20161130/2342_w1024h1024c1cx2699cy1799.jpg'),
       (8, 'Suprême', 12.99, 'https://assets.afcdn.com/recipe/20171206/75873_origincxt0cyt0cxb4912cyb3264.jpg'),
       (9, 'Quatre Fromages', 11.99, 'https://assets.afcdn.com/recipe/20160926/5624_w1024h1024c1cx1872cy2808.webp'),
       (10, 'Veggie Deluxe', 12.99, 'https://assets.afcdn.com/recipe/20170105/1769_w1024h1024c1cx1824cy2736.jpg');

-- Associate ingredients with pizzas 
INSERT INTO Compose (id_pizza, id_ingredient)
VALUES (1, 1), -- Margherita - Sauce Tomate
       (1, 2), -- Margherita - Fromage Mozzarella
       (2, 1), -- Pepperoni - Sauce Tomate
       (2, 2), -- Pepperoni - Fromage Mozzarella
       (2, 3), -- Pepperoni - Pepperoni
       (3, 1), -- Végétarienne - Sauce Tomate
       (3, 2), -- Végétarienne - Fromage Mozzarella
       (3, 4), -- Végétarienne - Champignons
       (3, 5), -- Végétarienne - Oignons
       (3, 6), -- Végétarienne - Poivrons
       (4, 1), -- Hawaïenne - Sauce Tomate
       (4, 2), -- Hawaïenne - Fromage Mozzarella
       (4, 9), -- Hawaïenne - Jambon
       (4, 10), -- Hawaïenne - Ananas
       (5, 1), -- Meet Lovers - Sauce Tomate
       (5, 2), -- Meet Lovers - Fromage Mozzarella
       (5, 3), -- Meet Lovers - Pepperoni
       (5, 4), -- Meet Lovers - Champignons
       (5, 8), -- Meet Lovers - Bacon
       (6, 7), -- Poulet BBQ - Olives
       (6, 2), -- Poulet BBQ - Fromage Mozzarella
       (6, 17), -- Poulet BBQ - Poulet
       (6, 15), -- Poulet BBQ - Ail
       (7, 1), -- Champignons - Sauce Tomate
       (7, 2), -- Champignons - Fromage Mozzarella
       (7, 4), -- Champignons - Champignons
       (7, 15), -- Champignons - Ail
       (8, 1), -- Suprême - Sauce Tomate
       (8, 2), -- Suprême - Fromage Mozzarella
       (8, 3), -- Suprême - Pepperoni
       (8, 4), -- Suprême - Champignons
       (8, 5), -- Suprême - Oignons
       (8, 6), -- Suprême - Poivrons
       (8, 7), -- Suprême - Olives
       (8, 8), -- Suprême - Bacon
       (8, 9), -- Suprême - Jambon
       (9, 2), -- Quatre Fromages - Fromage Mozzarella
       (9, 12), -- Quatre Fromages - Fromage Feta
       (9, 13), -- Quatre Fromages - Parmesan
       (9, 14), -- Quatre Fromages - Fromage Cheddar
       (10, 1), -- Veggie Deluxe - Sauce Tomate
       (10, 2), -- Veggie Deluxe - Fromage Mozzarella
       (10, 4), -- Veggie Deluxe - Champignons
       (10, 5), -- Veggie Deluxe - Oignons
       (10, 6), -- Veggie Deluxe - Poivrons
       (10, 11), -- Veggie Deluxe - Épinards
       (10, 19), -- Veggie Deluxe - Artichaut
       (10, 20); -- Veggie Deluxe - Basilic

-- Add livreurs
INSERT INTO Livreur (id_livreur, name)
VALUES (1, 'Dominic Toretto'),
(2, 'Brian O Conner'),
(3, 'Luke Hobbs');

-- Add vehicles
INSERT INTO Vehicle (id_vehicule, name, type)
VALUES ('1', 'Dodge Charger', 'voiture'),
('2', 'Toyota Supra', 'voiture'),
('3', 'Yamaha YZF-R1', 'moto');