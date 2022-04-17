package com.example.els.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.els.view.home.LessonObjectFragment;

public class LessonCollectionAdapter extends FragmentStateAdapter {
    public LessonCollectionAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // return a new fragment instance in create fragment(int)
        Fragment fragment = new LessonObjectFragment() ;
        Bundle args = new Bundle();
        args.putInt(LessonObjectFragment.POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
