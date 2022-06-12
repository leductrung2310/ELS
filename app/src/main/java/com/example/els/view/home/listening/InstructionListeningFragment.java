package com.example.els.view.home.listening;

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
import com.example.els.databinding.FragmentInstructionListeningBinding;
import com.example.els.viewmodel.home.HomeViewModel;

public class InstructionListeningFragment extends Fragment {

    FragmentInstructionListeningBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInstructionListeningBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HomeViewModel homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        homeViewModel.getSkillKey().observe(getViewLifecycleOwner(), key -> {
            switch (key) {
                case "listening": {
                    binding.instructionReadingLly.setVisibility(View.GONE);
                    binding.instructionListeningLly.setVisibility(View.VISIBLE);
                    break;
                }
                case "reading": {
                    binding.instructionListeningLly.setVisibility(View.GONE);
                    binding.instructionReadingLly.setVisibility(View.VISIBLE);
                    break;
                }
            }
        });

        binding.backBtn.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_instructionListeningFragment_to_skillsFragment));
    }


}