package com.jams.itsolution.demoweather.model;



import com.google.gson.annotations.SerializedName;

public class WeatherData {


    @SerializedName("location")
    private Location locationWeather;

    public Location getLocationWeather() {
        return locationWeather;
    }

    @SerializedName("current")
    private Current currentWeather;

    public Current getCurrentWeather() {
        return currentWeather;
    }


    @SerializedName("forecast")
    private Forecast forecastWeather;

    public Forecast getForecastWeather() {
        return forecastWeather;
    }

}
