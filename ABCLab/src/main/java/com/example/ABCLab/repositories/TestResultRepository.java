package com.example.ABCLab.repositories;

import com.example.ABCLab.model.TestResult;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    List<TestResult> findByTestId(Long testId);

}