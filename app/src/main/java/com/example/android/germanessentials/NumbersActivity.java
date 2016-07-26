package com.example.android.germanessentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);



        // Create an arraylist
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","eins"));
        words.add(new Word("two","zwei"));
        words.add(new Word("three","drei"));
        words.add(new Word("four","vier"));
        words.add(new Word("five","funf"));
        words.add(new Word("six","sechs"));
        words.add(new Word("seven","sieben"));
        words.add(new Word("eight","acht"));
        words.add(new Word("nine","neun"));
        words.add(new Word("ten","zehn"));




        WordAdapter wordAdapter = new WordAdapter(this,words);

        ListView l = (ListView) findViewById(R.id.list);

        l.setAdapter(wordAdapter);


    }



}
