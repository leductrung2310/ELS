package com.example.els.viewmodel.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GrammarViewModel extends ViewModel {
  private MutableLiveData<String> content;
    public GrammarViewModel() {
        content = new MutableLiveData<>();
    }

    public MutableLiveData<String> getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content.setValue(content);
    }
}
