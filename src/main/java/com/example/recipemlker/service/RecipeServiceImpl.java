package com.example.recipemlker.service;

import com.example.recipemlker.model.Rating;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Override
    public List<Recipe> getAllRecipeIsPublished() {return recipeRepository.findAllByIsPublished(true);}

    @Override
    public List<Rating> getAllRatingForRecipe(Long id) {
        return recipeRepository.findById(id).get().getRatings();
    }

    @Override
    public double getAverageMarkForRecipe(Long id) {
        double sum = 0;
        List<Rating> ratings = getAllRatingForRecipe(id);
        for (Rating rating : ratings) {
            sum+=rating.getMark();
        }
        return sum/ratings.size();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).get();
    }

}
