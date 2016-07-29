package com.example.android.germanessentials;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {



    // MediaPlayer Object
    MediaPlayer mPlaySound;


    // AudioManagement
    private AudioManager mAudioManager;

    // Audio Management
    private AudioManager.OnAudioFocusChangeListener afChangeListener= new AudioManager.OnAudioFocusChangeListener(){

        public void onAudioFocusChange(int focusChange){

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

    /*private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mp) {
            // As sound file is finished playing, so release resources.
            releaseMediaPlayer();
        }
    };
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Create an arraylist
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","eins",R.drawable.one,R.raw.eins_one));
        words.add(new Word("two","zwei",R.drawable.two,R.raw.zwei_two));
        words.add(new Word("three","drei",R.drawable.three,R.raw.drei_three));
        words.add(new Word("four","vier",R.drawable.four,R.raw.vier_4));
        words.add(new Word("five","funf",R.drawable.five,R.raw.five_5));
        words.add(new Word("six","sechs",R.drawable.six,R.raw.sechs_6));
        words.add(new Word("seven","sieben",R.drawable.seven,R.raw.sieben_7));
        words.add(new Word("eight","acht",R.drawable.eight,R.raw.acht_8));
        words.add(new Word("nine","neun",R.drawable.nine,R.raw.neun_9));
        words.add(new Word("ten","zehn",R.drawable.ten,R.raw.zehn_10));




        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView l = (ListView) findViewById(R.id.list);

        l.setAdapter(wordAdapter);


        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               Word currentPlayedWord = words.get(position);

                int result = mAudioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    releaseMediaPlayer();

                    mPlaySound = MediaPlayer.create(NumbersActivity.this, currentPlayedWord.getmAudioResourceID());
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
