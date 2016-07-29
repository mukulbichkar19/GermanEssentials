package com.example.android.germanessentials;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family_MembersActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_family__members);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("Older Sister","Ältere Schwester",R.drawable.family_older_sister,R.raw.older_sister));
        family.add(new Word("Older Brother","Älterer Bruder",R.drawable.family_older_brother,R.raw.older_brother));
        family.add(new Word("Younger Sister","Jüngere Schwester",R.drawable.family_younger_sister,R.raw.younger_sister));
        family.add(new Word("Younger Brother","Jüngerer Bruder",R.drawable.family_younger_brother,R.raw.younger_brother));
        family.add(new Word("Older Brother","Älterer Bruder",R.drawable.family_older_brother,R.raw.older_brother));
        family.add(new Word("Grandfather","Großvater",R.drawable.family_grandfather,R.raw.grandfather));
        family.add(new Word("Grandmother","Oma",R.drawable.family_grandmother,R.raw.grandmother));
        family.add(new Word("Mother","Mutter",R.drawable.family_mother,R.raw.mom));
        family.add(new Word("Father","Vater",R.drawable.family_father,R.raw.father));
        family.add(new Word("Son","Sohn",R.drawable.family_son,R.raw.son));
        family.add(new Word("Daughter","Tochter",R.drawable.family_daughter,R.raw.daughter));
        family.add(new Word("Mother-in-law","Schwiegermutter",R.drawable.family_mother,R.raw.mother_in_law));
        family.add(new Word("Father-in-law","Schwiegervater",R.drawable.family_father,R.raw.father_in_law));

        WordAdapter familyAdapter = new WordAdapter(this,family,R.color.category_family);

        ListView l =(ListView)findViewById(R.id.list);

        l.setAdapter(familyAdapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                int result = mAudioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Word currentFamily_Member = family.get(position);
                    releaseMediaPlayer();
                    mPlaySound = MediaPlayer.create(Family_MembersActivity.this, currentFamily_Member.getmAudioResourceID());
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
