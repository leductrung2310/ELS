package com.example.els.network;

import com.example.els.network.games.WordQuizAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class DeviceAPIHelper {
    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl("https://els-server-production-f309.up.railway.app/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Get data from dictionary for word quiz game and dictionary
    // This Java class is used to send requests to an API.
    // We specify the URL that contains the data required and use the Retrofit Builder class.
    public static Retrofit getWordQuizData() {
        return new Retrofit.Builder()
                .baseUrl(WordQuizAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
