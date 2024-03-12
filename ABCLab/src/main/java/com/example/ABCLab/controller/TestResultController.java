package com.example.ABCLab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.example.ABCLab.model.TestResult;
import com.example.ABCLab.service.TestResultService;

@Controller

public class TestResultController {
    
@GetMapping("tech/result/{testId}")
public String getResultPage(@PathVariable(name = "testId") Long testId, Model model) {
    if (testId != null) {
        model.addAttribute("testId", testId);
    }

    return "tech/addresults";
}
   private final TestResultService testResultService;

    @Autowired
    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @PostMapping("/tech/result/add-all")
        @ResponseBody
    public String addAllTestResults(@RequestBody List<TestResult> testResults) {
        testResultService.saveAll(testResults);
        return "Done";
    }
    @GetMapping("/tests/generate-report/{testId}")
public String generateReport(@PathVariable(name = "testId") Long testId, Model model) {
    // Logic to fetch results based on test_id and prepare data for the report
    List<TestResult> testResults = testResultService.getTestResultsByTestId(testId);
    model.addAttribute("testResults", testResults);

    return "tests/report";
}
}
