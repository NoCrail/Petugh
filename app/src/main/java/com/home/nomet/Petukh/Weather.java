package com.home.nomet.Petukh;

/**
 * Created by Владислав_2 on 14.05.2017.
 */

import com.google.gson.annotations.SerializedName;
public class Weather {
    @SerializedName("main")
    public String main;

    @SerializedName("description")
    public String description;
}
