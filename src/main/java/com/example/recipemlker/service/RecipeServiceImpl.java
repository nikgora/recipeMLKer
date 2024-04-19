package com.example.recipemlker.service;

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
    public List<Recipe> getAllRecipeThatPublished() {return recipeRepository.findAllByis_published(true);}
}
