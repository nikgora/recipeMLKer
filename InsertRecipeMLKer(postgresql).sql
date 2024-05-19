-- Inserting Cooking Devices
INSERT INTO CookingDevice (title)
VALUES ('Oven'),
       ('Stove'),
       ('Microwave'),
       ('Blender'),
       ('Mixer'),
       ('Grill');


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
       ('Bacon', FALSE),
       ('Cocoa Powder', FALSE),
       ('Sugar', FALSE),
       ('Baking powder', FALSE),
       ('Baking soda', FALSE),
       ('Oil', FALSE),
       ('Water', FALSE),
       ('Vanilla extract', TRUE),
       ('Brown sugar', FALSE),
       ('Lemon juice', TRUE),
       ('Salmon', FALSE),
       ('Soy Sauce', TRUE),
       ('Parsley', FALSE),
       ('Tahini', FALSE);

-- Inserting Published Recipes
INSERT INTO PublishedRecipe (title, cooking_time, description, published, fk_user, fk_category)
VALUES ('Scrambled Eggs', 15,
        'Whisk eggs with milk (if using), salt, and pepper. Heat butter in a pan over medium heat.
        <br><br>Add egg mixture and let the base set slightly. Gently run a spoon through eggs, creating soft curds.
        <br><br>Push and fold until just cooked but slightly custardy.
        <br><br>Remove from heat, stir briefly, then serve piled on toast or preferred accompaniment.',
        TRUE, 1, 7),
       ('Spaghetti Carbonara', 30,
        'Bring a large pot of salted water to a boil (1 tablespoon salt for every 2 quarts of water).
        <br><br>In a large sauté pan over medium heat, heat the butter. Add the diced pancetta and cook until crispy.
        <br><br>If using garlic, add it and cook for another minute. Turn off the heat and transfer the pancetta and garlic to a large bowl.
        <br><br>In a small bowl, beat the eggs and mix in about half of the grated cheese. Once the water is boiling, add the dry pasta and cook until al dente.
        <br><br>Using tongs, transfer the cooked pasta to the bowl with the pancetta and garlic. Let it be dripping wet.
        <br><br>Reserve some of the pasta water. Quickly toss the pasta with the beaten eggs and cheese until well combined.
        <br><br>Season with salt and pepper to taste. Garnish with the remaining grated cheese and freshly ground black pepper.
        <br><br>Optionally, sprinkle with chopped parsley before serving. Enjoy immediately.',
        TRUE, 2, 2),
       ('Chocolate Cake', 60,
        'Preheat your oven to 175°C. Grease and flour cake pans and line the bottoms with parchment paper.
        In a large mixing bowl, sift together the flour, cocoa powder, granulated sugar, baking powder, baking soda, and salt.
        <br><br>Add the eggs, milk, oil, and vanilla extract to the dry ingredients. Beat on medium speed for 2 minutes until well combined.
        Stir in the boiling water until the batter is smooth.
        <br><br>Pour the batter evenly into the prepared cake pans. Tap the pans on the counter a few times to remove any air bubbles.
        Bake in the preheated oven for 30-35 minutes, or until a toothpick inserted into the center of the cakes comes out clean.
        <br><br>Remove the cakes from the oven and allow them to cool. Once the cakes are completely cool, place one layer on a serving plate or cake stand.
        Optionally, you can garnish the cake with chopped peanuts and mini chocolate chips if desired.',
        TRUE, 3, 5);
        ('Grilled Salmon', 90,
        'In a small bowl, whisk together brown sugar, lemon juice, black pepper, salt, soy sauce, olive oil, water, and minced garlic to create the marinade.
         <br><br>Place the salmon fillets in a shallow dish and pour the marinade over them. Make sure the salmon is well coated and refrigerate for at least 30 minutes, allowing it to marinate. For a more intense flavor, you can marinate it for up to 2 hours.
         <br><br>Preheat your grill to medium-high heat (about 190-200°C). If using a gas grill, preheat for about 10-15 minutes.
         <br><br>Remove the salmon from the marinade and discard any excess marinade. Brush the grill grates lightly with oil to prevent sticking.
        <br><br>Place the salmon fillets directly onto the grill, skin side down if they have skin. Close the lid and cook for about 4-6 minutes per side, depending on the thickness of the fillets.Avoid flipping the salmon too frequently to prevent it from falling apart. Use a spatula to carefully flip the fillets halfway through the cooking time.
        <br><br>The salmon is done when it flakes easily with a fork and reaches an internal temperature of 63°C.
        <br><br>Once the salmon is cooked through, remove it from the grill and transfer it to a serving platter.
        Optionally, garnish with fresh herbs like chopped parsley or dill.',
        TRUE, 1, 8),
        ('Pancakes', 30,
        'Sift together flour, baking powder, sugar, and salt in a large bowl.
        <br><br>Make a well in the center of the dry ingredients and add milk, melted butter, and egg. Mix until smooth.
        <br><br>Heat a lightly oiled griddle or pan over medium-high heat.
        <br><br>Pour or scoop the batter onto the griddle; cook until bubbles form and the edges are dry, about 2 to 3 minutes.
        <br><br>Flip and cook until browned on the other side.
        <br><br>Repeat with remaining butter.',
        TRUE, 4, 5),
        ('Green tahini', 5,
        'Blend up all your sauce ingredients in a food processor or blender until smooth. Taste and adjust. If the sauce is too runny, add a little more tahini.
        <br><br>Pour over roasted vegetables, beans, grains, protein… anything that needs to be woken up with some rich and creamy flavor!',
        TRUE, 2, 9);

INSERT INTO recipe_ingredient (amount_of_ingredient, fk_ingredient, fk_recipe)
VALUES ('2', 1, 1),
       ('1 spoon', 5, 1),
       ('1 spoon', 2, 1),
       ('for flavor', 6, 1),
       ('for flavor', 7, 1),
       ('1 spoon', 5, 2),
       ('2 cloves', 9, 2),
       ('200g', 12, 2),
       ('400g', 8, 2),
       ('1 cup grated', 10, 2),
       ('for flavor', 6, 2),
       ('for flavor', 7, 2),
       ('1 and 3/4 cups', 3, 3),
       ('3/4 cup', 13, 3),
       ('1.5 cups', 14, 3),
       ('1 and 1/2 spoons', 15, 3),
       ('1 spoon', 16, 3),
       ('2', 1, 3),
       ('1 cup', 2, 3),
       ('2 spoons', 17, 3),
       ('2 teaspoons', 19, 3),
       ('1 cup', 18, 3),
       ('1 teaspoon', 6, 3),
       ('2 fillets', 22, 4),
       ('1/2 cup', 20, 4),
       ('2 spoons', 21, 4),
       ('1/2 cup', 23, 4),
       ('2 cloves', 9, 4),
       ('2 spoons', 18, 4),
       ('3 spoons', 17, 4),
       ('for flavor', 6, 4),
       ('for flavor', 7, 4),
       ('1 and 1/2 cups', 3, 5),
       ('20g', 15, 5),
       ('1 spoon', 14, 5),
       ('300g', 2, 5),
       ('1', 1, 5),
       ('3 spoons', 5, 5),
       ('1/4 teaspoon', 6, 5),
       ('1/2 cup', 17, 6),
       ('1/4 cup', 25, 6),
       ('a big bunch', 24, 6),
       ('1/2 cup', 18, 6),
       ('1 clove', 9, 6),
       ('2 tablespoon', 21, 6),
       ('1/2 tablespoon', 6, 6);

INSERT INTO Recipe_Device (fk_device, fk_recipe)
VALUES (1, 1),
       (1, 2),
       (5, 3),
       (2, 3),
       (6, 4),
       (5, 5),
       (1, 5),
       (4, 6);

-- Inserting Ratings
INSERT INTO Rating (mark, fk_user, fk_recipe)
VALUES (3, 1, 1),
       (10, 1, 2),
       (7, 2, 3),
       (9, 3, 4),
       (8, 3, 5),
       (6, 2, 6);

-- Inserting Comments
INSERT INTO "comment" ("text", fk_user, fk_recipe)
VALUES ('Great recipe, loved it!', 1, 1),
       ('I added some extra cheese, delicious!', 2, 1),
       ('Easy to follow instructions, thanks!', 3, 1),
       ('Very tasty, soft and fluffy pancakes. I had to add a little bit more milk to make it thinner.', 1, 5),
       ('Best pancake recipe. I''m keeping it for sure, thank you :)', 2, 5),
       ('Tried this recipe instead of my usual store-bought mix. It is worth it.', 3, 5),
       ('Grilled this salmon on a charcoal grill, and the smoky flavor combined with the marinade was out of this world. Highly recommend!', 1, 4),
       ('I usually bake my salmon, but this grilled version was a game-changer. The marinade kept it moist and flavorful. Will definitely make again!', 2, 4),
       ('The combination of brown sugar and soy sauce creates a perfect balance of sweet and savory. My family loved it!', 3, 4),
       ('I used this green tahini sauce as a spread on my sandwiches and it was fantastic. So much better than mayo!', 1, 6),
       ('So easy to make and packed with flavor. I’ll be keeping a jar of this green tahini sauce in my fridge at all times!', 2, 6);

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


-- Inserting User Lists
INSERT INTO UserList (title, fk_user)
VALUES ('Favorites', 1),
       ('To Try', 2),
       ('Healthy Choices', 3);