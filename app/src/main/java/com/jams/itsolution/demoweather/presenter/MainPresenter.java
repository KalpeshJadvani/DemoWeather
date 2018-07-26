package com.jams.itsolution.demoweather.presenter;

import com.jams.itsolution.demoweather.view.WeatherView;

import java.util.logging.Handler;

public class MainPresenter {

    private WeatherView weatherView;




    public MainPresenter(WeatherView weatherView){

        this.weatherView = weatherView;


    }


    public void getWeather(){

       weatherView.showLoading();  // process Start .....


         new android.os.Handler().postDelayed(new Runnable(){

             @Override
             public void run() {



                 weatherView.hideLoading(); // Process Finished ......
                 weatherView.setAdapter();

             }
         },1500);


    }


}
