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

