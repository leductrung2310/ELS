package com.example.els.network;

import com.example.els.network.games.WordQuizAPI;
import com.example.els.network.listening.ListeningApi;
import com.example.els.network.reading.ReadingApi;

public class ApiUtils {

    public static ListeningApi getAllListeningLesson() {
        return DeviceAPIHelper.getClient().create(ListeningApi.class);
    }

    public static WordQuizAPI getQuizList() {
        return DeviceAPIHelper.getWordQuizData().create(WordQuizAPI.class);
    }

    public static ReadingApi getReading() {
        return DeviceAPIHelper.getReadingClient().create(ReadingApi.class);

    }
}
