package com.example.recipemlker.repository;

import com.example.recipemlker.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findById(long id);
    Recipe findByTitle(String Title);
    List<Recipe> findAllByIsPublished(boolean published);
}
