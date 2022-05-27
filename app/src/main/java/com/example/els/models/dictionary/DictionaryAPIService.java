package com.example.els.models.dictionary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DictionaryAPIService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    DictionaryAPIService apiService = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(DictionaryAPIService.class);


    @GET("api/v2/entries/en/{word}")
    Call<Word> getWord(@Path("word") String word);
}

