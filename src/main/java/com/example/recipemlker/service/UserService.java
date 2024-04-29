package com.example.recipemlker.service;

import com.example.recipemlker.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User getUserById(Long id);

    User getUserByUsername(String username);

    UserDetailsService userDetailsService();
}
