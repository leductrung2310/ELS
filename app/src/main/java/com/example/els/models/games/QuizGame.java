package com.example.els.models.games;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuizGame {
    @SerializedName("area")
    private String area;

    @SerializedName("level")
    private int level;

    @SerializedName("quizlist")
    private ArrayList<Quiz> quizList;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Quiz> getQuizList() {
        if (quizList == null) quizList = new ArrayList<>();
        return quizList;
    }

}
