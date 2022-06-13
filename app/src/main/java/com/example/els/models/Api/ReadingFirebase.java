package com.example.els.models.Api;

import java.util.ArrayList;
import java.util.List;

public class ReadingFirebase {
    private String id;
    private String score;
    private List<String> answer;

    public ReadingFirebase() {
        this.id = "";
        this.score ="";
        this.answer = new ArrayList<>();
    }

    public ReadingFirebase(String id, String score, List<String> answer) {
        this.id = id;
        this.score = score;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
