package com.example.recipemlker.service.impl;

import com.example.recipemlker.dto.AuthDTO;
import com.example.recipemlker.model.User;
import com.example.recipemlker.repository.UserRepository;
import com.example.recipemlker.service.AuthService;
import com.example.recipemlker.service.JwtService;
import com.example.recipemlker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthDTO.JwtAuthenticationResponse signup(AuthDTO.SignupRequest request) {
        User user = User.builder().login(request.username()).password(passwordEncoder.encode(request.password())).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return AuthDTO.JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public AuthDTO.JwtAuthenticationResponse signin(AuthDTO.SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        var user = userRepository.findByLogin(request.username())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return AuthDTO.JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
//https://github.com/buingoctruong/springboot3-springsecurity6-jwt/blob/master/src/main/java/com/truongbn/security/dao/request/SigninRequest.java