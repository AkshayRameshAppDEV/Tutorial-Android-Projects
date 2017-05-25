/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;

public class FamilyActivity extends AppCompatActivity
{

    private MediaPlayer mediaPlayer;

    private AudioManager am;


    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ) {
                       mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    }
                    else if (focusChange == AUDIOFOCUS_GAIN)
                    {
                        mediaPlayer.start();
                        // Pause playback
                    }
                    else if (focusChange == AUDIOFOCUS_LOSS)
                    {
                        releaseMediaPlayer();

                    }
                }
            };


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp)
        {
            releaseMediaPlayer();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //mediaPlayer = MediaPlayer.create(NumbersActivity.this,R.raw.number_one);
                //mediaPlayer.start();
                if(position == 0)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_father);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }


                }
                if(position == 1)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_mother);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
                if(position == 2)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_son);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }

                if(position == 3)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_daughter);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }

                if(position == 4)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_older_brother);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
                if(position == 5)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_younger_brother);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
                if(position == 6)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_older_sister);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
                if(position == 7)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_younger_sister);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
                if(position == 8)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_grandmother);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
                if(position == 9)
                {
                    releaseMediaPlayer();
                    int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                    {
                        mediaPlayer.start();
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this,R.raw.family_grandfather);


                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }

            }
        });
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer()
    {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            am.abandonAudioFocus(afChangeListener);
        }
    }
}
