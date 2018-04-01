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

}
