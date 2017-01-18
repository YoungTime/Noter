package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by DuZeming on 2017/1/18.
 */
public class MainAdapter extends FragmentPagerAdapter{
    private List<Fragment>fragmentList;
    private List<String>titleList;
    public MainAdapter(FragmentManager fm,List<Fragment>fragmentList,List<String>titleList) {
        super(fm);
        this.fragmentList=fragmentList;
        this.titleList=titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
