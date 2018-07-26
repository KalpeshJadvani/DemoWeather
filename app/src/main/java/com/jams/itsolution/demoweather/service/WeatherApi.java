package com.jams.itsolution.demoweather.service;

import com.jams.itsolution.demoweather.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("forecast.json?key="+Const.API_KEY+"&q="+Const.CITY+"&days="+Const.DALY)
    Call<WeatherData> getWeather();

}
