package com.example.duzeming.noter;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;
import fragment.AllFragment;
import fragment.ObsoleteFragment;
import fragment.TodayFragment;
import fragment.WeekFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Fragment>fragmentList;
    private List<String>titleList;
    private TabLayout tabLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("Noter");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitle));
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_main:
                        Intent intent=new Intent(MainActivity.this,NewActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new TodayFragment());
        fragmentList.add(new WeekFragment());
        fragmentList.add(new AllFragment());
        fragmentList.add(new ObsoleteFragment());

        titleList=new ArrayList<String>();
        titleList.add("今天");
        titleList.add("本周");
        titleList.add("全部");
        titleList.add("过时");
        tabLayout= (TabLayout) findViewById(R.id.tablayout_main);
        for (int i=0;i<titleList.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
        }

        viewPager= (ViewPager) findViewById(R.id.viewpager_main);
        MainAdapter adapter=new MainAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
