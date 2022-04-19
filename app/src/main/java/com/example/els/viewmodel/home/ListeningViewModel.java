package com.example.els.viewmodel.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.Lesson;
import com.example.els.models.LessonData;

import java.util.ArrayList;

public class ListeningViewModel extends ViewModel {
    private final LessonData lessonData = new LessonData();

    // Done listening lessons
    private MutableLiveData<ArrayList<Lesson>> _doneListeningLessons;

    public LiveData<ArrayList<Lesson>> getDoneListeningLessons() {
        if (_doneListeningLessons == null) _doneListeningLessons = new MutableLiveData<>();
        loadDoneLessons();
        return _doneListeningLessons;
    }

    public void loadDoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.listeningLessons.size(); i++) {
            if (lessonData.listeningLessons.get(i).getState()) {
                temp.add(lessonData.listeningLessons.get(i));
            }
        }
        _doneListeningLessons.setValue(temp);
    }

    // Undone listening lessons
    private MutableLiveData<ArrayList<Lesson>> _undoneListeningLessons;

    public LiveData<ArrayList<Lesson>> getUndoneListeningLessons() {
        if (_undoneListeningLessons == null) _undoneListeningLessons = new MutableLiveData<>();
        loadUndoneLessons();
        return _undoneListeningLessons;
    }

    public void loadUndoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.listeningLessons.size(); i++) {
            if (!lessonData.listeningLessons.get(i).getState()) {
                temp.add(lessonData.listeningLessons.get(i));
            }
        }
        _undoneListeningLessons.setValue(temp);
    }

    // Total duration
    private final MutableLiveData<Integer> _totalDuration = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalDuration() {
        int total = 0;
        for (int i = 0; i < lessonData.listeningLessons.size(); i++) {
            total += lessonData.listeningLessons.get(i).getDuration();
        }
        _totalDuration.setValue(total);
        return _totalDuration;
    }

    // Number of lessons
    private final MutableLiveData<Integer> _totalLessons = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalLessons() {
        _totalLessons.setValue(lessonData.listeningLessons.size());
        return _totalLessons;
    }

    // Complete percentage
    private final MutableLiveData<Integer> _completePercentage = new MutableLiveData<>(0);

    public LiveData<Integer> getCompletePercentage() {
        int count = 0;
        for (int i = 0; i < lessonData.listeningLessons.size(); i++) {
            if(lessonData.listeningLessons.get(i).getState()){
                count++;
            }
        }
        double percentage = ((double) count / (double) lessonData.listeningLessons.size() * 100);
        int percent = (int)percentage;
        _completePercentage.setValue(percent);
        return _completePercentage;
    }
}
