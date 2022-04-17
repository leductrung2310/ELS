package com.example.els.viewmodel.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.Lesson;
import com.example.els.models.LessonData;

import java.util.ArrayList;

public class WritingViewModel extends ViewModel {
    private final LessonData lessonData = new LessonData();

    // Done speaking lessons
    private MutableLiveData<ArrayList<Lesson>> _doneWritingLessons;

    public LiveData<ArrayList<Lesson>> getDoneWritingLessons() {
        if (_doneWritingLessons == null) _doneWritingLessons = new MutableLiveData<>();
        loadDoneLessons();
        return _doneWritingLessons;
    }

    public void loadDoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.writingLessons.size(); i++) {
            if (lessonData.writingLessons.get(i).getState()) {
                temp.add(lessonData.writingLessons.get(i));
            }
        }
        _doneWritingLessons.setValue(temp);
    }

    // Undone reading lessons
    private MutableLiveData<ArrayList<Lesson>> _undoneWritingLessons;

    public LiveData<ArrayList<Lesson>> getUndoneWritingLessons() {
        if (_undoneWritingLessons == null) _undoneWritingLessons = new MutableLiveData<>();
        loadUndoneLessons();
        return _undoneWritingLessons;
    }

    public void loadUndoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.writingLessons.size(); i++) {
            if (!lessonData.writingLessons.get(i).getState()) {
                temp.add(lessonData.writingLessons.get(i));
            }
        }
        _undoneWritingLessons.setValue(temp);
    }

    // Total duration
    private final MutableLiveData<Integer> _totalDuration = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalDuration() {
        int total = 0;
        for (int i = 0; i < lessonData.writingLessons.size(); i++) {
            total += lessonData.writingLessons.get(i).getDuration();
        }
        _totalDuration.setValue(total);
        return _totalDuration;
    }

    // Number of lessons
    private final MutableLiveData<Integer> _totalLessons = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalLessons() {
        _totalLessons.setValue(lessonData.writingLessons.size());
        return _totalLessons;
    }

    // Complete percentage
    private final MutableLiveData<Integer> _completePercentage = new MutableLiveData<>(0);

    public LiveData<Integer> getCompletePercentage() {
        int count = 0;
        for (int i = 0; i < lessonData.writingLessons.size(); i++) {
            if(lessonData.writingLessons.get(i).getState()){
                count++;
            }
        }
        double percentage = ((double) count / (double) lessonData.writingLessons.size() * 100);
        int percent = (int)percentage;
        _completePercentage.setValue(percent);
        return _completePercentage;
    }
}
