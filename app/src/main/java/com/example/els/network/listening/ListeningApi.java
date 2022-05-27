package com.example.els.network.listening;

import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ListeningApi {
    @GET("listening")
    Call<List<Listening>> getAllListeningLesson();

    @POST("listeningQuestion")
    Call<List<ListeningQuestion>> getAllListeningQuestion(@Field(value = "id") String id);
}
