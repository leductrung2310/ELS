package com.example.els.viewmodel.games;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.games.History;
import com.example.els.models.games.HistoryRepository;

import java.util.ArrayList;

public class HistoryViewModel extends ViewModel {
    private MutableLiveData<ArrayList<History>> _histories;
    private MutableLiveData<Integer> _averageScore;
    private MutableLiveData<Integer> _bestScore;
    private MutableLiveData<Long> _playTimes;
    private HistoryRepository repository;

    public MutableLiveData<ArrayList<History>> histories() {
        if (_histories == null) _histories = new MutableLiveData<>();
        return _histories;
    }

    public MutableLiveData<Integer> averageScore() {
        if (_averageScore == null) _averageScore = new MutableLiveData<>();
        return _averageScore;
    }

    public MutableLiveData<Integer> bestScore() {
        if (_bestScore == null) _bestScore = new MutableLiveData<>();
        return _bestScore;
    }

    public MutableLiveData<Long> playTimes() {
        if (_playTimes == null) _playTimes = new MutableLiveData<>();
        return _playTimes;
    }

    // Check whether user play the game before
    public boolean isHistoryExist() {
        if (repository == null) repository = new HistoryRepository();
        return repository.fetchHistory() != null;
    }

    // Get data from firestore
    public void fetchHistories() {
        if (repository == null) repository = new HistoryRepository();
        //histories().setValue(repository.fetchHistoryFromFirestore());
        repository.getHistoryList(histories -> {
            Log.d("ListSize", String.valueOf(histories.size()));
            histories().setValue(histories);
        });
    }

    // Push data to firestore through viewmodel
    public void pushHistoryToDB(History history) {
        if (repository == null) repository = new HistoryRepository();
        repository.pushHistoryToFireStore(history);
    }

    // Update history
    public void updateHistoryToDB(History history) {
        if (repository == null) repository = new HistoryRepository();
        repository.updateHistoryToFirestore(history);
    }
}
