package com.home.nomet.Petukh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

public class Alarm extends AppCompatActivity {

    private static String tts = "Речь Речь Речь";
    TextToSpeech TTS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        TTS = new TextToSpeech(this, new OnInitListener() {         //фигня для говорилки
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) speak();
            }
        });


        /*Thread speak = new Thread(new Runnable() {
            @Override
            public void run() {
                speak();                        //попытка запустить speak в потоке
            }
        });
        speak.start();*/

       /* Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {              //для дебага
            @Override
            public void onClick(View v) {
                tts = "Оно работает";
                speak();
            }
        });*/




    }

    private void speak() {
        TTS.speak(tts,TextToSpeech.QUEUE_ADD,null);             //метод говорения переменной tts string
    }


}
