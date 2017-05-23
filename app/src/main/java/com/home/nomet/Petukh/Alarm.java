package com.home.nomet.Petukh;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Locale;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.home.nomet.Petukh.Spset.CheckGMB;
import static com.home.nomet.Petukh.Spset.CheckGMBS;
import static com.home.nomet.Petukh.Spset.CheckTDBS;
import static com.home.nomet.Petukh.Spset.CheckWBS;
import static com.home.nomet.Petukh.TODO.TODOListPR;
import static com.home.nomet.Petukh.TODO.TODOPR;
import static com.home.nomet.Petukh.WeatherServerConstants.API_KEY;
import static com.home.nomet.Petukh.WeatherServerConstants.API_KEY_PARAM;
import static com.home.nomet.Petukh.WeatherServerConstants.UNITS_METRIC;
import static com.home.nomet.Petukh.WeatherServerConstants.UNITS_PARAM;

public class Alarm extends AppCompatActivity {
    public Weather weather;
    public Weathermain weathermain;
    public String a;
    TextToSpeech TTS;
    public static String GM;
    public static String Weather;
    public static String ToDo;

    public static int GMB;
    public static int WB;
    public static int TDB;

    public static String tts = "Речь Речь Речь";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Retrofit.Builder builder = new Retrofit.Builder();
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter(UNITS_PARAM, UNITS_METRIC).addQueryParameter(API_KEY_PARAM, API_KEY).build();                        //Погода
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });
        OkHttpClient okHttpClient = okHttpClientBuilder.build();
        Gson gson = new GsonBuilder().create();
        final Retrofit retrofit = builder.baseUrl(WeatherServerConstants.BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).build();
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        final Call<WeatherResponce>weatherInfoCall = weatherApi.getWeatherInfoByCityName("Voronezh", Locale.getDefault().getLanguage());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    retrofit2.Response responce = weatherInfoCall.execute();
                    WeatherResponce weatherResponse = (WeatherResponce)responce.body();
                    weather = new Weather();
                    weathermain = new Weathermain();
                    weather.description = weatherResponse.weather[0].description;
                    weathermain.temp = weatherResponse.main.temp;
                    Weather = " Сейчас на улице " + weathermain.temp + " градусов, " + weather.description+".";
                    //Toast.makeText(Alarm.this, Weather, Toast.LENGTH_SHORT).show();

                } catch (Exception e){

                }
            }

        });
        thread.start();


        GM = "Доброе утро!";

        TODO.ToDo = getSharedPreferences(TODOPR, Context.MODE_PRIVATE);
        if(TODO.ToDo.contains(TODOListPR))   {
            ToDo = TODO.ToDo.getString(TODOListPR, "");}

        ToDo = " Ваши дела на сегодня : " + ToDo;
        Spset.CheckGMSP = getSharedPreferences(CheckGMB, Context.MODE_PRIVATE);
        if(Spset.CheckGMSP.contains(CheckGMBS)){
             GMB = Spset.CheckGMSP.getInt(CheckGMBS, 0);
             if(GMB==0)GM = "";
        }
        if(Spset.CheckGMSP.contains(CheckTDBS)){
            TDB = Spset.CheckGMSP.getInt(CheckTDBS, 0);
            if(TDB==0)ToDo = "";
        }
        if(Spset.CheckGMSP.contains(CheckWBS)){
            WB = Spset.CheckGMSP.getInt(CheckWBS, 0);
            if (WB==0)Weather="";
        }

        tts = GM + Weather + ToDo;

        TTS = new TextToSpeech(this, new OnInitListener() {         //фигня для говорилки
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) speak();
            }
        });







    }

    private void speak() {
        TTS.speak(tts,TextToSpeech.QUEUE_ADD,null);             //метод говорения переменной tts string
    }


}
