package com.example.recipemlker.repository;

import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
    RecipeIngredient findFirstByRecipe(Recipe recipe);
    //TODO ADD SERVICE
}
