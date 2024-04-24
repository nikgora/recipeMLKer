package com.example.recipemlker.repository;

import com.example.recipemlker.model.Category;
import com.example.recipemlker.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findFirstById(long id);

    List<Recipe> findAllByIsPublished(boolean published);

    List<Recipe> findAllByCategory(Category category);

    @Query(value = "SELECT DISTINCT r FROM Recipe r INNER JOIN r.recipeIngredients ri INNER JOIN ri.ingredient i WHERE i.name = :ingredientName")
    List<Recipe> findAllByRecipeIngredient(String ingredientName);

    List<Recipe> findAllByTitleStartsWith(String title);

    List<Recipe> findALlByCookingTimeBetween(int min, int max);

    @Query(value = "SELECT pr FROM Recipe pr JOIN Rating r ON pr.id = r.recipe.id GROUP BY pr.id HAVING AVG(r.mark) BETWEEN :min AND :max")
    List<Recipe> findAllByAverageRatingBetween(double min, double max);
}
