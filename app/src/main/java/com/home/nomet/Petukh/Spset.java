package com.home.nomet.Petukh;

import android.content.Context;
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
import android.widget.Toast;

public class Spset extends AppCompatActivity {
    public static final String CheckGMB = "a";

    public static final String CheckGMBS = "a";
    public static final String CheckWBS = "b";
    public static final String CheckTDBS = "c";

    static SharedPreferences CheckGMSP;


    private int CheckGMA;
    private int CheckWA;
    private int CheckTDA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spset);
        Button todoEdit = (Button)findViewById(R.id.TODOEdit);
        Button save = (Button)findViewById(R.id.save);
        final CheckBox CheckGM = (CheckBox)findViewById(R.id.checkGoodMorning);
        final CheckBox CheckW = (CheckBox)findViewById(R.id.checkWeather);
        final CheckBox CheckTD = (CheckBox)findViewById(R.id.checkRemind);



        CheckGMSP = getSharedPreferences(CheckGMB, Context.MODE_PRIVATE);


        if(CheckGMSP.contains(CheckGMBS)){
            CheckGMA = CheckGMSP.getInt(CheckGMBS, 0);
            if (CheckGMA == 1)CheckGM.setChecked(true);
        }
        if(CheckGMSP.contains(CheckTDBS)){
            CheckTDA = CheckGMSP.getInt(CheckTDBS, 0);
            if (CheckTDA == 1)CheckTD.setChecked(true);
        }
        if(CheckGMSP.contains(CheckWBS)){
            CheckWA = CheckGMSP.getInt(CheckWBS, 0);
            if (CheckWA == 1)CheckW.setChecked(true);
        }







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
                if(CheckGM.isChecked()){CheckGMA = 1;} else {CheckGMA = 0;};
                if(CheckTD.isChecked()){CheckTDA = 1;} else {CheckTDA = 0;};
                if(CheckW.isChecked()){CheckWA = 1;} else {CheckWA = 0;};
                SharedPreferences.Editor editorGM = CheckGMSP.edit();
                editorGM.putInt(CheckGMBS, CheckGMA);
                editorGM.putInt(CheckTDBS, CheckTDA);
                editorGM.putInt(CheckWBS, CheckWA);
                editorGM.apply();

                Toast.makeText(Spset.this, "ok", Toast.LENGTH_SHORT).show();


            }
        });

    }

}
