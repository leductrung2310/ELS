package com.example.els.models.Api;

import com.google.gson.annotations.SerializedName;

public class ReadingQuestion {
    @SerializedName("id")
    private String uuid;

    @SerializedName("readingLessonUuid")
    private String readingLessonUuid;

    @SerializedName("content")
    private String content;

    public ReadingQuestion() {

    }

    public ReadingQuestion(String uuid, String readingLessonUuid, String content) {
        this.uuid = uuid;
        this.readingLessonUuid = readingLessonUuid;
        this.content = content;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getReadingLessonUuid() {
        return readingLessonUuid;
    }

    public void setReadingLessonUuid(String readingLessonUuid) {
        this.readingLessonUuid = readingLessonUuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReadingQuestion{" +
                "uuid='" + uuid + '\'' +
                ", readingLessonUuid='" + readingLessonUuid + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
