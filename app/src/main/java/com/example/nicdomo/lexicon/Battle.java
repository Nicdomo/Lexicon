package com.example.nicdomo.lexicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class Battle extends AppCompatActivity {
    Player player;
    ArrayList<String> words;
//    ImageView Character

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        Intent i = getIntent();
        player = (Player)i.getSerializableExtra("player");//grabs the player object from the previous intent
        words = new ArrayList<String>();

    }
    private void setupButtons(){

    }

}
