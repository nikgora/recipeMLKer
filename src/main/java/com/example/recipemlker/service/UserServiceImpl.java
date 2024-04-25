package com.example.recipemlker.service;

import com.example.recipemlker.model.User;
import com.example.recipemlker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findFirstById(id);
    }
}
