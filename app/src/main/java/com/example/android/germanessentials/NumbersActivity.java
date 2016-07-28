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
        words.add(new Word("one","eins",R.drawable.number_one));
        words.add(new Word("two","zwei",R.drawable.number_two));
        words.add(new Word("three","drei",R.drawable.number_three));
        words.add(new Word("four","vier",R.drawable.number_four));
        words.add(new Word("five","funf",R.drawable.number_five));
        words.add(new Word("six","sechs",R.drawable.number_six));
        words.add(new Word("seven","sieben",R.drawable.number_seven));
        words.add(new Word("eight","acht",R.drawable.number_eight));
        words.add(new Word("nine","neun",R.drawable.number_nine));
        words.add(new Word("ten","zehn",R.drawable.number_ten));




        WordAdapter wordAdapter = new WordAdapter(this,words);

        ListView l = (ListView) findViewById(R.id.list);

        l.setAdapter(wordAdapter);


    }



}
