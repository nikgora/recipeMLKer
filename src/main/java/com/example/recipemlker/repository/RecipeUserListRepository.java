package com.example.recipemlker.repository;

import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.RecipeUserList;
import com.example.recipemlker.model.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeUserListRepository extends JpaRepository<RecipeUserList, Long> {
    RecipeUserList getFirstByUserListAndRecipe(UserList userList, Recipe recipe);
}
