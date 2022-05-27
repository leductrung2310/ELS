package com.example.els.view.games;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.databinding.FragmentGamesBinding;

public class GamesFragment extends Fragment {
    private FragmentGamesBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGamesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.wordQuiz.setOnClickListener(this::moveToWordQuiz);
    }

    // Move to word quiz game
    private void moveToWordQuiz(View view) {
        Navigation.findNavController(view).navigate(R.id.action_gamesFragment_to_wordQuizFragment);
    }
}