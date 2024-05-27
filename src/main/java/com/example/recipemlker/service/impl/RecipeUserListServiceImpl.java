package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.RecipeUserList;
import com.example.recipemlker.model.UserList;
import com.example.recipemlker.repository.RecipeUserListRepository;
import com.example.recipemlker.service.RecipeUserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeUserListServiceImpl implements RecipeUserListService {
    @Autowired
    RecipeUserListRepository recipeUserListRepository;

    @Override
    public RecipeUserList getFirstByUserListAndRecipe(UserList userList, Recipe recipe) {
        return recipeUserListRepository.getFirstByUserListAndRecipe(userList, recipe);
    }

    @Override
    public List<RecipeUserList> getAllByUserList(UserList userList) {
        return recipeUserListRepository.getAllByUserList(userList);
    }

    @Override
    public void save(RecipeUserList recipeUserList) {
        recipeUserListRepository.save(recipeUserList);
    }
}
