package com.example.els.models.authentication;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class PhoneAccountRepository {

    private String phoneNumber;

    public PhoneAccountRepository(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValidPhoneNumber() {
        return !TextUtils.isEmpty(phoneNumber) && phoneNumber.length() < 9;
    }

    private Application application;

    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;
    private MutableLiveData<String> verificationId;

    public LiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public LiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }

    public PhoneAccountRepository() {
    }

    public PhoneAccountRepository(Application application) {
        this.application = application;
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.userLiveData = new MutableLiveData<>();
        this.loggedOutLiveData = new MutableLiveData<>();
        this.verificationId = new MutableLiveData<>();

        if (firebaseAuth.getCurrentUser() != null) {
            userLiveData.postValue(firebaseAuth.getCurrentUser());
            loggedOutLiveData.postValue(false);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    private void OnClickVerifyOtpId(String otp) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(String.valueOf(verificationId), otp);
        signInWithPhoneAuthCredential(credential);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        try {
            firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener(application.getMainExecutor(), (OnCompleteListener<AuthResult>) task -> {
                        if (task.isSuccessful()) {

                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                            // Update UI

                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(application.getApplicationContext(),
                                        "The verification code entered was invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } catch (Exception e) {
            Toast.makeText(application.getApplicationContext(), "Not Support The Remaining Android Version!", Toast.LENGTH_SHORT).show();
        }
    }

    private void logOut() {
        firebaseAuth.signOut();
        loggedOutLiveData.postValue(true);
    }


}
