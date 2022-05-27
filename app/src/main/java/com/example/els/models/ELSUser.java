package com.example.els.models;

public class ELSUser {
    String name;
    Integer age;
    Boolean gender;
    String position;

    public ELSUser() {
    }

    public ELSUser(String name, Integer age, Boolean gender, String position) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean isGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
