CREATE TABLE CookingDevice (
        device_id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL
);

CREATE TABLE Category (
        category_id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL
);

CREATE TABLE "User" (
user_id SERIAL PRIMARY KEY,
        login VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL
);

CREATE TABLE AI (
        ai_id SERIAL PRIMARY KEY,
secret_password VARCHAR(255) NOT NULL
);
CREATE TABLE Ingredient (
        ingredient_id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
amount_of_ingredient VARCHAR(255) NOT NULL,
allergen BOOLEAN
);
CREATE TABLE PublishedRecipe (
        recipe_id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
cooking_time VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL,
is_favorite BOOLEAN,
        fk_category INT REFERENCES Category(category_id)
);

CREATE TABLE UserReport (
        report_id SERIAL PRIMARY KEY,
description VARCHAR(255) NOT NULL,
fk_user_id INT REFERENCES "User"(user_id),
fk_PublishedRecipe_id INT REFERENCES PublishedRecipe(recipe_id)
);

CREATE TABLE Moderator (
        moderator_id SERIAL PRIMARY KEY,
secret_password VARCHAR(255) NOT NULL,
fk_user INT REFERENCES "User"(user_id),
fk_report INT REFERENCES UserReport(report_id)

);



CREATE TABLE AIReport (
        report_id SERIAL PRIMARY KEY,
	description VARCHAR(255) NOT NULL,
	fk_ai INT REFERENCES AI(ai_id),
        fk_recipe INT REFERENCES PublishedRecipe(recipe_id)
);





CREATE TABLE Recipe (
        fk_device INT REFERENCES CookingDevice (device_id),
        fk_ingredient INT REFERENCES Ingredient (ingredient_id),
        fk_recipe INT REFERENCES PublishedRecipe(recipe_id)
);

CREATE TABLE Rating(
        rating_id SERIAL PRIMARY KEY,
mark DOUBLE PRECISION,
fk_user INT REFERENCES "User"(user_id),
fk_recipe INT REFERENCES PublishedRecipe(recipe_id)
);

CREATE table "Comment"(
        comment_id SERIAL PRIMARY KEY,
text VARCHAR(255) NOT NULL ,
fk_user INT REFERENCES "User"(user_id),
        fk_recipe INT REFERENCES PublishedRecipe(recipe_Id)
);

CREATE TABLE UserList (
        list_id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL,
fk_user INT REFERENCES "User"(user_id)
);

CREATE TABLE UserRecipe (
        user_recipe_id SERIAL PRIMARY KEY,
is_published BOOLEAN,
        fk_user INT REFERENCES "User"(user_id),
fk_recipe INT REFERENCES PublishedRecipe(recipe_id)
);







CREATE TABLE AddedList (
        fk_recipe_id INT REFERENCES PublishedRecipe(recipe_id),
        fk_user_list INT REFERENCES "User"(user_id)
);


