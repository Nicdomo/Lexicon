package com.example.nicdomo.lexicon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Battle extends AppCompatActivity {
    ProgressBar progressBar;
    private int  progressBarS2atus = 0;
    private Handler progressBarHandler = new Handler();
    Random rand;
    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    ImageButton button6;
    ImageButton button7;
    ImageButton button8;

    ImageButton slot1;
    ImageButton slot2;
    ImageButton slot3;
    ImageButton slot4;
    ImageButton slot5;
    ImageButton slot6;
    ImageButton slot7;
    ImageButton slot8;

    LinkedList<ImageButton>slots;

    Letter letter1;
    Letter letter2;
    Letter letter3;
    Letter letter4;
    Letter letter5;
    Letter letter6;
    Letter letter7;
    Letter letter8;

    ImageButton attackBtn;
    ImageButton shuffleBtn;
    ImageButton cancelBtn;
    ImageButton backBtn;
    String formedWord;

    LinkedList<Letter>pickedLetter;
//    ImageButton[] letterbuttons;
    LinkedList<Letter>buttonChoices;
    String[] choices = new String[8];


    Boolean attack_disabled = false;
    Boolean shuffle_disabled = false;
    Boolean cancel_disabled = false;
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
        rand = new Random();
        formedWord ="";
        pickedLetter = new LinkedList<Letter>();
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

        setCharacter(player.getClassName());
        setupButtons(player);

    }
    private void setCharacter(String className){
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
    }

    private void setupButtons(Player player){
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(player.getCurrentHealth());
        progressBar.setMax(player.getCurrentHealth());
        attackBtn = (ImageButton)findViewById(R.id.imageButtonAttack);
        shuffleBtn = (ImageButton)findViewById(R.id.imageButtonShuffle);
        cancelBtn = (ImageButton)findViewById(R.id.imageButtonCancel);

        button1 = (ImageButton)findViewById(R.id.ImageButtonBlank1);
        button2 = (ImageButton)findViewById(R.id.ImageButtonBlank2);
        button3 = (ImageButton)findViewById(R.id.ImageButtonBlank3);
        button4 = (ImageButton)findViewById(R.id.ImageButtonBlank4);
        button5 = (ImageButton)findViewById(R.id.ImageButtonBlank5);
        button6 = (ImageButton)findViewById(R.id.ImageButtonBlank6);
        button7 = (ImageButton)findViewById(R.id.ImageButtonBlank7);
        button8 = (ImageButton)findViewById(R.id.ImageButtonBlank8);

        initSlots();
        initLetters();
        attackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!attack_disabled){
                    attack();
                }
            }
        });

        shuffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!shuffle_disabled){
                    shuffle();
                }
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!cancel_disabled){
                    cancel();
                }

            }
        });

        if(cancel_disabled){
            cancelBtn.setBackgroundResource(R.drawable.button_cancel_d);
        }else{
            cancelBtn.setBackgroundResource(R.drawable.button_cancel);
        }
        if(attack_disabled){
            attackBtn.setBackgroundResource(R.drawable.button_attack_d);
        }else{
            attackBtn.setBackgroundResource(R.drawable.button_attack);
        }
        if(shuffle_disabled){
            shuffleBtn.setBackgroundResource(R.drawable.button_shuffle_d);
        }else{
            shuffleBtn.setBackgroundResource(R.drawable.button_shuffle);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonpress","button1 pressed");
                //kunin yung letter assigned sa button
                if(!letter1.isDisabled()){
                    pickedLetter.add(letter1);
                    setSlotValues();
                    enableAttack();
                    enableCancel();
                    enableShuffle();
                }else{
                    Toast.makeText(Battle.this,"Button is disabled!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonpress","button2 pressed");
                if(!letter2.isDisabled()){
                    pickedLetter.add(letter2);
                    setSlotValues();
                    enableAttack();
                    enableCancel();
                    enableShuffle();
                }else{
                    Toast.makeText(Battle.this,"Button is disabled!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonpress","button3 pressed");
                if(!letter3.isDisabled()){
                    pickedLetter.add(letter3);
                    setSlotValues();
                    enableAttack();
                    enableCancel();
                    enableShuffle();
                }else{
                    Toast.makeText(Battle.this,"Button is disabled!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonpress","button4 pressed");
                if(!letter4.isDisabled()){
                    pickedLetter.add(letter4);
                    setSlotValues();
                    enableAttack();
                    enableCancel();
                    enableShuffle();
                }else{
                    Toast.makeText(Battle.this,"Button is disabled!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonpress","button5 pressed");
                if(!letter5.isDisabled()){
                    pickedLetter.add(letter5);
                    setSlotValues();
                    enableAttack();
                    enableCancel();
                    enableShuffle();
                }else{
                    Toast.makeText(Battle.this,"Button is disabled!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonpress","button6 pressed");
                if(!letter6.isDisabled()){
                    pickedLetter.add(letter6);
                    setSlotValues();
                    enableAttack();
                    enableCancel();
                    enableShuffle();
                }else{
                    Toast.makeText(Battle.this,"Button is disabled!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonpress","button1 pressed");
                if(!letter7.isDisabled()){
                    pickedLetter.add(letter7);
                    setSlotValues();
                    enableAttack();
                    enableCancel();
                    enableShuffle();
                }else{
                    Toast.makeText(Battle.this,"Button is disabled!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonpress","button1 pressed");
                if(!letter8.isDisabled()){
                    pickedLetter.add(letter8);
                    setSlotValues();
                    enableAttack();
                    enableCancel();
                    enableShuffle();
                }else{
                    Toast.makeText(Battle.this,"Button is disabled!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    //takes in an array of string and returns the same array with the random generated values
//    private char generateRandomString(){
////        String[] array= new String[8];
//        String choices ="";
//        Random r = new Random();
//        for(int i = 1;i<=8; i++){
//            char c = (char)(r.nextInt(26) + 'a');
//        }
//        return c;
//    }
    private void initLetters(){
        letter1 = new Letter(button1,(char)(rand.nextInt(26) + 'a'));
        letter2 = new Letter(button2,(char)(rand.nextInt(26) + 'a'));
        letter3 = new Letter(button3,(char)(rand.nextInt(26) + 'a'));
        letter4 = new Letter(button4,(char)(rand.nextInt(26) + 'a'));
        letter5 = new Letter(button5,(char)(rand.nextInt(26) + 'a'));
        letter6 = new Letter(button6,(char)(rand.nextInt(26) + 'a'));
        letter7 = new Letter(button7,(char)(rand.nextInt(26) + 'a'));
        letter8 = new Letter(button8,(char)(rand.nextInt(26) + 'a'));
        buttonChoices = new LinkedList<Letter>();
        buttonChoices.add(letter1);
        buttonChoices.add(letter2);
        buttonChoices.add(letter3);
        buttonChoices.add(letter4);
        buttonChoices.add(letter5);
        buttonChoices.add(letter6);
        buttonChoices.add(letter7);
        buttonChoices.add(letter8);
    }
    private void initSlots(){
        slots = new LinkedList<ImageButton>();
        slot1 = (ImageButton)findViewById(R.id.slot1);
        slot2 = (ImageButton)findViewById(R.id.slot2);
        slot3 = (ImageButton)findViewById(R.id.slot3);
        slot4 = (ImageButton)findViewById(R.id.slot4);
        slot5 = (ImageButton)findViewById(R.id.slot5);
        slot6 = (ImageButton)findViewById(R.id.slot6);
        slot7 = (ImageButton)findViewById(R.id.slot7);
        slot8 = (ImageButton)findViewById(R.id.slot8);
        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);
        slots.add(slot5);
        slots.add(slot6);
        slots.add(slot7);
        slots.add(slot8);
    }
    //takes in an array of string and converts it to a string
    private String arrayToString(String[] array){
        String word;
        StringBuilder builder = new StringBuilder();
        for(String s : array) {
            builder.append(s);
        }
        word = builder.toString();
        return word;
    }

    private void shuffle(){
//       Random r = new Random();
        letter1.randomizeLetter();
        letter2.randomizeLetter();
        letter3.randomizeLetter();
        letter4.randomizeLetter();
        letter5.randomizeLetter();
        letter6.randomizeLetter();
        letter7.randomizeLetter();
        letter8.randomizeLetter();
    }
    private void setValue(ImageButton button, char letter){
        if(letter =='a'){
           button.setBackgroundResource(R.drawable.letter_a);
        }else if(letter =='b'){
            button.setBackgroundResource(R.drawable.letter_b);
        }else if(letter =='c'){
            button.setBackgroundResource(R.drawable.letter_c);
        }else if(letter =='d'){
            button.setBackgroundResource(R.drawable.letter_d);
        }else if(letter =='e'){
            button.setBackgroundResource(R.drawable.letter_e);
        }else if(letter =='f'){
            button.setBackgroundResource(R.drawable.letter_f);
        }else if(letter =='g'){
            button.setBackgroundResource(R.drawable.letter_g);
        }else if(letter =='h'){
            button.setBackgroundResource(R.drawable.letter_h);
        }else if(letter =='i'){
            button.setBackgroundResource(R.drawable.letter_i);
        }else if(letter =='j'){
            button.setBackgroundResource(R.drawable.letter_j);
        }else if(letter =='k'){
            button.setBackgroundResource(R.drawable.letter_k);
        }else if(letter =='l'){
            button.setBackgroundResource(R.drawable.letter_l);
        }else if(letter =='m'){
            button.setBackgroundResource(R.drawable.letter_m);
        }else if(letter =='n'){
            button.setBackgroundResource(R.drawable.letter_n);
        }else if(letter =='o'){
            button.setBackgroundResource(R.drawable.letter_o);
        }else if(letter =='p'){
            button.setBackgroundResource(R.drawable.letter_p);
        }else if(letter =='q'){
            button.setBackgroundResource(R.drawable.letter_q);
        }else if(letter =='r'){
            button.setBackgroundResource(R.drawable.letter_r);
        }else if(letter =='s'){
            button.setBackgroundResource(R.drawable.letter_s);
        }else if(letter =='t'){
            button.setBackgroundResource(R.drawable.letter_t);
        }else if(letter =='u'){
            button.setBackgroundResource(R.drawable.letter_u);
        }else if(letter =='v'){
            button.setBackgroundResource(R.drawable.letter_v);
        }else if(letter =='w'){
            button.setBackgroundResource(R.drawable.letter_w);
        }else if(letter =='x'){
            button.setBackgroundResource(R.drawable.letter_x);
        }else if(letter =='y'){
            button.setBackgroundResource(R.drawable.letter_y);
        }else if(letter =='z'){
            button.setBackgroundResource(R.drawable.letter_z);
        }
    }
    private void attack(){
        //if the word exists
        formedWord ="";
        pickedLetter.clear();
        for(ImageButton im:slots){
            im.setBackgroundResource(R.drawable.letter_blank);
        }
        disableAttack();
        disableCancel();
        disableShuffle();
    }

    private void cancel(){
        formedWord ="";

        for(Letter m: buttonChoices){
            m.enable();
        }

        pickedLetter.clear();
        for(ImageButton im:slots){
            im.setBackgroundResource(R.drawable.letter_blank);
        }
        disableAttack();
        disableCancel();
        disableShuffle();
    }

    private char generateRandomVowel(){
        Random r = new Random();
        char[] a = {'a','e','i','o','u'};
        return (a[r.nextInt(5)]);

    }
    private void disableAttack(){
        attackBtn.setBackgroundResource(R.drawable.button_attack_d);
        attack_disabled = true;
    }
    private void enableAttack(){
        attackBtn.setBackgroundResource(R.drawable.button_attack);
        attack_disabled = false;

    }
    private void disableShuffle(){
        shuffleBtn.setBackgroundResource(R.drawable.button_shuffle_d);
        shuffle_disabled = true;

    }
    private void enableShuffle(){
        shuffleBtn.setBackgroundResource(R.drawable.button_shuffle);
        shuffle_disabled = false;
    }
    private void disableCancel(){
        cancelBtn.setBackgroundResource(R.drawable.button_cancel_d);
        cancel_disabled = false;
    }
    private void enableCancel(){
        cancelBtn.setBackgroundResource(R.drawable.button_cancel);
        cancel_disabled = true;

    }
    private void setSlotValues(){
        if(pickedLetter.size()>0) {
            Log.d("Array", pickedLetter.size() + "");
            for(int i = 0; i<=pickedLetter.size()-1;i++){
                setValue(slots.get(i),pickedLetter.get(i).getAssignedLetter());
                pickedLetter.get(i).disable();
            }
        }
    }



}
