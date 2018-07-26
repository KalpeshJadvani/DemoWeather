package com.jams.itsolution.demoweather.view;

import com.jams.itsolution.demoweather.model.Current;
import com.jams.itsolution.demoweather.model.Forecast;
import com.jams.itsolution.demoweather.model.Location;
import com.jams.itsolution.demoweather.model.WeatherData;

import java.util.ArrayList;

public interface WeatherView {

   void showLoading();

   void hideLoading();

   void setAdapter(ArrayList<Forecast.ForecastDay>  adapter);

   void showCurrentWeather(Current current);

   void showLocationWeather(Location location);

   void showForecastWeather(Forecast forecast);

   void refreshApp();

}
