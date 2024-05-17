INSERT INTO ingredient ("title", allergen)
VALUES ('Butter', TRUE),
       ('Salt', FALSE),
	   ('Pepper', FALSE),
	   ('Spaghetti', FALSE),
       ('Garlic', FALSE),
	   ('Parmesan', FALSE),
	   ('Pancetta', FALSE), 
		('Bacon', FALSE);
	   
INSERT INTO recipe_ingredient (amount_of_ingredient, fk_ingredient, fk_recipe)
VALUES ('2 spoons', 2, 1),
       ('for flavor', 5, 1),
       ('for flavor', 6, 1),
	   ('for flavor', 7, 1),
	   ('1 spoon', 5, 2),
       ('2 cloves', 9, 2),
	   ('200 grams', 12, 2),
	   ('400 grams', 8, 2),
	   ('1 cup grated', 10, 2),
	   ('for flavor', 6, 2),
	   ('for flavor', 7, 2),
       ('300 grams', 3, 3),
       ('230 grams', 18, 3),
       ('300 grams', 17, 3),
       ('1.5 teaspoons', 16, 3),
       ('1.5 teaspoons', 15, 3),
       ('1 teaspoon', 6, 3),
       ('3', 1, 3),
       ('1 cup', 2, 3),
       ('2 spoons', 19, 3),
       ('2 teaspoons', 13, 3),
       ('1 cup', 14, 3);

INSERT INTO CookingDevice (title)
VALUES ('Mixer');

INSERT INTO Recipe_Device (fk_device, fk_recipe)
VALUES (5, 3);