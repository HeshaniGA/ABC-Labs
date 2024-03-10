package com.example.ABCLab.repositories;

import com.example.ABCLab.model.Test;
import com.example.ABCLab.model.TestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findAll();

    List<Test> findByPatientId(Long patientId);

    // List<Test> findByTechnician(String technician);

    // List<Test> findByState(TestState state);


    void updateTestStateById(Long id, TestState state);
}
