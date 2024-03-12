package com.example.ABCLab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ABCLab.service.TestService;
import com.example.ABCLab.service.UserService;

// AdminController.java
@Controller
public class AdminController {
    private final UserService userService;
    private final TestService testService;

    @Autowired
    public AdminController(UserService userService, TestService testService) {
        this.userService = userService;
        this.testService = testService;
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        // Get counts
        long totalUsers = userService.getTotalUsers();
        long totalTests = testService.getTotalTests();
        long totalPendingTests = testService.getTotalPendingTests();
        long totalCompletedTests = testService.getTotalCompletedTests();

        // Add counts to the model
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalTests", totalTests);
        model.addAttribute("totalPendingTests", totalPendingTests);
        model.addAttribute("totalCompletedTests", totalCompletedTests);

        return "admin/admin";
    }

    @GetMapping("/tech/dashboard")
    public String techDashboard(Model model) {
        // Get counts
        long totalTests = testService.getTotalTests();
        long totalPendingTests = testService.getTotalPendingTests();
        long totalCompletedTests = testService.getTotalCompletedTests();

        model.addAttribute("totalTests", totalTests);
        model.addAttribute("totalPendingTests", totalPendingTests);
        model.addAttribute("totalCompletedTests", totalCompletedTests);

        return "tech/home";
    }
}
