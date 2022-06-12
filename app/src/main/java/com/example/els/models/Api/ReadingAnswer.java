package com.example.els.models.Api;

import com.google.gson.annotations.SerializedName;

public class ReadingAnswer {
    @SerializedName("id")
    private String uuid;

    @SerializedName("readingQuestionUuid")
    private String readingQuestionUuid;

    @SerializedName("answer")
    private String answer;

    @SerializedName("correct")
    private boolean isCorrect;


    public ReadingAnswer() {

    }

    public ReadingAnswer(String uuid, String readingQuestionUuid, String answer, boolean isCorrect) {
        this.uuid = uuid;
        this.readingQuestionUuid = readingQuestionUuid;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getReadingQuestionUuid() {
        return readingQuestionUuid;
    }

    public void setReadingQuestionUuid(String readingQuestionUuid) {
        this.readingQuestionUuid = readingQuestionUuid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "ReadingAnswer{" +
                "uuid='" + uuid + '\'' +
                ", readingQuestionUuid='" + readingQuestionUuid + '\'' +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
