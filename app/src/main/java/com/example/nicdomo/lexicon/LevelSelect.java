package com.example.nicdomo.lexicon;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LevelSelect extends AppCompatActivity {
    Player player;
    TextView playerName;
    ProgressBar progressBar;
    TextView healthLabel;
    ImageButton avatar;
//    ImageView star1;
//    ImageView star2;
//    ImageView star3;


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


        TextView playerName = this.findViewById(R.id.textViewPlayer);
        TextView healthLabel = (TextView) findViewById(R.id.textViewHealthSelect);


        Intent i = getIntent();
        player = (Player)i.getSerializableExtra("player");
        progressBar = (ProgressBar)findViewById(R.id.progressBarStage);
        progressBar.setProgress(player.getCurrentHealth());
        progressBar.setMax(player.getCurrentHealth());

        healthLabel.setText(player.getCurrentHealth()+"/"+player.getMaxHealth());

//        ImageView star1 = findViewById(R.id.star1_1);
//        ImageView star2 = findViewById(R.id.star1_2);
//        ImageView star3 = findViewById(R.id.star1_3);
        if(player !=null){
            Log.d("check", "player is not null");
            if(player.getName()!=null){
                Log.d("check", "player's name is"+player.getName());
            }
        }else{
            Log.d("check", "player is null");
        }

        playerName.setText("Hello, "+player.getName()+"!");

        setupButtons();

        ImageButton avatar = (ImageButton)findViewById(R.id.imageButtonAvatar);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelSelect.this);
                View  mView = getLayoutInflater().inflate(R.layout.character_layout, null);
                openPlayerDialog(player);
            }
        });
        //setup character avatar
        if(player.getClassName().equals("archer")){
            avatar.setBackgroundResource(R.drawable.archer_avatar);
        }else if(player.getClassName().equals("warrior")){
            avatar.getLayoutParams().height = 290;
            avatar.getLayoutParams().width = 427;
            avatar.setBackgroundResource(R.drawable.warrior_avatar);


        }else if(player.getClassName().equals("mage")){
            avatar.getLayoutParams().height = 100;
            avatar.getLayoutParams().width = 131;
            avatar.setBackgroundResource(R.drawable.mage_avatar);

        }else{
            avatar.setBackgroundResource(R.drawable.letter_blank);
        }
    }

    /*
        forest
        desert
        ice
        underwater
        hell

     */

    private void openPlayerDialog(Player player){

        LayoutInflater inflater = LayoutInflater.from(LevelSelect.this);
        View subView = inflater.inflate(R.layout.character_layout, null);

        ImageView character = (ImageView)subView.findViewById(R.id.characterImage);
        TextView name = (TextView)subView.findViewById(R.id.nameView);
        TextView className = (TextView)subView.findViewById(R.id.nameView);
        TextView health = (TextView)subView.findViewById(R.id.nameView);
        TextView damage = (TextView)subView.findViewById(R.id.nameView);
        TextView upgradePoints = (TextView)subView.findViewById(R.id.nameView);

        String charName = player.getName();
        String charDamage= player.getDamage()+"";
        String charHealth= player.getMaxHealth()+"";
        String charClass= player.getClassName();
        int charSlot1= player.getSlot1();
        int charSlot2= player.getSlot2();
        int charSlot3= player.getSlot3();
        int charSlot4= player.getSlot4();
        int charSlot5= player.getSlot5();
        int charUpgradePoints= player.getSkillPoints();

        ImageView slot1 = (ImageView)subView.findViewById(R.id.blank1);
        ImageView slot2 = (ImageView)subView.findViewById(R.id.blank2);
        ImageView slot3 = (ImageView)subView.findViewById(R.id.blank3);
        ImageView slot4 = (ImageView)subView.findViewById(R.id.blank4);
        ImageView slot5 = (ImageView)subView.findViewById(R.id.blank5);
        //set class name
        Log.d("name",charName);
        Log.d("class",charClass);
        Log.d("health",charHealth);
        Log.d("damage",charDamage);
        //setcharimage
        if(player.getClassName().equals("mage")){
            character.setBackgroundResource(R.drawable.mage_front);
        }
        if(player.getClassName().equals("archer")){
            character.setBackgroundResource(R.drawable.archer_front);
        }
        if(player.getClassName().equals("warrior")){
            character.setBackgroundResource(R.drawable.warrior_front);
        }

        //set equipped slots
        if(charSlot1==1){
            slot1.setBackgroundResource(R.drawable.book_1);
        }
        if(charSlot2==1){
            slot1.setBackgroundResource(R.drawable.book_2);
        }
        if(charSlot3==1){
            slot1.setBackgroundResource(R.drawable.book_3);
        }
        if(charSlot4==1){
            slot1.setBackgroundResource(R.drawable.book_4);
        }
        if(charSlot5==1){
            slot1.setBackgroundResource(R.drawable.book_5);
        }
        //setname
        name.setText("name: "+charName);
        //sethealth
        health.setText("health: "+charHealth);
        //setdamage
        damage.setText("damage: "+charDamage);
        //setskillpoints
        upgradePoints.setText("Upgrade points: "+charUpgradePoints);
        //setchar image

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.show();

    }
    private void openDialog(String level){
        LayoutInflater inflater = LayoutInflater.from(LevelSelect.this);
        View subView = inflater.inflate(R.layout.dialog_level, null);

        final ImageView star1 = (ImageView)subView.findViewById(R.id.star1_1);
        final ImageView star2 = (ImageView)subView.findViewById(R.id.star1_2);
        final ImageView star3 = (ImageView)subView.findViewById(R.id.star1_3);


        Button play = (Button) subView.findViewById(R.id.buttonPlay);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelSelect.this, Battle.class);
                i.putExtra("player",player); //passes the player object to the next Intent
                startActivity(i);
            }

        });
        Drawable star = getResources().getDrawable(R.drawable.star);
        Drawable graystar = getResources().getDrawable(R.drawable.star);

        if(level.equals("forest")){
            //if the player already got the first star for the forest level
            if(player.getForestOne()>0){
                star1.setImageResource(R.drawable.star);
            }else{
                star1.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the second star
            if(player.getForestTwo()>0){
                star2.setImageResource(R.drawable.star);
            }else{
                star2.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the third star
            if(player.getForestThree()>0){
                star3.setImageResource(R.drawable.star);
            }else{
                star3.setBackgroundResource(R.drawable.star_gray);
            }
        }
        if(level.equals("hell")){
            //if the player already got the first star for the forest level
            if(player.getHellOne()>0){
                star1.setImageResource(R.drawable.star);
            }else{
                star1.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the second star
            if(player.getHellTwo()>0){
                star2.setImageResource(R.drawable.star);
            }else{
                star2.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the third star
            if(player.getHellThree()>0){
                star3.setImageResource(R.drawable.star);
            }else{
                star3.setBackgroundResource(R.drawable.star_gray);
            }
        }
        if(level.equals("ice")){
            //if the player already got the first star for the forest level
            if(player.getIceOne()>0){
                star1.setImageResource(R.drawable.star);
            }else{
                star1.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the second star
            if(player.getIceTwo()>0){
                star2.setImageResource(R.drawable.star);
            }else{
                star2.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the third star
            if(player.getIceThree()>0){
                star3.setImageResource(R.drawable.star);
            }else{
                star3.setBackgroundResource(R.drawable.star_gray);
            }
        }
        if(level.equals("desert")){
            //if the player already got the first star for the forest level
            if(player.getDesertOne()>0){
                star1.setImageResource(R.drawable.star);
            }else{
                star1.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the second star
            if(player.getDesertTwo()>0){
                star2.setImageResource(R.drawable.star);
            }else{
                star2.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the third star
            if(player.getDesertThree()>0){
                star3.setImageResource(R.drawable.star);
            }else{
                star3.setBackgroundResource(R.drawable.star_gray);
            }
        }
        if(level.equals("underwater")){
            //if the player already got the first star for the forest level
            if(player.getUnderwaterOne()>0){
                star1.setImageResource(R.drawable.star);
            }else{
                star1.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the second star
            if(player.getUnderwaterTwo()>0){
                star2.setImageResource(R.drawable.star);
            }else{
                star2.setBackgroundResource(R.drawable.star_gray);
            }
            //if the player got the third star
            if(player.getUnderwaterThree()>0){
                star3.setImageResource(R.drawable.star);
            }else{
                star3.setBackgroundResource(R.drawable.star_gray);
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.show();
    }

    private void setupButtons(){

        ImageButton first = this.findViewById(R.id.imageButtonFirst);
        ImageButton second = this.findViewById(R.id.imageButtonSecond);
        ImageButton third = this.findViewById(R.id.imageButtonThird);
        ImageButton fourth = this.findViewById(R.id.imageButtonFourth);
        ImageButton fifth = this.findViewById(R.id.imageButtonFifth);
        ImageButton backButton = this.findViewById(R.id.imageButtonBack2);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelSelect.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_level, null);
                openDialog("forest");
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelSelect.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_level, null);
                openDialog("desert");
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelSelect.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_level, null);
                openDialog("underwater");
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelSelect.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_level, null);
                openDialog("ice");
            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelSelect.this);
                View  mView = getLayoutInflater().inflate(R.layout.dialog_level, null);
                openDialog("hell");
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelSelect.this, NewGame.class);
                startActivity(i);
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(LevelSelect.this, MainActivity.class);
        i.putExtra("player",player); //passes the player object to the next Intent
        startActivity(i);    }
}
