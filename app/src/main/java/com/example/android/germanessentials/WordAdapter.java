package com.example.android.germanessentials;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mukul on 7/26/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int mColor;
    public WordAdapter(Activity context, ArrayList<Word> words,int color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.mColor = color;

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

        // Find the ImageView in the list_item.xml layout with the ID german
        ImageView listImageView = (ImageView) listItemView.findViewById(R.id.list_image);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView


        // Setting different background images
        // 1. Find the text view in the list item
        View textContainer = (View)listItemView.findViewById(R.id.nuclear);
        // 2. Find the associated color
        int color = ContextCompat.getColor(getContext(),mColor);
        // 3. Set the background of view to associated color
        textContainer.setBackgroundColor(color);


        if(currentWord.getIfImageAssociated()) {
            listImageView.setImageResource(currentWord.getMImageID());
        }
        else{
            listImageView.setVisibility(View.GONE);
        }


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }
}
