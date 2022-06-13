package com.example.els.view.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentGamesBinding;
import com.example.els.viewmodel.games.WordQuizViewModel;

public class GamesFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {
    private FragmentGamesBinding binding;
    private WordQuizViewModel quizViewModel;

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

        binding.playBtn.setOnClickListener(this::moveToWordQuiz);

        // Initialize viewmodel
        quizViewModel = new ViewModelProvider(requireActivity()).get(WordQuizViewModel.class);

        // Observe changes and set text to the level text view
        quizViewModel.level().observe(getViewLifecycleOwner(), this::setTextForLevel);

        // Observe changes and set text to the area text view
        quizViewModel.area().observe(getViewLifecycleOwner(), this::setTextForArea);

        // Show the level popup menu
        binding.level.setOnClickListener(this::showLevelPopupMenu);

        // Show the area popup menu
        binding.area.setOnClickListener(this::showAreaPopupMenu);

        // Move to history fragment
        binding.historyBtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_gamesFragment_to_playHistoryFragment));
    }

    // Show level popup menu
    public void showLevelPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireActivity(), view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.game_level_menu);
        popupMenu.show();
    }

    // Show area popup menu
    public void showAreaPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireActivity(), view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.game_area_menu);
        popupMenu.show();
    }

    // Move to word quiz game
    private void moveToWordQuiz(View view) {
        Navigation.findNavController(view).navigate(R.id.action_gamesFragment_to_wordQuizFragment);
    }

    // Set text for the level text view
    public void setTextForLevel(int level) {
        binding.levelTv.setText(getResources().getString(R.string.level, level));
    }

    // Set text for the level text view
    public void setTextForArea(String area) {
        binding.areaTv.setText(getResources().getString(R.string.area, area));
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                quizViewModel.level().setValue(1);
                return true;
            case R.id.two:
                quizViewModel.level().setValue(2);
                return true;
            case R.id.three:
                quizViewModel.level().setValue(3);
                return true;
            case R.id.four:
                quizViewModel.level().setValue(4);
                return true;
            case R.id.five:
                quizViewModel.level().setValue(5);
                return true;
            case R.id.six:
                quizViewModel.level().setValue(6);
                return true;
            case R.id.seven:
                quizViewModel.level().setValue(7);
                return true;
            case R.id.eight:
                quizViewModel.level().setValue(8);
                return true;
            case R.id.nine:
                quizViewModel.level().setValue(9);
                return true;
            case R.id.ten:
                quizViewModel.level().setValue(10);
                return true;
            // id for game area
            case R.id.overall:
                quizViewModel.area().setValue("Overall");
                return true;
            case R.id.toeic:
                quizViewModel.area().setValue("TOEIC");
                return true;
            case R.id.ielts:
                quizViewModel.area().setValue("IELTS");
                return true;
            case R.id.toefl:
                quizViewModel.area().setValue("TOEFL");
                return true;
            case R.id.sat:
                quizViewModel.area().setValue("SAT");
                return true;
            default:
                return false;
        }
    }
}