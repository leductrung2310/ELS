package com.example.els;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.els.databinding.ActivitySettingAccountBinding;

public class SettingAccountActivity extends AppCompatActivity {

    ActivitySettingAccountBinding activitySettingAccountBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySettingAccountBinding = ActivitySettingAccountBinding.inflate(getLayoutInflater());
        setContentView(activitySettingAccountBinding.getRoot());

        setUpEvent();
    }

    private void setUpEvent() {
        activitySettingAccountBinding.personalSettingAccountBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingAccountActivity.super.onBackPressed();
            }
        });
    }
}