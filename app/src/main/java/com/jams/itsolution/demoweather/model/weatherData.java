package com.jams.itsolution.demoweather.model;

import android.widget.ImageView;

public class weatherData {

    private String date,text,temperature,image;


     public weatherData(String date,String text,String temperature, String image){
         this.date = date;
         this.text = text;
         this.temperature = temperature;
         this.image = image;

     }


    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getTemperature() {
        return temperature;
    }

}
