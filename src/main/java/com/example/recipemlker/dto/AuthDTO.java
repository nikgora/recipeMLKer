package com.example.recipemlker.dto;

import lombok.Builder;
import lombok.Data;

public class AuthDTO {
   @Builder
    public record SigninRequest (String username, String password) {
    }
@Builder
    public record JwtAuthenticationResponse(String token) {
    }
@Builder
    public record SignupRequest(String username, String password) {
    }
}