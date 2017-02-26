package com.example.duzeming.noter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import method.SQLMethod;

public class ShowActivity extends AppCompatActivity {
    private TextView showTime;
    private EditText showTitle;
    private EditText showNote;
    private Button save;
    private Button cancel;
    private SQLMethod sqlMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        showTime= (TextView) findViewById(R.id.tv_show_time);
        showTitle= (EditText) findViewById(R.id.et_show_title);
        showNote= (EditText) findViewById(R.id.et_show_note);
        save= (Button) findViewById(R.id.btn_show_save);
        cancel= (Button) findViewById(R.id.btn_show_cancel);

        Intent intent=getIntent();
        int position=intent.getIntExtra("id",1);

        sqlMethod=new SQLMethod(this);

        showTitle.setText(sqlMethod.getTitle().get(position));
        showNote.setText(sqlMethod.getNote().get(position));
        showTime.setText(sqlMethod.getWriteTime().get(position));


    }
}
