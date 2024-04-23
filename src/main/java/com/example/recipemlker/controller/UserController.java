package com.example.recipemlker.controller;

import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.repository.RecipeRepository;
import com.example.recipemlker.service.CategoryService;
import com.example.recipemlker.service.RecipeService;
import com.example.recipemlker.service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.params.GetExParams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public String mainPage() {
        return "user/main";
    }

    @GetMapping("/allRecipe")
    public String allRecipePage(Model model, @RequestParam(required = false) String category) {
        List<Recipe> recipes = this.recipeService.getAllRecipeIsPublished();
        if (category != null) {
            recipes.retainAll(this.recipeService.getAllByCategory(this.categoryService.getCategoryByTitle(category)));
        }
        model.addAttribute("recipes", recipes);
        return "user/allRecipe";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user/user";
    }

    @GetMapping("/recipe/{id}")
    public String recipePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("recipe", this.recipeService.getRecipeById(id));
        return "user/recipe";
    }
}
