package com.example.els.network.dictionary;

import com.example.els.models.dictionary.Word;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DictionaryAPIService {
    @GET("entries/en/{word}")
    Call<Word> getWord1(@Path("word") String word);

    @GET("apple")
    Call<Word> getWord();
}

