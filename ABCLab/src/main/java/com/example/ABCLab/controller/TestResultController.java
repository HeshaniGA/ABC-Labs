package com.example.ABCLab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ABCLab.model.TestResult;
import com.example.ABCLab.service.TestResultService;

@Controller

public class TestResultController {
    

      @GetMapping("tech/result/")
    public String getResultPage() {
       
        
    
        return "tech/addresults";
}
   private final TestResultService testResultService;

    @Autowired
    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @PostMapping("/add-all")
    public void addAllTestResults(@RequestBody List<TestResult> testResults) {
        testResultService.saveAll(testResults);
    }
}
