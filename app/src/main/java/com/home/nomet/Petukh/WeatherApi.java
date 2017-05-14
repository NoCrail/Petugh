package com.home.nomet.Petukh;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import static com.home.nomet.Petukh.WeatherServerConstants.API_KEY_PARAM;
import static com.home.nomet.Petukh.WeatherServerConstants.LANG_PARAM;
import static com.home.nomet.Petukh.WeatherServerConstants.UNITS_METRIC;
import static com.home.nomet.Petukh.WeatherServerConstants.UNITS_PARAM;
import static com.home.nomet.Petukh.WeatherServerConstants.WEATHER_URL;

/**
 * Created by Владислав_2 on 14.05.2017.
 */

public interface WeatherApi {
    @GET(WEATHER_URL)
    Call<WeatherResponce>getWeatherInfoByCityName(@Query("q")String cityName, @Query(LANG_PARAM) String language);


}
