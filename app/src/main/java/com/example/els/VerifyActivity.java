package com.example.els;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyActivity extends AppCompatActivity {

    public static final String TAG = VerifyActivity.class.getName();
    private FirebaseAuth mAuth;
    PhoneAuthProvider.ForceResendingToken resendingToken;

    private EditText inputCode1, inputCode2, inputCode3, inputCode4, inputCode5, inputCode6;
    private TextView resendOtp;
    private String phoneNumber, verificationId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //khởi tạo
        mAuth = FirebaseAuth.getInstance();

        //ánh xạ
        inputCode1 = findViewById(R.id.inputCode1);
        inputCode2 = findViewById(R.id.inputCode2);
        inputCode3 = findViewById(R.id.inputCode3);
        inputCode4 = findViewById(R.id.inputCode4);
        inputCode5 = findViewById(R.id.inputCode5);
        inputCode6 = findViewById(R.id.inputCode6);
        TextView textMobile = findViewById(R.id.phone_number_verify);
        Button backBtn = findViewById(R.id.back_button);
        Button verifyOptBtn = findViewById(R.id.verifyBtn);
        resendOtp = findViewById(R.id.resend_otp);


        //get phone number from sign up screen
        getIntentData();

        //go back previous screen
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerifyActivity.super.onBackPressed();
            }
        });

        //verify otp code
        verifyOptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp = getVerificationId();
                //OnClickVerifyOtpId(otp);
            }
        });

        //resend otp code
        resendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickResendOtpId();
            }
        });
    }

    private void getIntentData() {
        phoneNumber = getIntent().getStringExtra("phone_number");
        verificationId = getIntent().getStringExtra("verified_id");
    }


    private String getVerificationId() {
        return
                inputCode1.getText().toString() +
                inputCode2.getText().toString() +
                inputCode3.getText().toString() +
                inputCode4.getText().toString() +
                inputCode5.getText().toString() +
                inputCode6.getText().toString();
    }

    private void OnClickResendOtpId() {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+84" + phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)
                        .setForceResendingToken(resendingToken)// Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                //signInWithPhoneAuthCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(VerifyActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String strVerificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(verificationId, forceResendingToken);
                                verificationId = strVerificationId;
                                resendingToken = forceResendingToken;
                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }


    private void enterMainActivity(String phoneNumber) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("phone_number", phoneNumber);
        startActivity(intent);
    }
}
