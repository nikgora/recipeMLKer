package com.example.recipemlker.repository;

import com.example.recipemlker.model.Category;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findFirstById(long id);

    Recipe findFirstByTitle(String Title);

    List<Recipe> findAllByIsPublished(boolean published);

    List<Recipe> findAllByCategory(Category category);

//    List<Recipe> findAllByRecipeIngredients(List<RecipeIngredient> recipeIngredients);

    List<Recipe> findByUser(User user);
}
