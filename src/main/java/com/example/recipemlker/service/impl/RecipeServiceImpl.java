package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.Category;
import com.example.recipemlker.model.Rating;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.repository.RecipeRepository;
import com.example.recipemlker.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipeIsPublished() {
        return recipeRepository.findAllByIsPublished(true);
    }

    @Override
    public List<Rating> getAllRatingForRecipe(Long id) {
        return recipeRepository.findFirstById(id).getRatings();
    }

    @Override
    public double getAverageMarkForRecipe(Long id) {
        double sum = 0;
        List<Rating> ratings = getAllRatingForRecipe(id);
        for (Rating rating : ratings) {
            sum += rating.getMark();
        }
        return sum / ratings.size();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Recipe> getAllByCategory(Category category) {
        return recipeRepository.findAllByCategory(category);
    }

    @Override
    public List<Recipe> getAllStartWith(String name) {
        return recipeRepository.findAllByTitleStartsWith(name);
    }

    @Override
    public List<Recipe> getAllByTimeBetween(int min, int max) {
        return recipeRepository.findALlByCookingTimeBetween(min, max);
    }

    @Override
    public List<Recipe> getAllByAverageRatingBetween(double min, double max) {
        return recipeRepository.findAllByAverageRatingBetween(min, max);
    }

    @Override
    public List<Recipe> getAllByIngredient(String ingredient) {
        return recipeRepository.findAllByRecipeIngredient(ingredient);
    }

}
