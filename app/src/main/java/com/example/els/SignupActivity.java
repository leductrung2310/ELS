//package com.example.els;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseException;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.PhoneAuthCredential;
//import com.google.firebase.auth.PhoneAuthOptions;
//import com.google.firebase.auth.PhoneAuthProvider;
//
//import java.util.concurrent.TimeUnit;
//
//public class SignupActivity extends AppCompatActivity {
//
//    public static final String TAG = SignupActivity.class.getName();
//    EditText phoneNumber;
//    Button sendOTPBtn, backBtn;
//    FirebaseAuth firebaseAuth;
//    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
//
//        //khởi tạo
//        firebaseAuth = FirebaseAuth.getInstance();
//
//        //ánh xạ
//         phoneNumber = (EditText) findViewById(R.id.phone_number);
//         sendOTPBtn = findViewById(R.id.requestBtn);
//         backBtn = findViewById(R.id.back_button_signup);
//
//        //check phone number
//        sendOTPBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(phoneNumber.getText().toString().trim().isEmpty() || phoneNumber.getText().toString().trim().length() < 9) {
//                    Toast.makeText(SignupActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
//                } else {
//                    String number = phoneNumber.getText().toString();
//                    //send code otp
//                    sendOtpCode(number);
//                }
//            }
//        });
//
//        //back to previous screen
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SignupActivity.super.finish();
//            }
//        });
//
//    }
//
//    private void sendOtpCode(String number) {
//        PhoneAuthOptions options =
//                PhoneAuthOptions.newBuilder(firebaseAuth)
//                        .setPhoneNumber("+84" + number)       // Phone number to verify
//                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                        .setActivity(this)                 // Activity (for callback binding)
//                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                            @Override
//                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                                signInWithPhoneAuthCredential(phoneAuthCredential);
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NonNull FirebaseException e) {
//                                Toast.makeText(SignupActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                                super.onCodeSent(verificationId, forceResendingToken);
//                                enterVerifyActivity(number, verificationId);
//                            }
//                        })          // OnVerificationStateChangedCallbacks
//                        .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//    }
//
//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//        firebaseAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithCredential:success");
//
//                            FirebaseUser user = task.getResult().getUser();
//                            // Update UI
//                            if (user != null) {
//                                enterMainActivity(user.getPhoneNumber());
//                            }
//                        } else {
//                            // Sign in failed, display a message and update the UI
//                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//                                // The verification code entered was invalid
//                                Toast.makeText(SignupActivity.this,
//                                        "The verification code entered was invalid", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                });
//    }
//
//    private void enterMainActivity(String phoneNumber) {
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        intent.putExtra("phone_number", phoneNumber);
//        startActivity(intent);
//    }
//
//    private void enterVerifyActivity(String phoneNumber, String verificationId) {
//        Intent intent = new Intent(getApplicationContext(), VerifyActivity.class);
//        intent.putExtra("phone_number", phoneNumber);
//        intent.putExtra("verified_id", verificationId);
//        startActivity(intent);
//    }
//}
