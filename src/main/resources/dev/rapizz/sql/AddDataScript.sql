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

-- Add livreur
INSERT INTO Livreur (id_livreur, name)
VALUES (1, 'Dominic Toretto'),
(2, 'Brian O''Conner'),
(3, 'Luke Hobbs');

-- Add vehicles
INSERT INTO Vehicle (id_vehicule, name, type)
VALUES (1, 'Dodge Charger', 'voiture'),
(2, 'Toyota Supra', 'voiture'),
(3, 'Yamaha YZF-R1', 'moto');


-- Add clients
INSERT INTO Client (id_client, name, wallet, address, is_subscribe)
VALUES
  (1, 'Goku', 100.0, 'Kame House, Roshi Island', true),
  (2, 'Luffy', 50.0, 'Thousand Sunny, East Blue', true),
  (3, 'Naruto', 75.0, 'Hidden Leaf Village, Fire Country', true),
  (4, 'Ichigo', 80.0, 'Karaku Town, Soul Society', true),
  (5, 'Sakura', 30.0, 'Hidden Leaf Village, Fire Country', false),
  (6, 'Levi', 90.0, 'Scout Regiment HQ, Wall Rose', true),
  (7, 'Mikasa', 70.0, 'Shiganshina District, Wall Maria', true),
  (8, 'Eren', 40.0, 'Marley, Liberio', true),
  (9, 'Light', 60.0, 'Tokyo, Japan', false),
  (10, 'L', 85.0, 'Los Angeles, USA', true),
  (11, 'Saitama', 120.0, 'Z-City', true),
  (12, 'Edward', 55.0, 'Resembool, Amestris', true),
  (13, 'Spike', 95.0, 'Mars, Solar System', true),
  (14, 'Gon', 20.0, 'Whale Island, Yorbian', true),
  (15, 'Killua', 45.0, 'Kukuroo Mountain, Republic of Padokea', true),
  (16, 'Nami', 65.0, 'Cocoyasi Village, Conomi Islands', true),
  (17, 'Vegeta', 150.0, 'Capsule Corporation, Earth', true),
  (18, 'Shinobu', 25.0, 'Demon Slayer Corps HQ, Japan', true),
  (19, 'Asuna', 100.0, 'New Aincrad, Sword Art Online', true),
  (20, 'Eren', 70.0, 'Eldia, Paradis Island', false);

-- Add size
INSERT INTO Size (id_size, name, price_modifier)
VALUES
  (1, 'humaine', 1),    -- prix de base
  (2, 'naine', 2/3),    -- 1/3 moins chere
  (3, 'ogresse', 4/3);  -- 1/3 plus chere

-- Add commands
INSERT INTO Command (id_command, id_size, status, date_start, date_end, id_pizza, id_client, id_vehicule, id_livreur)
VALUES
  (1, 2, 'finish', '2023-06-20 10:00:00', '2023-06-20 10:10:00', 5, 1, 1, 1),
  (2, 2, 'finish', '2023-06-20 11:00:00', '2023-06-20 11:11:00', 2, 2, 1, 2),
  (3, 3, 'finish', '2023-06-20 12:30:00', '2023-06-20 13:30:00', 3, 3, 3, 3),
  (4, 2, 'finish', '2023-06-20 13:00:00', '2023-06-20 13:24:00', 4, 4, 1, 1),
  (5, 1, 'finish', '2023-06-20 14:00:00', '2023-06-20 14:57:00', 5, 5, 2, 2),
  (6, 3, 'finish', '2023-06-20 15:30:00', '2023-06-20 16:02:00', 6, 6, 3, 3),
  (7, 2, 'finish', '2023-06-20 16:00:00', '2023-06-20 16:24:00', 7, 7, 1, 1),
  (8, 3, 'finish', '2023-06-20 17:00:00', '2023-06-20 17:15:00', 5, 8, 2, 2),
  (9, 3, 'finish', '2023-06-20 18:30:00', '2023-06-20 18:10:00', 9, 9, 3, 3),
  (10, 2, 'finish', '2023-06-20 19:00:00', '2023-06-20 19:17:00', 10, 10, 1, 1),
  (11, 3, 'finish', '2023-06-20 20:00:00', '2023-06-20 20:45:00', 1, 11, 2, 1),
  (12, 3, 'finish', '2023-06-20 21:30:00', '2023-06-20 21:37:00', 2, 12, 3, 3),
  (13, 2, 'finish', '2023-06-21 10:00:00', '2023-06-21 10:12:00', 3, 13, 1, 1),
  (14, 1, 'finish', '2023-06-21 11:00:00', '2023-06-21 11:15:00', 4, 14, 2, 2),
  (15, 3, 'finish', '2023-06-21 12:30:00', '2023-06-21 12:29:00', 5, 15, 3, 3),
  (16, 1, 'finish', '2023-06-21 13:00:00', '2023-06-21 13:30:00', 9, 16, 1, 1),
  (17, 1, 'finish', '2023-06-21 14:00:00', '2023-06-21 14:45:00', 7, 17, 3, 2),
  (18, 3, 'finish', '2023-06-21 15:30:00', '2023-06-21 15:09:00', 8, 18, 3, 1),
  (19, 3, 'finish', '2023-06-21 16:00:00', '2023-06-21 16:14:00', 10, 19, 1, 1),
  (20, 1, 'finish', '2023-06-21 17:00:00', '2023-06-21 17:20:00', 10, 20, 2, 2),
  (21, 1, 'finish', '2023-06-21 18:30:00', '2023-06-21 18:30:00', 6, 1, 3, 3),
  (22, 2, 'finish', '2023-06-21 19:00:00', '2023-06-21 19:16:00', 2, 1, 1, 1),
  (23, 1, 'finish', '2023-06-21 20:00:00', '2023-06-21 20:04:00', 5, 5, 3, 2),
  (24, 3, 'finish', '2023-06-21 21:30:00', '2023-06-21 22:01:00', 3, 6, 1, 3),
  (25, 2, 'finish', '2023-06-22 10:00:00', '2023-06-22 10:12:00', 5, 9, 1, 1),
  (26, 1, 'finish', '2023-06-22 11:00:00', '2023-06-22 11:15:00', 6, 6, 2, 2),
  (27, 3, 'finish', '2023-06-22 12:30:00', '2023-06-22 12:13:00', 7, 7, 2, 1),
  (28, 2, 'finish', '2023-06-22 13:00:00', '2023-06-22 13:10:00', 4, 8, 1, 1),
  (29, 1, 'in progress', '2023-06-22 14:00:00', NULL, 9, 11, 2, 2),
  (30, 2, 'in progress', '2023-06-22 15:30:00', NULL, 9, 12, 3, 3);