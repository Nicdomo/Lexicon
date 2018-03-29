package com.example.nicdomo.lexicon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Nicdomo on 2/9/2018.
 */

public class Player implements Serializable{
    public String name;
    public String className;
    public int currentHealth;
    public int baseDamage;
    public int maxHealth;
    public int[]potions;
    public Equipment[] equipment;

    public Player(String name, String className){
        this.name = name;
        this.className = className;

        if(className=="warrior"){
            setBaseDamage(10);
            setCurrentHealth(300);
            setMaxHealth(300);
        }else if (className=="mage"){
            setBaseDamage(30);
            setCurrentHealth(100);
            setMaxHealth(100);
        }else{//archer
            setBaseDamage(20);
            setCurrentHealth(200);
            setMaxHealth(200);
        }

    }

    public void setCurrentHealth(int Health){
        this.currentHealth = Health;
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }
    public void setBaseDamage(int baseDamage){
        this.baseDamage = baseDamage;
    }

    public void consumePotion(){
        if(potions.length>0){


        }
    }


    public void replenishHealth(int potionHeal){

    }
}
