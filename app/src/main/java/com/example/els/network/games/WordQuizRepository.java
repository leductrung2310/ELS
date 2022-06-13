package com.example.els.network.games;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.els.models.games.QuizGame;
import com.example.els.network.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordQuizRepository {
    private final WordQuizAPI api = ApiUtils.getQuizList();

    public void getQuizList(int level, String area, OnGetSurveyListener onGetSurveyListener) {
        api.fetchQuizList(level, area).enqueue(new Callback<QuizGame>() {
            @Override
            public void onResponse(@NonNull Call<QuizGame> call, @NonNull Response<QuizGame> response) {
                onGetSurveyListener.onCallBack((QuizGame) response.body());
            }

            @Override
            public void onFailure(@NonNull Call<QuizGame> call, @NonNull Throwable t) {
                Log.d("response", "fail");
            }
        });
    }

    // This callback used with asynchronous programming
    public interface OnGetSurveyListener {
        void onCallBack(QuizGame quizGame);
    }
}