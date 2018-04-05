package com.example.nicdomo.lexicon;

import android.util.Log;
import android.widget.ImageButton;

import java.util.Random;

/**
 * Created by Nicdomo on 2/9/2018.
 */

public class Letter {
    Random random;
    boolean disabled;
    private ImageButton imageButton;
    private char assignedLetter;
    public Letter(char c){
        setAssignedLetter(assignedLetter);
    }

    public Letter(ImageButton imageButton, char assignedLetter){
        random = new Random();
        setImageButton(imageButton);
        setAssignedLetter(assignedLetter);
        disabled = false;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

    public void setImageButtonWithLetter(char letter){
        if(letter =='a'){
            imageButton.setBackgroundResource(R.drawable.letter_a);
        }else if(letter =='b'){
            imageButton.setBackgroundResource(R.drawable.letter_b);
        }else if(letter =='c'){
            imageButton.setBackgroundResource(R.drawable.letter_c);
        }else if(letter =='d'){
            imageButton.setBackgroundResource(R.drawable.letter_d);
        }else if(letter =='e'){
            imageButton.setBackgroundResource(R.drawable.letter_e);
        }else if(letter =='f'){
            imageButton.setBackgroundResource(R.drawable.letter_f);
        }else if(letter =='g'){
            imageButton.setBackgroundResource(R.drawable.letter_g);
        }else if(letter =='h'){
            imageButton.setBackgroundResource(R.drawable.letter_h);
        }else if(letter =='i'){
            imageButton.setBackgroundResource(R.drawable.letter_i);
        }else if(letter =='j'){
            imageButton.setBackgroundResource(R.drawable.letter_j);
        }else if(letter =='k'){
            imageButton.setBackgroundResource(R.drawable.letter_k);
        }else if(letter =='l'){
            imageButton.setBackgroundResource(R.drawable.letter_l);
        }else if(letter =='m'){
            imageButton.setBackgroundResource(R.drawable.letter_m);
        }else if(letter =='n'){
            imageButton.setBackgroundResource(R.drawable.letter_n);
        }else if(letter =='o'){
            imageButton.setBackgroundResource(R.drawable.letter_o);
        }else if(letter =='p'){
            imageButton.setBackgroundResource(R.drawable.letter_p);
        }else if(letter =='q'){
            imageButton.setBackgroundResource(R.drawable.letter_q);
        }else if(letter =='r'){
            imageButton.setBackgroundResource(R.drawable.letter_r);
        }else if(letter =='s'){
            imageButton.setBackgroundResource(R.drawable.letter_s);
        }else if(letter =='t'){
            imageButton.setBackgroundResource(R.drawable.letter_t);
        }else if(letter =='u'){
            imageButton.setBackgroundResource(R.drawable.letter_u);
        }else if(letter =='v'){
            imageButton.setBackgroundResource(R.drawable.letter_v);
        }else if(letter =='w'){
            imageButton.setBackgroundResource(R.drawable.letter_w);
        }else if(letter =='x'){
            imageButton.setBackgroundResource(R.drawable.letter_x);
        }else if(letter =='y'){
            imageButton.setBackgroundResource(R.drawable.letter_y);
        }else if(letter =='z'){
            imageButton.setBackgroundResource(R.drawable.letter_z);
        }
    }

    public void disable(){
        if(assignedLetter =='a'){
            imageButton.setBackgroundResource(R.drawable.letter_a_d);
        }else if(assignedLetter =='b'){
            imageButton.setBackgroundResource(R.drawable.letter_b_d);
        }else if(assignedLetter =='c'){
            imageButton.setBackgroundResource(R.drawable.letter_c_d);
        }else if(assignedLetter =='d'){
            imageButton.setBackgroundResource(R.drawable.letter_d_d);
        }else if(assignedLetter =='e'){
            imageButton.setBackgroundResource(R.drawable.letter_e_d);
        }else if(assignedLetter =='f'){
            imageButton.setBackgroundResource(R.drawable.letter_f_d);
        }else if(assignedLetter =='g'){
            imageButton.setBackgroundResource(R.drawable.letter_g_d);
        }else if(assignedLetter =='h'){
            imageButton.setBackgroundResource(R.drawable.letter_h_d);
        }else if(assignedLetter =='i'){
            imageButton.setBackgroundResource(R.drawable.letter_i_d);
        }else if(assignedLetter =='j'){
            imageButton.setBackgroundResource(R.drawable.letter_j_d);
        }else if(assignedLetter =='k'){
            imageButton.setBackgroundResource(R.drawable.letter_k_d);
        }else if(assignedLetter =='l'){
            imageButton.setBackgroundResource(R.drawable.letter_l_d);
        }else if(assignedLetter =='m'){
            imageButton.setBackgroundResource(R.drawable.letter_m_d);
        }else if(assignedLetter =='n'){
            imageButton.setBackgroundResource(R.drawable.letter_n_d);
        }else if(assignedLetter =='o'){
            imageButton.setBackgroundResource(R.drawable.letter_o_d);
        }else if(assignedLetter =='p'){
            imageButton.setBackgroundResource(R.drawable.letter_p_d);
        }else if(assignedLetter =='q'){
            imageButton.setBackgroundResource(R.drawable.letter_q_d);
        }else if(assignedLetter =='r'){
            imageButton.setBackgroundResource(R.drawable.letter_r_d);
        }else if(assignedLetter =='s'){
            imageButton.setBackgroundResource(R.drawable.letter_s_d);
        }else if(assignedLetter =='t'){
            imageButton.setBackgroundResource(R.drawable.letter_t_d);
        }else if(assignedLetter =='u'){
            imageButton.setBackgroundResource(R.drawable.letter_u_d);
        }else if(assignedLetter =='v'){
            imageButton.setBackgroundResource(R.drawable.letter_v_d);
        }else if(assignedLetter =='w'){
            imageButton.setBackgroundResource(R.drawable.letter_w_d);
        }else if(assignedLetter =='x'){
            imageButton.setBackgroundResource(R.drawable.letter_x_d);
        }else if(assignedLetter =='y'){
            imageButton.setBackgroundResource(R.drawable.letter_y_d);
        }else if(assignedLetter =='z'){
            imageButton.setBackgroundResource(R.drawable.letter_z_d);
        }
        disabled = true;
        Log.d("isDisabled","Letter Disabled");
    }
    public void enable(){
        if(assignedLetter =='a'){
            imageButton.setBackgroundResource(R.drawable.letter_a);
        }else if(assignedLetter =='b'){
            imageButton.setBackgroundResource(R.drawable.letter_b);
        }else if(assignedLetter =='c'){
            imageButton.setBackgroundResource(R.drawable.letter_c);
        }else if(assignedLetter =='d'){
            imageButton.setBackgroundResource(R.drawable.letter_d);
        }else if(assignedLetter =='e'){
            imageButton.setBackgroundResource(R.drawable.letter_e);
        }else if(assignedLetter =='f'){
            imageButton.setBackgroundResource(R.drawable.letter_f);
        }else if(assignedLetter =='g'){
            imageButton.setBackgroundResource(R.drawable.letter_g);
        }else if(assignedLetter =='h'){
            imageButton.setBackgroundResource(R.drawable.letter_h);
        }else if(assignedLetter =='i'){
            imageButton.setBackgroundResource(R.drawable.letter_i);
        }else if(assignedLetter =='j'){
            imageButton.setBackgroundResource(R.drawable.letter_j);
        }else if(assignedLetter =='k'){
            imageButton.setBackgroundResource(R.drawable.letter_k);
        }else if(assignedLetter =='l'){
            imageButton.setBackgroundResource(R.drawable.letter_l);
        }else if(assignedLetter =='m'){
            imageButton.setBackgroundResource(R.drawable.letter_m);
        }else if(assignedLetter =='n'){
            imageButton.setBackgroundResource(R.drawable.letter_n);
        }else if(assignedLetter =='o'){
            imageButton.setBackgroundResource(R.drawable.letter_o);
        }else if(assignedLetter =='p'){
            imageButton.setBackgroundResource(R.drawable.letter_p);
        }else if(assignedLetter =='q'){
            imageButton.setBackgroundResource(R.drawable.letter_q);
        }else if(assignedLetter =='r'){
            imageButton.setBackgroundResource(R.drawable.letter_r);
        }else if(assignedLetter =='s'){
            imageButton.setBackgroundResource(R.drawable.letter_s);
        }else if(assignedLetter =='t'){
            imageButton.setBackgroundResource(R.drawable.letter_t);
        }else if(assignedLetter =='u'){
            imageButton.setBackgroundResource(R.drawable.letter_u);
        }else if(assignedLetter =='v'){
            imageButton.setBackgroundResource(R.drawable.letter_v);
        }else if(assignedLetter =='w'){
            imageButton.setBackgroundResource(R.drawable.letter_w);
        }else if(assignedLetter =='x'){
            imageButton.setBackgroundResource(R.drawable.letter_x);
        }else if(assignedLetter =='y'){
            imageButton.setBackgroundResource(R.drawable.letter_y);
        }else if(assignedLetter =='z'){
            imageButton.setBackgroundResource(R.drawable.letter_z);
        }
        disabled = false;
    }
    public char getAssignedLetter() {
        return assignedLetter;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setAssignedLetter(char letter) {
        this.assignedLetter = letter;
        if(letter=='a'){
            imageButton.setBackgroundResource(R.drawable.letter_a);
        }else if(letter =='b'){
            imageButton.setBackgroundResource(R.drawable.letter_b);
        }else if(letter =='c'){
            imageButton.setBackgroundResource(R.drawable.letter_c);
        }else if(letter =='d'){
            imageButton.setBackgroundResource(R.drawable.letter_d);
        }else if(letter =='e'){
            imageButton.setBackgroundResource(R.drawable.letter_e);
        }else if(letter =='f'){
            imageButton.setBackgroundResource(R.drawable.letter_f);
        }else if(letter =='g'){
            imageButton.setBackgroundResource(R.drawable.letter_g);
        }else if(letter =='h'){
            imageButton.setBackgroundResource(R.drawable.letter_h);
        }else if(letter =='i'){
            imageButton.setBackgroundResource(R.drawable.letter_i);
        }else if(letter =='j'){
            imageButton.setBackgroundResource(R.drawable.letter_j);
        }else if(letter =='k'){
            imageButton.setBackgroundResource(R.drawable.letter_k);
        }else if(letter =='l'){
            imageButton.setBackgroundResource(R.drawable.letter_l);
        }else if(letter =='m'){
            imageButton.setBackgroundResource(R.drawable.letter_m);
        }else if(letter =='n'){
            imageButton.setBackgroundResource(R.drawable.letter_n);
        }else if(letter =='o'){
            imageButton.setBackgroundResource(R.drawable.letter_o);
        }else if(letter =='p'){
            imageButton.setBackgroundResource(R.drawable.letter_p);
        }else if(letter =='q'){
            imageButton.setBackgroundResource(R.drawable.letter_q);
        }else if(letter =='r'){
            imageButton.setBackgroundResource(R.drawable.letter_r);
        }else if(letter =='s'){
            imageButton.setBackgroundResource(R.drawable.letter_s);
        }else if(letter =='t'){
            imageButton.setBackgroundResource(R.drawable.letter_t);
        }else if(letter =='u'){
            imageButton.setBackgroundResource(R.drawable.letter_u);
        }else if(letter =='v'){
            imageButton.setBackgroundResource(R.drawable.letter_v);
        }else if(letter =='w'){
            imageButton.setBackgroundResource(R.drawable.letter_w);
        }else if(letter =='x'){
            imageButton.setBackgroundResource(R.drawable.letter_x);
        }else if(letter =='y'){
            imageButton.setBackgroundResource(R.drawable.letter_y);
        }else if(letter =='z'){
            imageButton.setBackgroundResource(R.drawable.letter_z);
        }

    }

    public void randomizeLetter(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        setAssignedLetter(c);
        setImageButtonWithLetter(c);
    }

    public char pressed(){
        this.disable();
        return assignedLetter;

    }

}
