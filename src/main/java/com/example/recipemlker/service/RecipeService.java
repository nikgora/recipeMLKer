package com.example.recipemlker.service;

import com.example.recipemlker.model.Category;
import com.example.recipemlker.model.Rating;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.User;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipeIsPublished();

    List<Rating> getAllRatingForRecipe(Long id);

    double getAverageMarkForRecipe(Long id);

    Recipe getRecipeById(Long id);

    List<Recipe> getAllByCategory(Category category);

    List<Recipe> getAllStartWith(String name);

    List<Recipe> getAllByTimeBetween(int min, int max);

    List<Recipe> getAllByAverageRatingBetween(double min, double max);

    List<Recipe> getAllByIngredient(String ingredient);

    void save(Recipe recipe);

    List<Recipe> getAllByUser(User user);

    List<Recipe> getAllByDevice(String device);
}
