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

import com.example.els.R;
import com.example.els.databinding.FragmentWordQuizBinding;
import com.example.els.models.games.Quiz;
import com.example.els.models.games.QuizGame;
import com.example.els.viewmodel.games.WordQuizViewModel;

public class WordQuizFragment extends Fragment {
    public static final int totalQuiz = 10;
    private FragmentWordQuizBinding binding;
    private WordQuizViewModel quizViewModel;
    private Button firstBtn;
    private Button secondBtn;
    public static int constantsTime = 1500;

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
        firstBtn = binding.firstAnswerBtn;
        secondBtn = binding.secondAnswerBtn;

        // Fetch quiz list from API when first join in the game
        quizViewModel.fetchQuizFromAPI();

        // fetch data when get into screen
        quizViewModel.currentQuiz().observe(getViewLifecycleOwner(), currentQuiz -> {
            // Give a delay time for user to see the question and its answer
            (new Handler()).postDelayed(() -> {
                updateQuizViewContent(currentQuiz);
                updateProgressInfo(currentQuiz);
            }, constantsTime);
        });

        // Handle event when user choose the second option of answers
        quizViewModel.quizGame().observe(getViewLifecycleOwner(), quizGame -> {
            // Handle event when user choose the first option of answers
            firstBtn.setOnClickListener(view1 -> {
                onFirstOptionChosen(quizGame);
                if(quizViewModel.currentQuiz().getValue() == totalQuiz) navigateToTheCongratulationsScreen(view1);
            });
            // Handle event when user choose the first option of answers
            secondBtn.setOnClickListener(view12 -> {
                onSecondOptionChosen(quizGame);
                if(quizViewModel.currentQuiz().getValue() == totalQuiz) navigateToTheCongratulationsScreen(view12);
            });
        });

        // handle back event
        binding.backBtn.setOnClickListener(this::onBackBtnPressed);

        // Skip quiz
        binding.skipThisQuiz.setOnClickListener(view13 -> {
            quizViewModel.updateQuiz();
            updateQuizViewContent(quizViewModel.currentQuiz().getValue());
            updateProgressInfo(quizViewModel.currentQuiz().getValue());
        });
    }

    // Update quiz content
    public void updateQuizViewContent(int currentQuiz) {
        // start to observe changes and update it to the views above
        // Use observer to make sure the quizlist changes and non null to avoid crash
        quizViewModel.quizGame().observe(getViewLifecycleOwner(), quizGame -> {
            // get the current quiz from the quiz list with the given index
            // Current quiz is always greater than the index of quiz 1 unit
            Quiz quiz = quizGame.getQuizList().get(currentQuiz - 1);
            // Set quiz content
            binding.quiz.setText(getString(R.string.quiz_content,
                    quiz.getQuestions().get(0),
                    quiz.getQuestions().get(1),
                    quiz.getQuestions().get(2)
            ));
            // Make buttons clickable
            setButtonClickable(true);
            // Set text for answer button text
            firstBtn.setText(getString(R.string.first_answer,
                    quiz.getOptions().get(0)
            ));
            secondBtn.setText(getString(R.string.second_answer,
                    quiz.getOptions().get(1)
            ));
            resetButtonColor();
        });
    }

    // Update score, quiz index and progress indicator
    public void updateProgressInfo(int currentQuiz) {
        // Observe changes of quiz number and score then update it
        binding.currentQuiz.setText(getString(
                R.string.current_question,
                currentQuiz,
                totalQuiz
        ));
        quizViewModel.currentScore().observe(getViewLifecycleOwner(), score -> binding.yourScore.setText(getString(
                R.string.current_score,
                score,
                totalQuiz)
        ));
        // Update progress indicator
        binding.wordQuizIndicator.setProgress(currentQuiz * 10, true);
    }

    public void onFirstOptionChosen(QuizGame quizGame) {
        // Set clickable to false to avoid user click so many times
        setButtonClickable(false);

        Quiz quiz = quizGame.getQuizList().get(quizViewModel.currentQuiz().getValue() - 1);
        // if the correct answer is 1 then change the button color to green and increase the score
        if (quiz.getCorrect() == 1) {
            setButtonStateRight(firstBtn);
            quizViewModel.updateScore();
        } else {
            // else set the button color to red color
            setButtonStateFalse(firstBtn);
        }

        // Finally update the current quiz
        quizViewModel.updateQuiz();
    }

    public void onSecondOptionChosen(QuizGame quizGame) {
        // Set clickable to false to avoid user click so many times
        setButtonClickable(false);

        Quiz quiz = quizGame.getQuizList().get(quizViewModel.currentQuiz().getValue() - 1);
        // if the correct answer is 1 then change the button color to red
        if (quiz.getCorrect() == 1) {
            setButtonStateFalse(secondBtn);
        } else {
            // else set the button color to green color and increase the score
            setButtonStateRight(secondBtn);
            quizViewModel.updateScore();
        }

        // Finally update the current quiz
        quizViewModel.updateQuiz();
    }

    // Navigate to the congratulations fragment
    public void navigateToTheCongratulationsScreen(View view) {
        (new Handler()).postDelayed(() ->
                Navigation.findNavController(view).navigate(R.id.action_wordQuizFragment_to_congratulationFragment),
                constantsTime
        );
    }

    // Set state of the buttons
    public void setButtonStateRight(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.secondary_color_1, null));
    }
    public void setButtonStateFalse(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.secondary_color_3, null));
    }
    public void resetButtonColor() {
        // Update button background back to normal after user submit an answer
        firstBtn.setBackgroundColor(getResources().getColor(R.color.accent_color, null));
        secondBtn.setBackgroundColor(getResources().getColor(R.color.accent_color, null));
    }

    // Set button clickable or not
    public void setButtonClickable(boolean isClickable) {
        firstBtn.setClickable(isClickable);
        secondBtn.setClickable(isClickable);
    }

    // Handle on back button click
    private void onBackBtnPressed(View view) {
        Navigation.findNavController(view).navigate(R.id.action_wordQuizFragment_to_gamesFragment);
    }
}