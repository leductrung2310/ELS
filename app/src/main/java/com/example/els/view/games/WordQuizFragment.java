package com.example.els.view.games;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.els.R;
import com.example.els.databinding.FragmentWordQuizBinding;
import com.example.els.models.games.Quiz;
import com.example.els.viewmodel.games.WordQuizViewModel;

import java.util.Objects;


public class WordQuizFragment extends Fragment {
    private FragmentWordQuizBinding binding;
    private WordQuizViewModel quizViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWordQuizBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize viewmodel
        quizViewModel = new ViewModelProvider(requireActivity()).get(WordQuizViewModel.class);

        // Fetch quiz list from APi
        quizViewModel.fetchQuizFromAPI();

        // fetch data when get into screen
        quizViewModel.currentQuiz().observe(getViewLifecycleOwner(), currentQuiz -> {
            updateView(currentQuiz);
            updateCurrentQuiz(currentQuiz);
        });
        quizViewModel.currentScore().observe(getViewLifecycleOwner(), this::updateCurrentScore);

        // On submit answer event handler
        binding.firstAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitAnswer();
            }
        });

        binding.secondAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitAnswer();
            }
        });

        // handle back event
        binding.backBtn.setOnClickListener(this::onBackBtnPressed);
    }

    // Update view with new quiz and options
    private void updateView(int currentQuiz) {
        Button firstQuestion = binding.firstAnswerBtn;
        Button secondQuestion = binding.secondAnswerBtn;
        TextView tvQuiz = binding.quiz;
        // if the quiz list is not null then setup the question with given API
        if (Objects.requireNonNull(quizViewModel.quizGame().getValue()).getQuizList() != null) {
            Quiz quiz = Objects.requireNonNull(quizViewModel.quizGame().getValue()).getQuizList().get(currentQuiz);
            tvQuiz.setText(getString(
                    R.string.quiz_content,
                    quiz.getQuestions().get(0),
                    quiz.getQuestions().get(1),
                    quiz.getQuestions().get(2)
            ));
            firstQuestion.setText(getString(R.string.first_answer,
                    quiz.getOptions().get(0)
            ));
            secondQuestion.setText(getString(R.string.second_answer,
                    quiz.getOptions().get(1)
            ));
        } else {
            // Else hide the button options and show loading dialog
            tvQuiz.setVisibility(View.GONE);
            firstQuestion.setVisibility(View.GONE);
            secondQuestion.setVisibility(View.GONE);
        }
    }

    // Update current quiz
    public void updateCurrentQuiz(int currentQuiz) {
        TextView tvCurrentQuiz = binding.currentQuiz;
        tvCurrentQuiz.setText(getString(
                R.string.current_question,
                currentQuiz,
                10
        ));
    }

    public void updateCurrentScore(int currentScore) {
        TextView tvCurrentScore = binding.yourScore;
        tvCurrentScore.setText(getString(
                R.string.current_score,
                currentScore,
                10
        ));
    }

    // Handle event when player submit their answer
    private void onSubmitAnswer() {
        quizViewModel.updateScoreAndQuiz();
        quizViewModel.currentScore();
    }

    // Handle on back button click
    private void onBackBtnPressed(View view) {
        Navigation.findNavController(view).navigate(R.id.action_wordQuizFragment_to_gamesFragment);
    }
}