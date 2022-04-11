package com.example.els.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.databinding.FragmentHomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // On Card click listener
        binding.listeningCardView.setOnClickListener(view1 -> moveToSkillLearningTab("listening", view1));
        binding.readingCardView.setOnClickListener(view12 -> moveToSkillLearningTab("reading", view12));
        binding.speakingCardView.setOnClickListener(view13 -> moveToSkillLearningTab("speaking", view13));
        binding.writingCardView.setOnClickListener(view14 -> moveToSkillLearningTab("writing", view14));
    }

    void moveToSkillLearningTab(String key, View view) {
        HomeFragmentDirections.ActionHomeFragmentToSkillsFragment action = HomeFragmentDirections.actionHomeFragmentToSkillsFragment();
        action.setSkillArg(key);
        Navigation.findNavController(view).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}