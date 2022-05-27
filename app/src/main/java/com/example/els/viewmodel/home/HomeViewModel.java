package com.example.els.viewmodel.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.AccountRepository;

public class HomeViewModel extends ViewModel {
    // Skill key
    private final MutableLiveData<String> _skillKey = new MutableLiveData<>("key");

    public LiveData<String> getSkillKey() {
        return _skillKey;
    }

    public void setSkillKey(String keyValue) {
        _skillKey.setValue(keyValue);
    }

    //get data user
    private AccountRepository accountRepository = new AccountRepository();

    public void getAccountInfo() {
        accountRepository.getUserDataFromFirestore();
    }
}
