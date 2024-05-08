package com.example.recipemlker.controller;

import com.example.recipemlker.dto.AuthDTO;
import com.example.recipemlker.model.User;
import com.example.recipemlker.service.AuthService;
import com.example.recipemlker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO.LoginRequest userLogin) {
        // Find user by username
        User userOptional = userService.getUserByUsername(userLogin.username());

        if (userOptional == null) {
            // User not found
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthDTO.Response("Invalid username or password", null));
        }


        // Authenticate user
        try {

            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            userLogin.username(),
                            userLogin.password()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Generate token
            String token = authService.generateToken(authentication);
            AuthDTO.Response response = new AuthDTO.Response("User logged in successfully", token);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthDTO.Response("Invalid username or password", null));
        }
    }

    @PostMapping("/register")

    public ResponseEntity<?> register(@RequestBody AuthDTO.RegisterRequest userRegister) {
        if (userService.isExistByLogin(userRegister.username())) {
            return ResponseEntity.badRequest().body(new AuthDTO.Response("Username already exists", null));
        }
        String encodedPassword = passwordEncoder.encode(userRegister.password());

        // Create new user
        User newUser = new User();
        newUser.setLogin(userRegister.username());
        newUser.setPassword(encodedPassword);
        userService.save(newUser);
        return ResponseEntity.ok(new AuthDTO.Response("User registered successfully", null));
    }
}