package com.home.nomet.Petukh;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TODO extends AppCompatActivity {
    public static final String TODOPR = "List TODO";
    public static final String TODOListPR= "Todo List";
    static SharedPreferences ToDo;
    private String TODOList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        ToDo = getSharedPreferences(TODOPR, Context.MODE_PRIVATE);
        final EditText TextTODO = (EditText)findViewById(R.id.TODO);
        if(ToDo.contains(TODOListPR))   {
                TODOList = ToDo.getString(TODOListPR, "");
                TextTODO.setText(TODOList);
            }
        final Button save = (Button)findViewById(R.id.Save);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TODOList = TextTODO.getText().toString();
                SharedPreferences.Editor editor = ToDo.edit();
                editor.putString(TODOListPR, TODOList);
                editor.apply();

                Toast.makeText(TODO.this, "ok" , Toast.LENGTH_SHORT).show();
            }
        });


    }

}
