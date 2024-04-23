package com.example.recipemlker.service;

import com.example.recipemlker.model.Category;
import com.example.recipemlker.model.Ingredient;
import com.example.recipemlker.model.Rating;
import com.example.recipemlker.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipeIsPublished();
    List<Rating> getAllRatingForRecipe(Long id);
    double getAverageMarkForRecipe(Long id);
    Recipe getRecipeById(Long id);
    List<Recipe> getAllByCategory (Category category);
    List<Recipe> getAllByIngredient(Ingredient ingredient);
}
