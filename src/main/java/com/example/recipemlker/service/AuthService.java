package com.example.recipemlker.service;

import com.example.recipemlker.dto.AuthDTO;

public interface AuthService {
    AuthDTO.JwtAuthenticationResponse signup(AuthDTO.SignupRequest request);

    AuthDTO.JwtAuthenticationResponse signin(AuthDTO.SigninRequest request);
}