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

public class ColorsActivity extends AppCompatActivity {


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
        setContentView(R.layout.activity_colors);


        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> colors = new ArrayList<Word>();

        colors.add(new Word("Blue","Blau",R.drawable.blue,R.raw.blau_blue));
        colors.add(new Word("Brown","Braun",R.drawable.brown,R.raw.braun_brown));
        colors.add(new Word("Yellow","Gelb",R.drawable.yellow,R.raw.gelb_yellow));
        colors.add(new Word("Green","Grün",R.drawable.green,R.raw.green));
        colors.add(new Word("Purple","Lila",R.drawable.purple,R.raw.lila_purple));
        colors.add(new Word("Orange","Orange",R.drawable.orange,R.raw.orange_orange));
        colors.add(new Word("Pink","Rosa",R.drawable.pink,R.raw.rosa_pink));
        colors.add(new Word("Black","Schwarz",R.drawable.black,R.raw.schwarz_black));
        colors.add(new Word("Red","Rot",R.drawable.red,R.raw.rot_red));
        colors.add(new Word("White","Weiß",R.drawable.white,R.raw.white));

        WordAdapter colorAdapter = new WordAdapter(this,colors,R.color.category_colors);

        ListView l = (ListView)findViewById(R.id.list);

        l.setAdapter(colorAdapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                int result = mAudioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    Word currentColor = colors.get(position);

                    releaseMediaPlayer();

                    mPlaySound = MediaPlayer.create(ColorsActivity.this, currentColor.getmAudioResourceID());
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
