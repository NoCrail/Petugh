package com.home.nomet.Petukh;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent activity_about = new Intent(this, About.class);
        //final PendingIntent p_activity_about = PendingIntent.getActivity(this, 0, activity_about, 0);       //ингтент запуска окна о программе

        final Intent activity_set = new Intent(this, AlarmSet.class);
        //final PendingIntent p_activity_set = PendingIntent.getActivity(this, 0, activity_set, 0);       //интенты запуска окна set


        Button about = (Button)findViewById(R.id.about);
        Button set = (Button)findViewById(R.id.timeset);            //кнопки назначаются

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activity_set);
            }
        });
       /* about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    p_activity_about.send();
                } catch (PendingIntent.CanceledException e) {               //клик кнопки about
                    e.printStackTrace();
                }
            }
        }); */
       about.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(activity_about);
           }
       });
        /*set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                   //клик кнопки set
                try {
                    p_activity_set.send();
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
            }
        });*/

    }


}
