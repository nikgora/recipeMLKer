package com.example.recipemlker.service;

import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.RecipeUserList;
import com.example.recipemlker.model.UserList;

import java.util.List;

public interface RecipeUserListService {
    void save(RecipeUserList recipeUserList);

    List<RecipeUserList> getAllByUserList(UserList userList);

    RecipeUserList getFirstByUserListAndRecipe(UserList userList, Recipe recipe);
}
