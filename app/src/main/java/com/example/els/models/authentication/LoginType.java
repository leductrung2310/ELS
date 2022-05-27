package com.example.els.models.authentication;

public class LoginType {
    int loginType;

    private static final LoginType ourInstance = new LoginType();
    public static LoginType getInstance() {
        return ourInstance;
    }
    private LoginType() {}

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }
}
