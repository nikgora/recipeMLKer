package com.example.recipemlker.service;

import com.example.recipemlker.model.Ingredient;

public interface IngredientService {
    Ingredient getIngredientByName(String name);
}
