package com.example.els.models.Api;

import com.google.gson.annotations.SerializedName;

public class Listening {
    @SerializedName("id")
    private String uuid;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("audio")
    private String audio;

    public Listening(String uuid, String title, String content, Integer duration, String audio) {
        this.uuid = uuid;
        this.title = title;
        this.content = content;
        this.duration = duration;
        this.audio = audio;
    }

    public Listening() {
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Listening{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", duration=" + duration +
                ", audio='" + audio + '\'' +
                '}';
    }
}

