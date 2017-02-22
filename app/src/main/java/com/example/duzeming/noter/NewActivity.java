package com.example.duzeming.noter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Time;
import java.util.Calendar;

import databasehelper.MyDatabaseHelper;

public class NewActivity extends AppCompatActivity {
    private MyDatabaseHelper myDatabaseHelper;
    private TextView writeTime;
    private Calendar calendar;
    private int year,month,day,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        writeTime = (TextView) findViewById(R.id.tv_new_time);
        getTime();
        myDatabaseHelper=new MyDatabaseHelper(this,"note.db",null,1);




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
}
