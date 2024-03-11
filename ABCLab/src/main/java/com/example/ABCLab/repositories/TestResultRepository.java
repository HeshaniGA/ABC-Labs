package com.example.ABCLab.repositories;

import com.example.ABCLab.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    // Add custom query methods if needed
}