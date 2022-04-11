package com.example.els;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.els.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {

    ActivitySettingBinding activitySettingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySettingBinding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(activitySettingBinding.getRoot());

        setUp();
    }

    private void setUp() {
        activitySettingBinding.personalSettingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingActivity.super.onBackPressed();
            }
        });

        activitySettingBinding.personalSettingAccountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingAccountActivity.class);
                startActivity(intent);
            }
        });

    }
}