package com.example.els.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.dictionary.DictionaryRepository;
import com.example.els.models.dictionary.Word;

public class DictionaryViewmodel extends ViewModel {

    private MutableLiveData<Word> newWord = new MutableLiveData<>();

    public MutableLiveData<Word> getNewWord() {
        return newWord;
    }

    private MutableLiveData<Boolean> isSuccess = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsSuccess() {
        return isSuccess;
    }

    private DictionaryRepository dictionaryRepository;

    public void getWord(String newWord) {

        dictionaryRepository.requestJson(newWord);

        if (dictionaryRepository.requestJson(newWord) != null) {
            this.newWord.setValue(dictionaryRepository.requestJson(newWord));
            isSuccess.setValue(true);
        } else {
            this.newWord.setValue(null);
            isSuccess.setValue(false);
        }
    }
}
