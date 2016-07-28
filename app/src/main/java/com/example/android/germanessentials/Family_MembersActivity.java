package com.example.android.germanessentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Family_MembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family__members);

        ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("Older Sister","Ältere Schwester",R.drawable.family_older_sister));
        family.add(new Word("Older Brother","Älterer Bruder",R.drawable.family_older_brother));
        family.add(new Word("Younger Sister","Jüngere Schwester",R.drawable.family_younger_sister));
        family.add(new Word("Younger Brother","Jüngerer Bruder",R.drawable.family_younger_brother));
        family.add(new Word("Older Brother","Älterer Bruder",R.drawable.family_older_brother));
        family.add(new Word("Grandfather","Großvater",R.drawable.family_grandfather));
        family.add(new Word("Grandmother","Oma",R.drawable.family_grandmother));
        family.add(new Word("Mother","Mutter",R.drawable.family_mother));
        family.add(new Word("Father","Vater",R.drawable.family_father));
        family.add(new Word("Son","Sohn",R.drawable.family_son));
        family.add(new Word("Daughter","Tochter",R.drawable.family_daughter));
        family.add(new Word("Mother-in-law","Schwiegermutter",R.drawable.family_mother));
        family.add(new Word("Father-in-law","Schwiegervater",R.drawable.family_father));

        WordAdapter familyAdapter = new WordAdapter(this,family);

        ListView l =(ListView)findViewById(R.id.list);

        l.setAdapter(familyAdapter);




    }
}
