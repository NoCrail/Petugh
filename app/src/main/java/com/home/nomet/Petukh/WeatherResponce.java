package com.home.nomet.Petukh;

import com.google.gson.annotations.SerializedName;
/**
 * Created by Владислав_2 on 14.05.2017.
 */

public class WeatherResponce {
    @SerializedName("weather")
    public Weather[] weather;

    @SerializedName("main")
    public Weathermain main;
}
