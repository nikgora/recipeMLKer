package com.example.recipemlker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String mainPage() {return "user/main";}
    @GetMapping("/recipe")
    public String recipePage() {return "user/recipe";}
}
