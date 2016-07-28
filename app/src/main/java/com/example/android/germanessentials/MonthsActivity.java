package com.example.android.germanessentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MonthsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);


        ArrayList<Word> months = new ArrayList<>();
        months.add(new Word("January","Januar"));
        months.add(new Word("February","Februar"));
        months.add(new Word("March","März"));
        months.add(new Word("April","April"));
        months.add(new Word("May","Mai"));
        months.add(new Word("June","Juni"));
        months.add(new Word("July","Juli"));
        months.add(new Word("August","August"));
        months.add(new Word("September","September"));
        months.add(new Word("October","Oktober"));
        months.add(new Word("November","November"));
        months.add(new Word("December","Dezember"));

        WordAdapter monthsAdapter = new WordAdapter(this,months);

        ListView l = (ListView)findViewById(R.id.list);

        l.setAdapter(monthsAdapter);









    }
}
