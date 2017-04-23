package com.home.nomet.Petukh;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AlarmSet extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alart_set);

        final TimePicker Timepick = (TimePicker)findViewById(R.id.TimePicker);
        Button alarmset = (Button)findViewById(R.id.timeset);                       //работа с интерфейсом и пр
        Timepick.setIs24HourView(true);
        final AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        Intent RING = new Intent(this, Alarm.class );
        final PendingIntent p_RING = PendingIntent.getActivity(this, 0, RING, 0);   //интенты  звонка будильника


        final Calendar cal = new GregorianCalendar();
        Calendar cur_cal = new GregorianCalendar();
        cur_cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.DAY_OF_YEAR, cur_cal.get(Calendar.DAY_OF_YEAR));           //подключение календарей будильника
        //cal.set(Calendar.SECOND, cur_cal.get(Calendar.SECOND));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, cur_cal.get(Calendar.MILLISECOND));
        cal.set(Calendar.DATE, cur_cal.get(Calendar.DATE));
        cal.set(Calendar.MONTH, cur_cal.get(Calendar.MONTH));

        alarmset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlarmSet.this, "Setted", Toast.LENGTH_SHORT).show();
                int h = Timepick.getCurrentHour();
                int m = Timepick.getCurrentMinute();
                cal.set(Calendar.HOUR_OF_DAY, h);
                cal.set(Calendar.MINUTE, m);
                //alarm.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), p_RING);
            }
        });



    }





}
