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
	   ('for flavor', 7, 2);
	   