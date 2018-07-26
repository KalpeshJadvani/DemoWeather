package com.jams.itsolution.demoweather.model;

import com.google.gson.annotations.SerializedName;

public class Location {


//            "name": "Paris",
//            "region": "Ile-de-France",
//            "country": "France",
//            "lat": 48.87,
//            "lon": 2.33,
//            "tz_id": "Europe/Paris",
//            "localtime_epoch": 1532347483,
//            "localtime": "2018-07-23 14:04"



    @SerializedName("name")
    private String nameLocation;

    @SerializedName("region")
    private String regionLocation;

    @SerializedName("country")
    private String countryLocation;

    @SerializedName("localtime")
    private String localtimeLocation;



    public String getNameLocation() {
        return nameLocation;
    }

    public String getRegionLocation() {
        return regionLocation;
    }

    public String getCountryLocation() {
        return countryLocation;
    }

    public String getLocaltimeLocation() {
        return localtimeLocation;
    }
}
