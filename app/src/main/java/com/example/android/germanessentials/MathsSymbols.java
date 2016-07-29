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

public class MathsSymbols extends AppCompatActivity {

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



    private MediaPlayer.OnCompletionListener mOnComplete = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_symbols);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        // Declare an arraylist to contain Word Objects
        final ArrayList<Word> mathsSymbols = new ArrayList<>();
        mathsSymbols.add(new Word("Divide","Dussh",R.drawable.divide,R.raw.division));
        mathsSymbols.add(new Word("Equal","Gleich",R.drawable.equal,R.raw.equals));
        mathsSymbols.add(new Word("Minus","Minoos",R.drawable.minus,R.raw.minus));
        mathsSymbols.add(new Word("Plus","Plus",R.drawable.plus,R.raw.plus));
        mathsSymbols.add(new Word("Multiply","Mal",R.drawable.multiply,R.raw.multiplication));

        WordAdapter mathsAdapter = new WordAdapter(this,mathsSymbols,R.color.category_maths);

        ListView l = (ListView) findViewById(R.id.list);

        l.setAdapter(mathsAdapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int result = mAudioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Word currentMath = mathsSymbols.get(position);

                    releaseMediaPlayer();
                    mPlaySound = MediaPlayer.create(MathsSymbols.this, currentMath.getmAudioResourceID());
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
