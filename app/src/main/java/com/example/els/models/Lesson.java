package com.example.els.models;

public class Lesson {
    int lessonNumber;
    String lessonName;
    int duration;
    boolean state;

    public Lesson(int lessonNumber, String lessonName, int duration, boolean state) {
        this.lessonNumber = lessonNumber;
        this.lessonName = lessonName;
        this.duration = duration;
        this.state = state;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public String getLessonName() {
        return lessonName;
    }

    public int getDuration() {
        return duration;
    }

    public boolean getState() {
        return state;
    }
}
