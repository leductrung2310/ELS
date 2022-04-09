package com.example.els;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.els.databinding.ActivityOnBoardingBinding;

public class OnboardingActivity extends AppCompatActivity {

    ActivityOnBoardingBinding activityOnBoardingBinding;

    ViewPager mSlideViewPager;
    ViewPagerAdapter viewPagerAdapter;

    TextView[] dots;
    LinearLayout mDotLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOnBoardingBinding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(activityOnBoardingBinding.getRoot());

        viewPagerAdapter = new ViewPagerAdapter(this);
        activityOnBoardingBinding.slideViewPager.setAdapter(viewPagerAdapter);
        //setUpIndicator(0);
        activityOnBoardingBinding.tabLayout.setupWithViewPager(activityOnBoardingBinding.slideViewPager, true);
        setUpEvent();
    }

    public void setUpEvent() {
        activityOnBoardingBinding.btnOnBoardingOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(0) <= 1)
                    activityOnBoardingBinding.slideViewPager.setCurrentItem(getItem(1), true);
                else {
                    Intent i = new Intent(OnboardingActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        activityOnBoardingBinding.tvSkipOb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OnboardingActivity.this, LoginActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

//    public void setUpIndicator(int position) {
//
//        dots = new TextView[3];
//        activityOnBoardingBinding.indicatorLayout.removeAllViews();
//
//        for (int i = 0; i < dots.length; i++) {
//
//            dots[i] = new TextView(this);
//            dots[i].setText(Html.fromHtml("&#8226"));
//            dots[i].setTextSize(30);
//            dots[i].setTextColor(getResources().getColor(R.color.text_on_s));
//            activityOnBoardingBinding.indicatorLayout.addView(dots[i]);
//
//        }
//
//        dots[position].setTextColor(getResources().getColor(R.color.text_on_s));
//
//    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //setUpIndicator(position);

//            if (position > 0){
//
//                backbtn.setVisibility(View.VISIBLE);
//
//            }else {
//
//                backbtn.setVisibility(View.INVISIBLE);
//
//            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i) {
        return activityOnBoardingBinding.slideViewPager.getCurrentItem() + i;
    }
}
