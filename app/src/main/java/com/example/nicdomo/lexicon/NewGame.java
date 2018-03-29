package com.example.nicdomo.lexicon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class NewGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        setupButtons();

        ImageView archer=(ImageView)findViewById(R.id.archerIcon);
        archer.setImageResource(R.drawable.archer_animation_front);
        AnimationDrawable animated_archer = (AnimationDrawable)archer.getDrawable();
        animated_archer.start();


//        ImageView warrior=(ImageView)findViewById(R.id.warriorIcon);
//        warrior.setImageResource(R.drawable.warrior_animation_front);
//        AnimationDrawable animated_warrior = (AnimationDrawable)warrior.getDrawable();
//        animated_warrior.start();
//
//        ImageView mage=(ImageView)findViewById(R.id.mageIcon);
//        mage.setImageResource(R.drawable.mage_animation_front);
//        AnimationDrawable animated_mage = (AnimationDrawable)mage.getDrawable();
//        animated_mage.start();

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
                            Toast.makeText(NewGame.this,"Character Created", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(NewGame.this, LevelSelect.class);
                            Player player = new Player(playerName,"mage");
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
                            Toast.makeText(NewGame.this,"Character Created", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(NewGame.this, LevelSelect.class);
                            Player player = new Player(playerName,"warrior");
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
                            Toast.makeText(NewGame.this,"Character Created", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(NewGame.this, LevelSelect.class);
                            Player player = new Player(playerName,"archer");
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
}
