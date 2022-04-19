package com.example.els.viewmodel.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.Lesson;
import com.example.els.models.LessonData;

import java.util.ArrayList;

public class SpeakingViewModel extends ViewModel {
    private final LessonData lessonData = new LessonData();

    // Done speaking lessons
    private MutableLiveData<ArrayList<Lesson>> _doneSpeakingLessons;

    public LiveData<ArrayList<Lesson>> getDoneSpeakingLessons() {
        if (_doneSpeakingLessons == null) _doneSpeakingLessons = new MutableLiveData<>();
        loadDoneLessons();
        return _doneSpeakingLessons;
    }

    public void loadDoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.speakingLessons.size(); i++) {
            if (lessonData.speakingLessons.get(i).getState()) {
                temp.add(lessonData.speakingLessons.get(i));
            }
        }
        _doneSpeakingLessons.setValue(temp);
    }

    // Undone reading lessons
    private MutableLiveData<ArrayList<Lesson>> _undoneSpeakingLessons;

    public LiveData<ArrayList<Lesson>> getUndoneSpeakingLessons() {
        if (_undoneSpeakingLessons == null) _undoneSpeakingLessons = new MutableLiveData<>();
        loadUndoneLessons();
        return _undoneSpeakingLessons;
    }

    public void loadUndoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.speakingLessons.size(); i++) {
            if (!lessonData.speakingLessons.get(i).getState()) {
                temp.add(lessonData.speakingLessons.get(i));
            }
        }
        _undoneSpeakingLessons.setValue(temp);
    }

    // Total duration
    private final MutableLiveData<Integer> _totalDuration = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalDuration() {
        int total = 0;
        for (int i = 0; i < lessonData.speakingLessons.size(); i++) {
            total += lessonData.speakingLessons.get(i).getDuration();
        }
        _totalDuration.setValue(total);
        return _totalDuration;
    }

    // Number of lessons
    private final MutableLiveData<Integer> _totalLessons = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalLessons() {
        _totalLessons.setValue(lessonData.speakingLessons.size());
        return _totalLessons;
    }

    // Complete percentage
    private final MutableLiveData<Integer> _completePercentage = new MutableLiveData<>(0);

    public LiveData<Integer> getCompletePercentage() {
        int count = 0;
        for (int i = 0; i < lessonData.speakingLessons.size(); i++) {
            if(lessonData.speakingLessons.get(i).getState()){
                count++;
            }
        }
        double percentage = ((double) count / (double) lessonData.speakingLessons.size() * 100);
        int percent = (int)percentage;
        _completePercentage.setValue(percent);
        return _completePercentage;
    }
}
