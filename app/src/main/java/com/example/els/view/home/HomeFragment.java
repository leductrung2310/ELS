package com.example.els.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentHomeBinding;
import com.example.els.viewmodel.home.HomeViewModel;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

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
        // Initialize view model
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        // On Card click listener
        binding.listeningCardView.setOnClickListener(view1 -> moveToSkillLearningTab("listening", view1));
        binding.readingCardView.setOnClickListener(view12 -> moveToSkillLearningTab("reading", view12));
        binding.grammarCardView.setOnClickListener(view13 -> Navigation.findNavController(view13).navigate(R.id.action_homeFragment_to_newspaperFragment));

        //get user data
        homeViewModel.getAccountInfo();
    }

    private void moveToSkillLearningTab(String key, View view) {
        homeViewModel.setSkillKey(key);
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_skillsFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}