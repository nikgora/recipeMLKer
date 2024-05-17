package com.example.recipemlker.service;

import com.example.recipemlker.model.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient getIngredientByName(String name);

    List<Ingredient> findAll();

}
