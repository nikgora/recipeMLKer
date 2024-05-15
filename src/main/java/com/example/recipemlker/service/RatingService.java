package com.example.recipemlker.service;

import com.example.recipemlker.model.Rating;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.User;

public interface RatingService {
    public void save(Rating rating);

    public Rating getByUserAndRecipe(User user, Recipe recipe);
}