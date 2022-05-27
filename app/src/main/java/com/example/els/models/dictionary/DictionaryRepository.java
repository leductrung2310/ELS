package com.example.els.models.dictionary;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DictionaryRepository {

    public Word requestJson(String newWord) {

        final Word[] word = new Word[1];

        DictionaryAPIService.apiService.getWord(newWord).enqueue(new Callback<Word>() {
            @Override
            public void onResponse(Call<Word> call, Response<Word> response) {

                Word word1 = response.body();
                if(word1 != null) {
                    word[0] = word1;
                }
            }

            @Override
            public void onFailure(Call<Word> call, Throwable t) {

            }
        });
    return word[0];
    }

}
