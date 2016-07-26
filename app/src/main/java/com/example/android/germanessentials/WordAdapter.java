package com.example.android.germanessentials;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mukul on 7/26/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Activity context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID english
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english);
        // Get the English Word from the current Word object and
        // set this text on the name TextView
        defaultTextView.setText(currentWord.getMdefaultWord());

        // Find the TextView in the list_item.xml layout with the ID german
        TextView translatedTextView = (TextView) listItemView.findViewById(R.id.translated);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        translatedTextView.setText(currentWord.getMtranslatedWord());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }
}