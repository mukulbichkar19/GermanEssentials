package com.example.android.germanessentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CommonWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_words);


        ArrayList<Word> common_words = new ArrayList<>();
        common_words.add(new Word("Address","Adresse"));
        common_words.add(new Word("Cafe","Cafe"));
        common_words.add(new Word("Computer","Computer"));
        common_words.add(new Word("Thank You","Danke"));
        common_words.add(new Word("Mr.","Herr."));
        common_words.add(new Word("Mrs.","Frau."));
        common_words.add(new Word("Good Morning","Guten Morgen"));
        common_words.add(new Word("Big","Groß"));
        common_words.add(new Word("Mobile Number","Handynummer"));
        common_words.add(new Word("Intelligent","Intelligent"));
        common_words.add(new Word("Years","Jahre"));
        common_words.add(new Word("Yes","Ja"));
        common_words.add(new Word("No","Nein"));
        common_words.add(new Word("Now","Jetzt"));
        common_words.add(new Word("Coffee","Kaffee"));
        common_words.add(new Word("Clear","Klar"));
        common_words.add(new Word("Small","Klein"));
        common_words.add(new Word("Correct","Korrekt"));
        common_words.add(new Word("Slow","Langsam"));
        common_words.add(new Word("Last Name","Familienname"));
        common_words.add(new Word("First Name","Vorname"));
        common_words.add(new Word("Once Again","Noch Einmal"));
        common_words.add(new Word("Fast","Schnell"));
        common_words.add(new Word("Beautiful","Schön"));
        common_words.add(new Word("Street","Straße"));
        common_words.add(new Word("Tea","Tee"));
        common_words.add(new Word("Telephone","Telefon"));
        common_words.add(new Word("Visiting Card","Visitenkarte"));
        common_words.add(new Word("Weather","Wetter"));
        common_words.add(new Word("Weekend","Wochenende"));

        WordAdapter commonAdapter = new WordAdapter(this,common_words);

        ListView l = (ListView)findViewById(R.id.list);

        l.setAdapter(commonAdapter);





    }
}
