package com.example.nicdomo.lexicon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Battle extends AppCompatActivity {
    ProgressBar progressBar;
    private int  progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();

    Player player;
    ArrayList<String> words;
    ImageView Character;
    TextView HP;
    TextView Damage;
    TextView Name;
    String className;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        Intent i = getIntent();

        ImageView Character = (ImageView) findViewById(R.id.imageViewCharacter);
        TextView HP =(TextView) findViewById(R.id.textViewHP);
        TextView Damage =(TextView) findViewById(R.id.textViewDamage);
        TextView Name =(TextView) findViewById(R.id.textViewName);

        player = (Player)i.getSerializableExtra("player");//grabs the player object from the previous intent
        HP.setText(player.getCurrentHealth()+"/"+player.getMaxHealth()+"");
        Damage.setText(player.getDamage()+"");
        Name.setText(player.getName());
        Log.d("classname: ",player.getClassName());
        className = player.getClassName();
        if(className=="mage"){
            Character.setBackgroundResource(R.drawable.mage_right);
            Log.d("classname: ","pasok sa mage");
        }else if(className=="archer"){
            Character.setBackgroundResource(R.drawable.archer_right);
            Log.d("classname: ","pasok sa archer");
        }else if(className=="warrior"){
            Character.setBackgroundResource(R.drawable.warrior_right);
            Log.d("classname: ","pasok sa warrior");
        }
        showCharacter();
        setupButtons(player);
    }
    private void showCharacter(){



    }
    private void setupButtons(Player player){
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(player.getCurrentHealth());
        progressBar.setMax(player.getCurrentHealth());

    }

}
