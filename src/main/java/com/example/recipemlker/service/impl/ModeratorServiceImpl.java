package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.Moderator;
import com.example.recipemlker.model.User;
import com.example.recipemlker.repository.ModeratorRepository;
import com.example.recipemlker.service.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeratorServiceImpl implements ModeratorService {
    @Autowired
    private ModeratorRepository moderatorRepository;

    public Moderator getFirstById(Long id) {
        return moderatorRepository.getFirstById(id);
    }

    public boolean existsByUser(User user) {
        return moderatorRepository.existsByUser(user);
    }
}
