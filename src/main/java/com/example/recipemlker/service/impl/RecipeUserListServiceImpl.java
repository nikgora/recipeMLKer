package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.RecipeUserList;
import com.example.recipemlker.repository.RecipeUserListRepository;
import com.example.recipemlker.service.RecipeUserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeUserListServiceImpl implements RecipeUserListService {
    @Autowired
    RecipeUserListRepository recipeUserListRepository;

    @Override
    public void save(RecipeUserList recipeUserList) {
        recipeUserListRepository.save(recipeUserList);
    }
}
