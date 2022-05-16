package com.example.els.models.Api;

import com.google.gson.annotations.SerializedName;

public class ListeningQuestion {
    @SerializedName("id")
    private String uuid;

    @SerializedName("listeningid")
    private String listeningUuid;

    @SerializedName("content")
    private String content;

    @SerializedName("answer")
    private String answer;

    public ListeningQuestion() {

    }

    public ListeningQuestion(String uuid, String listeningUuid, String content, String answer) {
        this.uuid = uuid;
        this.listeningUuid = listeningUuid;
        this.content = content;
        this.answer = answer;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getListeningUuid() {
        return listeningUuid;
    }

    public void setListeningUuid(String listeningUuid) {
        this.listeningUuid = listeningUuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
