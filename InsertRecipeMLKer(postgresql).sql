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
       ('Tahini', FALSE),
       ('Blueberry', TRUE),
       ('Banana', FALSE),
       ('Greek yogurt', FALSE),
       ('Apple juice', FALSE),
       ('Mint', FALSE),
       ('Onion', FALSE),
       ('Leek', FALSE),
       ('Coriander', FALSE),
       ('Cumin', FALSE),
       ('Pumpkin', FALSE),
       ('Potato', FALSE),
       ('Chicken broth', FALSE),
       ('Sour cream', FALSE),
       ('Yeast', FALSE),
       ('Cinnamon', TRUE),
       ('Cream Cheese', FALSE),
       ('Powdered sugar', FALSE),
       ('Wholegrain Mustard', FALSE),
       ('Spinach', FALSE),
       ('Corn flakes', FALSE),
       ('Marshmallow', FALSE),
       ('Mushrooms', FALSE),
       ('Basil', FALSE),
       ('Pumpkin seeds', FALSE),
       ('Turkey', FALSE),
       ('Red bell pepper', FALSE),
       ('Orange', TRUE),
       ('Walnuts', TRUE),
       ('Oregano', FALSE),
       ('Cherry tomatoes', TRUE),
       ('Cucumber', FALSE),
       ('Red onion', FALSE),
       ('Olives', FALSE),
       ('Feta cheese', FALSE),
       ('Plum', FALSE),
       ('Coffee', FALSE),
       ('Cardamon', TRUE),
       ('Lemon', TRUE),
       ('Pomegranate', TRUE),
       ('Lime', TRUE),
       ('Lemonade', TRUE),
       ('Pack chorizo', TRUE),
       ('Turmeric', TRUE),
       ('Long rice', FALSE),
       ('Peas', FALSE),
       ('Seafood', TRUE),
       ('Rosemary', TRUE),
       ('Shallot', TRUE),
       ('Thyme', FALSE),
       ('Red wine', FALSE),
       ('Peppercorn', TRUE),
       ('Beef stock', TRUE);

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
        TRUE, 3, 5),
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
       ('Green Tahini', 5,
        'Blend up all your sauce ingredients in a food processor or blender until smooth. Taste and adjust. If the sauce is too runny, add a little more tahini.
        <br><br>Pour over roasted vegetables, beans, grains, protein… anything that needs to be woken up with some rich and creamy flavor!',
        TRUE, 2, 9),
       ('Blueberry Smoothie', 5,
        'Put the blueberries, banana, yogurt, apple juice and mint, if using, in a blender and blitz until smooth. Add a splash of water if it seems too thick.
     <br><br>Pour the smoothie into a tall glass with a glass straw to serve. Garnish with a sprig of mint, if you like.',
        TRUE, 1, 6),
       ('Pumpkin Soup', 40,
        'Heat oil in a large saucepan over low heat, add onion and leek and cook for 2-3 minutes, until softened but not coloured.
 <br><br>Add garlic, coriander, cumin, and nutmeg and cook, stirring, for 30 seconds. Add pumpkin, potato and stock and bring to the boil. Turn heat to low, cover and simmer for 30 minutes. Allow to cool slightly, then blend in batches.
 <br><br>Return soup to pan, stir through cream and reheat gently. Season and add a little more nutmeg if desired.',
        TRUE, 2, 1),
       ('Cinnabon Cinnamon Rolls', 90,
        'In the bowl of a stand mixer, dissolve yeast in warm milk until lightly foamy.
 <br><br>Add the rest of the ingredients to the bowl and mix with a wooden spoon until combined.
 <br><br>Attach the bowl to the mixer along with the dough hook. Kneed the dough for about 4 minutes until the dough is soft and smooth.
 Grease a clean with butter. Transfer the dough to the buttered bowl. Allow dough to rise undisturbed for one hour.
 <br><br>In a small bowl, mix the cinnamon and sugar together. Transfer the mixture to a sugar shaker (this will eliminate any lumps from the brown sugar). Put aside.
 Transfer the dough to a clean  lightly dusted with flour. Roll out the dough into a rectangle that’s approximately 12 inches by 16 inches.
 <br><br>With a spatula, spread the softened butter evenly over the dough. Sprinkle the cinnamon sugar evenly over the entire surface of the dough.
 From the long end, carefully roll the dough into a log. With a knife or floss, cut the dough into cinnamon rolls. Transfer cinnamon rolls to the buttered baking dish and cover the baking dish with a towel. Allow cinnamon rolls to rise for 30 minutes.
 <br><br>Preheat oven to 350 degrees. Bake the cinnamon rolls for 15 minutes with the foil tent.
 <br><br>In a mixing bowl, whip the butter, cream cheese, powdered sugar, salt and vanilla until light and fluffy.
 Using an icing spatula, frost the baked cinnamon rolls with icing while they’re still warm.',
        TRUE, 3, 4),
       ('Warm Potato Salad', 45,
        'Preheat oven to 180°C. Line 2 baking trays with baking paper. Place the potato and garlic on 1 lined tray. Spray with olive oil spray. Season. Bake for 45 mins or until potato is tender and the skin is crispy. Arrange the bacon on remaining lined tray. Bake with potato for the last 15 mins of cooking. Cool slightly. Tear bacon into pieces.
 <br><br>Meanwhile, cook the eggs in a saucepan of boiling water for 8 mins for set yolks. Refresh under cold water. Peel each egg and cut in half.
 <br><br>Squeeze the garlic into a small bowl and discard skins. Stir in the yoghurt, mustard and half the chives. Season.
 <br><br>Combine the potato, bacon, onion, spinach, egg and yoghurt mixture in a large bowl. Sprinkle with the remaining chives. Season.',
        TRUE, 2, 3),
       ('Cornflake Marshmallow Treats', 65,
        'Preheat oven to 160ºC. Line two rimmed baking sheets with parchment and divide cereal evenly between the two sheets. Gently crumble the cornflakes to break them up into smaller pieces.
 <br><br>Toast in the oven, using a spatula to stir the grains occasionally, until deep golden brown, about 10 minutes. Remove from oven and cool for 5 minutes. When cool, lift both sides of the parchment to form a “sleeve” and transfer corn flakes to a large bowl.
 <br><br>While the corn flakes toast, line a 9-by 9-inch baking dish with parchment and coat evenly with nonstick baking spray.
 <br><br>In a large pot, melt 4 tablespoons unsalted butter over medium heat, stirring until solids turn golden brown, 3 to 4 minutes. Reduce heat to low. Add salt, followed by marshmallows. Using a rubber spatula, stir until the marshmallows have just melted, about 4 minutes. Stir in toasted corn flakes, folding well to incorporate.
 <br><br>Transfer to prepared baking dish, using a rubber spatula greased with nonstick baking spray to coax the mixture into the pan.  Allow bars to cool for 30 minutes before portioning.
 <br><br>To portion, remove bars from the baking dish and place on a cutting board. Use a serrated knife to cut bars into squares, rectangles, or your desired shape.',
        TRUE, 2, 7),
       ('Creamy Mushroom Soup', 25,
        'Chop the onion and mushrooms into medium-sized pieces. Cook in about 1 tbsp vegetable oil until the onions are translucent and the mushrooms are soft, about 6-7 minutes. Don’t forget to stir them from time to time. Salt and pepper to taste. Add the ground coriander.
 <br><br>Transfer the cooked onion and mushrooms into a saucepan and add part of the milk. Using a hand blender, blitz until combined. Pour in the rest of the milk and blitz until smooth. You can adjust the amount of milk according to how thick you prefer your soup.
 <br><br>Reheat the soup over medium heat and cook for about 3-4 minutes. Garnish with pumpkin seeds and basil leaves before serving.',
        TRUE, 1, 1),
       ('Baked Turkey', 170,
        'Preheat the oven to 125 degrees.
 <br><br>Peel a turkey fillet, rub it with salt and pepper from all sides. Pour 1 tbsp of sunflower oil over the meat.Put the turkey fillet in a baking sleeve and pack tightly. Bake the meat in the oven at 125 degrees for 2.5 hours.
 <br><br>Wash the red bell pepper, make a small incision to let the air out. Wrap the pepper in foil together with 3 unpeeled cloves of garlic and add some salt.
 <br><br>Then remove the meat from the "sleeve" and bake the turkey for another 10 minutes. Put pepper with garlic in the oven together with the meat.
 <br><br>Peel the baked pepper and get rid of seeds.
 <br><br>Put pieces of baked pepper and garlic in a blender bowl. Add 2 tbsp. of walnuts, 1 tbsp. of sunflower oil, salt and pepper to the taste.
 <br><br>Squeeze a little orange juice into a bowl and mix everything with a blender to the desired texture of the sauce.
 <br><br>Cut the orange fillet. Spread the sauce on the turkey or on the side of the meat, lay out the orange fillets and sprinkle your dish with 1 tsp. of oregano.',
        TRUE, 2, 2),
       ('Greek Salad', 15,
        'Cut all vegetables into large pieces. Cherry tomatoes you can cut in a half, that’ll be enough.
 <br><br>The cucumber cut it in half, and then cut each half into half rings 0.5 cm thick. If necessary, peel the cucumber. Transfer to a bowl with the tomatoes.
 <br><br>The pepper cut it in half, remove the stem and seeds, then dice it about the same size as the tomatoes if you used regular instead of cherry tomatoes. The traditional Greek salad recipe uses green bell peppers, but you can substitute them with red, orange or yellow. Transfer the chopped pepper to a bowl.
 <br><br>Cut half of the onion into half rings. Also transfer to a bowl with all the salad ingredients.
 <br><br>If you are preparing a Greek salad in serving plates, put a piece of feta on top of the vegetables. Then everyone who will taste the dish will cut the cheese the way he wants. If you are preparing a Greek salad for a common table, cut 200 g of feta cheese into large cubes. But add to the bowl last.
 <br><br>Add pitted olives, oregano and salt.
 <br><br>Drizzle 3-4 tbsp. of olive oil and stir carefully. Then dice feta cheese and add it to the salad.
 <br><br>Then dice feta cheese and add it to the salad.',
        TRUE, 1, 3),
       ('Plum Pie', 50,
        'To make shortcrust pastry, mix 350 g of flour with warm butter (200 g) in a bowl, add an egg, a pinch of salt and 1 tablespoon of sugar. Knead a dough. If the dough is very dry, add 1 tablespoon of milk and 1 tablespoon of water. This will make a homogeneous dough.
 <br><br>Preheat the oven to 180 C. Roll out the dough between two sheets of parchment.
 <br><br>Carefully place the dough in a baking dish and press it slightly along the side with your hands.
 <br><br>Cut with a knife the remnants of the dough which go beyond the sides of the form. Make holes in the dough with a fork so that it is evenly baked and does not swell. Place the dough in the oven for 10-15 minutes.
 <br><br>Now wash 400 g of plums, cut them in half and remove the stones.
 <br><br>Transfer plums to a saucepan, add 200 g of sugar, 100 g of water, 3 pieces of cardamom, 1 tablespoon of ground coffee and 2 cinnamon sticks.
 <br><br>Cook plums for about 15-20 minutes on very low heat, stirring constantly so that the mixture does not burn.
 <br><br>Discard the finished filling in a colander to remove excess liquid and remove the cinnamon sticks.
 <br><br>Distribute the filling around the dough with a spoon. Put the pie in a preheated oven to 180 degrees for 10-15 minutes.
 <br><br>Remove the pie from the oven and let it cool. Grate a little zest (about half a lemon) directly on the cake.
 <br><br>Decorate the finished cake with mint leaves to give it a nice fresh note.',
        TRUE, 2, 4),
       ('Pomegranate Mojito', 10,
        'STEP 1
 <br>A day ahead, divide the pomegranate seeds between the holes in an ice cube tray, top up with water and freeze.
 <br><br>STEP 2
 <br>Reserve half the mint for serving, and tear the rest into a large jug with the lime quarters. Using a rolling pin, bash the mint and lime to release the flavours. Add the pomegranate juice and lemonade. Put ice cubes in each glass,
         then strain over the pomegranate mix through a small sieve. Garnish with lime slices and more mint.',
        TRUE, 3, 6),
       ('Seafood Rice', 25,
        'STEP 1
 <br>Heat the oil in a deep frying pan, then soften the leek for 5 mins without browning. Add the chorizo and fry until it releases its oils. Stir in the turmeric and rice until coated by the oils, then pour in the stock. Bring to the boil, then simmer for 15 mins, stirring occasionally.
 <br><br>STEP 2
 <br>Tip in the peas and cook for 5 mins, then stir in the seafood to heat through for a final 1-2 mins cooking or until rice is cooked. Check for seasoning and serve immediately with lemon wedges.',
        FALSE, 3, 8),
       ('Red Wine Sauce', 22,
        'Heat the oil in a large saucepan over a medium-high heat. Add the shallots, garlic, rosemary, thyme, peppercorns and salt. Cook for 5 minutes, stirring frequently.
 <br><br>Pour the wine into the pan, turn up the heat and reduce the liquid by two thirds.
 <br><br>Once the wine has reduced, add the beef stock and bring to a rolling boil. Keep the sauce at this temperature and continue to cook until the liquid has reduced by half and the sauce has thickened.
 <br><br>Carefully strain the sauce through a sieve into a clean saucepan, discarding the cooked vegetables and herbs.
 <br><br>The finished sauce should coat the back of a spoon, so if it hasn’t reached the right consistency just keep reducing the sauce in the pan before serving.',
        TRUE, 1, 9);

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
       ('1/2 tablespoon', 6, 6),
       ('175 g', 26, 7),
       ('1 small', 27, 7),
       ('1 tbsp', 28, 7),
       ('100 ml', 29, 7),
       ('3-4 leaves', 30, 7),
       ('2 tbsp', 17, 8),
       ('1 chopped', 31, 8),
       ('1 white part', 32, 8),
       ('1 clove', 9, 8),
       ('1/2 tbsp', 33, 8),
       ('1 tbsp', 34, 8),
       ('1 kg', 35, 8),
       ('1 large', 36, 8),
       ('1L', 37, 8),
       ('1/2 cup', 38, 8),
       ('1 packet dry', 39, 9),
       ('1 cup warm', 18, 9),
       ('2 large', 1, 9),
       ('1 cup', 5, 9),
       ('1 tsp', 6, 9),
       ('1/2 cup', 14, 9),
       ('5 cups', 3, 9),
       ('1 cup', 20, 9),
       ('3 spoons', 40, 9),
       ('1/4 cup', 41, 9),
       ('1 and 1/2 tsps', 19, 9),
       ('1 and 1/2 tsps', 42, 9),
       ('1kg', 36, 10),
       ('3 cloves', 9, 10),
       ('4', 1, 10),
       ('4 pieces', 12, 10),
       ('210g', 28, 10),
       ('3 tsp', 43, 10),
       ('1 red', 31, 10),
       ('60g', 44, 10),
       ('252g', 45, 11),
       ('56g', 5, 11),
       ('for flavor', 6, 11),
       ('1 bag', 46, 11),
       ('600g', 47, 12),
       ('200g', 31, 12),
       ('600-800ml', 2, 12),
       ('2 bunches', 48, 12),
       ('for flavor', 33, 12),
       ('for flavor', 6, 12),
       ('for flavor', 7, 12),
       ('', 49, 12),
       ('1 tbsp', 17, 12),
       ('800g of fillet', 50, 13),
       ('1', 51, 13),
       ('1', 52, 13),
       ('2 tbsp', 53, 13),
       ('3 cloves', 9, 13),
       ('1 tsp', 54, 13),
       ('2 tbsp', 17, 13),
       ('for flavor', 6, 13),
       ('for flavor', 7, 13),
       ('200g', 55, 14),
       ('1', 56, 14),
       ('1/2', 57, 14),
       ('50g', 58, 14),
       ('200g', 59, 14),
       ('1-2 tsp', 54, 14),
       ('3-4 tbsp', 17, 14),
       ('to taste', 6, 14),
       ('400g', 60, 15),
       ('210g', 14, 15),
       ('100g', 18, 15),
       ('1 tbsp', 61, 15),
       ('to taste', 62, 15),
       ('2 sticks', 40, 15),
       ('1/2 pieces', 63, 15),
       ('3 spings', 30, 15),
       ('350g', 3, 15),
       ('200g', 5, 15),
       ('1', 1, 15),
       ('1 pinch', 6, 15),
       ('1 tbsp', 2, 15),
       ('3 tbsp of seeds', 64, 16),
       ('big bunch', 30, 16),
       ('2', 65, 16),
       ('1L of juice', 64, 16),
       ('500ml', 66, 16),
       ('1 tbsp', 17, 17),
       ('1', 32, 17),
       ('110g', 67, 17),
       ('1 tsp', 68, 17),
       ('300g', 69, 17),
       ('1L', 37, 17),
       ('200g', 70, 17),
       ('400g', 71, 17),
       ('2 tbsp', 17, 18),
       ('100g', 73, 18),
       ('3 cloves', 9, 18),
       ('1 sprig', 72, 18),
       ('1 sprig', 74, 18),
       ('3', 76, 18),
       ('1/2 tsp', 6, 18),
       ('375ml', 75, 18),
       ('500ml', 77, 18);

INSERT INTO Recipe_Device (fk_device, fk_recipe)
VALUES (1, 1),
       (1, 2),
       (5, 3),
       (2, 3),
       (6, 4),
       (5, 5),
       (1, 5),
       (4, 6),
       (4, 7),
       (2, 8),
       (4, 8),
       (2, 9),
       (5, 9),
       (1, 10),
       (1, 11),
       (2, 12),
       (4, 12),
       (1, 13),
       (1, 15),
       (2, 17);

-- Inserting Ratings
INSERT INTO Rating (mark, fk_user, fk_recipe)
VALUES (3, 1, 1),
       (10, 1, 2),
       (7, 2, 3),
       (9, 3, 4),
       (8, 3, 5),
       (6, 2, 6),
       (4, 1, 10),
       (10, 3, 11),
       (8.3, 2, 12),
       (10, 1, 13),
       (7, 2, 14),
       (8, 1, 15),
       (9, 2, 16);

-- Inserting Comments
INSERT INTO "comment" ("text", fk_user, fk_recipe)
VALUES ('Great recipe, loved it!', 1, 1),
       ('I added some extra cheese, delicious!', 2, 1),
       ('Easy to follow instructions, thanks!', 3, 1),
       ('Very tasty, soft and fluffy pancakes. I had to add a little bit more milk to make it thinner.', 1, 5),
       ('Best pancake recipe. I''m keeping it for sure, thank you :)', 2, 5),
       ('Tried this recipe instead of my usual store-bought mix. It is worth it.', 3, 5),
       ('Grilled this salmon on a charcoal grill, and the smoky flavor combined with the marinade was out of this world. Highly recommend!',
        1, 4),
       ('I usually bake my salmon, but this grilled version was a game-changer. The marinade kept it moist and flavorful. Will definitely make again!',
        2, 4),
       ('The combination of brown sugar and soy sauce creates a perfect balance of sweet and savory. My family loved it!',
        3, 4),
       ('I used this green tahini sauce as a spread on my sandwiches and it was fantastic. So much better than mayo!',
        1, 6),
       ('So easy to make and packed with flavor. I’ll be keeping a jar of this green tahini sauce in my fridge at all times!',
        2, 6),
       ('The addition of leek and potato really adds a nice depth to the soup. It is become a staple in my fall recipe rotation.',
        1, 8),
       ('The spices in this soup are just right – not too overpowering but still flavorful.', 2, 8),
       ('Tried making this pumpkin soup for the first time and ended up with a kitchen disaster! Forgot to blend it and ended up with a chunky mess. Lesson learned: read the recipe thoroughly before starting!',
        3, 8),
       ('The flavors in this pumpkin soup were a bit too subtle for my taste. I ended up adding extra spices and a splash of hot sauce for some extra kick.',
        1, 8),
       ('We need to know if thought can make the night before and roll out the next morning? Thanks!', 1, 9),
       ('Thanks so much for putting up this recipe. It was so easy and they turned out great. I would recommend your recipe to All first timers wanting to make these cinnamon buns. So delicious too.',
        2, 9),
       ('In my search for Cinnabon Cinnamon Rolls I found this website. I made these cinnamon rolls for a friend of mine for her birthday. The rolls are very light and fluffy. And it was the very first time that a yeast dough turned out so perfectly for me.',
        3, 9),
       ('I can''t wait to try this recipe! The combination of crispy potato, savory bacon, and creamy yogurt sauce sounds absolutely mouthwatering.',
        1, 10),
       ('Didn''t have spinach, still amazing!', 2, 10),
       ('Love how versatile this recipe is, you can customize it with different cereals and add-ins.', 3, 11),
       ('Perfect snack for on-the-go or for a quick breakfast.', 1, 11),
       ('I bet adding a sprinkle of cinnamon would be delicious.', 2, 11),
       ('So much better than store-bought cereal bars, and healthier too!', 1, 11),
       ('I think I''ll add a splash of white wine while cooking the onions and mushrooms for extra flavor.', 1, 12),
       ('The pumpkin seeds and basil leaves garnish is a nice touch. Adds a bit of crunch and color!', 3, 12),
       ('Slow-cooking the turkey at 125 degrees for 2.5 hours must make it incredibly tender. Can''t wait to try this!',
        2, 13),
       ('The red bell pepper and garlic sauce sounds amazing. Adding walnuts for extra texture is a great idea.', 3,
        13),
       ('Peeling the bell pepper after baking can be tricky. Any tips on making it easier?', 4, 13),
       ('I usually add a splash of red wine vinegar to my Greek salad. Anyone else likes a bit of acidity?', 2, 14),
       ('I love the idea of making holes in the dough with a fork. It ensures the crust bakes evenly without puffing up.',
        1, 15),
       ('This recipe seems quite adaptable. I might try it with other fruits like peaches or cherries next time.', 3,
        15),
       ('This is my favorite non-alcoholic drink! I love this pomegranate mojito cocktail recipe because it is so refreshing and tasty.',
        1, 16),
       ('I had 150mls of leftover pomegranate juice so decided to make this to go along with some enchiladas. I quartered the recipe, using some cranberry to make up the juice and used fizzy water rather than lemonade. Made two good sized glasses.',
        2, 16),
       ('Not very flavoursome really. I think it might be better without being diluted with lemonade. The ice cubes are a great idea and look funky.',
        1, 16);

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