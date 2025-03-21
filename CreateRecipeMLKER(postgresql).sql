CREATE TABLE CookingDevice
(
    device_id SERIAL PRIMARY KEY,
    title     VARCHAR(255) NOT NULL
);

CREATE TABLE Category
(
    category_id SERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL
);

CREATE TABLE "user"
(
    user_id    SERIAL PRIMARY KEY,
    login      VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL
);


CREATE TABLE Ingredient
(
    ingredient_id SERIAL PRIMARY KEY,
    "title"       VARCHAR(255) NOT NULL,
    allergen      BOOLEAN
);

CREATE TABLE PublishedRecipe
(
    recipe_id    SERIAL PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    cooking_time INT          NOT NULL,
    description  VARCHAR(1500) NOT NULL,
    published    BOOLEAN      NOT NULL,
    fk_user      INT REFERENCES "user" (user_id),
    fk_category  INT REFERENCES Category (category_id)
);

CREATE TABLE Moderator
(
    moderator_id    SERIAL PRIMARY KEY,
    secret_password VARCHAR(255) NOT NULL,
    fk_user         INT REFERENCES "user" (user_id)
);

CREATE TABLE UserReport
(
    report_id             SERIAL PRIMARY KEY,
    description           VARCHAR(255) NOT NULL,
    is_accepted           BOOLEAN,
    fk_user_id            INT REFERENCES "user" (user_id),
    fk_PublishedRecipe_id INT REFERENCES PublishedRecipe (recipe_id),
    fk_moderator          INT REFERENCES Moderator (moderator_id)
);

CREATE TABLE AIReport
(
    report_id    SERIAL PRIMARY KEY,
    description  VARCHAR(255) NOT NULL,
    is_accepted  BOOLEAN,
    fk_recipe    INT REFERENCES PublishedRecipe (recipe_id),
    fk_moderator INT REFERENCES Moderator (moderator_id)
);

CREATE TABLE Recipe_Ingredient
(
    recipe_ingredient_id SERIAL PRIMARY KEY,
    amount_of_ingredient VARCHAR(255),
    fk_ingredient        INT REFERENCES Ingredient (ingredient_id),
    fk_recipe            INT REFERENCES PublishedRecipe (recipe_id)
);

CREATE TABLE Recipe_Device
(
    recipe_device_id SERIAL PRIMARY KEY,
    fk_device        INT REFERENCES CookingDevice (device_id),
    fk_recipe        INT REFERENCES PublishedRecipe (recipe_id)
);
CREATE TABLE Rating
(
    rating_id SERIAL PRIMARY KEY,
    mark      DOUBLE PRECISION,
    fk_user   INT REFERENCES "user" (user_id),
    fk_recipe INT REFERENCES PublishedRecipe (recipe_id)
);

CREATE table "comment"
(
    comment_id SERIAL PRIMARY KEY,
    "text"     VARCHAR(255) NOT NULL,
    fk_user    INT REFERENCES "user" (user_id),
    fk_recipe  INT REFERENCES PublishedRecipe (recipe_Id)
);

CREATE TABLE UserList
(
    list_id SERIAL PRIMARY KEY,
    title   VARCHAR(255) NOT NULL,
    fk_user INT REFERENCES "user" (user_id)
);


CREATE TABLE Recipe_UserList
(
    recipe_userList_id SERIAL PRIMARY KEY,
    fk_recipe_id       INT REFERENCES PublishedRecipe (recipe_id),
    fk_user_list       INT REFERENCES UserList (list_id)
);

ALTER TABLE publishedrecipe
    ALTER COLUMN cooking_time TYPE integer USING cooking_time::integer;

