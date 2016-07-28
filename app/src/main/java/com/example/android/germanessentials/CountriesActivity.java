package com.example.android.germanessentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CountriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        ArrayList<Word> countries = new ArrayList<>();
        countries.add(new Word("America","Amerika",R.drawable.america));
        countries.add(new Word("Australia","Australien",R.drawable.australia));
        countries.add(new Word("China","China",R.drawable.china));
        countries.add(new Word("Germany","Deutschland",R.drawable.germany));
        countries.add(new Word("England","England",R.drawable.england));
        countries.add(new Word("France","Frankreich",R.drawable.france));
        countries.add(new Word("India","Indien",R.drawable.india));
        countries.add(new Word("Italy","Italien",R.drawable.italy));
        countries.add(new Word("Japan","Japan",R.drawable.japan));
        countries.add(new Word("Canada","Kanada",R.drawable.canada));
        countries.add(new Word("Pakistan","Pakistan",R.drawable.pakistan));
        countries.add(new Word("Portugal","Portugal",R.drawable.portugal));
        countries.add(new Word("Switzerland","Schweiz",R.drawable.switzerland));
        countries.add(new Word("Singapore","Singapur",R.drawable.singapore));
        countries.add(new Word("Spain","Spanien",R.drawable.spain));


        WordAdapter countriesAdapter = new WordAdapter(this,countries);

        ListView l = (ListView)findViewById(R.id.list);

        l.setAdapter(countriesAdapter);









    }
}
