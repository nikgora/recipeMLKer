package com.example.recipemlker.repository;

import com.example.recipemlker.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findFirstByName(String name);

    @Query("select ing from Ingredient ing")
    List<Ingredient> findAll();
}
