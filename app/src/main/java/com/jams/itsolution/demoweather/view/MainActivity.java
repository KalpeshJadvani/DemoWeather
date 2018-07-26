package com.jams.itsolution.demoweather.view;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.jams.itsolution.demoweather.R;
import com.jams.itsolution.demoweather.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements WeatherView{

    ProgressBar progressBar;
    RelativeLayout topPanel, bottomPanel;
    RecyclerView temperature_list;

    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.loading_bar);

         topPanel = findViewById(R.id.topPanel);
         bottomPanel = findViewById(R.id.bottomPanel);
         temperature_list =findViewById(R.id.temperature_list);


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

    @Override
    public void setAdapter() {
        bottomPanel.setVisibility(View.VISIBLE);
        ObjectAnimator animation = ObjectAnimator.ofFloat(bottomPanel,"transitionY",bottomPanel.getHeight(),0f);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setDuration(500);
        animation.start();


    }
}
