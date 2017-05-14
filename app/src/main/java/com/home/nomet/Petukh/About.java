package com.home.nomet.Petukh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

import static android.R.string.ok;
import static com.home.nomet.Petukh.WeatherServerConstants.API_KEY;
import static com.home.nomet.Petukh.WeatherServerConstants.API_KEY_PARAM;
import static com.home.nomet.Petukh.WeatherServerConstants.UNITS_METRIC;
import static com.home.nomet.Petukh.WeatherServerConstants.UNITS_PARAM;

public class About extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_about);
            Toast.makeText(this, "kek", Toast.LENGTH_SHORT).show();
            Button test = (Button)findViewById(R.id.WeatherTest);

            Retrofit.Builder builder = new Retrofit.Builder();
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();


            okHttpClientBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    HttpUrl url = request.url().newBuilder().addQueryParameter(UNITS_PARAM, UNITS_METRIC).addQueryParameter(API_KEY_PARAM, API_KEY).build();
                    return chain.proceed(request);
                }
            });
            OkHttpClient okHttpClient = okHttpClientBuilder.build();
            Gson gson = new GsonBuilder().create();
            final Retrofit retrofit = builder.baseUrl(WeatherServerConstants.BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).build();

            test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WeatherApi weatherApi = retrofit.create(WeatherApi.class);
                    final Call<WeatherResponce>weatherInfoCall = weatherApi.getWeatherInfoByCityName("Voronezh", Locale.getDefault().getLanguage());
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                WeatherResponce responce = weatherInfoCall.execute().body();
                                int a = 5;
                            } catch (Exception e){
                                int a = 5;
                            }
                        }

                    });
                    thread.start();
                    Toast.makeText(About.this,"" , Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

