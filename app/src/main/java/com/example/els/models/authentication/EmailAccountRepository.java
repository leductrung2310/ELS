package com.example.els.models.authentication;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

public class EmailAccountRepository {

    private Application application;

    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> isLoggOutLiveData;
    private MutableLiveData<Boolean> isRegisterSuccessLiveData;

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getIsLoggOutLiveData() {
        return isLoggOutLiveData;
    }

    public MutableLiveData<Boolean> getIsRegisterSuccessLiveData() {
        return isRegisterSuccessLiveData;
    }

    public EmailAccountRepository(Application application) {



    }



    @RequiresApi(api = Build.VERSION_CODES.P)
    public void loginEmailAccount(String email, String password) {

    }

}
