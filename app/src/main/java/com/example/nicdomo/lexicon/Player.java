package com.example.nicdomo.lexicon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Nicdomo on 2/9/2018.
 */

public class Player implements Serializable{
    /*
    public static final String TABLE = "players";
    public static final String COLUMN_ID = "id"; // conform to android standards
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CLASS = "class";

    public static final String COLUMN_MAX_HEALTH = "max_health";
    public static final String COLUMN_MAX_DAMAGE = "damage";

    public static final String COLUMN_HIGHEST_SCORE = "highest_score";
    public static final String COLUMN_FOUR_LETTER = "four_letter_words";
    public static final String COLUMN_FIVE_LETTER = "five_letter_words";
    public static final String COLUMN_SIX_LETTER = "six_letter_words";
    public static final String COLUMN_SEVEN_LETTER = "seven_letter_words";
    public static final String COLUMN_EIGHT_LETTER = "eight_letter_words";

    public static final String COLUMN_HAS_FIRST_BOOK = "has_first_book";
    public static final String COLUMN_HAS_SECOND_BOOK = "has_second_book";
    public static final String COLUMN_HAS_THIRD_BOOK = "has_third_book";
    public static final String COLUMN_HAS_FOURTH_BOOK = "has_fourth_book";
    public static final String COLUMN_HAS_FIFTH_BOOK = "has_fifth_book";

    public static final String COLUMN_EQUIPPED_BOOK = "equipped_book";

    //Forest stage stars
    public static final String COLUMN_FOREST_ONE = "forest_one";
    public static final String COLUMN_FOREST_TWO = "forest_two";
    public static final String COLUMN_FOREST_THREE = "forest_three";

    //Desert stage stars
    public static final String COLUMN_DESERT_ONE = "desert_one";
    public static final String COLUMN_DESERT_TWO = "desert_two";
    public static final String COLUMN_DESERT_THREE = "desert_three";

    //Underwater stage stars
    public static final String COLUMN_UNDERWATER_ONE = "underwater_one";
    public static final String COLUMN_UNDERWATER_TWO = "underwater_two";
    public static final String COLUMN_UNDERWATER_THREE = "underwater_three";

    //ICE stage stars
    public static final String COLUMN_ICE_ONE = "ice_one";
    public static final String COLUMN_ICE_TWO = "ice_two";
    public static final String COLUMN_ICE_THREE = "ice_three";

    //Hell stage stars
    public static final String COLUMN_HELL_ONE = "hell_one";
    public static final String COLUMN_HELL_TWO = "hell_two";
    public static final String COLUMN_HELL_THREE = "hell_three";

    //potions
    public static final String COLUMN_POTIONS = "potions";


    */
    private int id;
    private String name;
    private String className;
    private int currentHealth;
    private int damage;
    private int maxHealth;
    private int potions;
    public String equippedBook;
    public int highestScore;
    //stores the number of words formed
    private int fourCtr;
    private int fiveCtr;
    private int sixCtr;
    private int sevenCtr;
    private int eightCtr;

    //if player had a saved game or not
    private boolean savedGame = false;


    //stores stars collected from each level
    private int forestOne; //0 false, 1 true
    private int forestTwo; //0 false, 1 true
    private int forestThree; //0 false, 1 true

    private int desertOne; //0 false, 1 true
    private int desertTwo; //0 false, 1 true
    private int desertThree; //0 false, 1 true

    private int underwaterOne; //0 false, 1 true
    private int underwaterTwo; //0 false, 1 true
    private int underwaterThree; //0 false, 1 true

    private int iceOne; //0 false, 1 true
    private int iceTwo; //0 false, 1 true
    private int iceThree; //0 false, 1 true

    private int hellOne; //0 false, 1 true
    private int hellTwo; //0 false, 1 true
    private int hellThree; //0 false, 1 true

    //stores books collected from each level
    private int firstBook;//0 false, 1 true
    private int secondBook;
    private int thirdBook;
    private int fourthBook;
    private int fifthBook;
    private int skillPoints;

    public int getSlot1() {
        return slot1;
    }

    public void setSlot1(int slot1) {
        this.slot1 = slot1;
    }

    public int getSlot2() {
        return slot2;
    }

    public void setSlot2(int slot2) {
        this.slot2 = slot2;
    }

    public int getSlot3() {
        return slot3;
    }

    public void setSlot3(int slot3) {
        this.slot3 = slot3;
    }

    public int getSlot4() {
        return slot4;
    }

    public void setSlot4(int slot4) {
        this.slot4 = slot4;
    }

    public int getSlot5() {
        return slot5;
    }

    public void setSlot5(int slot5) {
        this.slot5 = slot5;
    }

    private int slot1;
    private int slot2;
    private int slot3;
    private int slot4;
    private int slot5;

    public boolean isSavedGame() {
        return savedGame;
    }

    public void setSavedGame(boolean savedGame) {
        this.savedGame = savedGame;
    }


    public Player () {

    }
    public Player(String name, String className){
        this.name = name;
        this.className = className;

        if(className.equals("warrior")){
            setDamage(10);
            setCurrentHealth(300);
            setMaxHealth(300);
        }else if (className.equals("mage")){
            setDamage(30);
            setCurrentHealth(100);
            setMaxHealth(100);
        }else if(className.equals("archer")){//archer
            setDamage(20);
            setCurrentHealth(200);
            setMaxHealth(200);
        }
        initBooks();
        initCtr();
        initCtr();
    }

    public String getName() {
        return name;
    }
    public boolean canUpgrade(){
        boolean canUpgrade = false;
        if(skillPoints>0){
            canUpgrade = true;
        }
        return canUpgrade;
    }
    public void upgradeHealth(){
        if(canUpgrade()){
            maxHealth +=10;
            skillPoints--;
        }
    }
    public void upgradeDamage(){
        if(canUpgrade()){
            damage +=10;
            skillPoints--;
        }
    }
    public void increasePoints(){
        skillPoints++;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public String getEquippedBook() {
        return equippedBook;
    }

    public void setEquippedBook(String equippedBook) {
        this.equippedBook = equippedBook;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public int getFourCtr() {
        return fourCtr;
    }

    public void setFourCtr(int fourCtr) {
        this.fourCtr = fourCtr;
    }

    public int getFiveCtr() {
        return fiveCtr;
    }

    public void setFiveCtr(int fiveCtr) {
        this.fiveCtr = fiveCtr;
    }

    public int getSixCtr() {
        return sixCtr;
    }

    public void setSixCtr(int sixCtr) {
        this.sixCtr = sixCtr;
    }

    public int getSevenCtr() {
        return sevenCtr;
    }

    public void setSevenCtr(int sevenCtr) {
        this.sevenCtr = sevenCtr;
    }

    public int getEightCtr() {
        return eightCtr;
    }

    public void setEightCtr(int eightCtr) {
        this.eightCtr = eightCtr;
    }

    public int getForestOne() {
        return forestOne;
    }

    public void setForestOne(int forestOne) {
        this.forestOne = forestOne;
    }

    public int getForestTwo() {
        return forestTwo;
    }

    public void setForestTwo(int forestTwo) {
        this.forestTwo = forestTwo;
    }

    public int getForestThree() {
        return forestThree;
    }

    public void setForestThree(int forestThree) {
        this.forestThree = forestThree;
    }

    public int getDesertOne() {
        return desertOne;
    }

    public void setDesertOne(int desertOne) {
        this.desertOne = desertOne;
    }

    public int getDesertTwo() {
        return desertTwo;
    }

    public void setDesertTwo(int desertTwo) {
        this.desertTwo = desertTwo;
    }

    public int getDesertThree() {
        return desertThree;
    }

    public void setDesertThree(int desertThree) {
        this.desertThree = desertThree;
    }

    public int getUnderwaterOne() {
        return underwaterOne;
    }

    public void setUnderwaterOne(int underwaterOne) {
        this.underwaterOne = underwaterOne;
    }

    public int getUnderwaterTwo() {
        return underwaterTwo;
    }

    public void setUnderwaterTwo(int underwaterTwo) {
        this.underwaterTwo = underwaterTwo;
    }

    public int getUnderwaterThree() {
        return underwaterThree;
    }

    public void setUnderwaterThree(int underwaterThree) {
        this.underwaterThree = underwaterThree;
    }

    public int getIceOne() {
        return iceOne;
    }

    public void setIceOne(int iceOne) {
        this.iceOne = iceOne;
    }

    public int getIceTwo() {
        return iceTwo;
    }

    public void setIceTwo(int iceTwo) {
        this.iceTwo = iceTwo;
    }

    public int getIceThree() {
        return iceThree;
    }

    public void setIceThree(int iceThree) {
        this.iceThree = iceThree;
    }

    public int getHellOne() {
        return hellOne;
    }

    public void setHellOne(int hellOne) {
        this.hellOne = hellOne;
    }

    public int getHellTwo() {
        return hellTwo;
    }

    public void setHellTwo(int hellTwo) {
        this.hellTwo = hellTwo;
    }

    public int getHellThree() {
        return hellThree;
    }

    public void setHellThree(int hellThree) {
        this.hellThree = hellThree;
    }

    public int getFirstBook() {
        return firstBook;
    }

    public void setFirstBook(int firstBook) {
        this.firstBook = firstBook;
    }

    public int getSecondBook() {
        return secondBook;
    }

    public void setSecondBook(int secondBook) {
        this.secondBook = secondBook;
    }

    public int getThirdBook() {
        return thirdBook;
    }

    public void setThirdBook(int thirdBook) {
        this.thirdBook = thirdBook;
    }

    public int getFourthBook() {
        return fourthBook;
    }

    public void setFourthBook(int fourthBook) {
        this.fourthBook = fourthBook;
    }

    public int getFifthBook() {
        return fifthBook;
    }

    public void setFifthBook(int fifthBook) {
        this.fifthBook = fifthBook;
    }

    public boolean isWounded(){
        boolean isWounded=false;
        if(currentHealth<maxHealth){
            isWounded = true;
        }
        return isWounded;
    }

    public void consumePotion(){
        if(potions>0){
            if(isWounded()){
                currentHealth = maxHealth;
                potions--;
            }
        }
    }
    public void initBooks(){
        setFirstBook(0);
        setSecondBook(0);
        setThirdBook(0);
        setFourthBook(0);
        setFifthBook(0);
        setEquippedBook("");
    }
    public void initCtr(){
        setFourCtr(0);
        setFiveCtr(0);
        setSixCtr(0);
        setSevenCtr(0);
        setEightCtr(0);
    }
    public void initStars(){
        setForestOne(0);
        setForestTwo(0);
        setForestThree(0);

        setDesertOne(0);
        setDesertTwo(0);
        setDesertThree(0);

        setUnderwaterOne(0);
        setUnderwaterTwo(0);
        setUnderwaterThree(0);

        setHellOne(0);
        setHellTwo(0);
        setHellThree(0);

        setIceOne(0);
        setIceTwo(0);
        setIceThree(0);
    }
    public void initSlots(){
        setSlot1(0);
        setSlot2(0);
        setSlot3(0);
        setSlot4(0);
        setSlot5(0);
    }



}
