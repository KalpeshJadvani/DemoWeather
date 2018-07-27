package com.jams.itsolution.demoweather.presenter;

import com.jams.itsolution.demoweather.model.Current;
import com.jams.itsolution.demoweather.model.Forecast;
import com.jams.itsolution.demoweather.model.Location;
import com.jams.itsolution.demoweather.model.WeatherData;
import com.jams.itsolution.demoweather.service.WeatherService;
import com.jams.itsolution.demoweather.view.WeatherView;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainPresenter {

    private WeatherView weatherView;

    private WeatherService weatherService;

    public MainPresenter(WeatherView weatherView){


        this.weatherView = weatherView;

        this.weatherService = new WeatherService();

    }

    public void onResume() {
        if (weatherView != null) {
//            getWeather();
        }


    }
    public void getWeather(){

       weatherView.showLoading();  // process Start .....


        weatherService.getAPI().getWeather().enqueue(new Callback<WeatherData>() {
                    @Override
                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                        WeatherData data = response.body();

                        if (data != null && data.getCurrentWeather() != null && data.getLocationWeather() != null && data.getForecastWeather() != null    ) {


                            Current current = data.getCurrentWeather();
                            Location location = data.getLocationWeather();
                            Forecast forecast =  data.getForecastWeather();

                            weatherView.showCurrentWeather(current);
                            weatherView.showLocationWeather(location);
                            weatherView.showForecastWeather(forecast);

                            weatherView.setAdapter(forecast.getForecastDay());

                            weatherView.hideLoading();

                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherData> call, Throwable t) {




                        try {
                            weatherView.hideLoading();
                            weatherView.refreshApp();

                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });



    }


    public void onDestroy() {
       weatherView = null;
    }
}
