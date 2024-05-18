package com.example.recipemlker.service;

import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.RecipeUserList;
import com.example.recipemlker.model.UserList;

public interface RecipeUserListService {
    void save(RecipeUserList recipeUserList);

    RecipeUserList getFirstByUserListAndRecipe(UserList userList, Recipe recipe);
}
