package com.example.els.models.dictionary;

import java.util.List;

public class Word {

    String word;
    String phonetic;
    List<Phonetic> phonetics;
    List<Meaning> meanings;

    public Word() {
    }

    public Word(String word, String phonetic, List<Phonetic> phonetics, List<Meaning> meanings) {
        this.word = word;
        this.phonetic = phonetic;
        this.phonetics = phonetics;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public List<Phonetic> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetic> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }
}
