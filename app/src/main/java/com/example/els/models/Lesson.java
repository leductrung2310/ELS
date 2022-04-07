package com.example.els.models;

import java.time.LocalTime;

public class Lesson {
    int lessonNumber;
    String lessonName;
    String duration;

    public Lesson(int lessonNumber, String lessonName, String duration) {
        this.lessonNumber = lessonNumber;
        this.lessonName = lessonName;
        this.duration = duration;
    }

    public Lesson() {}

    public int getLessonNumber() {
        return lessonNumber;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getDuration() {
        return duration;
    }
}
