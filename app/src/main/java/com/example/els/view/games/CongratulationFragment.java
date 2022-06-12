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
    //private HistoryViewModel historyViewModel;

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
        //historyViewModel = new ViewModelProvider(requireActivity()).get(HistoryViewModel.class);

        // Set score
        quizViewModel.currentScore().observe(getViewLifecycleOwner(), score -> binding.tvScore.setText(getString(R.string.score, score)));

        binding.btnContinue.setOnClickListener(view1 -> {
            //completeGameAndPushHistoryData();
            Navigation.findNavController(view1).navigate(R.id.action_congratulationFragment_to_gamesFragment);
            quizViewModel.clearCurrentProgress();
        });
    }

//    public void completeGameAndPushHistoryData() {
//        // Define time when user complete the game
//        Date now = new Date();
//        // Create a new history item and pass needed arguments to it
//        History history = new History(
//                quizViewModel.area().getValue(),
//                now,
//                quizViewModel.level().getValue() == null ? 0 : quizViewModel.level().getValue(),
//                quizViewModel.currentScore().getValue() == null ? 0 : quizViewModel.currentScore().getValue()
//        );
//        // Push data to firestore through view model
//        // if this is not the first time user play update new history
//        if(historyViewModel.isHistoryExist()) {
//            Log.d("hisVM", "exist");
//            historyViewModel.updateHistoryToDB(history);
//        } // else create new history list field
//        else {
//            Log.d("hisVM", "not exist");
//            historyViewModel.pushHistoryToDB(history);
//        }
//    }
}