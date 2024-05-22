package com.example.recipemlker.service;

import com.example.recipemlker.model.Moderator;
import com.example.recipemlker.model.User;

public interface ModeratorService {
    Moderator getFirstById(Long id);

    boolean existsByUser(User user);
}
