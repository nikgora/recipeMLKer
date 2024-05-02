package com.example.recipemlker.service;

import com.example.recipemlker.model.Recipe;

public interface AIService {
    String isOkToPublish(Recipe recipe);
}
