package com.example.recipemlker.service;

import com.example.recipemlker.dao.request.SignInRequest;
import com.example.recipemlker.dao.request.SignUpRequest;
import com.example.recipemlker.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);
}
