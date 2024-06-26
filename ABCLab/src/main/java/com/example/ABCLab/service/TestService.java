package com.example.ABCLab.service;

import com.example.ABCLab.model.Test;
import com.example.ABCLab.model.TestState;

import java.util.List;

public interface TestService {

    Test saveTest(Test test);

    List<Test> getAllTests();


    List<Test> getTestByPatientId(Long patientId);

    // List<Test> getTestsByTechnician(String technician);

    // List<Test> getTestsByState(TestState state);

    void updateTestStateById(Long id, TestState state,String technicianName);
    long getTotalTests();

    long getTotalPendingTests();

    long getTotalCompletedTests();
 List<Test> getTestsByTechnician(String technicianName);
 void updatePaymentStatus(Long testId, String paymentStatus);

}
