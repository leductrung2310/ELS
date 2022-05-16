package com.example.els.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.databinding.FragmentLessonDetailBinding;

public class LessonDetailFragment extends Fragment {
    private FragmentLessonDetailBinding binding;
    private int position = -1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLessonDetailBinding.inflate(inflater, container, false);
        if (getArguments() != null){
            position = getArguments().getInt("position");
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // Handle back event
        binding.backBtn.setOnClickListener(this::onBackButtonPressed);
    }

    public void onBackButtonPressed(View view) {
        Navigation.findNavController(view).navigate(R.id.action_lessonDetailFragment_to_skillsFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}