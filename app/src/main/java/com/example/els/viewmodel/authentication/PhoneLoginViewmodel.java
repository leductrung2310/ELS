package com.example.els.viewmodel.authentication;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.authentication.LoginType;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PhoneLoginViewmodel extends ViewModel {

    private FirebaseAuth firebaseAuth;

    private  MutableLiveData<FirebaseUser> userLiveData;
    private  MutableLiveData<Boolean> isLoggOutLiveData;
    private  MutableLiveData<Boolean> isOnCodeSent;
    private  MutableLiveData<String> phoneNumber;
    private  MutableLiveData<String> verifiedId;

    public PhoneLoginViewmodel() {
        firebaseAuth = FirebaseAuth.getInstance();
        verifiedId= new MutableLiveData<>();
        isOnCodeSent= new MutableLiveData<>(false);
        isLoggOutLiveData= new MutableLiveData<>(false);
        userLiveData= new MutableLiveData<>();
        phoneNumber = new MutableLiveData<>();

        if (firebaseAuth.getCurrentUser() != null) {
            userLiveData.setValue(firebaseAuth.getCurrentUser());
            isLoggOutLiveData.setValue(false);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void signInWithPhoneAuthCredential(PhoneAuthCredential credential, Application application) {

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            userLiveData.setValue(firebaseAuth.getCurrentUser());
                            Toast.makeText(application.getApplicationContext(), "Log in success", Toast.LENGTH_SHORT).show();
                            LoginType.getInstance().setLoginType(1);
                        } else {
                            Toast.makeText(application.getApplicationContext(), "Login Failure: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void sendOtpCode(String number, Activity activity, Application application) {
        phoneNumber.setValue(number);
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber("+84" + number)
                        .setActivity(activity)// Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @RequiresApi(api = Build.VERSION_CODES.P)
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signInWithPhoneAuthCredential(phoneAuthCredential, application);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(application.getApplicationContext(), "Authentication Failed!" + e.getMessage(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(verificationId, forceResendingToken);
                                isOnCodeSent.setValue(true);
                                setVerifiedId(verificationId);
                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void verifyOtp(String inputOtp, Application application) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(getVerifiedId().getValue(), inputOtp);
        signInWithPhoneAuthCredential(credential, application);
    }

    public void logOut() {
        isOnCodeSent.setValue(false);
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

    public MutableLiveData<Boolean> getIsOnCodeSent() {
        return isOnCodeSent;
    }

    public LiveData<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.setValue( phoneNumber);
    }

    public LiveData<String> getVerifiedId() {
        return verifiedId;
    }

    public void setVerifiedId(String verifiedId) {
        this.verifiedId.setValue(verifiedId );
    }
}
