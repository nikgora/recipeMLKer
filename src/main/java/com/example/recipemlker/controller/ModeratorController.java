package com.example.recipemlker.controller;

import com.example.recipemlker.service.AiReportService;
import com.example.recipemlker.service.UserReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModeratorController {
    @Autowired
    private AiReportService aiReportService;

    @Autowired
    private UserReportService userReportService;

    @GetMapping("/moderator/account")
    public String moderatorAccount(Model model) {
        //TODO ADD NAME as Moderator Name
        //TODO model.addAttribute("moderator", new Moderator());
        return "moderator/moderatorAccount";
    }

    @GetMapping("/moderator/AIReports")
    public String moderatorAIReports(Model model) {
        //TODO MAKE ID THAT CHANGES
        model.addAttribute("reports", aiReportService.findAvailableForModer(false, 1L));
        return "moderator/moderatorAIReports";
    }

    @GetMapping("/moderator/UserReports")
    public String moderatorUserReports(Model model) {
        //TODO MAKE ID THAT CHANGES
        model.addAttribute("reports", userReportService.findAvailableForModer(false, 1L));
        return "moderator/moderatorUserReports";
    }

}
