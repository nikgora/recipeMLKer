package com.example.recipemlker.service.impl;

import com.example.recipemlker.dto.AuthDTO;
import com.example.recipemlker.model.User;
import com.example.recipemlker.repository.UserRepository;
import com.example.recipemlker.service.AuthService;
import com.example.recipemlker.service.JwtService;
import com.example.recipemlker.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@WebFilter
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, Filter {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private String jwt;

    @Override
    public AuthDTO.JwtAuthenticationResponse signup(AuthDTO.SignupRequest request) {
        if (userRepository.existsByLogin(request.username())) {
            throw new IllegalArgumentException("Such client is register");
        }
        User user = User.builder().login(request.username()).password(passwordEncoder.encode(request.password())).build();
        userRepository.save(user);
        jwt = jwtService.generateToken(user);
        return AuthDTO.JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public AuthDTO.JwtAuthenticationResponse signin(AuthDTO.SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        User user = userRepository.findByLogin(request.username())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        jwt = jwtService.generateToken(user);

        return AuthDTO.JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader(
                "Authorization", jwt);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}