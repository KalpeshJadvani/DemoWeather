package com.jams.itsolution.demoweather;

import com.jams.itsolution.demoweather.model.Current;
import com.jams.itsolution.demoweather.model.Forecast;
import com.jams.itsolution.demoweather.model.Location;
import com.jams.itsolution.demoweather.model.WeatherData;
import com.jams.itsolution.demoweather.presenter.MainPresenter;
import com.jams.itsolution.demoweather.service.WeatherService;
import com.jams.itsolution.demoweather.view.WeatherView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Mock
    private WeatherService weatherService;
    @Mock
    private WeatherView weatherView;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        weatherView = Mockito.mock(WeatherView.class);
        weatherService = new WeatherService();

    }


    @Test
    public void addition_isCorrect() {


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


}