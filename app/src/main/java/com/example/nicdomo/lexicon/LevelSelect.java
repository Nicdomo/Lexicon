package com.example.nicdomo.lexicon;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LevelSelect extends AppCompatActivity {
    Player player;
    //keys for STATE SAVING
    private final static String LEVEL_FOREST = "LEVEL_FOREST";
    private final static String LEVEL_DESERT = "LEVEL_DESERT";
    private final static String LEVEL_UNDERWATER = "LEVEL_UNDERWATER";
    private final static String LEVEL_NORTHPOLE = "LEVEL_NORTHPOLE";
    private final static String LEVEL_HELL = "LEVEL_HELL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        setupButtons();
        Intent i = getIntent();
        player = (Player)i.getSerializableExtra("player");

    }
    private void setupButtons(){
        ImageButton first = this.findViewById(R.id.imageButtonFirst);
        ImageButton second = this.findViewById(R.id.imageButtonSecond);
        ImageButton third = this.findViewById(R.id.imageButtonThird);
        ImageButton fourth = this.findViewById(R.id.imageButtonFourth);
        ImageButton fifth = this.findViewById(R.id.imageButtonFifth);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelSelect.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_level, null);


                Button play = (Button) mView.findViewById(R.id.buttonPlay);
                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                            Toast.makeText(LevelSelect.this,"Character Created", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LevelSelect.this, Battle.class);

                            i.putExtra("player",player); //passes the player object to the next Intent
                            startActivity(i);
                    }

                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(LevelSelect.this, Battle.class);
//                i.putExtra("player",player); //passes the player object to the next Intent
//                startActivity(i);
//
//            }
        });
    }
}
