package com.pm.launcher.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 首页ViewPager 适配器
 * Created by jinghao on 2017/10/9.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> mFragmentList;
    public HomeViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        mFragmentList=fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
