package com.example.els.models.games;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Dictionary {
    @SerializedName("word")
    private String word;

    @SerializedName("definition")
    private ArrayList<String> definitions;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Dictionary() {
    }

    public Dictionary(ArrayList<String> definitions) {
        this.definitions = definitions;
    }

    public ArrayList<String> getDefinitionList() {
        return definitions;
    }

    public void setDefinitionList(ArrayList<String> definitions) {
        this.definitions = definitions;
    }
}
