package com.example.nhk2204.calapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent=getIntent();
        double Answer2=intent.getDoubleExtra("Answer",0);

        TextView answerView=(TextView)findViewById(R.id.answerText);
        answerView.setText(String.valueOf(Answer2));
    }
}
