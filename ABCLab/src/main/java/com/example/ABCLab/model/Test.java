package com.example.ABCLab.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.List;
@Table(name = "Test")

@Entity
public class Test {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long patientId;
    private String patientName;
    private String name;

    private int age;
    private String prescriptionFileName;
    private String payment = "PENDING";
    
    private String recommendedDoctor;

    private String technician;

    @Enumerated(EnumType.STRING)
    private TestState state;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestResult> results;

    public Test(){
        super();
    }

    public Test( Long patientId, String patientName, String name, int age, String prescriptionFileName, String recommendedDoctor, String technician, TestState state, List<TestResult> results) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.name = name;
        this.age = age;
        this.prescriptionFileName = prescriptionFileName;
        this.recommendedDoctor = recommendedDoctor;
        this.technician = technician;
        this.state = state;
        this.results = results;
    }


    public String getPrescriptionFileName() {
        return this.prescriptionFileName;
    }

    public void setPrescriptionFileName(String prescriptionFileName) {
        this.prescriptionFileName = prescriptionFileName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return this.patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRecommendedDoctor() {
        return this.recommendedDoctor;
    }

    public void setRecommendedDoctor(String recommendedDoctor) {
        this.recommendedDoctor = recommendedDoctor;
    }

    public String getTechnician() {
        return this.technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public TestState getState() {
        return this.state;
    }

    public void setState(TestState state) {
        this.state = state;
    }

    public List<TestResult> getResults() {
        return this.results;
    }

    public void setResults(List<TestResult> results) {
        this.results = results;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}
