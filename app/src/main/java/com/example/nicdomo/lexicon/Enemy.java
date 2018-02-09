package com.example.nicdomo.lexicon;

/**
 * Created by Nicdomo on 2/9/2018.
 */

public class Enemy {
    public Enemy(int health, int damage) {
        this.setHealth(health);
        this.setDamage(damage);
    }

    public int health, damage;
    //getter and setter

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    //methods
    public boolean isAlive(){
        return this.health > 0;
    }
}
