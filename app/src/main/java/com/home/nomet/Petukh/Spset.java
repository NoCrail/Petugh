package com.home.nomet.Petukh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Spset extends AppCompatActivity {
    public static final Boolean CheckGMB = false;
    public static final Boolean CheckWB = false;
    public static final Boolean CheckTDB = false;

    private SharedPreferences CheckGMSP;
    private SharedPreferences CheckWSP;
    private SharedPreferences CheckTDSP;

    private Boolean CheckGMA;
    private Boolean CheckWA;
    private Boolean CheckTDA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spset);

        Button todoEdit = (Button)findViewById(R.id.TODOEdit);
        Button save = (Button)findViewById(R.id.save);
        CheckBox CheckGM = (CheckBox)findViewById(R.id.checkGoodMorning);
        CheckBox CheckW = (CheckBox)findViewById(R.id.checkWeather);
        CheckBox CheckTD = (CheckBox)findViewById(R.id.checkRemind);


        todoEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent todoEditor = new Intent(Spset.this, TODO.class);
                startActivity(todoEditor);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
