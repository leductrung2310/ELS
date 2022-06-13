package com.example.els.models.Api;

import com.google.gson.annotations.SerializedName;

public class ReadingLesson {
    @SerializedName("id")
    private String uuid;
    @SerializedName("title")
    private String title;
    @SerializedName("duration")
    private int duration;

    public ReadingLesson() {

    }

    public ReadingLesson(String uuid, String title, int duration) {
        this.uuid = uuid;
        this.title = title;
        this.duration = duration;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ReadingLesson{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
