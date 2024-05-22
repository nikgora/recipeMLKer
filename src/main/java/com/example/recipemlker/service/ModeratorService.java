package com.example.recipemlker.service;

import com.example.recipemlker.model.Moderator;
import com.example.recipemlker.model.User;

public interface ModeratorService {
    Moderator getFirstById(Long id);

    Moderator getFirstByUser(User user);

    boolean existsByUser(User user);
}
