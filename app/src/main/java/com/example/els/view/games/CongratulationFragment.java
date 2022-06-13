package com.example.els.view.games;

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
import com.example.els.databinding.FragmentCongratulationBinding;
import com.example.els.viewmodel.games.WordQuizViewModel;

public class CongratulationFragment extends Fragment {
    private FragmentCongratulationBinding binding;
    private WordQuizViewModel quizViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCongratulationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize viewmodel
        quizViewModel = new ViewModelProvider(requireActivity()).get(WordQuizViewModel.class);

        // Set score
        quizViewModel.currentScore().observe(getViewLifecycleOwner(), score -> binding.tvScore.setText(getString(R.string.score, score)));

        binding.btnContinue.setOnClickListener(view1 -> {
            //completeGameAndPushHistoryData();
            Navigation.findNavController(view1).navigate(R.id.action_congratulationFragment_to_gamesFragment);
            quizViewModel.clearCurrentProgress();
        });
    }
}