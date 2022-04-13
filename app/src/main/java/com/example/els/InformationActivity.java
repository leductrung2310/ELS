package com.example.els;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.els.databinding.ActivityInformationBinding;

public class InformationActivity extends AppCompatActivity {

    ActivityInformationBinding activityInformationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInformationBinding = ActivityInformationBinding.inflate(getLayoutInflater());
        setContentView(activityInformationBinding.getRoot());

        setUpEvent();
    }

    private void setUpEvent() {
        activityInformationBinding.personalEditInfoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InformationActivity.super.onBackPressed();
            }
        });
    }
}