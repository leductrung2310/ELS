package com.example.els.viewmodel.authentication;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.els.models.authentication.EmailAccountRepository;
import com.google.firebase.auth.FirebaseUser;

public class EmailLoginViewmodel extends AndroidViewModel {

    private EmailAccountRepository emailAccountRepository;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> isRegisterSuccessLiveData;
    private MutableLiveData<Boolean> isLoggOutLiveData;

    public EmailLoginViewmodel (Application application) {
        super(application);
        emailAccountRepository = new EmailAccountRepository(application);
        userLiveData = emailAccountRepository.getUserLiveData();
        isRegisterSuccessLiveData = emailAccountRepository.getIsRegisterSuccessLiveData();
        isLoggOutLiveData = emailAccountRepository.getIsLoggOutLiveData();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void loginEmail(String email, String password) {
        emailAccountRepository.loginEmailAccount(email, password);
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void register(String email, String password) {
        emailAccountRepository.registerEmailAccount(email, password);
    }

    public void logOut() {
        emailAccountRepository.logOut();
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getIsRegisterSuccessLiveData() {
        return isRegisterSuccessLiveData;
    }

    public MutableLiveData<Boolean> getIsLoggOutLiveData() {
        return isLoggOutLiveData;
    }
}
