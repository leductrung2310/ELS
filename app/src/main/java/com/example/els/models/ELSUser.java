package com.example.els.models;

public class ELSUser {
    String name;
    String age;
    String gender;
    String position;
    String phoneNumber;

    public ELSUser() {
    }

    public ELSUser(String name, String age, String gender, String position) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String isGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
