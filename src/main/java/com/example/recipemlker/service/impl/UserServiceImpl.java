package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.AuthUser;
import com.example.recipemlker.model.User;
import com.example.recipemlker.repository.UserRepository;
import com.example.recipemlker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findFirstById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByLogin(username).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean isExistByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return new AuthUser(userRepository.findByLogin(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found")));
            }
        };
    }
}
