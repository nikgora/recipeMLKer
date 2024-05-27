package com.example.recipemlker.controller;

import com.example.recipemlker.dto.AuthDTO;
import com.example.recipemlker.dto.AuthDTO.JwtAuthenticationResponse;
import com.example.recipemlker.model.*;
import com.example.recipemlker.service.*;
import lombok.Getter;
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
    private RecipeUserListService recipeUserListService;
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
    private RatingService ratingService;
    @Autowired
    private UserReportService userReportService;
    @Autowired
    private AiReportService aiReportService;
    @Autowired
    private UserListService userListService;
    @Autowired
    private ModeratorService moderatorService;

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private IngredientService ingredientService;
    @Getter
    private String jwt = null;

    @GetMapping("/")
    public String mainPage(Model model) {
        if (jwt != null) {
            UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", userService.getUserByUsername(jwtService.extractUserName(jwt)));
            model.addAttribute("favoriteList", favoriteList);
        }
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
        userList.setTitle("Favorites");
        userListService.save(userList);
        List<UserList> userLists = new ArrayList<>(1);
        userLists.add(userList);
        user.setUserLists(userLists);
        jwt = jwt1.token();
        return ResponseEntity.ok(jwt1);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody AuthDTO.SigninRequest request) {
        var jwt1 = authService.signin(request);
        jwt = jwt1.token();
        return ResponseEntity.ok(jwt1);
    }

    @GetMapping("/userList/{name}")
    public String Sfd(Model model, @PathVariable("name") String name, @RequestParam(required = false) List<String> device, @RequestParam(required = false) List<String> category, @RequestParam(required = false) List<String> ingredient, @RequestParam(required = false) List<String> startWith, @RequestParam(required = false) Integer minTime, @RequestParam(required = false) Integer maxTime, @RequestParam(required = false) Double minMark, @RequestParam(required = false) Double maxMark) {
        if (jwt == null) {
            return "redirect:/403";
        }
        User user = userService.getUserByUsername(jwtService.extractUserName(jwt));
        UserList userList = userListService.getFirstByTitleAndUser(name, user);
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeUserList> recipeUserLists = recipeUserListService.getAllByUserList(userList);
        for (var recipeUserList : recipeUserLists) {
            recipes.add(recipeUserList.getRecipe());
        }
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
        model.addAttribute("ingredients", ingredientService.findAll());
        model.addAttribute("devices", deviceService.findAll());

        return "user/allLists";
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
        if (jwt != null) {
            UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", userService.getUserByUsername(jwtService.extractUserName(jwt)));
            model.addAttribute("favoriteList", favoriteList);
        }

        model.addAttribute("isLogin", jwt != null);
        model.addAttribute("randomRecipeId", getRandomNumRecipe());
        model.addAttribute("recipes", recipes);
        model.addAttribute("ingredients", ingredientService.findAll());
        model.addAttribute("devices", deviceService.findAll());
        return "user/allRecipes";
    }

    @PostMapping("/api/addRecipeToList/{id}/{name}")
    public String addRecipeToList(@PathVariable("id") Long id, @PathVariable("name") String name) {
        if (jwt == null) return "redirect:/recipe/" + id;
        if (this.recipeService.getRecipeById(id) == null) {
            return "redirect:/404";
        }
        if (!this.recipeService.getRecipeById(id).isPublished()) return "redirect:/403";
        User user = userService.getUserByUsername(jwtService.extractUserName(jwt));
        UserList userList = userListService.getFirstByTitleAndUser(name, user);
        if (userList == null) return "redirect:/404";
        Recipe recipe = recipeService.getRecipeById(id);
        RecipeUserList exist = recipeUserListService.getFirstByUserListAndRecipe(userList, recipe);
        RecipeUserList recipeUserList = new RecipeUserList();
        if (exist != null) recipeUserList.setId(exist.getId());
        recipeUserList.setUserList(userList);
        recipeUserList.setRecipe(recipe);
        recipeUserListService.save(recipeUserList);
        return "redirect:/recipe/" + id;
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

        String username = jwtService.extractUserName(jwt);
        User user = userService.getUserByUsername(username);
        UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", user);
        model.addAttribute("favoriteList", favoriteList);
        model.addAttribute("isLogin", jwt != null);
        model.addAttribute("randomRecipeId", getRandomNumRecipe());
        model.addAttribute("user", user);
        model.addAttribute("notes", recipeService.getAllByUser(user));
        model.addAttribute("newList", new UserList());
        model.addAttribute("isAdmin", moderatorService.existsByUser(user));
        model.addAttribute("moderator", new Moderator());
        return "user/user";
    }

    @PostMapping("/api/newList/{id}")
    /// 0 - user page, some else recipe id
    public String newList(@ModelAttribute UserList userList, @PathVariable("id") Long id) {
        if (jwt == null) {
            return "redirect:/403";
        }
        User user = userService.getUserByUsername(jwtService.extractUserName(jwt));
        UserList newUserList = new UserList();
        newUserList.setTitle(userList.getTitle());
        newUserList.setUser(user);
        userListService.save(newUserList);
        if (id == 0) return "redirect:/user";
        String newList = "redirect:/recipe/" + id;
        return newList;
    }

    @PostMapping("/api/logout")
    public String logout() {
        jwt = null;
        return "redirect:/";
    }

    @GetMapping("/allLists")
    public String allLists(Model model) {
        if (jwt == null) return "redirect:/mustBeLogin";
        if (jwt != null) {
            UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", userService.getUserByUsername(jwtService.extractUserName(jwt)));
            model.addAttribute("favoriteList", favoriteList);
        }

        model.addAttribute("isLogin", true);
        model.addAttribute("randomRecipeId", getRandomNumRecipe());
        model.addAttribute("lists", userListService.getAllByUser(userService.getUserByUsername(jwtService.extractUserName(jwt))));
        return "user/allLists";
    }

    @PostMapping("/api/publishRecipe/{id}")
    public String publishRecipe(@PathVariable("id") Long id) {
        if (jwt == null) {
            return "redirect:/mustBeLogin";
        }
        Recipe recipe = recipeService.getRecipeById(id);
        AiReport aiReport = new AiReport();
        aiReport.setRecipe(recipe);
        aiReport.setDescription("New recipe in site. Please check");
        aiReportService.save(aiReport);
        return "redirect:/user";
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
        if (jwt != null) {
            UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", userService.getUserByUsername(jwtService.extractUserName(jwt)));
            model.addAttribute("favoriteList", favoriteList);
        }
        if (this.recipeService.getRecipeById(id).isPublished() || (jwt != null && userService.getUserByUsername(jwtService.extractUserName(jwt)) == this.recipeService.getRecipeById(id).getUser())) {
            model.addAttribute("recipe", this.recipeService.getRecipeById(id));
            model.addAttribute("id", id);
            model.addAttribute("isLogin", jwt != null);
            model.addAttribute("randomRecipeId", getRandomNumRecipe());
            Rating existed = null;
            if (jwt != null) {
                UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", userService.getUserByUsername(jwtService.extractUserName(jwt)));
                model.addAttribute("favoriteList", favoriteList);
                existed = ratingService.getByUserAndRecipe(userService.getUserByUsername(jwtService.extractUserName(jwt)), recipeService.getRecipeById(id));
                model.addAttribute("user", userService.getUserByUsername(jwtService.extractUserName(jwt)));
            }
            if (existed == null) {
                existed = new Rating();
                existed.setMark(10.0);
            }
            UserReport userReport = new UserReport();
            model.addAttribute("newList", new UserList());
            model.addAttribute("userReport", userReport);
            model.addAttribute("rating", existed);
            Comment comment = new Comment();
            model.addAttribute("comment", comment);
            model.addAttribute("isModerator", false);
            return "user/recipe";
        }
        return "redirect:/403";
    }

    @GetMapping("/newRecipe")
    public String newRecipePageForm(Model model) {
        if (jwt == null) return "redirect:/mustBeLogin";
        UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", userService.getUserByUsername(jwtService.extractUserName(jwt)));
        model.addAttribute("favoriteList", favoriteList);

        Recipe recipe = new Recipe();
        User user = (userService.getUserByUsername(jwtService.extractUserName(jwt)));
        model.addAttribute("user", user);
        model.addAttribute("ingredients", ingredientService.findAll());
        model.addAttribute("devices", deviceService.findAll());
        model.addAttribute("categorys", categoryService.getAllCategory());
        model.addAttribute("recipe", recipe);
        model.addAttribute("isLogin", jwt != null);
        String recipeCategory = "";
        model.addAttribute("recipeCategory", recipeCategory);
        model.addAttribute("randomRecipeId", getRandomNumRecipe());
        return "user/recipeCreation";
    }

    @PostMapping("/api/newRecipe")
    public String newRecipePageSubmit(@ModelAttribute Recipe recipe, @ModelAttribute String recipeCategory) {
        User user = (userService.getUserByUsername(jwtService.extractUserName(jwt)));
        recipe.setCategory(categoryService.getCategoryByTitle(recipeCategory));
        recipe.setUser(user);
        recipeService.save(recipe);
        return "redirect:/user";
    }

    @PostMapping("/api/newUserReport/{id}")
    public String newUserReport(@ModelAttribute UserReport userReport, @PathVariable("id") Long id) {
        if (jwt == null) return "redirect:/mustBeLogin";
        if (this.recipeService.getRecipeById(id) == null) {
            return "redirect:/404";
        }
        if (!this.recipeService.getRecipeById(id).isPublished()) return "redirect:/403";
        User user = userService.getUserByUsername(jwtService.extractUserName(jwt));
        UserReport newUserReport = new UserReport();
        newUserReport.setUser(user);
        newUserReport.setRecipe(recipeService.getRecipeById(id));
        newUserReport.setDescription(userReport.getDescription());
        newUserReport.setIsAccepted(false);
        userReportService.save(newUserReport);
        String string = "redirect:/recipe/" + id;
        return string;
    }

    @PostMapping("/api/newComment/{id}")
    public String newComment(@ModelAttribute Comment comment, @PathVariable("id") Long id) {
        if (jwt == null) return "redirect:/recipe/" + id;
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

    @PostMapping("/api/newRating/{id}")
    public String newMark(@ModelAttribute Rating rating, @PathVariable("id") Long id) {

        if (jwt == null) return "redirect:/recipe/" + id;
        Recipe recipe = this.recipeService.getRecipeById(id);

        if (recipe == null) {
            return "redirect:/404";
        }
        if (Double.isNaN(rating.getMark())) {
            rating.setMark(10.0);
        }
        Rating newRating = new Rating();
        if (!this.recipeService.getRecipeById(id).isPublished()) return "redirect:/403";
        newRating.setUser(userService.getUserByUsername(jwtService.extractUserName(jwt)));
        newRating.setRecipe(recipe);
        newRating.setMark(rating.getMark());
        Rating existed = ratingService.getByUserAndRecipe(userService.getUserByUsername(jwtService.extractUserName(jwt)), recipe);
        if (existed != null) {
            newRating.setId(existed.getId());
        }
        if (newRating.getMark() == null) {
            newRating.setMark(recipe.getAverageMark());
        }
        ratingService.save(newRating);
        String string = "redirect:/recipe/" + id;
        return string;
    }

    public Long getRandomNumRecipe() {
        List<Recipe> recipes = recipeService.getAllRecipeIsPublished();
        Random random = new Random();
        int ind = random.nextInt(recipes.size());
        return recipes.get(ind).getId();
    }
}
