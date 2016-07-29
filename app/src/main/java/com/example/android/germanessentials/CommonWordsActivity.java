package com.example.android.germanessentials;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CommonWordsActivity extends AppCompatActivity {


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

    private MediaPlayer.OnCompletionListener mOnCompleteListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_words);


        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> common_words = new ArrayList<>();
        common_words.add(new Word("Address","Adresse",R.raw.address));
        common_words.add(new Word("Cafe","Cafe",R.raw.cafe));
        common_words.add(new Word("Computer","Computer",R.raw.computer));
        common_words.add(new Word("Thank You","Danke",R.raw.thank_you));
        common_words.add(new Word("Mr.","Herr.",R.raw.mr));
        common_words.add(new Word("Mrs.","Frau.",R.raw.mrs));
        common_words.add(new Word("Good Morning","Guten Morgen",R.raw.goodmorning));
        common_words.add(new Word("Big","Groß",R.raw.big));
        common_words.add(new Word("Mobile Number","Handynummer",R.raw.mobilenumber));
        common_words.add(new Word("Intelligent","Intelligent",R.raw.intelligent));
        common_words.add(new Word("Years","Jahre",R.raw.years));
        common_words.add(new Word("Yes","Ja",R.raw.yes));
        common_words.add(new Word("No","Nein",R.raw.no));
        common_words.add(new Word("Now","Jetzt",R.raw.now));
        common_words.add(new Word("Coffee","Kaffee",R.raw.coffee));
        common_words.add(new Word("Clear","Klar",R.raw.clear));
        common_words.add(new Word("Small","Klein",R.raw.small));
        common_words.add(new Word("Correct","Korrekt",R.raw.correct));
        common_words.add(new Word("Slow","Langsam",R.raw.slow));
        common_words.add(new Word("Last Name","Familienname",R.raw.surname));
        common_words.add(new Word("First Name","Vorname",R.raw.name));
        common_words.add(new Word("Once Again","Noch Einmal",R.raw.once_again));
        common_words.add(new Word("Fast","Schnell",R.raw.fast));
        common_words.add(new Word("Beautiful","Schön",R.raw.beautiful));
        common_words.add(new Word("Street","Straße",R.raw.street));
        common_words.add(new Word("Tea","tea",R.raw.tea));
        common_words.add(new Word("Telephone","Telefon",R.raw.telephone));
        common_words.add(new Word("Visiting Card","Visitenkarte",R.raw.visitingcard));
        common_words.add(new Word("Weather","Wetter",R.raw.weather));
        common_words.add(new Word("Weekend","Wochenende",R.raw.weekend));

        WordAdapter commonAdapter = new WordAdapter(this,common_words,R.color.category_commonwords);

        ListView l = (ListView)findViewById(R.id.list);

        l.setAdapter(commonAdapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                int result = mAudioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Word currentCommon = common_words.get(position);
                    releaseMediaPlayer();
                    mPlaySound = MediaPlayer.create(CommonWordsActivity.this, currentCommon.getmAudioResourceID());
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

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
}
