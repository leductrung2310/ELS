package com.example.els.network.listening;

import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningQuestion;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ListeningApi {

    @GET("listening")
    Call<List<Listening>> getAllListeningLesson();

    @GET("listeningQuestion/")
    Call<List<ListeningQuestion>> getAllListeningQuestion(@QueryMap Map<String, String> params);
}
