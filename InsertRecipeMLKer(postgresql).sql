-- Inserting Cooking Devices
INSERT INTO CookingDevice (title)
VALUES ('Oven'),
       ('Stove'),
       ('Microwave'),
       ('Blender');


-- Inserting Categories
INSERT INTO Category (title, description)
VALUES ('Soup', 'Recipes suitable for first dish'),
       ('MainDish', 'Recipes suitable for main dish'),
       ('Salad', 'Recipes suitable for light vegetable  '),
       ('Pastry', 'Recipes suitable for breakfast'),
       ('Dessert', 'Recipes suitable for sweet treats'),
       ('Drinks', 'Recipes suitable for sip'),
       ('Snacks', 'Recipes for sweet treats'),
       ('FishDishes', 'Recipes suitable for lunch'),
       ('Sauces', 'Recipes suitable for dinner');

-- Inserting Users
INSERT INTO "user" (login, "password")
VALUES ('user1', 'password1'),
       ('user2', 'password2'),
       ('user3', 'password3');

-- Inserting Ingredients
INSERT INTO Ingredient ("title", allergen)
VALUES ('Eggs', FALSE),
       ('Milk', FALSE),
       ('Wheat Flour', TRUE),
       ('Peanuts', TRUE);

-- Inserting Published Recipes
INSERT INTO PublishedRecipe (title, cooking_time, description, published, fk_user, fk_category)
VALUES ('Scrambled Eggs', 15, 'Simple recipe for scrambled eggs', TRUE, 1, 1),
       ('Spaghetti Carbonara', 30, 'Classic Italian pasta dish', TRUE, 2, 3),
       ('Chocolate Cake', 60, 'Decadent dessert for chocolate lovers', TRUE, 3, 4);

-- Inserting Moderators
INSERT INTO Moderator (secret_password, fk_user)
VALUES ('moderator1pass', 1),
       ('moderator2pass', 2);

-- Inserting User Reports
INSERT INTO UserReport (description, is_accepted, fk_user_id, fk_PublishedRecipe_id, fk_moderator)
VALUES ('Offensive language in comments', TRUE, 1, 2, 1),
       ('Inaccurate cooking time', FALSE, 2, 3, 2);

-- Inserting AI Reports
INSERT INTO AIReport (description, is_accepted, fk_recipe, fk_moderator)
VALUES ('Possible copyright infringement', FALSE, 3, 1),
       ('Inappropriate content', TRUE, 1, 2);

-- Inserting Recipe Ingredients
INSERT INTO Recipe_Ingredient (amount_of_ingredient, fk_ingredient, fk_recipe)
VALUES ('3', 1, 1),
       ('200g', 3, 2),
       ('200g', 4, 3);

-- Inserting Recipe Devices
INSERT INTO Recipe_Device (fk_device, fk_recipe)
VALUES (1, 1),
       (2, 2),
       (1, 3);

-- Inserting Ratings
INSERT INTO Rating (mark, fk_user, fk_recipe)
VALUES (4.5, 1, 1),
       (3.8, 2, 2),
       (5.0, 3, 3);

-- Inserting Comments
INSERT INTO "comment" ("text", fk_user, fk_recipe)
VALUES ('Great recipe, loved it!', 1, 1),
       ('I added some extra cheese, delicious!', 2, 2),
       ('Easy to follow instructions, thanks!', 3, 3);

-- Inserting User Lists
INSERT INTO UserList (title, fk_user)
VALUES ('Favorites', 1),
       ('To Try', 2),
       ('Healthy Choices', 3);

-- Inserting Recipes into User Lists
INSERT INTO Recipe_UserList (fk_recipe_id, fk_user_list)
VALUES (1, 1),
       (2, 2),
       (3, 3);