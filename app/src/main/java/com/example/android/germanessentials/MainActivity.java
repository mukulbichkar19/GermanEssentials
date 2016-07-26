package com.example.android.germanessentials;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Relevant View
        TextView numbersView = (TextView)findViewById(R.id.numbers);
        // Set OnClickListener on that view
        numbersView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(i);
            }
        });

        TextView colors = (TextView)findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(i);
            }
        });


        TextView maths = (TextView)findViewById(R.id.maths);
        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MathsSymbols.class);
                startActivity(i);
            }
        });

        TextView days = (TextView)findViewById(R.id.days);
        days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,DaysActivity.class);
                startActivity(i);
            }
        });

        TextView times = (TextView)findViewById(R.id.times);
        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,TimesActivity.class);
                startActivity(i);
            }
        });

        TextView months = (TextView)findViewById(R.id.months);
        months.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MonthsActivity.class);
                startActivity(i);
            }
        });

        TextView countries = (TextView)findViewById(R.id.countries);
        countries
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CountriesActivity.class);
                startActivity(i);
            }
        });

        TextView family = (TextView)findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,Family_MembersActivity.class);
                        startActivity(i);
                    }
                });

        TextView common_words = (TextView)findViewById(R.id.common);
        common_words.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,CommonWordsActivity.class);
                        startActivity(i);
                    }
                });




    }














}
