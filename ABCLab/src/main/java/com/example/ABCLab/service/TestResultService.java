package com.example.ABCLab.service;

import com.example.ABCLab.model.TestResult;

import java.util.List;

public interface TestResultService {
    void saveAll(List<TestResult> testResults);
    List<TestResult> getTestResultsByTestId(Long testId);
    // Add other service methods if needed
}
