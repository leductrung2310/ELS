package com.example.els.network.listening;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.network.ApiUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeningRepository {
    private final ListeningApi listeningApi = ApiUtils.getAllListeningLesson();

    public void getAllListeningLesson(OnGetSurveyListener onGetSurveyListener) {
        Log.d("listening", "vô repo get data");
        listeningApi.getAllListeningLesson().enqueue(new Callback<List<Listening>>() {
            @Override
            public void onResponse(@NonNull Call<List<Listening>> call, @NonNull Response<List<Listening>> response) {
                if (response.isSuccessful() & response.body() != null) {
                    Log.d("listening", "có data trả về body");
                    onGetSurveyListener.onCallBack((ArrayList<Listening>) response.body());
                } else {
                    Log.d("listening", "ko có body");
                    Log.d("phat", "error");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Listening>> call, @NonNull Throwable t) {
                onGetSurveyListener.onCallBackFailure(new ArrayList<>());
            }

        });
    }

    public interface OnGetSurveyListener {
        void onCallBack(ArrayList<Listening> listenings);
       void onCallBackFailure(ArrayList<Listening> listenings);
    }

    public void getListeningQuestionByLesson(String id, OnGetListeningQuestionByLesson onGetListeningQuestionByLesson) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id",id);
        listeningApi.getAllListeningQuestion(params).enqueue(new Callback<List<ListeningQuestion>>() {
            @Override
            public void onResponse(Call<List<ListeningQuestion>> call, Response<List<ListeningQuestion>> response) {
                if (response.isSuccessful() && response.body() !=null) {
                    onGetListeningQuestionByLesson.onCallBack((ArrayList<ListeningQuestion>) response.body());
                } else {
                    Log.d("phat", "error");
                }
            }

            @Override
            public void onFailure(Call<List<ListeningQuestion>> call, Throwable t) {

            }
        });
    }

    public interface OnGetListeningQuestionByLesson {
        void onCallBack(ArrayList<ListeningQuestion> listeningQuestions);
        //void onGetSurveyFailure(errorMessage: String)
    }
}
