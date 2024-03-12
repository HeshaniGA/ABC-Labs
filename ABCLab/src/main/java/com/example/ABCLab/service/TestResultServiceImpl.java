package com.example.ABCLab.service;

import com.example.ABCLab.model.Test;
import com.example.ABCLab.model.TestResult;
import com.example.ABCLab.repositories.TestRepository;
import com.example.ABCLab.repositories.TestResultRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;
    private final TestRepository testRepository;

    @Autowired
    public TestResultServiceImpl(TestResultRepository testResultRepository, TestRepository testRepository) {
        this.testResultRepository = testResultRepository;
        this.testRepository = testRepository;
    }
    @Override
    public List<TestResult> getTestResultsByTestId(Long testId) {
        // Logic to fetch test results based on test_id
        Optional<Test> testOptional = testRepository.findById(testId);

        List<TestResult> result= testResultRepository.findByTestId(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
    
            // Iterate through the list of TestResults and set the Test entity
            for (TestResult testResult : result) {
                testResult.setTest(test);
            }
        } else {
            // Handle the case where the Test entity is not found
            // You may throw an exception or log an error, depending on your requirements
            System.err.println("Test not found with id: " + testId);
        }
    

        return result;
    }
    

    @Override
    public void saveAll(List<TestResult> testResults) {
        for (TestResult testResult : testResults) {
            // Fetch the Test entity from the database using the ID
            Long testId = testResult.getTest().getId();
            Optional<Test> testOptional = testRepository.findById(testId);
    
            if (testOptional.isPresent()) {
                Test test = testOptional.get();
    
                // Set the fetched Test entity in the TestResult
                testResult.setTest(test);
    
                // Save the TestResult entity
                testResultRepository.save(testResult);
            } else {
                // Handle the case where the Test entity is not found
                // You may throw an exception or log an error, depending on your requirements
                System.err.println("Test not found with id: " + testId);
            }
        }
    }
}
