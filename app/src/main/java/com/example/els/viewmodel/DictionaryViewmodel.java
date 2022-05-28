package com.example.els.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.dictionary.Word;
import com.example.els.network.dictionary.DictionaryAPIService;
import com.example.els.network.dictionary.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DictionaryViewmodel extends ViewModel {

    private MutableLiveData<Word> newWordLiveData = new MutableLiveData<>();

    private MutableLiveData<Boolean> isSuccess = new MutableLiveData<>();

    public void getWord(String word) {

        DictionaryAPIService apiService = RetroInstance.getRetroClient().create(DictionaryAPIService.class);
        Call<Word> call = apiService.getWord();

        Log.d("xxx", word);

        call.enqueue(new Callback<Word>() {
            @Override
            public void onResponse(Call<Word> call, Response<Word> response) {
                Log.d("xxx", "111");
                newWordLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Word> call, Throwable t) {
                Log.d("xxx", t.getMessage());
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
