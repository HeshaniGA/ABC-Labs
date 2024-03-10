package com.example.ABCLab.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "testresult", uniqueConstraints = @UniqueConstraint(columnNames = "Id"))



public class TestResult {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    private String name;

    private String result;

    private String normalRange;

    public TestResult() {
        super();
    }
    public TestResult( Test test, String name, String result, String normalRange) {
        this.test = test;
        this.name = name;
        this.result = result;
        this.normalRange = normalRange;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Test getTest() {
        return this.test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNormalRange() {
        return this.normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

}
