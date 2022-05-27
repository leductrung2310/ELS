package com.example.els.view.games;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.els.R;
import com.example.els.databinding.FragmentWordQuizBinding;
import com.example.els.models.games.Quiz;
import com.example.els.viewmodel.games.WordQuizViewModel;


public class WordQuizFragment extends Fragment {
    public static final int totalQuiz = 10;
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

        // Fetch quiz list from API when first join in the game
        quizViewModel.fetchQuizFromAPI();

        // fetch data when get into screen
        quizViewModel.currentQuiz().observe(getViewLifecycleOwner(), currentQuiz -> {
            // Give a delay time for user to see the question and its answer
            (new Handler()).postDelayed(() -> {
                updateView(currentQuiz);
            }, 2000);
        });

        // Handle event when user choose the first option of answers
        binding.firstAnswerBtn.setOnClickListener(view1 -> onSubmitAnswer(true));

        // Handle event when user choose the second option of answers
        binding.secondAnswerBtn.setOnClickListener(view12 -> onSubmitAnswer(false));

        // handle back event
        binding.backBtn.setOnClickListener(this::onBackBtnPressed);
    }

    // Update view with new quiz, options and score as well as quiz number
    private void updateView(int currentQuiz) {
        // Initialize views that need to update
        Button firstQuestion = binding.firstAnswerBtn;
        Button secondQuestion = binding.secondAnswerBtn;
        TextView tvQuiz = binding.quiz;
        TextView scoreTextView = binding.yourScore;
        TextView numberQuizTextView = binding.currentQuiz;

        // Observe changes of quiz number and score then update it
        numberQuizTextView.setText(getString(
                R.string.current_question,
                currentQuiz,
                totalQuiz
        ));
        quizViewModel.currentScore().observe(getViewLifecycleOwner(), score -> scoreTextView.setText(getString(
                R.string.current_score,
                score,
                totalQuiz)
        ));

        // start to observe changes and update it to the views above
        // Use observer to make sure the quizlist changes and non null to avoid crash
        quizViewModel.quizGame().observe(getViewLifecycleOwner(), quizGame -> {
            // Current quiz is always greater than the index of quiz 1 unit
            Quiz quiz = quizGame.getQuizList().get(currentQuiz - 1);
            // Set quiz content
            tvQuiz.setText(getString(R.string.quiz_content,
                    quiz.getQuestions().get(0),
                    quiz.getQuestions().get(1),
                    quiz.getQuestions().get(2)
            ));
            // Set text for answer button text
            firstQuestion.setText(getString(R.string.first_answer,
                    quiz.getOptions().get(0)
            ));
            secondQuestion.setText(getString(R.string.second_answer,
                    quiz.getOptions().get(1)
            ));
            // Update button background back to normal after user submit an answer
            binding.secondAnswerBtn.setBackgroundColor(getResources().getColor(R.color.accent_color, null));
            binding.firstAnswerBtn.setBackgroundColor(getResources().getColor(R.color.accent_color, null));
            // Update progress indicator
            binding.wordQuizIndicator.setProgress(currentQuiz * 10, true);
        });
    }

    // Handle the event after submit answer
    public void onSubmitAnswer(Boolean isFirstOption) {
        // Use observer to make sure the quizlist changes and non null to avoid crash
        quizViewModel.quizGame().observe(getViewLifecycleOwner(), quizGame -> {
            Quiz quiz = quizGame.getQuizList().get(quizViewModel.currentQuiz().getValue() - 1);
            // If the user click on the first option then:
            if (isFirstOption) {
                if (quiz.getCorrect() == 1) {
                    // if the correct answer is 1 then change the button color to green and increase the score
                    binding.firstAnswerBtn.setBackgroundColor(getResources().getColor(R.color.secondary_color_1, null));
                    quizViewModel.updateScore();
                } else {
                    // else set the button color to red color
                    binding.firstAnswerBtn.setBackgroundColor(getResources().getColor(R.color.secondary_color_3, null));
                }
            }
            // else the the user choose the second option
            else {
                if (quiz.getCorrect() == 2) {
                    // if the correct answer is 2 then change the button color to green and increase the score
                    binding.secondAnswerBtn.setBackgroundColor(getResources().getColor(R.color.secondary_color_1, null));
                    quizViewModel.updateScore();
                } else {
                    // else set the button color to red color
                    binding.secondAnswerBtn.setBackgroundColor(getResources().getColor(R.color.secondary_color_3, null));
                }
            }
        });

        // If this the final quiz then show a congratulation dialog


        // Finally update the current quiz
        quizViewModel.updateQuiz();
    }

    // Handle on back button click
    private void onBackBtnPressed(View view) {
        Navigation.findNavController(view).navigate(R.id.action_wordQuizFragment_to_gamesFragment);
    }
}