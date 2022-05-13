package com.example.els.viewmodel.authentication;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.authentication.EmailAccountRepository;
import com.google.firebase.auth.FirebaseUser;

public class EmailLoginViewmodel extends ViewModel {

    private EmailAccountRepository emailAccountRepository;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> isRegisterSuccessLiveData;

    public EmailLoginViewmodel (Application application) {
        //super(application);
        emailAccountRepository = new EmailAccountRepository(application);
        userLiveData = emailAccountRepository.getUserLiveData();
        isRegisterSuccessLiveData = emailAccountRepository.getIsRegisterSuccessLiveData();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void loginEmail(String email, String password) {
        emailAccountRepository.loginEmailAccount(email, password);
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void register(String email, String password) {
        emailAccountRepository.registerEmailAccount(email, password);
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getIsRegisterSuccessLiveData() {
        return isRegisterSuccessLiveData;
    }
}
