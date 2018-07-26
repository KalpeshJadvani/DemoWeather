package com.jams.itsolution.demoweather.model;

import com.google.gson.annotations.SerializedName;

public class Current {


//       "last_updated_epoch": 1532346308,
//               "last_updated": "2018-07-23 13:45",
//               "temp_c": 29,
//               "temp_f": 84.2,
//               "is_day": 1,
//               "condition": {
//                        "text": "Sunny",
//                        "icon": "//cdn.apixu.com/weather/64x64/day/113.png",
//                        "code": 1000
//                   },
//            "wind_mph": 5.6,
//            "wind_kph": 9,
//            "wind_degree": 50,
//            "wind_dir": "NE",
//            "pressure_mb": 1018,
//            "pressure_in": 30.5,
//            "precip_mm": 0,
//            "precip_in": 0,
//            "humidity": 37,
//            "cloud": 0,
//            "feelslike_c": 28.6,
//            "feelslike_f": 83.5,
//            "vis_km": 10,
//            "vis_miles": 6




    @SerializedName("temp_c")
    private int temoratureC;

    @SerializedName("temp_f")
    private String temoratureF;



    public int getTemoratureC() {
        return temoratureC;
    }

    public String getTemoratureF() {
        return temoratureF;
    }



    public Condition getCondition() {
        return condition;
    }

    @SerializedName("condition")
    private  Condition  condition;

    Current(){
        condition = new Condition();
    }

    public class Condition{


        @SerializedName("text")
        private String textCondition;

        @SerializedName("icon")
        private String iconCondition;



        public String getTextCondition() {
            return textCondition;
        }

        public String getIconCondition() {
            return iconCondition;
        }



    }

}
