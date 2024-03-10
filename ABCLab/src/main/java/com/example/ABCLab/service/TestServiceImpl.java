package com.example.ABCLab.service;

import com.example.ABCLab.model.Test;
import com.example.ABCLab.model.TestState;
import com.example.ABCLab.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public  List<Test> getTestByPatientId(Long patientId) {
        return testRepository.findByPatientId(patientId);
    }

    // @Override
    // public List<Test> getTestsByTechnician(String technician) {
    //     return testRepository.findByTechnician(technician);
    // }

    // @Override
    // public List<Test> getTestsByState(TestState state) {
    //     return testRepository.findByState(state);
    // }

    @Override
    public void updateTestStateById(Long id, TestState state) {
        testRepository.updateTestStateById(id, state);
    }
}
