package com.example.els.models.games;

import java.util.Date;

public class PlayHistory {
    private int score;
    private Date date;
    private int level;
    private String area;

    public PlayHistory(int score, Date date, int level, String area) {
        this.score = score;
        this.date = date;
        this.level = level;
        this.area = area;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
