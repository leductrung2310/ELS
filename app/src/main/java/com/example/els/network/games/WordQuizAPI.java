package com.example.els.network.games;

import com.example.els.models.games.QuizGame;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface WordQuizAPI {
    String BASE_URL = "https://twinword-word-association-quiz.p.rapidapi.com/";

    // Define an endpoint to get data from the API
    @Headers({
            "X-RapidAPI-Host: twinword-word-association-quiz.p.rapidapi.com",
            "X-RapidAPI-Key: f3c31aaa01mshd4c9bfd166b984ep122eedjsn9f5e1ad3fe7d"
    })
    @GET("type1/")
    Call<QuizGame> fetchQuizList(@Query("level") int level, @Query("area") String area);
}