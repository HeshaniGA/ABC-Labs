package com.example.ABCLab.dto;

public class TestResultDto {

    private String name;
    private String result;
    private String normalRange;

    public TestResultDto(String name, String result, String normalRange) {
        super();
        this.name = name;
        this.result = result;
        this.normalRange = normalRange;
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
