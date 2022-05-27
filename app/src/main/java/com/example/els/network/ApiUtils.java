package com.example.els.network;

import com.example.els.network.games.WordQuizAPI;
import com.example.els.network.listening.ListeningApi;

public class ApiUtils {

    public static ListeningApi getAllListeningLesson() {
        return DeviceAPIHelper.getClient().create(ListeningApi.class);
    }

    public static WordQuizAPI getQuizList() {
        return DeviceAPIHelper.getWordQuizData().create(WordQuizAPI.class);
    }
}