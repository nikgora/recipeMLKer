package com.example.recipemlker.controller;

import com.example.recipemlker.dto.AuthDTO;
import com.example.recipemlker.dto.AuthDTO.JwtAuthenticationResponse;
import com.example.recipemlker.model.Comment;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.User;
import com.example.recipemlker.model.UserList;
import com.example.recipemlker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthService authService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserListService userListService;
    private String jwt = null;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("isLogin", jwt != null);
        model.addAttribute("randomRecipeId", getRandomNumRecipe());
        return "user/main";
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody AuthDTO.SignupRequest request) {
        var jwt1 = authService.signup(request);
        User user = userService.getUserByUsername(jwtService.extractUserName(jwt1.token()));
        UserList userList = new UserList();
        userList.setUser(user);
        userList.setDescription("My favorite recipes");
        userList.setTitle("Favorites");
        userListService.save(userList);
        List<UserList> userLists = new ArrayList<>(1);
        userLists.add(userList);
        user.setUserLists(userLists);
        return ResponseEntity.ok(jwt1);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody AuthDTO.SigninRequest request) {
        var jwt1 = authService.signin(request);
        jwt = jwt1.token();
        return ResponseEntity.ok(jwt1);
    }

    @GetMapping("/allRecipes")
    public String allRecipePage(Model model, @RequestParam(required = false) List<String> device, @RequestParam(required = false) List<String> category, @RequestParam(required = false) List<String> ingredient, @RequestParam(required = false) List<String> startWith, @RequestParam(required = false) Integer minTime, @RequestParam(required = false) Integer maxTime, @RequestParam(required = false) Double minMark, @RequestParam(required = false) Double maxMark) {
        List<Recipe> recipes = this.recipeService.getAllRecipeIsPublished();
        if (device != null) {
            List<Recipe> recipeWithDevice = new ArrayList<>();
            for (String deviceName : device) {
                recipeWithDevice.addAll(this.recipeService.getAllByDevice(deviceName));
            }
            recipes.retainAll(recipeWithDevice);
        }
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
        model.addAttribute("isLogin", jwt != null);
        model.addAttribute("randomRecipeId", getRandomNumRecipe());
        model.addAttribute("recipes", recipes);
        return "user/allRecipes";
    }


    @GetMapping("/403")
    public String forbidden() {
        return "user/403";
    }

    @GetMapping("/404")
    public String notExist() {
        return "user/404";
    }

    @GetMapping("/user")
    public String userPage(Model model) {
        if (jwt == null) {
            return "redirect:/403";
        }
        User user = userService.getUserByUsername(jwtService.extractUserName(jwt));
        model.addAttribute("isLogin", jwt != null);
        model.addAttribute("randomRecipeId", getRandomNumRecipe());
        model.addAttribute("user", user);
        model.addAttribute("notes", recipeService.getAllByUser(user));
        model.addAttribute("newList", new UserList());
        return "user/user";
    }

    @PostMapping("/api/newList")
    public String newList(@ModelAttribute UserList userList) {
        if (jwt == null) {
            return "redirect:/403";
        }
        User user = userService.getUserByUsername(jwtService.extractUserName(jwt));
        UserList newUserList = new UserList();
        newUserList.setTitle(userList.getTitle());
        newUserList.setUser(user);
        newUserList.setDescription(userList.getDescription());
        userListService.save(newUserList);
        return "redirect:/user";
    }

    @PostMapping("/api/logout")
    public String logout() {
        jwt = null;
        return "redirect:/";
    }

    @GetMapping("/mustBeLogin")
    public String mustBeLogin() {
        return "user/mustBeLogin";
    }

    @GetMapping("/recipe/{id}")
    public String recipePage(Model model, @PathVariable("id") Long id) {
        if (this.recipeService.getRecipeById(id) == null) {
            return "redirect:/404";
        }
        if (this.recipeService.getRecipeById(id).isPublished()) {
            model.addAttribute("recipe", this.recipeService.getRecipeById(id));
            model.addAttribute("id", id);
            model.addAttribute("isLogin", jwt != null);
            model.addAttribute("randomRecipeId", getRandomNumRecipe());
            Comment comment = new Comment();
            model.addAttribute("comment", comment);
            return "user/recipe";
        }
        return "redirect:/403";
    }

    @GetMapping("/newRecipe")
    public String newRecipePageForm(Model model) {
        if (jwt == null) return "redirect:/mustBeLogin";
        Recipe recipe = new Recipe();
        User user = (userService.getUserByUsername(jwtService.extractUserName(jwt)));
        model.addAttribute("user", user);
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("recipe", recipe);
        model.addAttribute("isLogin", jwt != null);
        model.addAttribute("randomRecipeId", getRandomNumRecipe());
        return "user/recipeCreation";
    }

    @PostMapping("/api/newRecipe")
    public String newRecipePageSubmit(@ModelAttribute Recipe recipe) {
        User user = (userService.getUserByUsername(jwtService.extractUserName(jwt)));
        recipe.setCategory(categoryService.getCategoryById(1L));
        recipe.setUser(user);
        recipeService.save(recipe);
        return "redirect:/user";
    }

    @PostMapping("/api/newComment/{id}")
    public String newComment(@ModelAttribute Comment comment, @PathVariable("id") Long id) {

        if (jwt == null) return "redirect:/mustBeLogin";
        if (this.recipeService.getRecipeById(id) == null) {
            return "redirect:/404";
        }
        Comment newComment = new Comment();
        if (!this.recipeService.getRecipeById(id).isPublished()) return "redirect:/403";
        newComment.setUser(userService.getUserByUsername(jwtService.extractUserName(jwt)));
        newComment.setRecipe(recipeService.getRecipeById(id));
        newComment.setText(comment.getText());
        commentService.save(newComment);
        String string = "redirect:/recipe/" + id;
        return string;
    }

    private Long getRandomNumRecipe() {
        List<Recipe> recipes = recipeService.getAllRecipeIsPublished();
        Random random = new Random();
        int ind = random.nextInt(recipes.size());
        return recipes.get(ind).getId();
    }
}
