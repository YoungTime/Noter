package method;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import helper.MyDatabaseHelper;

/**
 * Created by DuZeming on 2017/2/22.
 */
public class SQLMethod {

    private List<Integer> id;
    private List<String> title;
    private List<String> note;
    private List<String> writeTime;
    private List<String> finishTime;
    private MyDatabaseHelper myDatabaseHelper;

    public SQLMethod(Context context) {
        myDatabaseHelper = new MyDatabaseHelper(context, "Note.db", null, 1);
    }

    public void query() {
        id=new ArrayList<Integer>();
        title=new ArrayList<String>();
        note=new ArrayList<String>();
        writeTime=new ArrayList<String>();
        finishTime=new ArrayList<String>();
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        Cursor cursor = db.query("Note", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                id.add(cursor.getInt(cursor.getColumnIndex("id")));
                title.add(cursor.getString(cursor.getColumnIndex("title")));
                note.add(cursor.getString(cursor.getColumnIndex("note")));
                writeTime.add(cursor.getString(cursor.getColumnIndex("writeTime")));
                finishTime.add(cursor.getString(cursor.getColumnIndex("finishTime")));
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

    public List<String> getTitle() {
        query();
        return title;
    }

    public List<String> getNote() {
        query();
        return note;
    }

    public List<String> getWriteTime() {
        query();
        return writeTime;
    }

    public List<String> getFinishTime() {
        query();
        return finishTime;
    }
    public List<Integer> getId(){
        query();
        return id;
    }
}
