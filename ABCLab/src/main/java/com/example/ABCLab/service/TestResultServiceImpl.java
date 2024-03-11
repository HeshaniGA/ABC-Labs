package com.example.ABCLab.service;

import com.example.ABCLab.model.TestResult;
import com.example.ABCLab.repositories.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;

    @Autowired
    public TestResultServiceImpl(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }

    @Override
    public void saveAll(List<TestResult> testResults) {
        testResultRepository.saveAll(testResults);
    }

}
