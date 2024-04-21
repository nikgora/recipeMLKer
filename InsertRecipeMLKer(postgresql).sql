-- Inserting Cooking Devices
INSERT INTO CookingDevice (title) VALUES
    ('Oven'),
    ('Stove'),
    ('Microwave'),
    ('Blender');

-- Inserting Categories
INSERT INTO Category (title, description) VALUES
    ('Breakfast', 'Recipes suitable for breakfast'),
    ('Lunch', 'Recipes suitable for lunch'),
    ('Dinner', 'Recipes suitable for dinner'),
    ('Dessert', 'Recipes for sweet treats');

-- Inserting Users
INSERT INTO "User" (login, "password") VALUES
    ('user1', 'password1'),
    ('user2', 'password2'),
    ('user3', 'password3');

-- Inserting Ingredients
INSERT INTO Ingredient ("title", allergen) VALUES
    ('Eggs', FALSE),
    ('Milk', FALSE),
    ('Wheat Flour', TRUE),
    ('Peanuts', TRUE);

-- Inserting Published Recipes
INSERT INTO PublishedRecipe (title, cooking_time, description, published, fk_user, fk_category) VALUES
    ('Scrambled Eggs', '15 minutes', 'Simple recipe for scrambled eggs', TRUE, 1, 1),
    ('Spaghetti Carbonara', '30 minutes', 'Classic Italian pasta dish', TRUE, 2, 3),
    ('Chocolate Cake', '1 hour', 'Decadent dessert for chocolate lovers', TRUE, 3, 4);

-- Inserting Moderators
INSERT INTO Moderator (secret_password, fk_user) VALUES
    ('moderator1pass', 1),
    ('moderator2pass', 2);

-- Inserting User Reports
INSERT INTO UserReport (description, is_accepted, fk_user_id, fk_PublishedRecipe_id, fk_moderator) VALUES
    ('Offensive language in comments', TRUE, 1, 2, 1),
    ('Inaccurate cooking time', FALSE, 2, 3, 2);

-- Inserting AI Reports
INSERT INTO AIReport (description, is_accepted, fk_recipe, fk_moderator) VALUES
    ('Possible copyright infringement', FALSE, 3, 1),
    ('Inappropriate content', TRUE, 1, 2);

-- Inserting Recipe Ingredients
INSERT INTO Recipe_Ingredient (amount_of_ingredient, fk_ingredient, fk_recipe) VALUES
    ('3', 1, 1),
    ('200g', 3, 2),
    ('200g', 4, 3);

-- Inserting Recipe Devices
INSERT INTO Recipe_Device (fk_device, fk_recipe) VALUES
    (1, 1),
    (2, 2),
    (1, 3);

-- Inserting Ratings
INSERT INTO Rating (mark, fk_user, fk_recipe) VALUES
    (4.5, 1, 1),
    (3.8, 2, 2),
    (5.0, 3, 3);

-- Inserting Comments
INSERT INTO "Comment" ("text", fk_user, fk_recipe) VALUES
    ('Great recipe, loved it!', 1, 1),
    ('I added some extra cheese, delicious!', 2, 2),
    ('Easy to follow instructions, thanks!', 3, 3);

-- Inserting User Lists
INSERT INTO UserList (title, description, fk_user) VALUES
    ('Favorites', 'My favorite recipes', 1),
    ('To Try', 'Recipes I want to try soon', 2),
    ('Healthy Choices', 'Healthy recipes I enjoy', 3);

-- Inserting Recipes into User Lists
INSERT INTO Recipe_UserList (fk_recipe_id, fk_user_list) VALUES
    (1, 1),
    (2, 2),
    (3, 3);