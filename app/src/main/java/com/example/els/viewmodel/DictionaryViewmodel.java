package com.example.els.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.dictionary.Word;
import com.example.els.network.dictionary.DictionaryAPIService;
import com.example.els.network.dictionary.RetroInstance;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DictionaryViewmodel extends ViewModel {

    private final MutableLiveData<Word> newWordLiveData = new MutableLiveData<>();

    public void getWord(String word) {

        DictionaryAPIService apiService = RetroInstance.getRetroClient().create(DictionaryAPIService.class);
        Call<List<Word>> call = apiService.getWord(word);

        call.enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(@NonNull Call<List<Word>> call, @NonNull Response<List<Word>> response) {
                newWordLiveData.postValue(Objects.requireNonNull(response.body()).get(0));
            }

            @Override
            public void onFailure(@NonNull Call<List<Word>> call, @NonNull Throwable t) {

            }
        });
    }

    public MutableLiveData<Word> getNewWordLiveData() {
        return newWordLiveData;
    }
}
