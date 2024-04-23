package com.example.recipemlker.controller;

import com.example.recipemlker.model.Ingredient;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.repository.RecipeRepository;
import com.example.recipemlker.service.CategoryService;
import com.example.recipemlker.service.IngredientService;
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
    private IngredientService ingredientService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public String mainPage() {
        return "user/main";
    }

    @GetMapping("/allRecipe")
    public String allRecipePage(Model model, @RequestParam(required = false) List<String> category,  @RequestParam(required = false) List<String> ingredient) {
        List<Recipe> recipes = this.recipeService.getAllRecipeIsPublished();
        if (category != null) {
            List<Recipe> recipeWithCategory = new ArrayList<>();
            for (String categoryName : category) {
                recipeWithCategory.addAll(this.recipeService.getAllByCategory(this.categoryService.getCategoryByTitle(categoryName)));
            }
            recipes.retainAll(recipeWithCategory);
        }
        if (ingredient != null) {
            List<Recipe> recipeWithIngredient = new ArrayList<>();
            for (String ingredientName : ingredient) {
                recipeWithIngredient.addAll(this.recipeService.getAllByIngredient(this.ingredientService.getIngredientByName(ingredientName)));
            }
            recipes.retainAll(recipeWithIngredient);
        }

        model.addAttribute("recipes", recipes);
        return "user/allRecipe";
    }

    @GetMapping("/403")
    public String userPage() {
        return "user/403";
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
