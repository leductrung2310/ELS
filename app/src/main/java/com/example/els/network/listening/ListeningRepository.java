package com.example.els.network.listening;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.network.ApiUtils;
import com.example.els.network.listening.ListeningApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeningRepository {
    private final ListeningApi listeningApi = ApiUtils.getAllListeningLesson();

    public LiveData<List<Listening>> getAllListeningLesson() {
        final MutableLiveData<List<Listening>> data = new MutableLiveData<>();
        listeningApi.getAllListeningLesson().enqueue(new Callback<List<Listening>>() {
            @Override
            public void onResponse(@NonNull Call<List<Listening>> call, @NonNull Response<List<Listening>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    Log.d("phat", "error");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Listening>> call, @NonNull Throwable t) {

            }
        });
        return data;
    }

    public LiveData<List<ListeningQuestion>> getListeningQuestionByLesson(String id) {
        final MutableLiveData<List<ListeningQuestion>> data = new MutableLiveData<>();
        listeningApi.getAllListeningQuestion(id).enqueue(new Callback<List<ListeningQuestion>>() {
            @Override
            public void onResponse(Call<List<ListeningQuestion>> call, Response<List<ListeningQuestion>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    Log.d("phat", "error");
                }
            }

            @Override
            public void onFailure(Call<List<ListeningQuestion>> call, Throwable t) {

            }
        });
        return data;
    }
}
