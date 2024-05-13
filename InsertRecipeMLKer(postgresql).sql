INSERT INTO "User" (login, "password") VALUES
('user1', 'password1'),
('user2', 'password2'),
('user3', 'password3');

INSERT INTO CookingDevice ("name") VALUES
('Oven'),
('Stove'),
('Microwave'),
('Blender');

INSERT INTO Category (title, description) VALUES
('Breakfast', 'Recipes suitable for breakfast meals'),
('Lunch', 'Recipes suitable for lunch meals'),
('Dinner', 'Recipes suitable for dinner meals'),
('Dessert', 'Recipes for sweet treats');

INSERT INTO AI (secret_password) VALUES
('secret_password1'),
('secret_password2');

INSERT INTO Ingredient ("name", allergen) VALUES
('Salt', FALSE),
('Sugar', FALSE),
('Flour', FALSE),
('Eggs', FALSE);

INSERT INTO Moderator (secret_password, fk_user) VALUES
('moderator_password1', 1),
('moderator_password2', 2),
('moderator_password3', 3);

INSERT INTO PublishedRecipe (title, cooking_time, description, fk_category) VALUES
('Scrambled Eggs', '15 minutes', 'Easy and delicious scrambled eggs recipe', 1),
('Chocolate Cake', '45 minutes', 'Decadent chocolate cake recipe', 4),
('Grilled Chicken', '30 minutes', 'Juicy grilled chicken recipe', 3),
('Pancakes', '20 minutes', 'Fluffy pancake recipe', 1);

INSERT INTO Recipe (fk_device, fk_ingredient, amount_of_ingredient, fk_recipe) VALUES
(NULL, 4, '2', 1),
(1, NULL, NULL, 2),
(NULL, 3, '500 g', 2),
(NULL, 1, '1 g' , 3),
(4, NULL, NULL, 4);

INSERT INTO Rating (mark, fk_user, fk_recipe) VALUES
(4.5, 1, 1),
(3.2, 2, 2),
(5.0, 3, 3),
(4.7, 1, 4);

INSERT INTO "Comment" (text, fk_user, fk_recipe) VALUES
('This recipe is amazing!', 1, 1),
('Tastes delicious!', 2, 2),
('Easy to follow instructions', 3, 3),
('Best pancakes ever!', 1, 4);


INSERT INTO UserList (title, description, fk_user) VALUES
('Favorite Recipes', 'A list of favorite recipes', 1),
('Quick Meals', 'Recipes for quick meal options', 2),
('Dessert Ideas', 'Ideas for sweet treats', 3);

INSERT INTO UserRecipe (is_published, fk_user, fk_recipe) VALUES
(TRUE, 1, 1),
(TRUE, 2, 2),
(FALSE, 3, 3),
(TRUE, 1, 4);

INSERT INTO AddedList (fk_recipe_id, fk_user_list) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1);

INSERT INTO AIReport (description, fk_ai, fk_recipe) VALUES
('Recipe contains allergens', 1, 2),
('Recipe cooking time too long', 2, 3),
('Recipe contains errors', 1, 4);

INSERT INTO UserReport (description, fk_user_id, fk_PublishedRecipe_id) VALUES
('Inappropriate language in comments', 1, 3),
('Spamming', 2, 2),
('False information', 3, 1);
