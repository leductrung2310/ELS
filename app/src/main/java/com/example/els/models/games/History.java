package com.example.els.models.games;

import com.google.type.DateTime;

import java.util.Date;

public class History {
    private int score;
    private Date date;
    private int level;
    private String area;

    public History(String area, Date date, int level, int score) {
        this.score = score;
        this.date = date;
        this.level = level;
        this.area = area;
    }

    public History() {}

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
