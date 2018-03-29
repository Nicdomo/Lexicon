package com.example.nicdomo.lexicon;

/**
 * Created by Nicdomo on 2/9/2018.
 */

public class Boss extends Enemy {
    int defense;

    public Boss(int health, int damage) {
        super(health, damage);
    }
    public Boss(int health, int damage, int defense) {
        super(health, damage);
        setDefense(defense);
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public int getDefense(){
        return this.defense;
    }


}
