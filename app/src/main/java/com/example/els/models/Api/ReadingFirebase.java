package com.example.els.models.Api;

public class ReadingFirebase {
    private String id;
    private String score;

    public ReadingFirebase() {
    }

    public ReadingFirebase(String id, String score) {
        this.id = id;
        this.score = score;
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
}
