package com.example.els.network.dictionary;

import android.util.Log;

import com.example.els.models.dictionary.Word;

public class DictionaryRepository {


    public void getWord(String word, GetWordCallback getWordCallback) {
        Log.d("trung", "111");
//        DictionaryAPIService.apiService.getWord(word).enqueue(new Callback<Word>() {
//            @Override
//            public void onResponse(Call<Word> call, Response<Word> response) {
//                Log.d("trung", "222");
//                getWordCallback.onCallback(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Word> call, Throwable t) {
//            }
//        });
    }

    public interface GetWordCallback {
        void onCallback(Word newWord);
    }
}
