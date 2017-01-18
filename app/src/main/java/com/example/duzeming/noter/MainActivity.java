package com.example.duzeming.noter;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Fragment>fragmentList;
    private List<String>titleList;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new Fragment.TodayFragment());
        fragmentList.add(new Fragment.WeekFragment());
        fragmentList.add(new Fragment.AllFragment());
        fragmentList.add(new Fragment.ObsoleteFragment());

        titleList=new ArrayList<String>();
        titleList.add("今天");
        titleList.add("本周");
        titleList.add("全部");
        titleList.add("过时");
        tableLayout= (TableLayout) findViewById(R.id.tablelayout_main);
        for (int i=0;i<titleList.size();i++){
            tableLayout.addView(tableLayout.newTab);
        }


    }
}
