package com.example.nicdomo.lexicon;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    AudioManager amanager;
    MediaPlayer music;
    ImageButton musicBtn;
    Boolean music_on;
    // 	Oxford Dictionary Application ID b1f4982e
    //Oxford Dictionary Application Key 5fa15145c3774df560e0dec7c596cf8e
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setupButtons();

        this.setupMusic();
    }
    private void setupMusic(){
        music = MediaPlayer.create(this, R.raw.main_music);
        Log.d("music","music started");
        music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                music.start();
            }
        });
        music_on = true;
    }
    private void setupButtons(){
        musicBtn = (ImageButton) this.findViewById(R.id.imageButtonMusic);
        ImageButton newGameButton = this.findViewById(R.id.imageButtonNewGame);
        ImageButton continueButton = this.findViewById(R.id.imageButtonContinue);
        ImageButton leaderboardButton = this.findViewById(R.id.imageButtonLeaderBoard);
        amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

       newGameButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(MainActivity.this, NewGame.class);
               startActivity(i);
           }
       });

       musicBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(music_on){
                   musicBtn.setBackgroundResource(R.drawable.button_music_d);
                   music_on = false;

                   //turns off the sounds
                   //mute sound

                   AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                   amanager.adjustStreamVolume(AudioManager.STREAM_MUSIC,amanager.ADJUST_MUTE,0);
                   amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                   amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
                   amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                   amanager.setStreamMute(AudioManager.STREAM_RING, true);
                   amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
                   Log.d("music","music stopped");

               }else{
                   musicBtn.setBackgroundResource(R.drawable.button_music);
                   music_on = true;

                   //turns on the sounds//
                   AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                   amanager.adjustStreamVolume(AudioManager.STREAM_MUSIC,amanager.ADJUST_UNMUTE,0);
                   amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                   amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
                   amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                   amanager.setStreamMute(AudioManager.STREAM_RING, false);
                   amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);

                   Log.d("music","music resumed");


               }

           }
       });
       continueButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(MainActivity.this, ContinueProfileActivity.class);
               startActivity(i);
               //continue intent here
           }
       });


        leaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show leaderboard here
                Intent i = new Intent(MainActivity.this, LeaderboardActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();



    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onStop() {
        super.onStop();
        if(music!=null){
            music.stop();
            music = null;
        }


    }
}
