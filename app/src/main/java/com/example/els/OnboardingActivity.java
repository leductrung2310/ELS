package com.example.els;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.els.adapter.ViewPagerAdapter;
import com.example.els.databinding.ActivityOnBoardingBinding;

public class OnboardingActivity extends AppCompatActivity {

    ActivityOnBoardingBinding activityOnBoardingBinding;

    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOnBoardingBinding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(activityOnBoardingBinding.getRoot());

        viewPagerAdapter = new ViewPagerAdapter(this);
        activityOnBoardingBinding.slideViewPager.setAdapter(viewPagerAdapter);
        activityOnBoardingBinding.tabLayout.setupWithViewPager(activityOnBoardingBinding.slideViewPager, true);
        setUpEvent();
    }

    public void setUpEvent() {
        activityOnBoardingBinding.btnOnBoardingOne.setOnClickListener(view -> {
            if (getItem(0) <= 1)
                activityOnBoardingBinding.slideViewPager.setCurrentItem(getItem(1), true);
        });

        activityOnBoardingBinding.tvSkipOb.setOnClickListener(v -> {

        });
    }

    private int getItem(int i) {
        return activityOnBoardingBinding.slideViewPager.getCurrentItem() + i;
    }
}
