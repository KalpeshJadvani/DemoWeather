package com.jams.itsolution.demoweather.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.jams.itsolution.demoweather.R;
import com.jams.itsolution.demoweather.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements WeatherView{

    ProgressBar progressBar;


    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar =findViewById(R.id.loading_bar);



        mainPresenter = new MainPresenter(this);


        mainPresenter.getWeather();  // Call for getting Data..

    }


    @Override
    public void showLoading() {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {

        progressBar.setVisibility(View.INVISIBLE);

    }
}
