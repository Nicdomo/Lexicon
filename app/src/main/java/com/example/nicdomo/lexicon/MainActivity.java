package com.example.nicdomo.lexicon;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
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
        music= MediaPlayer.create(MainActivity.this,R.raw.main_music);
        music.start();
    }
    private void setupButtons(){
        ImageButton newGameButton = this.findViewById(R.id.imageButtonNewGame);
        ImageButton continueButton = this.findViewById(R.id.imageButtonContinue);
        ImageButton leaderboardButton = this.findViewById(R.id.imageButtonLeaderBoard);

       newGameButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(MainActivity.this, NewGame.class);
               startActivity(i);
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

}
