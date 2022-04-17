package com.example.els.viewmodel.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.Lesson;
import com.example.els.models.LessonData;

import java.util.ArrayList;

public class ReadingViewModel extends ViewModel {
    private final LessonData lessonData = new LessonData();

    // Done reading lessons
    private MutableLiveData<ArrayList<Lesson>> _doneReadingLessons;

    public MutableLiveData<ArrayList<Lesson>> getDoneReadingLessons() {
        if (_doneReadingLessons == null) _doneReadingLessons = new MutableLiveData<>();
        loadDoneLessons();
        return _doneReadingLessons;
    }

    public void loadDoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.readingLessons.size(); i++) {
            if (lessonData.readingLessons.get(i).getState()) {
                temp.add(lessonData.readingLessons.get(i));
            }
        }
        _doneReadingLessons.setValue(temp);
    }

    // Undone listening lessons
    private MutableLiveData<ArrayList<Lesson>> _undoneReadingLessons;

    public LiveData<ArrayList<Lesson>> getUndoneReadingLessons() {
        if (_undoneReadingLessons == null) _undoneReadingLessons = new MutableLiveData<>();
        loadUndoneLessons();
        return _undoneReadingLessons;
    }

    public void loadUndoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.readingLessons.size(); i++) {
            if (!lessonData.readingLessons.get(i).getState()) {
                temp.add(lessonData.readingLessons.get(i));
            }
        }
        _undoneReadingLessons.setValue(temp);
    }

    // Total duration
    private final MutableLiveData<Integer> _totalDuration = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalDuration() {
        int total = 0;
        for (int i = 0; i < lessonData.readingLessons.size(); i++) {
            total += lessonData.readingLessons.get(i).getDuration();
        }
        _totalDuration.setValue(total);
        return _totalDuration;
    }

    // Number of lessons
    private final MutableLiveData<Integer> _totalLessons = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalLessons() {
        _totalLessons.setValue(lessonData.readingLessons.size());
        return _totalLessons;
    }

    // Complete percentage
    private final MutableLiveData<Integer> _completePercentage = new MutableLiveData<>(0);

    public LiveData<Integer> getCompletePercentage() {
        int count = 0;
        for (int i = 0; i < lessonData.readingLessons.size(); i++) {
            if(lessonData.readingLessons.get(i).getState()){
                count++;
            }
        }
        double percentage = ((double) count / (double) lessonData.readingLessons.size() * 100);
        int percent = (int)percentage;
        _completePercentage.setValue(percent);
        return _completePercentage;
    }
}
