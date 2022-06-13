package com.example.els.viewmodel.authentication;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordViewmodel extends ViewModel {

    private FirebaseAuth firebaseAuth;

    public ForgotPasswordViewmodel() {
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    public void resetPassword(String emailAddress, Application application) {
        firebaseAuth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(application.getApplicationContext(), "Send email reset password success. Please check your latest email",
                                    Toast.LENGTH_LONG).show();
                        } else  {
                            Toast.makeText(application.getApplicationContext(), "Send email reset password error. Please check your input email",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
