package com.example.nicdomo.lexicon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nicdomo on 4/2/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "lexicon_database";
    private static final int DATABASE_VERSION = 1;

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
    public static final String COLUMN_SKILLPOINTS = "skill_points";
    //equipped slots
    public static final String COLUMN_SLOT1 = "slot_one";
    public static final String COLUMN_SLOT2 = "slot_two";
    public static final String COLUMN_SLOT3 = "slot_three";
    public static final String COLUMN_SLOT4 = "slot_four";
    public static final String COLUMN_SLOT5 = "slot_five";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String playerDatabase
                = "CREATE TABLE IF NOT EXISTS "
                + TABLE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_CLASS + " TEXT NOT NULL, "
                + COLUMN_MAX_HEALTH + "INTEGER NOT NULL, "
                + COLUMN_MAX_DAMAGE + "INTEGER NOT NULL, "
                + COLUMN_POTIONS + "INTEGER, "
                + COLUMN_HIGHEST_SCORE + "INTEGER, "
                + COLUMN_FOUR_LETTER + "INTEGER, "
                + COLUMN_FIVE_LETTER + "INTEGER, "
                + COLUMN_SIX_LETTER + "INTEGER, "
                + COLUMN_SEVEN_LETTER + "INTEGER, "
                + COLUMN_EIGHT_LETTER + "INTEGER, "
                + COLUMN_HAS_FIRST_BOOK + "NUMERIC, "
                + COLUMN_HAS_SECOND_BOOK + "NUMERIC, "
                + COLUMN_HAS_THIRD_BOOK + "NUMERIC, "
                + COLUMN_HAS_FOURTH_BOOK + "NUMERIC, "
                + COLUMN_HAS_FIFTH_BOOK + "NUMERIC, "
                + COLUMN_EQUIPPED_BOOK + "TEXT, "
                + COLUMN_FOREST_ONE + "NUMERIC, "
                + COLUMN_FOREST_TWO + "NUMERIC, "
                + COLUMN_FOREST_THREE + "NUMERIC, "
                + COLUMN_DESERT_ONE + "NUMERIC, "
                + COLUMN_DESERT_TWO + "NUMERIC, "
                + COLUMN_DESERT_THREE + "NUMERIC, "
                + COLUMN_UNDERWATER_ONE + "NUMERIC, "
                + COLUMN_UNDERWATER_TWO + "NUMERIC, "
                + COLUMN_UNDERWATER_THREE + "NUMERIC, "
                + COLUMN_ICE_ONE + "NUMERIC, "
                + COLUMN_ICE_TWO + "NUMERIC, "
                + COLUMN_ICE_THREE + "NUMERIC, "
                + COLUMN_HELL_ONE + "NUMERIC, "
                + COLUMN_HELL_TWO + "NUMERIC, "
                + COLUMN_HELL_THREE + "NUMERIC, "
                + COLUMN_SKILLPOINTS + "INTEGER "
                + COLUMN_SLOT1 + "NUMERIC, "
                + COLUMN_SLOT2 + "NUMERIC, "
                + COLUMN_SLOT3 + "NUMERIC, "
                + COLUMN_SLOT4 + "NUMERIC, "
                + COLUMN_SLOT5 + "NUMERIC, "
                + ");";

        sqLiteDatabase.execSQL(playerDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TABLE + "'");
        onCreate(sqLiteDatabase);
    }
    //takes a player object and inserts it to the db
    public long addPlayer(Player player) {
        SQLiteDatabase db = getWritableDatabase();
        // INSERT INTO table (col1, col2, col3)
        //             VALUES(?   ,    ?,    ?);
        ContentValues cv = new ContentValues();

        cv.put(this.COLUMN_NAME, player.getName());
        cv.put(this.COLUMN_CLASS, player.getClassName());
        cv.put(this.COLUMN_MAX_HEALTH, player.getMaxHealth());
        cv.put(this.COLUMN_MAX_DAMAGE, player.getDamage());

        long id = db.insert(this.TABLE,
                null, // to prevent empty rows from being added
                cv);
        db.close();
        return id;
    }
    /*COMMENT: FINISH GET ALL PLAYERS SORTED BY HIGH SCORE
               FINISH GET SINGLE PLAYER
    *
    * */
    public int updatePlayer(Player player) {

        ContentValues cv = new ContentValues();
        cv.put(this.COLUMN_ID, player.getId());
        cv.put(this.COLUMN_NAME, player.getName());
        cv.put(this.COLUMN_CLASS, player.getClassName());
        cv.put(this.COLUMN_MAX_HEALTH, player.getMaxHealth());
        cv.put(this.COLUMN_MAX_DAMAGE, player.getDamage());
        cv.put(this.COLUMN_MAX_DAMAGE, player.getPotions());

        cv.put(this.COLUMN_HIGHEST_SCORE, player.getHighestScore());

        cv.put(this.COLUMN_FOUR_LETTER, player.getFourCtr());
        cv.put(this.COLUMN_FIVE_LETTER, player.getFiveCtr());
        cv.put(this.COLUMN_SIX_LETTER, player.getSixCtr());
        cv.put(this.COLUMN_SEVEN_LETTER, player.getSevenCtr());
        cv.put(this.COLUMN_EIGHT_LETTER, player.getEightCtr());

        cv.put(this.COLUMN_HAS_FIRST_BOOK, player.getFirstBook());
        cv.put(this.COLUMN_HAS_SECOND_BOOK, player.getSecondBook());
        cv.put(this.COLUMN_HAS_THIRD_BOOK, player.getThirdBook());
        cv.put(this.COLUMN_HAS_FOURTH_BOOK, player.getFourthBook());
        cv.put(this.COLUMN_HAS_FIFTH_BOOK, player.getFifthBook());

        cv.put(this.COLUMN_EQUIPPED_BOOK, player.getEquippedBook());

        cv.put(this.COLUMN_FOREST_ONE, player.getForestOne());
        cv.put(this.COLUMN_FOREST_TWO, player.getForestTwo());
        cv.put(this.COLUMN_FOREST_THREE, player.getForestThree());

        cv.put(this.COLUMN_DESERT_ONE, player.getDesertOne());
        cv.put(this.COLUMN_DESERT_TWO, player.getDesertTwo());
        cv.put(this.COLUMN_DESERT_THREE, player.getDesertThree());

        cv.put(this.COLUMN_ICE_ONE, player.getIceOne());
        cv.put(this.COLUMN_ICE_TWO, player.getIceTwo());
        cv.put(this.COLUMN_ICE_THREE, player.getIceThree());

        cv.put(this.COLUMN_UNDERWATER_ONE, player.getUnderwaterOne());
        cv.put(this.COLUMN_UNDERWATER_TWO, player.getUnderwaterTwo());
        cv.put(this.COLUMN_UNDERWATER_THREE, player.getUnderwaterThree());

        cv.put(this.COLUMN_HELL_ONE, player.getHellOne());
        cv.put(this.COLUMN_HELL_TWO, player.getHellTwo());
        cv.put(this.COLUMN_HELL_THREE, player.getHellThree());

        cv.put(this.COLUMN_SKILLPOINTS, player.getSkillPoints());
        cv.put(this.COLUMN_SLOT1, player.getSlot1());
        cv.put(this.COLUMN_SLOT1, player.getSlot2());
        cv.put(this.COLUMN_SLOT1, player.getSlot3());
        cv.put(this.COLUMN_SLOT1, player.getSlot4());
        cv.put(this.COLUMN_SLOT1, player.getSlot5());

//        + COLUMN_NAME + " TEXT NOT NULL, "
//        + COLUMN_CLASS + " TEXT NOT NULL, "
//        + COLUMN_MAX_HEALTH + "INTEGER NOT NULL, "
//        + COLUMN_MAX_DAMAGE + "INTEGER NOT NULL, "
//        + COLUMN_POTIONS + "INTEGER, "
//        + COLUMN_HIGHEST_SCORE + "INTEGER, "
//        + COLUMN_FOUR_LETTER + "INTEGER, "
//        + COLUMN_FIVE_LETTER + "INTEGER, "
//        + COLUMN_SIX_LETTER + "INTEGER, "
//        + COLUMN_SEVEN_LETTER + "INTEGER, "
//        + COLUMN_EIGHT_LETTER + "INTEGER, "
//        + COLUMN_HAS_FIRST_BOOK + "NUMERIC, "
//        + COLUMN_HAS_SECOND_BOOK + "NUMERIC, "
//        + COLUMN_HAS_THIRD_BOOK + "NUMERIC, "
//        + COLUMN_HAS_FOURTH_BOOK + "NUMERIC, "
//        + COLUMN_HAS_FIFTH_BOOK + "NUMERIC, "
//        + COLUMN_EQUIPPED_BOOK + "TEXT, "
//        + COLUMN_FOREST_ONE + "NUMERIC, "
//        + COLUMN_FOREST_TWO + "NUMERIC, "
//        + COLUMN_FOREST_THREE + "NUMERIC, "
//        + COLUMN_DESERT_ONE + "NUMERIC, "
//        + COLUMN_DESERT_TWO + "NUMERIC, "
//        + COLUMN_DESERT_THREE + "NUMERIC, "
//        + COLUMN_UNDERWATER_ONE + "NUMERIC, "
//        + COLUMN_UNDERWATER_TWO + "NUMERIC, "
//        + COLUMN_UNDERWATER_THREE + "NUMERIC, "
//        + COLUMN_ICE_ONE + "NUMERIC, "
//        + COLUMN_ICE_TWO + "NUMERIC, "
//        + COLUMN_ICE_THREE + "NUMERIC, "
//        + COLUMN_HELL_ONE + "NUMERIC, "
//        + COLUMN_HELL_TWO + "NUMERIC, "
//        + COLUMN_HELL_THREE + "NUMERIC, "
        SQLiteDatabase db = getWritableDatabase();
        int affectedRows = db.update(this.TABLE,
                cv,
                this.COLUMN_ID + " =?",
                new String[] {player.getId() + ""}
        );

        db.close();
        return affectedRows;
    }
    //retrieves a single player with the given id
    public Player getPlayer(int id) {
        Player player = null;
        SQLiteDatabase db = getReadableDatabase();
        /*
            SELECT * FROM player WHERE _id=?;
         */
        Cursor c = db.query(this.TABLE,
                null,
                this.COLUMN_ID + "=?", // where clause
                new String[]{id+""}, // values for each ?
                null, // group by
                null, // having
                null // order by
        );
        if (c.moveToFirst()) {

            player = new Player();
            player.setId(id);

            String name = c.getString(c.getColumnIndex(this.COLUMN_NAME));
            player.setName(name);

            int score = c.getInt(c.getColumnIndex(this.COLUMN_HIGHEST_SCORE));
            player.setHighestScore(score);

            String className = c.getString(c.getColumnIndex(this.COLUMN_CLASS));
            player.setClassName(className);

            int health = c.getInt(c.getColumnIndex(this.COLUMN_MAX_HEALTH));
            player.setMaxHealth(health);

            int damage = c.getInt(c.getColumnIndex(this.COLUMN_MAX_DAMAGE));
            player.setDamage(damage);

            int potions = c.getInt(c.getColumnIndex(this.COLUMN_POTIONS));
            player.setPotions(potions);

            int fourLetter = c.getInt(c.getColumnIndex(this.COLUMN_FOUR_LETTER));
            player.setFourCtr(fourLetter);

            int fiveLetter = c.getInt(c.getColumnIndex(this.COLUMN_FIVE_LETTER));
            player.setFiveCtr(fiveLetter);

            int sixLetter = c.getInt(c.getColumnIndex(this.COLUMN_SIX_LETTER));
            player.setSixCtr(sixLetter);

            int sevenLetter = c.getInt(c.getColumnIndex(this.COLUMN_SEVEN_LETTER));
            player.setSevenCtr(sevenLetter);

            int eightLetter = c.getInt(c.getColumnIndex(this.COLUMN_EIGHT_LETTER));
            player.setEightCtr(eightLetter);

            int hasFirstBook = c.getInt(c.getColumnIndex(this.COLUMN_HAS_FIRST_BOOK));
            player.setFirstBook(hasFirstBook);

            int hasSecondBook = c.getInt(c.getColumnIndex(this.COLUMN_HAS_SECOND_BOOK));
            player.setSecondBook(hasSecondBook);

            int hasThirdBook = c.getInt(c.getColumnIndex(this.COLUMN_HAS_THIRD_BOOK));
            player.setThirdBook(hasThirdBook);

            int hasFourthBook = c.getInt(c.getColumnIndex(this.COLUMN_HAS_FOURTH_BOOK));
            player.setFourthBook(hasFourthBook);

            int hasFifthBook = c.getInt(c.getColumnIndex(this.COLUMN_HAS_FIFTH_BOOK));
            player.setFifthBook(hasFifthBook);

            String equippedBook = c.getString(c.getColumnIndex(this.COLUMN_EQUIPPED_BOOK));
            player.setEquippedBook(equippedBook);
            //forest
            int forestOne = c.getInt(c.getColumnIndex(this.COLUMN_FOREST_ONE));
            player.setForestOne(forestOne);
            int forestTwo = c.getInt(c.getColumnIndex(this.COLUMN_FOREST_TWO));
            player.setForestTwo(forestTwo);
            int forestThree = c.getInt(c.getColumnIndex(this.COLUMN_FOREST_THREE));
            player.setForestThree(forestThree);
            //desert
            int desertOne = c.getInt(c.getColumnIndex(this.COLUMN_DESERT_ONE));
            player.setDesertOne(desertOne);
            int desertTwo = c.getInt(c.getColumnIndex(this.COLUMN_DESERT_TWO));
            player.setDesertTwo(desertTwo);
            int desertThree = c.getInt(c.getColumnIndex(this.COLUMN_DESERT_THREE));
            player.setDesertThree(desertThree);
            //underwater
            int underwaterOne = c.getInt(c.getColumnIndex(this.COLUMN_UNDERWATER_ONE));
            player.setUnderwaterOne(underwaterOne);
            int underwaterTwo = c.getInt(c.getColumnIndex(this.COLUMN_UNDERWATER_TWO));
            player.setUnderwaterTwo(underwaterTwo);
            int underwaterThree = c.getInt(c.getColumnIndex(this.COLUMN_UNDERWATER_THREE));
            player.setUnderwaterThree(underwaterThree);
            //ice
            int iceOne = c.getInt(c.getColumnIndex(this.COLUMN_ICE_ONE));
            player.setIceOne(iceOne);
            int iceTwo = c.getInt(c.getColumnIndex(this.COLUMN_ICE_TWO));
            player.setIceTwo(iceTwo);
            int iceThree = c.getInt(c.getColumnIndex(this.COLUMN_ICE_THREE));
            player.setIceThree(iceThree);
            //hell
            int hellOne = c.getInt(c.getColumnIndex(this.COLUMN_HELL_ONE));
            player.setHellOne(hellOne);
            int hellTwo = c.getInt(c.getColumnIndex(this.COLUMN_HELL_TWO));
            player.setHellTwo(hellOne);
            int hellThree = c.getInt(c.getColumnIndex(this.COLUMN_HELL_THREE));
            player.setHellThree(hellOne);

            int skillPoints = c.getInt(c.getColumnIndex(this.COLUMN_SKILLPOINTS));
            player.setSkillPoints(skillPoints);

            int slot1 = c.getInt(c.getColumnIndex(this.COLUMN_SLOT1));
            player.setSlot1(slot1);

            int slot2 = c.getInt(c.getColumnIndex(this.COLUMN_SLOT2));
            player.setSlot1(slot2);

            int slot3 = c.getInt(c.getColumnIndex(this.COLUMN_SLOT3));
            player.setSlot1(slot3);

            int slot4 = c.getInt(c.getColumnIndex(this.COLUMN_SLOT4));
            player.setSlot1(slot4);

            int slot5 = c.getInt(c.getColumnIndex(this.COLUMN_SLOT5));
            player.setSlot1(slot5);

        }
        c.close();
        db.close();
        return player;
    }
}
