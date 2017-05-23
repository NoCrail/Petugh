package com.home.nomet.Petukh;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


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

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView image = (ImageView)findViewById(R.id.imageView2);
        Button about = (Button)findViewById(R.id.about);
        Button spset = (Button)findViewById(R.id.Speak_set);
        Button set = (Button)findViewById(R.id.timeset);            //кнопки назначаются

        image.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.petukh1, 300, 300));

        spset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent activity_spset = new Intent(MainActivity.this, Spset.class);
                startActivity(activity_spset);
            }
        });

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
