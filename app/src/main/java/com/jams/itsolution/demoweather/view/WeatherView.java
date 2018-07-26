package com.jams.itsolution.demoweather.view;

import com.jams.itsolution.demoweather.model.weatherData;

import java.util.ArrayList;

public interface WeatherView {

   void showLoading();

   void hideLoading();

   void setAdapter(ArrayList<weatherData> weatherData);


}
