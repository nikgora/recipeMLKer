package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.Rating;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.User;
import com.example.recipemlker.repository.RatingRepository;
import com.example.recipemlker.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public void save(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public Rating getByUserAndRecipe(User user, Recipe recipe) {
        return ratingRepository.getRatingByUserAndRecipe(user, recipe);
    }
}
