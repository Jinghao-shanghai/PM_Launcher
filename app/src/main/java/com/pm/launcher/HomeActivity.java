package com.pm.launcher;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.pm.launcher.service.StateBarService;
import com.pm.launcher.view.adapter.HomeViewPagerAdapter;
import com.pm.launcher.view.customview.WheatherView;
import com.pm.launcher.view.fragment.HomeFragment;
import com.pm.launcher.view.fragment.LeftFragment;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {
    private HomeFragment mHomeFragment;
    private LeftFragment mLeftFrament;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragmentList=new ArrayList<Fragment>();
    private ViewPager vp_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i=new Intent(this, StateBarService.class);
        startService(i);
        mHomeFragment=new HomeFragment();
        mLeftFrament=new LeftFragment();
        mFragmentList.add(mLeftFrament);
        mFragmentList.add(mHomeFragment);
        mFragmentManager=getSupportFragmentManager();
        mFragmentPagerAdapter=new HomeViewPagerAdapter(mFragmentManager,mFragmentList);
        vp_home=findViewById(R.id.vp_home);
        vp_home.setAdapter(mFragmentPagerAdapter);
        vp_home.setCurrentItem(1);
    }
}
