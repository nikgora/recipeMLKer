-- Inserting Cooking Devices
INSERT INTO CookingDevice (title)
VALUES ('Oven'),
       ('Stove'),
       ('Microwave'),
       ('Blender'),
       ('Mixer');


-- Inserting Categories
INSERT INTO Category (title)
VALUES ('First Dish'),
       ('Main Dish'),
       ('Salad'),
       ('Pastry'),
       ('Dessert'),
       ('Drink'),
       ('Snack'),
       ('Fish Dish'),
       ('Sauce');

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
       ('Peanuts', TRUE),
       ('Butter', TRUE),
       ('Salt', FALSE),
       ('Pepper', FALSE),
       ('Spaghetti', FALSE),
       ('Garlic', FALSE),
       ('Parmesan', FALSE),
       ('Pancetta', FALSE),
       ('Bacon', FALSE);

-- Inserting Published Recipes
INSERT INTO PublishedRecipe (title, cooking_time, description, published, fk_user, fk_category)
VALUES ('Scrambled Eggs', 15,
        'Whisk eggs with milk (if using), salt, and pepper. Heat butter in a pan over medium heat.
        \n\nAdd egg mixture and let the base set slightly. Gently run a spoon through eggs, creating soft curds.
        \n\nPush and fold until just cooked but slightly custardy.
        \n\nRemove from heat, stir briefly, then serve piled on toast or preferred accompaniment.',
        TRUE, 1, 7),
       ('Spaghetti Carbonara', 30,
        'Bring a large pot of salted water to a boil (1 tablespoon salt for every 2 quarts of water).
        \n\nIn a large sauté pan over medium heat, heat the butter. Add the diced pancetta and cook until crispy.
        \n\nIf using garlic, add it and cook for another minute. Turn off the heat and transfer the pancetta and garlic to a large bowl.
        \n\nIn a small bowl, beat the eggs and mix in about half of the grated cheese. Once the water is boiling, add the dry pasta and cook until al dente.
        \n\nUsing tongs, transfer the cooked pasta to the bowl with the pancetta and garlic. Let it be dripping wet.
        \n\nReserve some of the pasta water. Quickly toss the pasta with the beaten eggs and cheese until well combined.
        \n\nSeason with salt and pepper to taste. Garnish with the remaining grated cheese and freshly ground black pepper.
        \n\nOptionally, sprinkle with chopped parsley before serving. Enjoy immediately.',
        TRUE, 2, 2),
       ('Chocolate Cake', 60,
        'Preheat your oven to 175°C. Grease and flour cake pans and line the bottoms with parchment paper.
        In a large mixing bowl, sift together the flour, cocoa powder, granulated sugar, baking powder, baking soda, and salt.
        \n\nAdd the eggs, milk, oil, and vanilla extract to the dry ingredients. Beat on medium speed for 2 minutes until well combined.
        Stir in the boiling water until the batter is smooth.
        \n\nPour the batter evenly into the prepared cake pans. Tap the pans on the counter a few times to remove any air bubbles.
        Bake in the preheated oven for 30-35 minutes, or until a toothpick inserted into the center of the cakes comes out clean.
        \n\nRemove the cakes from the oven and allow them to cool. Once the cakes are completely cool, place one layer on a serving plate or cake stand.
        Optionally, you can garnish the cake with chopped peanuts and mini chocolate chips if desired.',
        TRUE, 3, 4);

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