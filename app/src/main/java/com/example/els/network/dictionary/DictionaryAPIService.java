package com.example.els.network.dictionary;

import com.example.els.models.dictionary.Word;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DictionaryAPIService {
    @GET("{word}")
    Call<List<Word>> getWord(@Path("word") String word);
}

