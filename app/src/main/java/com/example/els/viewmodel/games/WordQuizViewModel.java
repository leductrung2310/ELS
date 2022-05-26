package com.example.els.viewmodel.games;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.games.QuizGame;
import com.example.els.network.games.WordQuizRepository;

public class WordQuizViewModel extends ViewModel {
    private WordQuizRepository _repository;
    private MutableLiveData<QuizGame> _quizGame;

    // Current score and quiz
    private MutableLiveData<Integer> _currentScore;
    private MutableLiveData<Integer> _currentQuiz;

    // Chosen level and area of the quiz
    private MutableLiveData<Integer> _level;
    private MutableLiveData<String> _area;

    // Getter for the word quiz variable to set data when we fetch from API
    public MutableLiveData<QuizGame> quizGame() {
        if (_quizGame == null) {
            _quizGame = new MutableLiveData<>();
        }
        return _quizGame;
    }

    // Getter for the word quiz repository
    public WordQuizRepository wordQuizRepo() {
        if (_repository == null) _repository = new WordQuizRepository();
        return _repository;
    }

    // Getter  for the current score and quiz
    public MutableLiveData<Integer> currentScore() {
        if (_currentScore == null) {
            _currentScore = new MutableLiveData<>(0);
        }
        return _currentScore;
    }

    public MutableLiveData<Integer> currentQuiz() {
        if (_currentQuiz == null) {
            _currentQuiz = new MutableLiveData<>(1);
        }
        return _currentQuiz;
    }

    // Getter and setter for the level and area of quiz list
    public MutableLiveData<Integer> level() {
        if (_level == null) _level = new MutableLiveData<>(1);
        return _level;
    }

    public MutableLiveData<String> area() {
        if (_area == null) _area = new MutableLiveData<>("toeic");
        return _area;
    }

    // Fetch data from word quiz API when user start the game
    public void fetchQuizFromAPI() {
        // call the get quiz list method from the repo class and pass necessary parameters
        wordQuizRepo().getQuizList(
                // Handle unboxing null object
                level().getValue() == null ? 1 : level().getValue(),
                area().getValue(),
                quizGame -> quizGame().postValue(quizGame)
        );
    }

    // update current score
    public void updateScoreAndQuiz() {
        int newQuiz = currentQuiz().getValue() + 1;
        currentQuiz().setValue(newQuiz);
        int newScore = currentScore().getValue() + 1;
        currentScore().setValue(newScore);
    }
}
