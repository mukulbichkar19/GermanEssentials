package com.example.android.germanessentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MathsSymbols extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_symbols);

        // Declare an arraylist to contain Word Objects
        ArrayList<Word> mathsSymbols = new ArrayList<>();
        mathsSymbols.add(new Word("Divide","Dussh",R.drawable.divide));
        mathsSymbols.add(new Word("Equal","Gleich",R.drawable.equal));
        mathsSymbols.add(new Word("Minus","Minoos",R.drawable.minus));
        mathsSymbols.add(new Word("Plus","Plus",R.drawable.plus));
        mathsSymbols.add(new Word("Multiply","Mal",R.drawable.multiply));

        WordAdapter mathsAdapter = new WordAdapter(this,mathsSymbols);

        ListView l = (ListView) findViewById(R.id.list);

        l.setAdapter(mathsAdapter);








    }
}
