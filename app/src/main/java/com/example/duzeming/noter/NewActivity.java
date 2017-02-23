package com.example.duzeming.noter;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;
import java.util.Calendar;

import databasehelper.MyDatabaseHelper;
import method.SQLMethod;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDatabaseHelper myDatabaseHelper;
    private TextView writeTime;
    private Calendar calendar;
    private int year,month,day,hour,minute;
    private Button save;
    private Button cancel;
    private String title;
    private String note;
    private EditText inputTitle;
    private EditText inputNote;
    private SQLMethod sqlMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        writeTime = (TextView) findViewById(R.id.tv_new_time);
        getTime();
        myDatabaseHelper=new MyDatabaseHelper(this,"note.db",null,1);
        sqlMethod=new SQLMethod(this);

        save= (Button) findViewById(R.id.btn_new_save);
        cancel= (Button) findViewById(R.id.btn_new_cancel);
        inputTitle= (EditText) findViewById(R.id.et_new_title);
        inputNote= (EditText) findViewById(R.id.et_new_work);
        save.setOnClickListener(this);
        cancel.setOnClickListener(this);




    }

    public void getTime() {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        writeTime.setText(year + "年" + month + 1 + "月" + day + "日" + hour + ":" + minute);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_new_save:
                sqlMethod.addData(inputTitle.getText().toString(),inputNote.getText().toString(),
                        year + "年" + month + 1 + "月" + day + "日" + hour + ":" + minute,null);
                Intent intent=new Intent(NewActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_new_cancel:

                break;
            default:
                break;
        }
    }
}
