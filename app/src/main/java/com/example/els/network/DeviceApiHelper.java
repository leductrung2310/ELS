package com.example.els.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class DeviceAPIHelper
{
    public static Retrofit getClient()
    {
        return new Retrofit.Builder()
                .baseUrl("https://els-server-production-f309.up.railway.app/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
