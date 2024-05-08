package com.example.recipemlker.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface JpaUserDetailsService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username);
}
