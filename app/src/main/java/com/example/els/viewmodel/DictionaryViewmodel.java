package com.example.els.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.dictionary.Word;
import com.example.els.network.dictionary.DictionaryAPIService;
import com.example.els.network.dictionary.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DictionaryViewmodel extends ViewModel {

    private final MutableLiveData<Word> newWordLiveData = new MutableLiveData<>();

    public void getWord(String word, Context context) {

        DictionaryAPIService apiService = RetroInstance.getRetroClient().create(DictionaryAPIService.class);
        Call<List<Word>> call = apiService.getWord(word);

        call.enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(@NonNull Call<List<Word>> call, @NonNull Response<List<Word>> response) {
                if(response.body() != null) {
                    newWordLiveData.postValue(response.body().get(0));
                } else {
                    Toast.makeText(context, "No word found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Word>> call, @NonNull Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public MutableLiveData<Word> getNewWordLiveData() {
        return newWordLiveData;
    }
}
