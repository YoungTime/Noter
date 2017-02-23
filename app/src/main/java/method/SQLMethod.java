package method;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import helper.MyDatabaseHelper;

/**
 * Created by DuZeming on 2017/2/22.
 */
public class SQLMethod {

    private String title;
    private String note;
    private String writeTime;
    private String finishTime;
    private MyDatabaseHelper myDatabaseHelper;

    public SQLMethod(Context context) {
        myDatabaseHelper = new MyDatabaseHelper(context, "Note.db", null, 1);
    }

    public void query() {
        SQLiteDatabase db = myDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("Note", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                title = cursor.getString(cursor.getColumnIndex("title"));
                note = cursor.getString(cursor.getColumnIndex("note"));
                writeTime = cursor.getString(cursor.getColumnIndex("writeTime"));
                finishTime = cursor.getString(cursor.getColumnIndex("finishTime"));
            } while (cursor.moveToNext());
        }

    }

    public void newDatabase() {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
    }

    public void addData(String title, String note, String writeTime, String finishTime) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("title", title);
        values.put("note", note);
        values.put("writeTime", writeTime);
        values.put("finishTime", finishTime);
        db.insert("Note", null, values);
    }

    public void updata() {

    }

    public void delete() {

    }

    public String getTitle() {
        query();
        return title;
    }

    public String getNote() {
        query();
        return note;
    }

    public String getWriteTime() {
        query();
        return writeTime;
    }

    public String getFinishTime() {
        query();
        return finishTime;
    }
}
