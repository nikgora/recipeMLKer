package com.example.recipemlker.controller;

import com.example.recipemlker.model.*;
import com.example.recipemlker.service.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class ModeratorController {
    @Getter
    private Long moderatorId;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AiReportService aiReportService;
    @Autowired
    private ModeratorService moderatorService;
    @Autowired
    private UserReportService userReportService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserController userController;

    @Autowired
    private UserListService userListService;

    @GetMapping("moderator/recipe/{id}")
    public String recipePage(Model model, @PathVariable("id") Long id) {
        if (this.recipeService.getRecipeById(id) == null) {
            return "redirect:/404";
        }
        if (moderatorId == null) {
            return "redirect:/403";
        }
        model.addAttribute("recipe", this.recipeService.getRecipeById(id));
        model.addAttribute("id", id);
        model.addAttribute("isLogin", true);
        model.addAttribute("randomRecipeId", userController.getRandomNumRecipe());
        model.addAttribute("isModerator", true);
        UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", moderatorService.getFirstById(moderatorId).getUser());
        model.addAttribute("favoriteList", favoriteList);

        return "user/recipe";
    }

    @GetMapping("/moderator")
    public String moderatorAccount(Model model) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        model.addAttribute("randomRecipeId", userController.getRandomNumRecipe());
        UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", moderatorService.getFirstById(moderatorId).getUser());
        model.addAttribute("favoriteList", favoriteList);

        model.addAttribute("moderator", moderatorService.getFirstById(moderatorId));
        return "moderator/moderatorPage";
    }

    @PostMapping("/api/moderator/login")
    public String LoginModerator(@ModelAttribute Moderator moderator) {
        String jwt = userController.getJwt();
        if (jwt == null) return "redirect:/403";
        User user = userService.getUserByUsername(jwtService.extractUserName(jwt));
        Moderator modUser = moderatorService.getFirstByUser(user);
        if (!Objects.equals(modUser.getSecret_password(), moderator.getSecret_password())) {
            return "redirect:/user";
        }
        moderatorId = modUser.getId();
        return "redirect:/moderator";
    }

    @GetMapping("/moderator/AIReports")
    public String moderatorAIReports(Model model) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        model.addAttribute("randomRecipeId", userController.getRandomNumRecipe());
        UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", moderatorService.getFirstById(moderatorId).getUser());
        model.addAttribute("favoriteList", favoriteList);

        model.addAttribute("reports", aiReportService.findAvailableForModer(false, moderatorId));
        return "moderator/moderatorAIReports";
    }

    @GetMapping("/moderator/UserReports")
    public String moderatorUserReports(Model model) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        model.addAttribute("randomRecipeId", userController.getRandomNumRecipe());
        model.addAttribute("reports", userReportService.findAvailableForModer(false, moderatorId));
        UserList favoriteList = userListService.getFirstByTitleAndUser("Favorites", moderatorService.getFirstById(moderatorId).getUser());
        model.addAttribute("favoriteList", favoriteList);

        return "moderator/moderatorUserReports";
    }

    @PostMapping("/api/moderator/takeUserReport/{idReport}")
    public String moderatorTakeUserReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        UserReport userReport = userReportService.getFirstById(idReport);
        userReport.setModerator(moderatorService.getFirstById(moderatorId));
        userReport.setIsAccepted(true);
        userReportService.save(userReport);
        return "redirect:/moderator/UserReports";
    }

    @PostMapping("/api/moderator/takeAIReport/{idReport}")
    public String moderatorTakeAiReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        AiReport aiReport = aiReportService.getFirstById(idReport);
        aiReport.setModerator(moderatorService.getFirstById(moderatorId));
        aiReport.setAccepted(true);
        aiReportService.save(aiReport);
        return "redirect:/moderator/AIReports";
    }

    @PostMapping("/api/moderator/approveAIReport/{idReport}")
    public String moderatorApproveAiReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        AiReport aiReport = aiReportService.getFirstById(idReport);
        Recipe recipe = aiReport.getRecipe();
        recipe.setPublished(false);
        aiReport.setModerator(null);
        aiReportService.save(aiReport);
        recipeService.save(recipe);
        return "redirect:/moderator/AIReports";
    }

    @PostMapping("/api/moderator/declineAIReport/{idReport}")
    public String moderatorDeclineAiReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        AiReport aiReport = aiReportService.getFirstById(idReport);
        Recipe recipe = aiReport.getRecipe();
        recipe.setPublished(true);
        aiReport.setModerator(null);
        aiReportService.save(aiReport);
        recipeService.save(recipe);
        return "redirect:/moderator/AIReports";
    }

    @PostMapping("/api/moderator/approveUserReport/{idReport}")
    public String moderatorApproveUserReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        UserReport userReport = userReportService.getFirstById(idReport);
        Recipe recipe = userReport.getRecipe();
        recipe.setPublished(false);
        userReport.setModerator(null);
        userReportService.save(userReport);
        recipeService.save(recipe);
        return "redirect:/moderator/UserReports";
    }

    @PostMapping("/api/moderator/declineUserReport/{idReport}")
    public String moderatorDeclineUserReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/403";
        }
        UserReport userReport = userReportService.getFirstById(idReport);
        Recipe recipe = userReport.getRecipe();
        recipe.setPublished(recipe.isPublished());
        userReport.setModerator(null);
        userReportService.save(userReport);
        recipeService.save(recipe);
        return "redirect:/moderator/UserReports";
    }
}
