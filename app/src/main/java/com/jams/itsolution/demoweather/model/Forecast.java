package com.jams.itsolution.demoweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Forecast {


    @SerializedName("forecastday")
    private ArrayList<ForecastDay> forecastDay = new ArrayList<ForecastDay>();

    public  Forecast(){


    }

    public ArrayList<ForecastDay> getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(ArrayList<ForecastDay> forecastDay) {
        this.forecastDay = forecastDay;
    }


    public class ForecastDay{


        @SerializedName("date")
        private String date;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }


        @SerializedName("day")
        private Day day;

        public Day getDay() {
            return day;
        }


        public class  Day{

            @SerializedName("maxtemp_c")
            private double maxtempC;
            @SerializedName("mintemp_c")
            private double mintempC;


            public double getMaxtempC() {
                return maxtempC;
            }

            public void setMaxtempC(double maxtempC) {
                this.maxtempC = maxtempC;
            }

            public double getMintempC() {

                return mintempC;
            }

            public void setMintempC(double mintempC) {
                this.mintempC = mintempC;
            }


            @SerializedName("condition")
            private Condition condition;

            public Condition getCondition() {
                return condition;
            }


            public class Condition{

                // "text": "Partly cloudy",
                // "icon": "//cdn.apixu.com/weather/64x64/day/116.png",
                // "code": 1003

                @SerializedName("text")
                private String text;

                @SerializedName("icon")
                private String icon;


                @SerializedName("code")
                private double code;

                public double getCode() {
                    return code;
                }

                public String getIcon() {
                    return icon;
                }

                public String getText() {
                    return text;
                }

            }



        }


    }
}
