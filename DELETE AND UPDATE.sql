DELETE FROM category
WHERE category_id=1;

UPDATE publishedrecipe
SET fk_category=6
WHERE recipe_id=5;

UPDATE publishedrecipe
SET fk_category=11
WHERE recipe_id=6;

DELETE FROM category
WHERE category_id=2;
DELETE FROM category
WHERE category_id=3;

UPDATE category
SET title='First Dish'
WHERE category_id=5;

UPDATE category
SET title='Drink'
WHERE category_id=10;

UPDATE category
SET title='Snack'
WHERE category_id=11;

UPDATE category
SET title='Sauce'
WHERE category_id=13;

ALTER TABLE publishedrecipe
ALTER COLUMN description TYPE VARCHAR(900);

UPDATE publishedrecipe
SET description='Whisk eggs with milk (if using), salt, and pepper. Heat butter in a pan over medium heat. Add egg mixture and let the base set slightly. Gently run a spoon through eggs, creating soft curds. Push and fold until just cooked but slightly custardy. Remove from heat, stir briefly, then serve piled on toast or preferred accompaniment.'
WHERE recipe_id=1

UPDATE publishedrecipe
SET description='Bring a large pot of salted water to a boil (1 tablespoon salt for every 2 quarts of water). In a large sauté pan over medium heat, heat the butter. Add the diced pancetta and cook until crispy. If using garlic, add it and cook for another minute. Turn off the heat and transfer the pancetta and garlic to a large bowl.
In a small bowl, beat the eggs and mix in about half of the grated cheese. Once the water is boiling, add the dry pasta and cook until al dente.
Using tongs, transfer the cooked pasta to the bowl with the pancetta and garlic. Let it be dripping wet. Reserve some of the pasta water. Quickly toss the pasta with the beaten eggs and cheese until well combined. Season with salt and pepper to taste.
Garnish with the remaining grated cheese and freshly ground black pepper. Optionally, sprinkle with chopped parsley before serving. Enjoy immediately.'
WHERE recipe_id=2

UPDATE publishedrecipe
SET description='Preheat your oven to 175°C. Grease and flour cake pans and line the bottoms with parchment paper. In a large mixing bowl, sift together the flour, cocoa powder, granulated sugar, baking powder, baking soda, and salt.
Add the eggs, milk, oil, and vanilla extract to the dry ingredients. Beat on medium speed for 2 minutes until well combined.
Stir in the boiling water until the batter is smooth.
Pour the batter evenly into the prepared cake pans. Tap the pans on the counter a few times to remove any air bubbles.
Bake in the preheated oven for 30-35 minutes, or until a toothpick inserted into the center of the cakes comes out clean.
Remove the cakes from the oven and allow them to cool. Once the cakes are completely cool, place one layer on a serving plate or cake stand.
Optionally, you can garnish the cake with chopped peanuts and mini chocolate chips if desired.'
WHERE recipe_id=3
