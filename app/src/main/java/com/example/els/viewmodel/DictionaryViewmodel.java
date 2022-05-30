package com.example.els.viewmodel;

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

    private MutableLiveData<Word> newWordLiveData = new MutableLiveData<>();

    private MutableLiveData<Boolean> isSuccess = new MutableLiveData<>();

    public void getWord(String word) {

        DictionaryAPIService apiService = RetroInstance.getRetroClient().create(DictionaryAPIService.class);
        Call<List<Word>> call = apiService.getWord(word);

        call.enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {

                newWordLiveData.postValue(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<Word>> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<Boolean> getIsSuccess() {
        return isSuccess;
    }

    public MutableLiveData<Word> getNewWordLiveData() {
        return newWordLiveData;
    }
}
