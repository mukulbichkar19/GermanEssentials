package com.example.android.germanessentials;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CountriesActivity extends AppCompatActivity {

    MediaPlayer mPlaySound;

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {




                if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                    mPlaySound.start();
                }
                else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                    releaseMediaPlayer();
                }
                else if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                        focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                    mPlaySound.pause();
                    mPlaySound.seekTo(0);
                }








        }
    };



    /*private MediaPlayer.OnCompletionListener monCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> countries = new ArrayList<>();
        countries.add(new Word("America","Amerika",R.drawable.america,R.raw.america));
        countries.add(new Word("Australia","Australien",R.drawable.australia,R.raw.australia));
        countries.add(new Word("China","China",R.drawable.china,R.raw.china));
        countries.add(new Word("Germany","Deutschland",R.drawable.germany,R.raw.germany));
        countries.add(new Word("england","england",R.drawable.england,R.raw.england));
        countries.add(new Word("France","Frankreich",R.drawable.france,R.raw.france));
        countries.add(new Word("India","Indien",R.drawable.india,R.raw.india));
        countries.add(new Word("Italy","Italien",R.drawable.italy,R.raw.italy));
        countries.add(new Word("Japan","Japan",R.drawable.japan,R.raw.japan));
        countries.add(new Word("Canada","Kanada",R.drawable.canada,R.raw.canada));
        countries.add(new Word("Pakistan","Pakistan",R.drawable.pakistan,R.raw.pakistan));
        countries.add(new Word("Portugal","Portugal",R.drawable.portugal,R.raw.portugal));
        countries.add(new Word("Switzerland","Schweiz",R.drawable.switzerland,R.raw.switzerland));
        countries.add(new Word("Singapore","Singapur",R.drawable.singapore,R.raw.singapore));
        countries.add(new Word("Spain","Spanien",R.drawable.spain,R.raw.spain));


        WordAdapter countriesAdapter = new WordAdapter(this,countries,R.color.category_countries);

        ListView l = (ListView)findViewById(R.id.list);

        l.setAdapter(countriesAdapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                int result = mAudioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    Word currentCountry = countries.get(position);
                    releaseMediaPlayer();
                    mPlaySound = MediaPlayer.create(CountriesActivity.this, currentCountry.getmAudioResourceID());
                    mPlaySound.start();
                    mPlaySound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }

            }
        });








    }


    private void releaseMediaPlayer(){

        if(mPlaySound != null){
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mPlaySound.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mPlaySound=null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
