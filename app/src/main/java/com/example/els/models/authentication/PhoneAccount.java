package com.example.els.models.authentication;

public class PhoneAccount {

    private String phoneNumber;

    public PhoneAccount(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
