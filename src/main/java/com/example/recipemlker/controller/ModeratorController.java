package com.example.recipemlker.controller;

import com.example.recipemlker.model.AiReport;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.model.UserReport;
import com.example.recipemlker.service.AiReportService;
import com.example.recipemlker.service.ModeratorService;
import com.example.recipemlker.service.RecipeService;
import com.example.recipemlker.service.UserReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModeratorController {
    private final Long moderatorId = 1L;
    @Autowired
    private AiReportService aiReportService;
    @Autowired
    private ModeratorService moderatorService;
    @Autowired
    private UserReportService userReportService;
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/moderator")
    public String moderatorAccount(Model model) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        model.addAttribute("moderator", moderatorService.getModeratorById(moderatorId));
        return "moderator/moderatorPage";
    }

    @GetMapping("/moderator/AIReports")
    public String moderatorAIReports(Model model) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        model.addAttribute("reports", aiReportService.findAvailableForModer(false, 1L));
        return "moderator/moderatorAIReports";
    }

    @GetMapping("/moderator/UserReports")
    public String moderatorUserReports(Model model) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        model.addAttribute("reports", userReportService.findAvailableForModer(false, 1L));
        return "moderator/moderatorUserReports";
    }

    @PostMapping("/api/moderator/takeUserReport/{idReport}")
    public String moderatorTakeUserReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        UserReport userReport = userReportService.getFirstById(idReport);
        userReport.setModerator(moderatorService.getModeratorById(moderatorId));
        userReport.setIsAccepted(true);
        userReportService.save(userReport);
        return "redirect:/moderator/moderatorUserReport";
    }

    @PostMapping("/api/moderator/takeAiReport/{idReport}")
    public String moderatorTakeAiReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        AiReport aiReport = aiReportService.getFirstById(idReport);
        aiReport.setModerator(moderatorService.getModeratorById(moderatorId));
        aiReport.setAccepted(true);
        aiReportService.save(aiReport);
        return "redirect:/moderator/moderatorAiReport";
    }

    @PostMapping("/api/moderator/approveAiReport/{idReport}")
    public String moderatorApproveAiReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        AiReport aiReport = aiReportService.getFirstById(idReport);
        Recipe recipe = aiReport.getRecipe();
        recipe.setPublished(false);
        aiReport.setModerator(null);
        aiReportService.save(aiReport);
        recipeService.save(recipe);
        return "redirect:/moderator/moderatorAiReport";
    }

    @PostMapping("/api/moderator/declineAiReport/{idReport}")
    public String moderatorDeclineAiReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        AiReport aiReport = aiReportService.getFirstById(idReport);
        Recipe recipe = aiReport.getRecipe();
        recipe.setPublished(true);
        aiReport.setModerator(null);
        aiReportService.save(aiReport);
        recipeService.save(recipe);
        return "redirect:/moderator/moderatorAiReport";
    }

    @PostMapping("/api/moderator/approveUserReport/{idReport}")
    public String moderatorApproveUserReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        UserReport userReport = userReportService.getFirstById(idReport);
        Recipe recipe = userReport.getRecipe();
        recipe.setPublished(false);
        userReport.setModerator(null);
        userReportService.save(userReport);
        recipeService.save(recipe);
        return "redirect:/moderator/moderatorUserReport";
    }

    @PostMapping("/api/moderator/declineUserReport/{idReport}")
    public String moderatorDeclineuserReport(@PathVariable Long idReport) {
        if (moderatorId == null) {
            return "redirect:/user/403";
        }
        UserReport userReport = userReportService.getFirstById(idReport);
        Recipe recipe = userReport.getRecipe();
        recipe.setPublished(true);
        userReport.setModerator(null);
        userReportService.save(userReport);
        recipeService.save(recipe);
        return "redirect:/moderator/moderatorUserReport";
    }
}
