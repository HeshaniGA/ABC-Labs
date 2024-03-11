package com.example.ABCLab.service;

import com.example.ABCLab.model.Test;
import com.example.ABCLab.model.TestState;
import com.example.ABCLab.repositories.TestRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void updateTestStateById(Long id, TestState state,String technicianName) {
        testRepository.updateTestStateById(id, state,technicianName);
    }

    @Override
    public List<Test> getTestsByTechnician(String technicianName) {
        return testRepository.findByTechnician(technicianName);
    }
    @Override
    @Transactional
    public void updatePaymentStatus(Long testId, String paymentStatus) {
        Optional<Test> optionalTest = testRepository.findById(testId);

        optionalTest.ifPresent(test -> {
            test.setPayment(paymentStatus);
            testRepository.save(test);
        });
    }
}
