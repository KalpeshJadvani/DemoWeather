package com.jams.itsolution.demoweather.view;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jams.itsolution.demoweather.R;
import com.jams.itsolution.demoweather.model.Current;
import com.jams.itsolution.demoweather.model.ForcastAdapter;
import com.jams.itsolution.demoweather.model.Forecast;
import com.jams.itsolution.demoweather.model.Location;
import com.jams.itsolution.demoweather.presenter.MainPresenter;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements WeatherView{

    ProgressBar loading_bar;
    RelativeLayout topPanel, bottomPanel;
    RecyclerView temperature_list;

    MainPresenter mainPresenter;

    TextView temperature,cityName,refreshapp;

    WeatherView weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          weatherView = this;
          mainPresenter = new MainPresenter(weatherView);


         loading_bar = findViewById(R.id.loading_bar);



         topPanel = findViewById(R.id.topPanel);
         bottomPanel = findViewById(R.id.bottomPanel);
         temperature_list =findViewById(R.id.temperature_list);

         temperature = findViewById(R.id.temperature);
         cityName = findViewById(R.id.cityName);
         refreshapp = findViewById(R.id.refreshapp);




         mainPresenter.getWeather();  // Call for getting Data..


        refreshapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainPresenter.getWeather(); // on error App get Refresh...
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();  // onResume App get Refresh...
    }

    @Override
    public void showLoading() {

        refreshapp.setVisibility(View.INVISIBLE);
        loading_bar.setVisibility(View.VISIBLE);


    }

    @Override
    public void hideLoading() {

        loading_bar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void setAdapter(ArrayList<Forecast.ForecastDay>  adapter) {
        temperature_list.setAdapter(new ForcastAdapter(adapter, getBaseContext()));
        bottomPanel.setVisibility(View.VISIBLE);
        ObjectAnimator animation = ObjectAnimator.ofFloat(bottomPanel,"translationY",bottomPanel.getHeight(),0f);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setDuration(500);
        animation.start();


    }

    @Override
    public void showCurrentWeather(Current current) {
        temperature.setText(String.format("%s°", current.getTemoratureC()));
    }

    @Override
    public void showLocationWeather(Location location) {
        cityName.setText(location.getNameLocation());
    }

    @Override
    public void showForecastWeather(Forecast forecast) {


    }

    @Override
    public void refreshApp() {

        refreshapp.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }
}
