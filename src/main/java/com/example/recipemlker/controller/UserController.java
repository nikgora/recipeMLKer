package com.example.recipemlker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.params.GetExParams;

@Controller
public class UserController {
    @GetMapping("/")
    public String mainPage() {
        return "user/main";
    }

    @GetMapping("/allRecipes")
    public String allRecipePage() {
        return "user/allRecipes";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user/user";
    }

    @GetMapping("/recipe")
    public String recipePage(Model model, @RequestParam(value = "id") String id) {
        model.addAttribute("id", id);
        return "user/recipe";
    }
}
