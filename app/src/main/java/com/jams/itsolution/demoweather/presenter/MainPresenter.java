package com.jams.itsolution.demoweather.presenter;

import com.jams.itsolution.demoweather.model.weatherData;
import com.jams.itsolution.demoweather.view.WeatherView;

import java.util.ArrayList;
import java.util.logging.Handler;

public class MainPresenter {

    private WeatherView weatherView;




    public MainPresenter(WeatherView weatherView){

        this.weatherView = weatherView;

    }


    public void getWeather(){

       weatherView.showLoading();  // process Start .....

       final ArrayList<weatherData> weatherData = new ArrayList<>();


         new android.os.Handler().postDelayed(new Runnable(){

             @Override
             public void run() {
                 weatherView.hideLoading();

                 for(int i = 0 ; i <10;i++){

                     weatherData.add(new weatherData("23-jun-2018","Coludy","20/30","image"));

                 }



                 weatherView.setAdapter(weatherData);
                  // Process Finished ......

             }
         },1300);


    }


}
