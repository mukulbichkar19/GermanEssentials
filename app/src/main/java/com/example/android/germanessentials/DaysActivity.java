package com.example.android.germanessentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DaysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);

        ArrayList<Word> days = new ArrayList<>();
        days.add(new Word("Monday","Montag",R.drawable.monday));
        days.add(new Word("Tuesday","Dienstag",R.drawable.tuesday));
        days.add(new Word("Wednesday","Mittwoch",R.drawable.wednesday));
        days.add(new Word("Thursday","Donnerstag",R.drawable.thursday));
        days.add(new Word("Friday","Freitag",R.drawable.friday));
        days.add(new Word("Saturday","Samstag",R.drawable.saturday));
        days.add(new Word("Sunday","Sonntag",R.drawable.sunday));

        WordAdapter daysAdapter = new WordAdapter(this,days);

        ListView l = (ListView)findViewById(R.id.list);

        l.setAdapter(daysAdapter);







    }
}
