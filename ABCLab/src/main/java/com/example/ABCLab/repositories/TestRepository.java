package com.example.ABCLab.repositories;

import com.example.ABCLab.model.Test;
import com.example.ABCLab.model.TestState;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findAll();

    List<Test> findByPatientId(Long patientId);

    // List<Test> findByTechnician(String technician);

    // List<Test> findByState(TestState state);
    @Modifying
    @Transactional
    @Query("UPDATE Test t SET t.state = :state, t.technician = :technicianName " +
           "WHERE t.id = :id AND (t.state = 'PENDING' OR t.technician = :technicianName)")
    void updateTestStateById(@Param("id") Long id, 
                             @Param("state") TestState state, 
                             @Param("technicianName") String technicianName);

                             List<Test> findByTechnician(String technicianName);

}
