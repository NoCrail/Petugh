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





        Button about = (Button)findViewById(R.id.about);
        Button set = (Button)findViewById(R.id.timeset);            //кнопки назначаются

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent activity_set = new Intent(MainActivity.this, AlarmSet.class);
                startActivity(activity_set);
            }
        });

       about.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final Intent activity_about = new Intent(MainActivity.this, About.class);
               startActivity(activity_about);
           }
       });


    }


}
