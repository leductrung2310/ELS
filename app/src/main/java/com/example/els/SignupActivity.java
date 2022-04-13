package com.example.els;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //ánh xạ
        EditText phoneNumber = (EditText) findViewById(R.id.phone_number);
        Button sendOTPBtn = findViewById(R.id.requestBtn);
        Button backBtn = findViewById(R.id.back_button_signup);

        //check phone number
        sendOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phoneNumber.getText().toString().trim().isEmpty() || phoneNumber.getText().toString().trim().length() < 9) {
                    Toast.makeText(SignupActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), VerifyActivity.class);
                intent.putExtra("mobile", phoneNumber.getText().toString());
                startActivity(intent);
            }
        });

        //back to previous screen
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignupActivity.super.finish();
            }
        });
    }
}
