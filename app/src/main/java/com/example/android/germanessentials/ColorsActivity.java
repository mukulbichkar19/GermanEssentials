package com.example.android.germanessentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


        ArrayList<Word> colors = new ArrayList<Word>();

        colors.add(new Word("Blue","Blau",R.drawable.blue));
        colors.add(new Word("Brown","Braun",R.drawable.brown));
        colors.add(new Word("Yellow","Gelb",R.drawable.yellow));
        colors.add(new Word("Green","Grün",R.drawable.green));
        colors.add(new Word("Purple","Lila",R.drawable.purple));
        colors.add(new Word("Orange","Orange",R.drawable.orange));
        colors.add(new Word("Pink","Rosa",R.drawable.pink));
        colors.add(new Word("Black","Schwarz",R.drawable.black));
        colors.add(new Word("Red","Rot",R.drawable.red));
        colors.add(new Word("White","Weiß",R.drawable.white));

        WordAdapter colorAdapter = new WordAdapter(this,colors);

        ListView l = (ListView)findViewById(R.id.list);

        l.setAdapter(colorAdapter);






    }
}
