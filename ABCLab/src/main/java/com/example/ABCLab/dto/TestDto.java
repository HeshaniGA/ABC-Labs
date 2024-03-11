package com.example.ABCLab.dto;

import org.springframework.web.multipart.MultipartFile;

import com.example.ABCLab.model.TestState;

public class TestDto {

    private Long patientId;
    private int age;
    private String recommendedDoctor;
    private String payment = "PENDING";

    private String technician;
    private TestState state;
    private MultipartFile prescriptionFile;


    private String patientName;
    private String name;
    public TestDto( int age, String recommendedDoctor, String technician, TestState state, MultipartFile prescriptionFile, String patientName, String name) {
        this.age = age;
        this.recommendedDoctor = recommendedDoctor;
        this.technician = technician;
        this.state = state;
        this.prescriptionFile = prescriptionFile;
        this.patientName = patientName;
        this.name = name;
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

    public Long getPatientId() {
        return this.patientId;
    }

    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

    public MultipartFile getPrescriptionFile() {
        return this.prescriptionFile;
    }

    public void setPrescriptionFile(MultipartFile prescriptionFile) {
        this.prescriptionFile = prescriptionFile;
    }

}
