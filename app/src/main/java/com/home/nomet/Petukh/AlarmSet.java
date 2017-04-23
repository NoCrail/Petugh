package com.home.nomet.Petukh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TimePicker;

public class AlarmSet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alart_set);
    }


    TimePicker Timepick = (TimePicker)findViewById(R.id.TimePicker);
    Button alarmset = (Button)findViewById(R.id.timeset);
    Timepick.setIs24HourView(true);

}
