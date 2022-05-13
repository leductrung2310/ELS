package com.example.els.models.authentication;

import android.app.Application;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class EmailAccountRepository {

    private Application application;

    private FirebaseAuth firebaseAuth;
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
        this.application = application;
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.userLiveData = new MutableLiveData<>();
        this.isLoggOutLiveData = new MutableLiveData<>();
        this.isRegisterSuccessLiveData = new MutableLiveData<>();

        if(firebaseAuth.getCurrentUser() != null) {
            userLiveData.postValue(firebaseAuth.getCurrentUser());
            isLoggOutLiveData.postValue(false);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void registerEmailAccount(String email, String password) {
        try{
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()) {
                        isRegisterSuccessLiveData.postValue(true);
                        Toast.makeText(application.getApplicationContext(), "Register successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(application.getApplicationContext(), "Register Failure: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e) {
            Toast.makeText(application.getApplicationContext(), "Not Support The Remaining Android Version!", Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void loginEmailAccount(String email, String password) {
       try {
           firebaseAuth.signInWithEmailAndPassword(email, password)
                   .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               userLiveData.postValue(firebaseAuth.getCurrentUser());
                           } else {
                               Toast.makeText(application.getApplicationContext(), "Login Failure: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
       } catch (Exception e) {
           Toast.makeText(application.getApplicationContext(), "Not Support The Remaining Android Version!", Toast.LENGTH_SHORT).show();
       }
    }

    public void logOut() {
        firebaseAuth.signOut();
        isLoggOutLiveData.postValue(true);
    }

}
