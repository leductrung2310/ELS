package com.example.els.viewmodel.authentication;

import android.app.Application;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.els.models.authentication.LoginType;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class EmailLoginViewmodel extends AndroidViewModel {

    private Application application;

    public static MutableLiveData<FirebaseUser> userLiveData;
    public static MutableLiveData<Boolean> isLoggOutLiveData;

    private FirebaseAuth firebaseAuth;

    public EmailLoginViewmodel(Application application) {
        super(application);
        this.application = application;
        this.firebaseAuth = FirebaseAuth.getInstance();
        userLiveData = new MutableLiveData<>();
        isLoggOutLiveData = new MutableLiveData<>(false);

        if (firebaseAuth.getCurrentUser() != null) {
            userLiveData.setValue(firebaseAuth.getCurrentUser());
            isLoggOutLiveData.setValue(false);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void loginEmail(String email, String password) {
        try {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                userLiveData.setValue(firebaseAuth.getCurrentUser());
                                LoginType.getInstance().setLoginType(0);
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
        userLiveData.setValue(null);
        isLoggOutLiveData.postValue(true);
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }


    public MutableLiveData<Boolean> getIsLoggOutLiveData() {
        return isLoggOutLiveData;
    }


}
