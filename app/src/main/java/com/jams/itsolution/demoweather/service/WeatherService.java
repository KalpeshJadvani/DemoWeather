package com.jams.itsolution.demoweather.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherService {

    private static Retrofit retrofit = null;

    public static WeatherApi getAPI(){

        if(retrofit ==null){
            synchronized (Retrofit.class)
            {
                if(retrofit ==null){
                    retrofit= new Retrofit.Builder()
                            .baseUrl(Const.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit.create(WeatherApi.class);
    }
}
