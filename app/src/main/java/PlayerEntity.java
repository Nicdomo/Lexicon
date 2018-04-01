import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Nicdomo on 4/1/2018.
 */
@Entity
public class PlayerEntity {
    @PrimaryKey(autoGenerate = true)
    private int player_id;

    @ColumnInfo(name="player_name")
    private String player_name;

    @ColumnInfo(name ="player_class")
    private String player_class;

    @ColumnInfo(name ="player_hp")
    private String player_hp;

    @ColumnInfo(name ="player_damage")
    private String player_;

    @ColumnInfo(name ="longest_word")
    private String longest_word;

    //stores the total number of 4-letter words made by the user.
    @ColumnInfo(name ="four_ctr")
    private int four_ctr;

    //stores the total number of 5-letter words made by the user.
    @ColumnInfo(name ="five_ctr")
    private int five_ctr;

    //stores the total number of 6-letter words made by the user.
    @ColumnInfo(name ="six_ctr")
    private int six_ctr;

    //stores the total number of 7-letter words made by the user.
    @ColumnInfo(name ="seven_ctr")
    private int seven_ctr;

    //stores the total number of 8-letter words made by the user.
    @ColumnInfo(name ="eight_ctr")
    private int eight_ctr;





}
