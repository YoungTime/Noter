package helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DuZeming on 2017/2/22.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREAT_NOTE="create table note("
            + "id integer primary key autoincrement,"
            +"title text,"
            +"note text,"
            +"writeTime text,"
            +"finishTime date)";

    private Context context;


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Note");
        onCreate(db);

    }
}
