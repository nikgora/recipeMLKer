package com.example.recipemlker.controller;

import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.User;
import com.example.recipemlker.service.CategoryService;
import com.example.recipemlker.service.RecipeService;
import com.example.recipemlker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String mainPage() {
        return "user/main";
    }

    @GetMapping("/allRecipes")
    public String allRecipePage(Model model, @RequestParam(required = false) List<String> category, @RequestParam(required = false) List<String> ingredient, @RequestParam(required = false) List<String> startWith, @RequestParam(required = false) Integer minTime, @RequestParam(required = false) Integer maxTime, @RequestParam(required = false) Double minMark, @RequestParam(required = false) Double maxMark) {
        List<Recipe> recipes = this.recipeService.getAllRecipeIsPublished();
        if (category != null) {
            List<Recipe> recipeWithCategory = new ArrayList<>();
            for (String categoryName : category) {
                recipeWithCategory.addAll(this.recipeService.getAllByCategory(this.categoryService.getCategoryByTitle(categoryName)));
            }
            recipes.retainAll(recipeWithCategory);
        }
        if (startWith != null) {
            List<Recipe> recipeWithAlphabet = new ArrayList<>();
            for (String letter : startWith) {
                recipeWithAlphabet.addAll(this.recipeService.getAllStartWith(letter));
            }
            recipes.retainAll(recipeWithAlphabet);
        }
        if (minTime != null && maxTime != null) {
            List<Recipe> recipeWithTime = new ArrayList<>(this.recipeService.getAllByTimeBetween(minTime, maxTime));
            recipes.retainAll(recipeWithTime);
        }
        if (minMark != null && maxMark != null) {
            List<Recipe> recipeWithMark = new ArrayList<>(this.recipeService.getAllByAverageRatingBetween(minMark, maxMark));
            recipes.retainAll(recipeWithMark);
        }
        if (ingredient != null) {
            List<Recipe> recipeWithIngredient = new ArrayList<>();
            for (String ingredientName : ingredient) {
                recipeWithIngredient.addAll(this.recipeService.getAllByIngredient(ingredientName));
            }
            recipes.retainAll(recipeWithIngredient);
        }

        model.addAttribute("recipes", recipes);
        return "user/allRecipes";
    }


    @GetMapping("/403")
    public String userPage() {
        return "user/403";
    }

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable Long id, Model model, @AuthenticationPrincipal User user) {
        if (Objects.equals(user.getId(), id)) {
            model.addAttribute("user", userService.getUserById(id));
            return "user/user";
        }
        return "redirect:/403";
    }

    @GetMapping("/recipe/{id}")
    public String recipePage(Model model, @PathVariable("id") Long id) {
        if (this.recipeService.getRecipeById(id).isPublished()) {
            model.addAttribute("recipe", this.recipeService.getRecipeById(id));
            return "user/recipe";
        }
        return "redirect:/403";
    }
}
