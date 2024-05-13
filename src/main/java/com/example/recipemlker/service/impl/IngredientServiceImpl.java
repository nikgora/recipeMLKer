package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.Ingredient;
import com.example.recipemlker.repository.IngredientRepository;
import com.example.recipemlker.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient getIngredientByName(String name) {
        return ingredientRepository.findFirstByName(name);
    }
}
