package com.example.nicdomo.lexicon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
/*
* tofix: crashes when creating another character since the oncreate from database helper triggers
* */
public class NewGame extends AppCompatActivity {

    DatabaseHelper dbHelper;
    MediaPlayer music;
    Boolean music_on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        setupButtons();

        dbHelper = new DatabaseHelper(getBaseContext());
        ImageView archer=(ImageView)findViewById(R.id.archerIcon);
//        ImageView mage=(ImageView)findViewById(R.id.mageIcon);
//        ImageView warrior=(ImageView)findViewById(R.id.warriorIcon);

        archer.setImageResource(R.drawable.archer_animation_front);
        AnimationDrawable animated_archer = (AnimationDrawable)archer.getDrawable();

//
//
//        ImageView warrior=(ImageView)findViewById(R.id.warriorIcon);
//        warrior.setImageResource(R.drawable.warrior_animation_front);
//        AnimationDrawable animated_warrior = (AnimationDrawable)warrior.getBackground();
//        animated_warrior.start();


//        mage.setImageResource(R.drawable.mage_animation_front);
//        AnimationDrawable animated_mage = (AnimationDrawable)mage.getDrawable();

        animated_archer.start();
//        animated_mage.start();

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
        ImageButton selectMage = this.findViewById(R.id.imageButtonMage3);
        ImageButton selectWarrior = this.findViewById(R.id.imageButtonWarrior);
        ImageButton selectArcher = this.findViewById(R.id.imageButtonArcher);

        selectMage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(NewGame.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_create, null);
                final EditText editTextName = (EditText) mView.findViewById(R.id.editTextName);

                ImageButton create = (ImageButton) mView.findViewById(R.id.imageButtonCreate);
                create.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!editTextName.getText().toString().isEmpty()){
                            String playerName = editTextName.getText().toString();
                            //creates new player
                            Player player = new Player(playerName,"mage");
                            //retrieves player id
                            long playerid = dbHelper.addPlayer(player);
                            //assigns player id to class
                            player.setId((int)playerid);

                            Toast.makeText(NewGame.this,"Character Created", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(NewGame.this, LevelSelect.class);

                            i.putExtra("player",player); //passes the player object to the next Intent
                            startActivity(i);
                        }else{
                            Toast.makeText(NewGame.this,"Character name cannot be empty!", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
        selectWarrior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(NewGame.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_create, null);
                final EditText editTextName = (EditText) mView.findViewById(R.id.editTextName);

                ImageButton create = (ImageButton) mView.findViewById(R.id.imageButtonCreate);
                create.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!editTextName.getText().toString().isEmpty()){
                            String playerName = editTextName.getText().toString();
                            //creates new player
                            Player player = new Player(playerName,"warrior");
                            //retrieves player id
                            long playerid = dbHelper.addPlayer(player);
                            //assigns player id to class
                            player.setId((int)playerid);

                            Toast.makeText(NewGame.this,"Character Created", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(NewGame.this, LevelSelect.class);

                            i.putExtra("player",player); //passes the player object to the next Intent
                            startActivity(i);
                        }else{
                            Toast.makeText(NewGame.this,"Character name cannot be empty!", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
        selectArcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(NewGame.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_create, null);
                final EditText editTextName = (EditText) mView.findViewById(R.id.editTextName);

                ImageButton create = (ImageButton) mView.findViewById(R.id.imageButtonCreate);
                create.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!editTextName.getText().toString().isEmpty()){
                            String playerName = editTextName.getText().toString();
                            //creates new player
                            Player player = new Player(playerName,"archer");
                            //retrieves player id
                            long playerid = dbHelper.addPlayer(player);
                            //assigns player id to class
                            player.setId((int)playerid);

                            Toast.makeText(NewGame.this,"Character Created", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(NewGame.this, LevelSelect.class);

                            i.putExtra("player",player); //passes the player object to the next Intent
                            startActivity(i);
                        }else{
                            Toast.makeText(NewGame.this,"Character name cannot be empty!", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });


    }
    public void mute(){
        music_on = false;
        //turns off the sounds
        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        amanager.setStreamMute(AudioManager.STREAM_RING, true);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
    }
    public void unmute(){
        music_on = true;
        //turns on the sounds
        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        amanager.setStreamMute(AudioManager.STREAM_RING, false);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
    }
}
