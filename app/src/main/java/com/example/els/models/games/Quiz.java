package com.example.els.models.games;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Quiz {
    @SerializedName("quiz")
    private final ArrayList<String> quiz;
    @SerializedName("option")
    private final ArrayList<String> option;
    @SerializedName("correct")
    private final int correct;

    public Quiz(ArrayList<String> questions, ArrayList<String> options, int correct) {
        this.quiz = questions;
        this.option = options;
        this.correct = correct;
    }

    public ArrayList<String> getQuestions() {
        return quiz;
    }

    public ArrayList<String> getOptions() {
        return option;
    }

    public int getCorrect() {
        return correct;
    }

}
